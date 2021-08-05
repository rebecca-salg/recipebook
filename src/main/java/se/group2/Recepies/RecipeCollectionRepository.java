package se.group2.Recepies;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeCollectionRepository extends CrudRepository<RecipeCollection, Long> {

    List<RecipeCollection> findAllByUserId(Long id);
}
