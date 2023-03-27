package ru.mirea.ikbo3021.practica11;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
;

@Controller
@ResponseBody
public class TestController {

    @GetMapping("/response_entity")
    public ResponseEntity withResponseEntity() {
        return ResponseEntity.status(HttpStatus.CREATED).body("HTTP Status will be CREATED (CODE 201)\n");
    }
}

// localhost:8080/actuator
//curl -i http://localhost:8080/response_entity
