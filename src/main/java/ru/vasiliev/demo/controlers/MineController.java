package ru.vasiliev.demo.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.vasiliev.demo.model.User;

@Controller
public class MineController {

    @GetMapping("/proba")
    public String printMineLoginPage(Model model) {
        User user=new User(1l,"Иван","Иванов", (byte) 30);
        model.addAttribute("user", user);
        return "index";
    }
}

