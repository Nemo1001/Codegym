package controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class Calculate {
    @GetMapping("/Calculate")
    public String Calculator(@RequestParam (name = "firstOperand", defaultValue = "0")float firstOperand,
                            @RequestParam (name = "secondOperand", defaultValue = "0")float secondOperand,
                            @RequestParam (name = "operator", defaultValue = "+") String operator, Model model){
        float result = 0;
        switch (operator) {
            case "Addition(+)":
                result = firstOperand + secondOperand;
                break;
            case "Subtraction(-)":
                result = firstOperand - secondOperand;
                break;
            case "Multiplication*)":
                result = firstOperand * secondOperand;
                break;
            case "Division(/)":
                if (secondOperand != 0) {
                     result = firstOperand / secondOperand;
                } else {
                    throw new RuntimeException("Can't divide by zero");
                }
        }
        model.addAttribute("firstOperand",firstOperand);
        model.addAttribute("secondOperand",secondOperand);
        model.addAttribute("operator",operator);
        model.addAttribute("result", result);
        return "index";
    }
}