package se.group2.Recepies;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String emailAddress);
    Iterable<User> findByUsername(String username);

}
