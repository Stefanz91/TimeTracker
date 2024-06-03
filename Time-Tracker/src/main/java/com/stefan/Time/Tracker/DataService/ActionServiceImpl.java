package com.stefan.Time.Tracker.DataService;

import com.stefan.Time.Tracker.DataService.ActionRepository;
import com.stefan.Time.Tracker.DataService.ActionService;
import com.stefan.Time.Tracker.Domain.Action;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionServiceImpl implements ActionService {
    private final ActionRepository actionRepository;

    public ActionServiceImpl(ActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }

    @Override
    public void save(Action action) {
        actionRepository.save(action);
    }

    @Override
    public List<Action> findAll() {
        return actionRepository.findAll();
    }

}
