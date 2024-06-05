package org.example.employee_gadget.controller;

import org.example.employee_gadget.dto.AuthenticationDto;
import org.example.employee_gadget.service.Impl.AuthenticationServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/authentication")
public class AuthenticationController {
    private final AuthenticationServiceImpl authenticationService;

    public AuthenticationController(AuthenticationServiceImpl authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping()
    public String authentication(@RequestBody AuthenticationDto authenticationDto) {
        return authenticationService.authentication(authenticationDto);
    }
}