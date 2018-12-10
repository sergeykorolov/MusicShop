package com.torrens.musicshop.controller;

import com.torrens.musicshop.domain.Comment;
import com.torrens.musicshop.domain.Instrument;
import com.torrens.musicshop.domain.User;
import com.torrens.musicshop.repos.CommentRepo;
import com.torrens.musicshop.repos.InstrumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class MainController {

    @Autowired
    private InstrumentRepo instrumentRepo;

    @Autowired
    private CommentRepo commentRepo;

    @GetMapping("/")
    public String greeting() {
        return "greeting";
    }

    @GetMapping("/mainPage")
    public String mainPage(Map<String, Object> model) {

        Iterable<Instrument> instruments = instrumentRepo.findAll();
        model.put("instruments", instruments);
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
    public String getInstrument(@RequestParam(name = "instrumentId") Integer id,
                                Map<String, Object> model) {

        Instrument instrument = instrumentRepo.getOne(id);
        model.put("instrument", instrument);

        List<Comment> comments = commentRepo.findByInstrumentId(id);
        model.put("comments", comments);

        return "instrumentPage";
    }

    @PostMapping("musicShop/instrumentPage")
    public String addComment(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam Integer instrumentId) {

        Comment comment = new Comment(text, new Date(), user, instrumentId);
        commentRepo.save(comment);

        return "redirect:/musicShop/instrumentPage?instrumentId=" + instrumentId;
    }
}