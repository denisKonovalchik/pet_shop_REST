//package by.konovalchik.springrest.dao;
//
//import by.konovalchik.springrest.entity.User;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//
//@Component
//public class UserDAOImp implements UserDAO {
//    private final List<User> users = new ArrayList<>();
//
//    @Override
//    public boolean isExist(long id) {
//       return users.stream().anyMatch(u -> u.getId()  == id);
//    }
//
//    @Override
//    public void saveUser(User user) {
//        users.add(user);
//    }
//
//    @Override
//    public void updateUserBy(User user) {
//       for(User u: users){
//           if(u.getId() == user.getId()){
//               u.setName(user.getName());
//               u.setUsername(user.getUsername());
//               u.setPassword(user.getPassword());
//               break;
//           }
//       }
//    }
//
//
//    @Override
//    public void deleteUserById(long id) {
//       Optional<User> user = users.stream().filter(u -> u.getId() == id).findFirst();
//        user.ifPresent(users::remove);
//    }
//
//    @Override
//    public Optional<User> getUserById(long id) {
//        return users.stream().filter(u -> u.getId() == id).findFirst();
//    }
//
//    @Override
//    public Optional<List<User>> getAll() {
//        return Optional.of(users);
//    }
//
//}
