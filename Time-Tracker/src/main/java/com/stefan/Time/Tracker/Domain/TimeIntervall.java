package com.stefan.Time.Tracker.Domain;

import com.stefan.Time.Tracker.Domain.Action;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity(name = "TimeIntervall")
@Table(name = "time_intervall_table")
public class TimeIntervall {

    @Id
    @SequenceGenerator(
            name = "time_sequence",
            sequenceName = "time_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "time_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Action action;

    @Column(name = "start_timestamp")
    Timestamp startTimestamp;

    @Column(name = "stop_timestamp")
    Timestamp stopTimestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Timestamp getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(Timestamp startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public Timestamp getStopTimestamp() {
        return stopTimestamp;
    }

    public void setStopTimestamp(Timestamp stopTimestamp) {
        this.stopTimestamp = stopTimestamp;
    }

    public TimeIntervall(Action action, Timestamp startTimestamp, Timestamp stopTimestamp) {
        this.action = action;
        this.startTimestamp = startTimestamp;
        this.stopTimestamp = stopTimestamp;
    }

    public TimeIntervall(){

    }
}
