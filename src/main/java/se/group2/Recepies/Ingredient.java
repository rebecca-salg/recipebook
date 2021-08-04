package se.group2.Recepies;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String unit;
    private double amount;

    public Ingredient(String name, String unit, double amount) {
        this.name = name;
        this.unit = unit;
        this.amount = amount;
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
}
