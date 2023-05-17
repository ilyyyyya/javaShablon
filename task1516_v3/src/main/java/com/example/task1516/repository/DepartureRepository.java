package com.example.task1516.repository;

import com.example.task1516.entity.Departure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DepartureRepository extends CrudRepository<Departure, Integer> {
    Departure getDepartureById(int id);

    List<Departure> findAll();

//    List<Departure> findByType();
//    List<Departure> findByDepartureDate();
}
