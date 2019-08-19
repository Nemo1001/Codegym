package controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Date;
import java.util.TimeZone;
@Controller
public class TimeController {
    @RequestMapping("worldclock")
    public String getTimeByTimezone(ModelMap model, @RequestParam(name = "city",
            required = false, defaultValue = "Asia/Ho_Chi_Minh") String city) {
        // codes below here
        return "worldclock";
    }
}