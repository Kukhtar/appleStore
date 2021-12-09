package ua.ipz4.aplleStore.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.ipz4.aplleStore.dto.UserDto;
import ua.ipz4.aplleStore.mapper.UserMapper;
import ua.ipz4.aplleStore.model.Role;
import ua.ipz4.aplleStore.model.UserModel;
import ua.ipz4.aplleStore.repository.UserRepo;
import ua.ipz4.aplleStore.service.AuthService;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserModel user = userRepo.findByLogin(s);
        if (user == null){
            throw new UsernameNotFoundException("Can't find this user");
        }

        return user;
    }

    @Override
    public UserDto signIn(UserDto userDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userDto.getLogin(), userDto.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserModel userModel = (UserModel) authentication.getPrincipal();
        return userMapper.entityToDto(userModel);
    }

    @Override
    public UserDto signUp(UserDto userDto, Role role) {
        UserModel userModel = userMapper.dtoToEntity(userDto);

        userModel.setRole(role);
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));

        userModel = userRepo.save(userModel);
        return userMapper.entityToDto(userModel);
    }

    @Override
    public void signOut() {
        SecurityContextHolder.clearContext();
    }
}
