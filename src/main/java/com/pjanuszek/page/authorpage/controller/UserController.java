package com.pjanuszek.page.authorpage.controller;

import com.pjanuszek.page.authorpage.dto.UserDto;
import com.pjanuszek.page.authorpage.service.interfaces.UserRegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("backend/user")
public class UserController {

    UserRegistrationService userRegistrationService;

    public UserController(UserRegistrationService userRegistrationService){
        this.userRegistrationService = userRegistrationService;
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserDto userDto) {
        userRegistrationService.register(userDto);
        return new ResponseEntity(HttpStatus.OK);
    }

}
