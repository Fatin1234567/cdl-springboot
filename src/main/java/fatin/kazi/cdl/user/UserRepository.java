package fatin.kazi.cdl.user;

import fatin.kazi.cdl.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByUserName(String userName);

    public boolean existsByUserName(String username);


}
