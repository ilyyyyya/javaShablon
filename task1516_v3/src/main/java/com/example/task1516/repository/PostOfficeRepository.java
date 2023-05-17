package com.example.task1516.repository;

import com.example.task1516.entity.PostOffice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Repository
public interface PostOfficeRepository extends CrudRepository<PostOffice, Integer> {

    PostOffice getPostOfficeById(int id);

    List<PostOffice> findAll();

//    List<PostOffice> findByOrderByName();
//    List<PostOffice> findByOrderByNameCity();


}