package ru.alex.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.alex.petclinic.model.Owner;
import ru.alex.petclinic.model.PetType;
import ru.alex.petclinic.model.Vet;
import ru.alex.petclinic.services.OwnerService;
import ru.alex.petclinic.services.PetTypeService;
import ru.alex.petclinic.services.VetService;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCstPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Khalipha");
        owner1.setLastName("Gendievna");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Yota");
        owner2.setLastName("Asakurok");

        ownerService.save(owner2);

        System.out.println("Owners saved:" + ownerService.findById(1L).getFirstName());
        System.out.println("Owners saved:" + ownerService.findById(2L).getFirstName());

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Samuele");
        vet2.setLastName("Axevich");

        vetService.save(vet2);


    }
}
