package ru.alex.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.alex.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
