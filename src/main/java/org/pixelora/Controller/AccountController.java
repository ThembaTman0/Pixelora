package org.pixelora.Controller;

import org.pixelora.model.Account;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    @GetMapping("/register")
    public String register(Model model){

        Account account  = new Account();
        model.addAttribute("account",account);
        return "register";
    }
}
