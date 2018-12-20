package com.torrens.musicshop.controller;

import com.torrens.musicshop.domain.Comment;
import com.torrens.musicshop.domain.Instrument;
import com.torrens.musicshop.domain.User;
import com.torrens.musicshop.repos.CommentRepo;
import com.torrens.musicshop.repos.InstrumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class MainController {

    @Autowired
    private InstrumentRepo instrumentRepo;

    @Autowired
    private CommentRepo commentRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String mainPage(Model model) {

        Iterable<Instrument> instruments = instrumentRepo.findAll();
        model.addAttribute("instruments", instruments);
        return "mainPage";
    }

    @GetMapping("/addInstrument")
    public String getAddInstrument() {
        return "addInstrument";
    }

    @PostMapping("/addInstrument")
    public String addInstrument(@RequestParam String type,
                                @RequestParam String title,
                                @RequestParam String description,
                                @RequestParam float price) {
        Instrument instrument = new Instrument(type, title, description, price);
        instrumentRepo.save(instrument);
        return "redirect:/mainPage";
    }

    @GetMapping("/musicShop/instrumentPage")
    public String getInstrument(@RequestParam(name = "instrumentId") Integer instrumentId,
                                Model model) {

        Instrument instrument = instrumentRepo.getOne(instrumentId);
        model.addAttribute("instrument", instrument);

        List<Comment> comments = commentRepo.findByInstrumentId(instrumentId);
        model.addAttribute("comments", comments);

        return "instrumentPage";
    }

    @PostMapping("musicShop/instrumentPage")
    public String addComment(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam Integer instrumentId,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        Comment comment = new Comment(text, new Date(), user, instrumentId);

        if(file != null && !file.getOriginalFilename().isEmpty()){
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            comment.setFilename(resultFilename);
        }
        commentRepo.save(comment);

        return "redirect:/musicShop/instrumentPage?instrumentId=" + instrumentId;
    }
}