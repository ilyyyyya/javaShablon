package com.example.task1516.service;

import com.example.task1516.entity.Departure;
import com.example.task1516.entity.PostOffice;
import com.example.task1516.repository.DepartureRepository;
import com.example.task1516.repository.PostOfficeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PostOfficeService  {
    @Autowired
    private PostOfficeRepository officeRepository;
    @Autowired
    private DepartureRepository departureRepository;

    public PostOfficeService(PostOfficeRepository officeRepository){
        this.officeRepository = officeRepository;
    }

    public PostOffice getPostOfficeById(int id){
        return officeRepository.getPostOfficeById(id);
    }

    public void addPostOffice(PostOffice po,int id) {
        Departure d = departureRepository.findById(id).get();
        po.setDeparture(d);
        log.info("postoffice add {}",po,id);
        officeRepository.save(po);
    }


    public List<PostOffice> getAllPostOffices() {
        return officeRepository.findAll();
    }

    public void deletePostOffice(int id) {
        officeRepository.deleteById(id);
    }

}