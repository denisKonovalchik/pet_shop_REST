package by.konovalchik.springrest.repository;

import by.konovalchik.springrest.entity.Order;
import by.konovalchik.springrest.entity.Pet;
import by.konovalchik.springrest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Order,Long> {



}
