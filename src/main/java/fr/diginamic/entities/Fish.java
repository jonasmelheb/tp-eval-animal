package fr.diginamic.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "fish")
public class Fish extends Animal{
    private FishLivEnv livingEnv;

    public Fish() {
    }

    public Fish(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }

    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "livingEnv=" + livingEnv +
                '}';
    }
}
