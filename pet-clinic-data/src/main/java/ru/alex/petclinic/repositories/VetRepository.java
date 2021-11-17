package ru.alex.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.alex.petclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
