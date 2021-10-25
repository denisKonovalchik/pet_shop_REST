package by.konovalchik.springrest.controller;


import by.konovalchik.springrest.entity.Order;
import by.konovalchik.springrest.entity.Pet;
import by.konovalchik.springrest.service.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/store")
@AllArgsConstructor
public class StoreController {
    StoreService storeService;


    @PostMapping("/place")
    public boolean placeOrder(@Valid @RequestBody Order order) {
        return storeService.placeOrder(order);
    }


    @Transactional
    @DeleteMapping("/delete/{id}")
    public boolean deleteOrderById(@PathVariable long id){
       return storeService.deleteOrderById(id);
    }


    @Transactional(readOnly = true)
    @GetMapping("/find/{id}")
    public ResponseEntity<Order> findOrderById(@PathVariable long id){
        Optional<Order> order = storeService.findOrderById(id);
        if(order.isPresent()){
            return ResponseEntity.ok(order.get());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }



}
