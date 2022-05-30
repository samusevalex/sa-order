package ru.iteco.saorder.service.security.accesscontrol.role;

import org.springframework.stereotype.Component;
import ru.iteco.config.security.accesscontrol.SimplePermission;
import ru.iteco.config.security.accesscontrol.role.AbstractRole;

import javax.annotation.PostConstruct;

import static ru.iteco.saorder.service.security.OrderBusinessOperation.*;

@Component(value = Admin.ADMIN)
public class Admin extends AbstractRole {

    public static final String ADMIN = "ADMIN";

    @Override
    @PostConstruct
    public void init() {
        super.init();
        perms.put(ORDER_CREATE.name(), new SimplePermission(ORDER_CREATE));
        perms.put(ORDER_GET.name(), new SimplePermission(ORDER_GET));
        perms.put(ORDER_DELETE.name(), new SimplePermission(ORDER_DELETE));
        perms.put(ORDER_UPDATE.name(), new SimplePermission(ORDER_UPDATE));
    }

    @Override
    public String getRoleName() {
        return ADMIN;
    }
}