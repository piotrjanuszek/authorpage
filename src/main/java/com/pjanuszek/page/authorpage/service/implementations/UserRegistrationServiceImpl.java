package com.pjanuszek.page.authorpage.service.implementations;

import com.pjanuszek.page.authorpage.dto.UserDto;
import com.pjanuszek.page.authorpage.entity.User;
import com.pjanuszek.page.authorpage.service.interfaces.EncryptionService;
import com.pjanuszek.page.authorpage.service.interfaces.UserRegistrationService;
import com.pjanuszek.page.authorpage.service.interfaces.UserService;
import org.springframework.stereotype.Service;

@Service("userRegistrationService")
public class UserRegistrationServiceImpl implements UserRegistrationService {

    UserService userService;
    EncryptionService encryptionService;

    public UserRegistrationServiceImpl(UserService userService, EncryptionService encryptionService){
        this.userService = userService;
        this.encryptionService = encryptionService;
    }

    @Override
    public void register(UserDto userDto) {
        User user = User.builder()
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .password(encryptionService.encrypt(userDto.getPassword()))
                .enabled(true)
                .build();
        userService.saveOrUpdate(user);
    }
}
