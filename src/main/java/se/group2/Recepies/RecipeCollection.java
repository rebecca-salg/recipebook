package se.group2.Recepies;


import javax.persistence.*;

@Entity
public class RecipeCollection {


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
    private Long id;
    @OneToOne
    private User user;
    @OneToOne
    private Recipe recipe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
