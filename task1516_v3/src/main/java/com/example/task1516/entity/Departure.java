package com.example.task1516.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Table(name = "departures")
@Getter
@Setter
public class Departure {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = false)
    private String type;

    @Column(nullable = false)
    private String departure_date;

    @Column
    private String edu_type;

    public Departure() {
    }

    public Departure(Long id, String type, String departure_date, String edu_type) {
        this.id = id;
        this.type = type;
        this.departure_date = departure_date;
        this.edu_type = edu_type;
    }

    @OneToMany(mappedBy = "departure", fetch = FetchType.LAZY)
    private List<PostOffice> postsoffice;


    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getDeparture_date() {
        return departure_date;
    }

    public String getEdu_type() {
        return edu_type;
    }


}
