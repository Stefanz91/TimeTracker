package com.stefan.Time.Tracker.DataService;

import com.stefan.Time.Tracker.Domain.Action;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionRepository extends JpaRepository<Action, Long> {

}
