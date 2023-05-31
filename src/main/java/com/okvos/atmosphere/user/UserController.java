package com.okvos.atmosphere.user;

import com.okvos.atmosphere.common.exceptions.ValidationException;
import com.okvos.atmosphere.data.user.entity.Account;
import com.okvos.atmosphere.data.user.repository.AccountRepository;

import com.okvos.atmosphere.user.domain.AuthenticateRequest;
import com.okvos.atmosphere.user.domain.AuthenticateResponse;
import com.okvos.atmosphere.user.domain.RegistrationRequest;
import com.okvos.atmosphere.user.domain.RegistrationResponse;
import com.okvos.atmosphere.user.exceptions.InvalidCredentialsException;

import com.okvos.atmosphere.user.exceptions.UsernameTakenException;
import com.okvos.atmosphere.util.Utilities;

import jakarta.validation.Valid;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;
import java.util.Optional;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/authenticate")
    public AuthenticateResponse authenticate(@RequestBody @Valid AuthenticateRequest req) throws InvalidCredentialsException {

        Account account = accountRepository.findByUsername(req.getUsername());
        if (account == null) {
            throw new InvalidCredentialsException("User not found");
        }

        if (Utilities.comparePassword(req.getPassword(), account.getPassword())) {
            throw new InvalidCredentialsException("Password wrong");
        }

        AuthenticateResponse resp = new AuthenticateResponse();
        resp.setUser_id(account.getUser_id());
        resp.setUsername(account.getUsername());
        return resp;
    }

    @PostMapping("/create")
    public RegistrationResponse register(@RequestBody @Valid RegistrationRequest req) throws UsernameTakenException, ValidationException {

        Utilities.validateUsername(req.getUsername());
        Utilities.validateEmailAddress(req.getEmailAddress());

        if (accountRepository.findByUsername(req.getUsername()) != null) {
            throw new UsernameTakenException("Username taken");
        }

        String password = Utilities.encodePassword(req.getPassword());
        String username = req.getUsername().toLowerCase();

        Account account = new Account();
        account.setEmail_address(req.getEmailAddress());
        account.setUsername(req.getUsername());
        account.setPassword(password);
        accountRepository.save(account);

        RegistrationResponse reg = new RegistrationResponse();
        reg.setUserId(account.getUser_id());
        reg.setUsername(username);

        return reg;

    }


    @GetMapping("/{id}")
    public Optional<Account> user(@PathVariable int id) {
        return accountRepository.findById(id);
    }

}
