package fr.diginamic;

import fr.diginamic.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.Set;

public class TestTp {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
        System.out.println("connected db");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        //new petstore
        PetStore petStore = new PetStore();
        petStore.setName("petstore");
        petStore.setManagerName("manager name");
        //new address
        Address address = new Address("22", "rue marcel", "34500", "Béziers");
        address.setPetStore(petStore);
        em.persist(address);
        petStore.setAddress(address);
        Product product = new Product("hsdhsd", "label", ProdType.valueOf("FOOD"), 21.00);
        product.setType(ProdType.valueOf("FOOD"));
        product.addPetStore(petStore);
        petStore.addProduct(product);

        //New animal
        //new cat
        Cat cat = new Cat();
        cat.setBirth(new Date());
        cat.setColor("Yello");
        cat.setChipId("CHIPID");
        cat.setPetStore(petStore);
        //new fish
        Fish fish = new Fish();
        fish.setBirth(new Date());
        fish.setColor("red");
        fish.setLivingEnv(FishLivEnv.FRESH_WATER);
        fish.setPetStore(petStore);

        petStore.addAnimal(cat);
        petStore.addAnimal(fish);

        em.persist(petStore);
        transaction.commit();
        em.close();
        emf.close();
    }
}
