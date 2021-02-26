package com.github.PawelSli.pollutionsApp.controlers;

import com.github.PawelSli.pollutionsApp.repository.MeasurementRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MeasurementController {
    private MeasurementRepository measurementRepository;

    public MeasurementController(){
        this.measurementRepository=new MeasurementRepository();
    }

    @RequestMapping("/main")
    public String showMainPanel(Model model){
        measurementRepository.initialize();
        model.addAttribute("cities",measurementRepository.getJsonStationNameAndLocation());
        return "main";
    }

    @RequestMapping("/test")
    public String showIndex(){
        return "test";
    }
}
