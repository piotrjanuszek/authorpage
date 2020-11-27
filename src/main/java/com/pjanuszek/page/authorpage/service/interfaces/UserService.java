package com.pjanuszek.page.authorpage.service.interfaces;

import com.pjanuszek.page.authorpage.entity.User;
import com.pjanuszek.page.authorpage.service.interfaces.CRUDService;

public interface UserService extends CRUDService<User> {
    User findByUsername(String username);
}
