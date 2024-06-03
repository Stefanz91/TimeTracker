package com.stefan.Time.Tracker;

import com.stefan.Time.Tracker.Domain.Action;
import com.stefan.Time.Tracker.GUIs.AddNewActionGUI;
import com.stefan.Time.Tracker.GUIs.MainGUI;

import java.awt.event.ActionEvent;

public class AddNewActionController {

    private final AddNewActionGUI actionGUI;

    public AddNewActionController(MainGUI mainGUI){
        actionGUI = new AddNewActionGUI(mainGUI);
        actionGUI.addActionListener(this::performAddAction);
    }


    private void performAddAction(ActionEvent actionEvent){
        String actionName = actionGUI.getTxtName().getText();
        Boolean isCategorie = actionGUI.getTextBoxIsAction();
        String kategorie = actionGUI.getTextFieldCategorie().getText();

        Action newAction = new Action(actionName);
        TimeTrackerApplication.setNewActions(newAction);
        TimeTrackerApplication.run();
    }
}
