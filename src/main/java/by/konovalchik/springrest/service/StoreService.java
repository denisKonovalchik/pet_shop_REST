package by.konovalchik.springrest.service;


import by.konovalchik.springrest.entity.Order;
import by.konovalchik.springrest.repository.StoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class StoreService {
    StoreRepository store;


   public Optional<Order> findOrderById(long id){
       return store.findById(id);
   }


   public boolean deleteOrderById(long id){
       if(store.existsById(id)){
           store.deleteById(id);
           return  true;
       }
       return false;
   }

    public boolean placeOrder(Order order){
       if(store.existsById(order.getId())){
           return false;
       }else{
           store.save(order);
           return  true;
       }
    }



}
