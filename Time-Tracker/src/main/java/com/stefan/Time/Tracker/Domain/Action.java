package com.stefan.Time.Tracker.Domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "action_table")
@Entity(name = "Action")
public class Action {



    @Id
    @SequenceGenerator(
            name = "action_sequence",
            sequenceName = "action_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "action_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(
            mappedBy = "action",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<TimeIntervall> timeIntervallList = new ArrayList<>();

    public Action(String name) {
        this.name = name;
    }

    public Action(){}

    public List<TimeIntervall> getTimeIntervallList() {
        return timeIntervallList;
    }

    public void setTimeIntervallList(List<TimeIntervall> timeIntervallList) {
        this.timeIntervallList = timeIntervallList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
