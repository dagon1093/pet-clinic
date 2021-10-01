package ru.alex.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.alex.petclinic.model.*;
import ru.alex.petclinic.services.OwnerService;
import ru.alex.petclinic.services.PetTypeService;
import ru.alex.petclinic.services.SpecialtyService;
import ru.alex.petclinic.services.VetService;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }


    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);


        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);


        Owner owner1 = new Owner();
        owner1.setFirstName("Khalipha");
        owner1.setLastName("Gendievna");
        owner1.setAddress("123 posad");
        owner1.setCity("Pskov");
        owner1.setTelephone("88005553535");

        ownerService.save(owner1);

        Pet khaliphasPet = new Pet();
        khaliphasPet.setPetType(savedDogPetType);
        khaliphasPet.setOwner(owner1);
        khaliphasPet.setBirthDate(LocalDate.now());
        khaliphasPet.setName("Cosa");
        owner1.getPets().add(khaliphasPet);

        Owner owner2 = new Owner();
        owner2.setFirstName("Yota");
        owner2.setLastName("Asakurok");
        owner2.setAddress("321 posad");
        owner2.setCity("Moscow");
        owner2.setTelephone("88005553355");
        ownerService.save(owner2);

        Pet yotasPet = new Pet();
        yotasPet.setName("Nostra");
        yotasPet.setOwner(owner2);
        yotasPet.setBirthDate(LocalDate.now());
        yotasPet.setPetType(savedCatPetType);
        owner2.getPets().add(yotasPet);

        System.out.println("Owners saved:" + ownerService.findById(1L).getFirstName());
        System.out.println("Owners saved:" + ownerService.findById(2L).getFirstName());

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Samuele");
        vet2.setLastName("Axevich");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);
    }
}
