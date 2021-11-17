package ru.alex.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.alex.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
