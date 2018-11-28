package com.torrens.musicshop;

import com.torrens.musicshop.domain.Instrument;
import com.torrens.musicshop.repos.InstrumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    private InstrumentRepo instrumentRepo;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
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
                              @RequestParam String description, @RequestParam float price,
                              Map<String, Object> model){
        Instrument instrument = new Instrument(type,title,description,price);
        instrumentRepo.save(instrument);
        return "redirect:/mainPage";
    }
}