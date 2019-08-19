package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TranslateDictionary {
    @GetMapping("/translate")
    public String translate(@RequestParam String english, Model model) {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("one", "một");
        dictionary.put("two", "hai");
        dictionary.put("three", "ba");
        dictionary.put("four", "bốn");
        dictionary.put("five", "năm");
        dictionary.put("six", "sáu");
        String vietnam = dictionary.get(english);
        if (english != null) {
            model.addAttribute("english", english);
            model.addAttribute("vietnam", vietnam);
        } else {
            System.out.println("Không tìm thấy");
        }
        return "dictionary";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}