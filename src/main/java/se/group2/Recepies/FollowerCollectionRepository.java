package se.group2.Recepies;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FollowerCollectionRepository extends CrudRepository<FollowerCollection, Long> {
    List<FollowerCollection> findAllByUserId(Long id);
}
