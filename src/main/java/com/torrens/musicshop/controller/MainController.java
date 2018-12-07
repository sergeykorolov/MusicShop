package com.torrens.musicshop.controller;

import com.torrens.musicshop.domain.Comment;
import com.torrens.musicshop.domain.Instrument;
import com.torrens.musicshop.repos.CommentRepo;
import com.torrens.musicshop.repos.InstrumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.Map;

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
    public String mainPage(Map<String, Object> model){

        Iterable<Instrument> instruments = instrumentRepo.findAll();
        model.put("instruments", instruments);
        return "mainPage";
    }

    @GetMapping("/addInstrument")
    public String getAddInstrument(){
        return "addInstrument";
    }

    @PostMapping("/addInstrument")
    public String addInstrument(@RequestParam String type, @RequestParam String title,
                              @RequestParam String description, @RequestParam float price){
        Instrument instrument = new Instrument(type,title,description,price);
        instrumentRepo.save(instrument);
        return "redirect:/mainPage";
    }

    @GetMapping("/musicShop/instrumentPage")
    public String getInstrument(@RequestParam(name = "instrumentId") Integer id,
                                Map<String, Object> model){

        Instrument instrument = instrumentRepo.getOne(id);
        model.put("instrument", instrument);

        Iterable<Comment> comments = commentRepo.findAll();
        model.put("comments", comments);
        System.out.println("comments");

        return "instrumentPage";
    }

    @PostMapping("musicShop/instrumentPage")
    public String addComment(@RequestParam String text, @RequestParam String instrumentId){

        Comment comment = new Comment(text, new Date());
        commentRepo.save(comment);

        return "redirect:/musicShop/instrumentPage?instrumentId="+instrumentId;
    }
}