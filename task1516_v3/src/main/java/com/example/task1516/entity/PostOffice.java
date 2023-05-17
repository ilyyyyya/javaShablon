package com.example.task1516.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@Table(name = "postoffices")
@Getter
@Setter
public class PostOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column
    private String city_name;
    public PostOffice() {
    }

    public PostOffice(int id, String name, String city_name, Departure departure) {
        this.id = id;
        this.name = name;
        this.city_name = city_name;
        this.departure = departure;
    }
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Departure departure;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity_name() {
        return city_name;
    }

    public Departure getDeparture() {
        return departure;
    }
}
