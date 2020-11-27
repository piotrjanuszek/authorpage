package com.pjanuszek.page.authorpage.converters;

import com.pjanuszek.page.authorpage.dto.UserDto;
import com.pjanuszek.page.authorpage.entity.User;
import com.pjanuszek.page.authorpage.service.interfaces.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUser implements Converter<UserDto, User> {

    EncryptionService encryptionService;

    @Autowired
    private void setEncryptionService(EncryptionService encryptionService){
        this.encryptionService = encryptionService;
    }

    @Override
    public User convert(UserDto userDto) {
        User user = new User();
        user.setEnabled(true);
        user.setUsername(userDto.getUsername());
        user.setPassword(encryptionService.encrypt(userDto.getPassword()));
        return user;
    }
}
