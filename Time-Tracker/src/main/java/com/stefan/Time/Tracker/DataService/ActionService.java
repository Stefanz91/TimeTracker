package com.stefan.Time.Tracker.DataService;

import com.stefan.Time.Tracker.Domain.Action;

import java.util.List;

public interface ActionService {

    void save(Action action);

    List<Action> findAll();
}
