package ru.alex.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.alex.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
