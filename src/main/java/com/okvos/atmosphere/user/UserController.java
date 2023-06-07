package com.okvos.atmosphere.user;


import com.okvos.atmosphere.data.user.entity.Account;
import com.okvos.atmosphere.data.user.repository.AccountRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AccountRepository accountRepository;


    @GetMapping("/test")
    public Object testView(HttpSession session) {
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(user);

        return session.getAttribute("test");
    }

    @GetMapping("/test/{id}")
    public Object test(@PathVariable int id, HttpSession session) {
        session.setAttribute("test", id);
        return session.getAttribute("test");
    }


    @GetMapping("/{id}")
    public Optional<Account> user(@PathVariable int id) {
        return accountRepository.findById(id);
    }

}
