package ru.alex.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.alex.petclinic.model.Owner;
import ru.alex.petclinic.model.Vet;
import ru.alex.petclinic.services.OwnerService;
import ru.alex.petclinic.services.VetService;
import ru.alex.petclinic.services.map.OwnerServiceMap;
import ru.alex.petclinic.services.map.VetServiceMap;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Khalipha");
        owner1.setLastName("Gendievna");

        ownerService.save(owner1);

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);


    }
}
