package com.pjanuszek.page.authorpage.security;

import com.pjanuszek.page.authorpage.service.interfaces.EncryptionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class DaoAuthenticationProviderConfig {

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(EncryptionService encryptionService, UserDetailsService userDetailsService) {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(encryptionService.getPasswordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }
}
