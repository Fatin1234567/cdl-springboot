package fatin.kazi.cdl.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository repo;

    public void createUserAccount(User user) {

        user.setPassword(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(user.getPassword()));
        repo.save(user);
    }

    public boolean loginExists(String username){
        return repo.existsByUserName(username);
    }


}
