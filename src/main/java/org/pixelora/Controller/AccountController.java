package org.pixelora.Controller;

import org.pixelora.model.Account;
import org.pixelora.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;  // Injects an instance of AccountService, which handles business logic for accounts.

    @GetMapping("/register")
    public String register(Model model){
        Account account = new Account();  // Creates a new instance of the Account object.
        model.addAttribute("account", account);  // Adds the account object to the model to be used in the registration form.
        return "register";  // Returns the name of the view (register.jsp or register.html) where the form will be displayed.
    }

    // Handles form submission for user registration
    @PostMapping("/register")
    public String register_user(@ModelAttribute Account account){
        accountService.save(account);  // Calls the service layer to save the account details to the database.
        return "redirect:/";  // Redirects the user to the homepage ("/") after successful registration.
    }

    @GetMapping("/login")
    public String login(Model model){
        return "login";  // Returns the name of the view (login.jsp or login.html) where the login form will be displayed.
    }
}