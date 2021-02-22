package com.github.PawelSli.pollutionsApp.controlers;

import com.github.PawelSli.pollutionsApp.repository.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MeasurementController {
    private MeasurementRepository measurementRepository;

    public MeasurementController(){
        this.measurementRepository=new MeasurementRepository();
    }

    @RequestMapping("/main")
    public String showMainPanel(Model model){
        model.addAttribute("cities",measurementRepository.getJsonArrayFromUrl());
        return "main";
    }

    @RequestMapping("/test")
    public String showIndex(){
        return "test";
    }
}
