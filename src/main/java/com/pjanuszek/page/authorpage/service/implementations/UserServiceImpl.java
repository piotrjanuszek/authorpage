package com.pjanuszek.page.authorpage.service.implementations;

import com.pjanuszek.page.authorpage.dto.UserDto;
import com.pjanuszek.page.authorpage.entity.User;
import com.pjanuszek.page.authorpage.exceptions.UserNotFoundException;
import com.pjanuszek.page.authorpage.repository.UserRepository;
import com.pjanuszek.page.authorpage.service.interfaces.EncryptionService;
import com.pjanuszek.page.authorpage.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private EncryptionService encryptionService;

    @Autowired
    public void setEncryptionService(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    private Converter<UserDto, User> userDtoUserConverter;

    public void setUserDtoUserConverter(Converter<UserDto, User> userDtoUserConverter) {
        this.userDtoUserConverter = userDtoUserConverter;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<?> listAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public User saveOrUpdate(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
