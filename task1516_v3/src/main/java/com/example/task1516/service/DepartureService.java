package com.example.task1516.service;

import com.example.task1516.entity.Departure;
import com.example.task1516.repository.DepartureRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class DepartureService {

    @Autowired
    private DepartureRepository departureRepository;
    public DepartureService(DepartureRepository departureRepository){
        this.departureRepository = departureRepository;
    }
    public List<Departure> getDepartures(){
        return departureRepository.findAll();
    }

    public Departure getDepartureByID(int id) {
        return departureRepository.getDepartureById(id);
    }

    public void addDeparture(Departure d) {
        log.info("add departure {}",d);
        departureRepository.save(d);
    }

    public void deleteDeparture(int id) {
        departureRepository.deleteById(id);
    }

//    public List<Departure> getByType() {
//        return departureRepository.findByType();
//    }

//    public List<Departure> getByDate() {
//        return departureRepository.findByDepartureDate();
//    }
}

