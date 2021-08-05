package se.group2.Recepies;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {



    Iterable<User> findByUsername(String username);
}
