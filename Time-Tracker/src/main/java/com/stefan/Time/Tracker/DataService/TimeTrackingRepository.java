package com.stefan.Time.Tracker.DataService;

import com.stefan.Time.Tracker.Domain.TimeIntervall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeTrackingRepository extends JpaRepository<TimeIntervall, Long> {
}
