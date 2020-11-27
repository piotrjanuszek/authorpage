package com.pjanuszek.page.authorpage.service.interfaces;

import com.pjanuszek.page.authorpage.dto.UserDto;
import com.pjanuszek.page.authorpage.entity.User;
import org.springframework.stereotype.Service;


public interface UserRegistrationService {
    void register(UserDto user);
}
