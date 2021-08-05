package fatin.kazi.cdl.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository repo;

    public void saveUser(User user){
        repo.save(user);
    }


}
