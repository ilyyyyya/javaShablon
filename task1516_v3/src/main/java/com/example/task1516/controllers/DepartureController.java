package com.example.task1516.controllers;

import com.example.task1516.entity.Departure;
import com.example.task1516.service.DepartureService;
import com.example.task1516.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class DepartureController {

    @Autowired
    private DepartureService depService;
    @Autowired
    private EmailService emailService;

    @GetMapping("/get_departures")
    public List<Departure> getDepartures() {
        return depService.getDepartures();
    }

    @GetMapping("get_departure/{departureID}")
    public Departure getDepartureByID(@PathVariable(value = "departureID") int id) {
        return depService.getDepartureByID(id);
    }


    @PostMapping("/add_departure")
    public HttpStatus addDeparture(@RequestBody Departure d) {
        try {
            depService.addDeparture(d);
            emailService.sendAddDepartureEmail(new Departure(d.getId(), d.getType(), d.getDeparture_date(), d.getEdu_type()));
            return HttpStatus.CREATED;
        }
        catch (Exception e) {
            return HttpStatus.BAD_REQUEST;
        }
    }

    @DeleteMapping("/delete_departure/{departureID}")
    public HttpStatus deleteDeparture(@PathVariable(value = "departureID") int id) {
        try {
            depService.deleteDeparture(id);
            return HttpStatus.OK;
        }
        catch (Exception e) {
            return HttpStatus.NOT_FOUND;
        }
    }

//    @GetMapping("/getDepartureByType")
//    public @ResponseBody List<Departure> getByType(Model model){
//        return depService.getByType();
//    }
//    @GetMapping("/getDepartureByDate")
//    public @ResponseBody List<Departure> getByDate(Model model){
//        return depService.getByDate();
//    }


}
