package net.crunchdroid.Services;

import net.crunchdroid.Dto.UserDto;
import net.crunchdroid.Dto.UserRegistrationDto;
import net.crunchdroid.Entities.Role;
import net.crunchdroid.Entities.User;
import net.crunchdroid.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;


    public boolean addUser(UserDto user){
        userRepository.save(new User(user.getLastName(),user.getFirstName()));
        return true;
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getUserById(Long id) throws Exception{
        Optional<User> user= userRepository.findById(id);
        if(!user.isPresent()) throw new Exception("We don't have any user with this id");
        return user.get();
    }

    public boolean updateUser(Long id,UserDto model) {
        Optional<User> byId = userRepository.findById(id);
        byId.get().setFirstName(model.getFirstName());
        byId.get().setLastName(model.getLastName());
        userRepository.save(byId.get());
        return true;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Long getTotal(){
        return userRepository.count();
    }



    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User save(UserRegistrationDto registration){
        User user = new User();
        user.setFirstName(registration.getFirstName());
        user.setLastName(registration.getLastName());
        user.setEmail(registration.getEmail());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));

        user.setRoles(Arrays.asList(new Role("ROLE_USER")));
/*
        Optional<Role> byId = roleRepository.findById(1);
        Set<Role> roles = new HashSet<>();
        //roles.add(new Role("USER"));
        roles.add(byId.get());
        user.setRoles(roles);
        */
        return userRepository.save(user);
    }


    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
