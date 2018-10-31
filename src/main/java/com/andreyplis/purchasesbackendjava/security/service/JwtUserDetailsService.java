package com.andreyplis.purchasesbackendjava.security.service;

import com.andreyplis.purchasesbackendjava.security.*;
import com.andreyplis.purchasesbackendjava.security.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;
import com.andreyplis.purchasesbackendjava.model.security.User;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return JwtUserFactory.create(user);
        }
    }
}
