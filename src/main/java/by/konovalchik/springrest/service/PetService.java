package by.konovalchik.springrest.service;


import by.konovalchik.springrest.entity.Pet;
import by.konovalchik.springrest.entity.PetStatus;
import by.konovalchik.springrest.entity.User;
import by.konovalchik.springrest.repository.PetRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PetService {
    private final PetRepository petRepository;


    public boolean savePet(Pet pet){
        if(petRepository.existsById(pet.getId())){
            return false;
        }else {
            petRepository.save(pet);
            return true;
        }
    }


    public boolean updatePet(Pet pet){
        if(petRepository.existsById(pet.getId())){
            petRepository.save(pet);
            return true;
        }
        return false;
    }

    public boolean updatePetNameStatus(long id, String name, PetStatus status){
        if(petRepository.existsById(id)) {
            Pet pet = petRepository.getById(id);
            pet.setName(name);
            pet.setStatus(status);
            petRepository.save(pet);
            return true;
        }
        return false;
    }


    public Optional<Pet> findPetById(long id){
        return petRepository.findById(id);
    }

    public boolean deletePet(long id){
        if(petRepository.existsById(id)){
            petRepository.deleteById(id);
            return true;
        }
        return false;
    }


    public Optional<List<Pet>> getPetByStatus(PetStatus status){
        return petRepository.getPetByStatus(status);
    }


}
