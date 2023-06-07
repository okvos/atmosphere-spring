package com.okvos.atmosphere.authenticate;


import com.okvos.atmosphere.authenticate.domain.AuthenticateRequest;
import com.okvos.atmosphere.authenticate.domain.AuthenticateResponse;
import com.okvos.atmosphere.authenticate.domain.RegistrationRequest;
import com.okvos.atmosphere.authenticate.domain.RegistrationResponse;
import com.okvos.atmosphere.authenticate.exceptions.InvalidCredentialsException;
import com.okvos.atmosphere.authenticate.exceptions.UsernameTakenException;
import com.okvos.atmosphere.common.exceptions.ValidationException;
import com.okvos.atmosphere.data.user.entity.Account;
import com.okvos.atmosphere.data.user.repository.AccountRepository;
import com.okvos.atmosphere.security.userdetails.User;
import com.okvos.atmosphere.util.Utilities;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/authenticate")
public class AuthenticateController {

    @Autowired
    private AccountRepository accountRepository;


    @PostMapping("")
    public AuthenticateResponse authenticate(@RequestBody @Valid AuthenticateRequest req, HttpServletRequest request) throws InvalidCredentialsException {

        try {
            request.login(req.getUsername(), req.getPassword());
        } catch (ServletException e) {
            throw new InvalidCredentialsException("Incorrect username/password");
        }
        Authentication auth = (Authentication) request.getUserPrincipal();
        User user = (User) auth.getPrincipal();

        AuthenticateResponse resp = new AuthenticateResponse();
        resp.setUser_id(user.getUserId());
        resp.setUsername(user.getUsername());

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

}
