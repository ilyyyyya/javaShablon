package com.example.task1516.controllers;

import com.example.task1516.entity.Departure;
import com.example.task1516.entity.PostOffice;
import com.example.task1516.repository.PostOfficeRepository;
import com.example.task1516.service.DepartureService;
import com.example.task1516.service.EmailService;
import com.example.task1516.service.PostOfficeService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostOfficeController {

    @Autowired
    private PostOfficeService postService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/add_postOffice/{departureID}")
    public HttpStatus addPostOffice(@PathVariable(value = "departureID") int id,@RequestBody PostOffice p) {
        try {
            postService.addPostOffice(p,id);
            emailService.sendAddPostOfficeEmail(new PostOffice(p.getId(), p.getName(), p.getCity_name(),p.getDeparture()));
            return HttpStatus.CREATED;
        }
        catch(Exception e) {
            return HttpStatus.NOT_FOUND;
        }
    }
    @GetMapping("/get_postoffices")
    public List<PostOffice> getPostOffices() {
        return postService.getAllPostOffices();
    }


    @DeleteMapping("/delete_postoffice/{postID}")
    public HttpStatus deletePost(@PathVariable(value = "postID") int id) {
        try {
            postService.deletePostOffice(id);
            return HttpStatus.OK;
        }
        catch (Exception e) {
            return HttpStatus.NOT_FOUND;
        }
    }


//    @GetMapping("/getPostOfficeByName")
//    public @ResponseBody List<PostOffice> filterName(Model model){
//        return postService.getByName();
//    }
//    @GetMapping("/getPostOfficeByCity")
//    public @ResponseBody List<PostOffice> filterCity(Model model){
//        return postService.getByCity();
//    }
}
