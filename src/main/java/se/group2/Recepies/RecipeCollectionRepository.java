package se.group2.Recepies;


import javax.persistence.*;

@Entity
public class RecipeCollectionRepository {


  /*  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_Id")
    private Long user_Id;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_Id")
    private Long recipe_Id;
*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id2;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user" )
    private Long user_id2;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "recipe")
    private Long recipe_id2;

}
