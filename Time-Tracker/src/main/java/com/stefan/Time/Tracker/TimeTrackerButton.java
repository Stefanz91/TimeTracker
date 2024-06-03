package com.stefan.Time.Tracker;

import com.stefan.Time.Tracker.Domain.Action;
import com.stefan.Time.Tracker.Domain.TimeIntervall;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

public class TimeTrackerButton extends JButton implements ActionListener {
    private Boolean start;
    private Action action;
    private Timestamp startTimestamp;
    private Timestamp endTimestamp;

    public TimeTrackerButton(Action action){
        start = true;
        this.action = action;
        startTimestamp = null;
        endTimestamp = null;
        this.addActionListener(this);
        this.setText("start");
    }

    public void actionPerformed(ActionEvent e) {
        // This method will be called when the button is clicked
        if (start) {
            startTimestamp = new Timestamp(System.currentTimeMillis());
            this.setText("stop");
            // Start tracking time
        } else {
            endTimestamp = new Timestamp(System.currentTimeMillis());
            this.setText("start");
            TimeIntervall timeIntervall = new TimeIntervall(action,startTimestamp,endTimestamp);
            TimeTrackingController.setTimeIntervall(timeIntervall);
            TimeTrackingController.run();
            // End tracking time
            // Calculate time difference if needed
        }
        start = !start; // Toggle start flag
    }


}
