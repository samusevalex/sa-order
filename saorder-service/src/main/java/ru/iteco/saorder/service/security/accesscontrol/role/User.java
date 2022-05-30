package ru.iteco.saorder.service.security.accesscontrol.role;

import org.springframework.stereotype.Component;
import ru.iteco.config.security.accesscontrol.role.AbstractRole;

import javax.annotation.PostConstruct;

@Component(value = User.USER)
public class User extends AbstractRole {

    public static final String USER = "USER";

    @Override
    @PostConstruct
    public void init() {
        super.init();
    }

    @Override
    public String getRoleName() {
        return USER;
    }
}