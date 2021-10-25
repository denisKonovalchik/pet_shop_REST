package by.konovalchik.springrest.service;


import by.konovalchik.springrest.entity.User;
import by.konovalchik.springrest.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public boolean saveUser(User user){
        if(userRepository.existsById(user.getId())){
            return false;
        }else {
            userRepository.save(user);
            return true;
        }
    }


    public boolean updateUserByUsername(String username, User user){
       Optional<User> userOpt = userRepository.findUserByUsername(username);
       if(userOpt.isPresent()){
         User userUp =  userRepository.getById(userOpt.get().getId());
         userUp.setUsername(user.getUsername());
         userUp.setFistsName(user.getFistsName());
         userUp.setLastName(user.getLastName());
         userUp.setEmail(user.getEmail());
         userUp.setPassword(user.getPassword());
         userUp.setPhone(user.getPhone());
         userUp.setUserStatus(user.getUserStatus());
         userRepository.save(user);
         return true;
       }
       return false;
    }


    public boolean deleteUserByUsername(String username){
        Optional<User> userOpt = userRepository.findUserByUsername(username);
        if(userOpt.isPresent()){
            userRepository.deleteById(userOpt.get().getId());
            return true;
        }
        return false;
    }


    public Optional<User> getUserByUsername(String username){
        Optional<User> userOpt = userRepository.findUserByUsername(username);
        return userOpt.flatMap(user -> userRepository.findById(user.getId()));
    }



    public Optional<List<User>> getAll(){
        return Optional.of(userRepository.findAll());
    }




}
