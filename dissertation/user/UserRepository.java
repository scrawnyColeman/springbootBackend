package uk.ac.qub.njoy.dissertation.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ac.qub.njoy.dissertation.user.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //public List<User> findByUserRoleId(Long userRoleId);

}