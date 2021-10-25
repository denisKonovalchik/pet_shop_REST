package by.konovalchik.springrest.controller;

import by.konovalchik.springrest.entity.User;
import by.konovalchik.springrest.repository.UserRepository;
import by.konovalchik.springrest.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Validated
public class UserController {
    private final UserService userService;

    @Transactional
    @PostMapping("/create")
    public boolean save(@Valid @RequestBody User user){
        return userService.saveUser(user);
    }


    @Transactional
    @PutMapping("/update/{username}")
    public boolean update(@Valid @Size(min = 3, max = 20) @PathVariable String username, @Valid @RequestBody User user){
        return userService.updateUserByUsername(username, user);
    }


    @Transactional
    @DeleteMapping("/delete/{username}")
    public boolean deleteByUsername(@PathVariable String username){
        return userService.deleteUserByUsername(username);
    }


   @Transactional(readOnly = true)
   @GetMapping("/getUser/{username}")
   public ResponseEntity<User> getUserByUsername(@Valid @NotBlank @Size(min = 3, max = 20) @PathVariable String username){
        Optional<User> userOpt = userService.getUserByUsername(username);
        if(userOpt.isPresent()){
             return ResponseEntity.ok(userOpt.get());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
   }


}
