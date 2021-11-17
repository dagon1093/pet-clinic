package ru.alex.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.alex.petclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
