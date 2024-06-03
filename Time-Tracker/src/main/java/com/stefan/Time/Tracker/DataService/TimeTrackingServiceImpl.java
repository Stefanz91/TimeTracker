package com.stefan.Time.Tracker.DataService;

import com.stefan.Time.Tracker.DataService.TimeTrackingRepository;
import com.stefan.Time.Tracker.DataService.TimeTrackingService;
import com.stefan.Time.Tracker.Domain.TimeIntervall;
import org.springframework.stereotype.Service;

@Service
public class TimeTrackingServiceImpl implements TimeTrackingService {

    private final TimeTrackingRepository timeTrackingRepository;

    public TimeTrackingServiceImpl(TimeTrackingRepository timeTrackingRepository){
        this.timeTrackingRepository = timeTrackingRepository;
    }
    @Override
    public void saveTime(TimeIntervall timeIntervall) {
        timeTrackingRepository.save(timeIntervall);
    }
}
