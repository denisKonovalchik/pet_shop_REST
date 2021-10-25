package by.konovalchik.springrest.controller;


import by.konovalchik.springrest.entity.Pet;
import by.konovalchik.springrest.entity.PetStatus;

import by.konovalchik.springrest.service.PetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Enumerated;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pet")
@AllArgsConstructor
@Validated
public class PetController {
    PetService petService;



    @PostMapping("/save")
    public boolean save(@Valid @RequestBody Pet pet){
        return petService.savePet(pet);
    }


    @Transactional
    @PutMapping("/update")
    public boolean update(@Valid @RequestBody Pet pet){
        return petService.updatePet(pet);
    }



    @Transactional(readOnly = true)
    @PostMapping("/findByStatus/{status}")
    public ResponseEntity<List <Pet>> findByStatus(@Valid @PathVariable String status){
       PetStatus statusOpt = PetStatus.getEnum(status);
        Optional<List<Pet>> pets = petService.getPetByStatus(statusOpt);
       if(pets.isPresent()){
           return new ResponseEntity<>(pets.get(), HttpStatus.OK) ;
       }
       return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }



    @Transactional(readOnly = true)
    @GetMapping("/getPet/{petId}")
    public ResponseEntity<Pet> getPetById(@PathVariable long petId){
        Optional<Pet> petOpt = petService.findPetById(petId);
        if(petOpt.isPresent()){
            return ResponseEntity.ok(petOpt.get());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }



    @PostMapping("/updateById/{petId}")
    public boolean updatePetById(@PathVariable long petId, @Valid @NotNull @NotBlank @NotEmpty @RequestParam String name, @RequestParam PetStatus status){
       return petService.updatePetNameStatus(petId, name, status);

    }

    @DeleteMapping("/delete/{petId}")
    public boolean delete(@PathVariable long petId){
        return petService.deletePet(petId);
    }

}
