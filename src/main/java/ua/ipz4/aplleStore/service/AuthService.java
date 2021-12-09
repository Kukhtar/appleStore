package ua.ipz4.aplleStore.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ua.ipz4.aplleStore.dto.UserDto;
import ua.ipz4.aplleStore.model.Role;
//import ua.labproject.repair_agency.dto.UserDto;
//import ua.labproject.repair_agency.model.enums.Role;

@Service
public interface AuthService extends UserDetailsService {
    UserDto signIn(UserDto userDto);

    UserDto signUp(UserDto userDto, Role role);

    void signOut();
}
