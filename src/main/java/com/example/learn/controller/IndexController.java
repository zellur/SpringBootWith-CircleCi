package com.example.learn.controller;

import com.example.learn.Services.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    private TestService testService;

    public IndexController(TestService testService){
        this.testService = testService;
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getTest(Model model){
        model.addAttribute("test",testService.getTest());
        return "index";
    }
}
