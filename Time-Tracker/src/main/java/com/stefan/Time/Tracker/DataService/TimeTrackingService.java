package com.stefan.Time.Tracker.DataService;

import com.stefan.Time.Tracker.Domain.TimeIntervall;

public interface TimeTrackingService {

    void saveTime(TimeIntervall timeIntervall);
}
