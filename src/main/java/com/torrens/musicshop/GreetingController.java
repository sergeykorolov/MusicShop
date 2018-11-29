package com.torrens.musicshop;

import com.torrens.musicshop.domain.Instrument;
import com.torrens.musicshop.repos.InstrumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    private InstrumentRepo instrumentRepo;

    @GetMapping("/")
    public String greeting(Map<String,Object> model) {
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
}