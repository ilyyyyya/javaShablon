package ru.mirea.ikbo3021.practica13.components;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

@Data
@Component
@Log4j2

public class Student {
    @Value("${student.name}")
    String name;
    @Value("${student.lastName}")
    String last_name;
    @Value("${student.group}")
    String group;

    @PostConstruct
    private void init() {
        System.out.println(this);
    }
}
