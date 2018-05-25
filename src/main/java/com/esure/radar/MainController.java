package com.esure.radar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController
{
    @RequestMapping("/")
    public String getHomePage()
    {
        return "home";
    }
}
