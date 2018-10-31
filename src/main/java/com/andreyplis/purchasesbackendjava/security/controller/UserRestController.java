package com.andreyplis.purchasesbackendjava.security.controller;

import javax.servlet.http.*;

import com.andreyplis.purchasesbackendjava.security.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserRestController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    @Qualifier("jwtUserDetailsService")
    private UserDetailsService userDetailsService;

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public JwtUser getAuthenticatedUser(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader).substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        return user;
    }

}
