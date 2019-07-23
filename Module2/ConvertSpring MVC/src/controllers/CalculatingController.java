package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatingController {
    @GetMapping("/convert")
    public String calculating(@RequestParam(defaultValue = "0") double rate, @RequestParam(defaultValue = "0") double usd, Model model) {
        double vnd = rate * usd;
        model.addAttribute("rate", rate);
        model.addAttribute("usd", usd);
        model.addAttribute("vnd", vnd);
        return "show";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}