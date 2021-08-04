package se.group2.Recepies;

import javax.persistence.*;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String unit;
    private double amount;
    @ManyToOne
    private Recipe ownerRecipe;

    public Ingredient(){

    }

    public Ingredient(String name, String unit, double amount) {
        this.name = name;
        this.unit = unit;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public double getAmount() {
        return amount;
    }

    public Recipe getOwnerRecipe() {
        return ownerRecipe;
    }

    public void setOwnerRecipe(Recipe ownerRecipe) {
        this.ownerRecipe = ownerRecipe;
    }
}
