package com.pjanuszek.page.authorpage.service.interfaces;

import org.springframework.security.crypto.password.PasswordEncoder;

public interface EncryptionService {
    String encrypt(String input);
    boolean matchPassword(String plainText, String encryptedPassword);
    PasswordEncoder getPasswordEncoder();
}
