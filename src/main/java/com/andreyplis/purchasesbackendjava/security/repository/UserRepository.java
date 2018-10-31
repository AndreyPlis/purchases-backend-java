package com.andreyplis.purchasesbackendjava.security.repository;


import com.andreyplis.purchasesbackendjava.model.security.*;
import org.springframework.data.jpa.repository.*;

/**
 * Created by stephan on 20.03.16.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
