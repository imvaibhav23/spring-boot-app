package com.example.demo;

import com.example.demo.dao.AlienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    AlienRepo repo;
    @RequestMapping("home")
    public String home(@RequestParam(value = "myName", defaultValue = "World") String name){
        System.out.print("Hi!");
        return "home";
    }
    @RequestMapping("addAlien")
    public String addAlien(Alien alien){
        repo.save(alien);
        return "home";
    }
    @RequestMapping("allAlien")
    public ModelAndView allAlien(@RequestParam int aid){
        ModelAndView mv= new ModelAndView("allAlien");
        Alien alien=repo.findById(aid).orElse(new Alien());
        mv.addObject(alien);
        return mv;

    }
}