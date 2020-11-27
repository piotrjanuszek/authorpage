package com.pjanuszek.page.authorpage.service.implementations;

import com.pjanuszek.page.authorpage.service.interfaces.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("encryptionService")
public class EncryptionServiceImpl implements EncryptionService {

    private PasswordEncoder passwordEncoder;
    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String encrypt(String input) {
        return passwordEncoder.encode(input);
    }

    @Override
    public boolean matchPassword(String plainText, String encryptedPassword) {
        return passwordEncoder.matches(plainText, encryptedPassword);
    }

    @Override
    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }
}
