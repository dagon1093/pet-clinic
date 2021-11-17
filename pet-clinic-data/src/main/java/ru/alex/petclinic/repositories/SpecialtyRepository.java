package ru.alex.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.alex.petclinic.model.Specialty;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
