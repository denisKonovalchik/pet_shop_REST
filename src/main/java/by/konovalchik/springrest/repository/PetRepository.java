package by.konovalchik.springrest.repository;

import by.konovalchik.springrest.entity.Pet;
import by.konovalchik.springrest.entity.PetStatus;
import by.konovalchik.springrest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PetRepository extends JpaRepository<Pet, Long> {

//    @Query(value = "from Pet p where p.status = ?1 ")
    Optional<List<Pet>> getPetByStatus(PetStatus petStatus);


}
