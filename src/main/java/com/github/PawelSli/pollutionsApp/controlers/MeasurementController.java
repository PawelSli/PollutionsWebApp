package com.github.PawelSli.pollutionsApp.controlers;

import com.github.PawelSli.pollutionsApp.repository.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MeasurementController {

    @RequestMapping("/main")
    public String showMainPanel(){
        return "main";
    }

    @RequestMapping("/test")
    public String showIndex(){
        return "test";
    }
}
