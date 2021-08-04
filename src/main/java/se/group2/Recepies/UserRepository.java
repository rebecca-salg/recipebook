package se.group2.Recepies;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {


    Iterable<User> findByUsername(String username);
}
