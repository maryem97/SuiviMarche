package net.crunchdroid.Services;

import net.crunchdroid.Dto.UserRegistrationDto;
import net.crunchdroid.Entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
