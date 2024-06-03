package com.stefan.Time.Tracker.GUIs;

import com.stefan.Time.Tracker.Domain.Action;
import com.stefan.Time.Tracker.TimeTrackerApplication;
import com.stefan.Time.Tracker.TimeTrackerButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class TimetrackingGUI extends JFrame {

    private MainGUI mainGUI;
    public TimetrackingGUI(MainGUI mainGUI){
        this.mainGUI = mainGUI;
        this.setSize(1000,800);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        fillFrame();

        this.setVisible(true);
    }

    private void fillFrame(){
        JPanel panel = new JPanel();
        BorderLayout borderLayout = new BorderLayout();
        panel.setLayout(borderLayout);
        JLabel headline = new JLabel("Tätigkeiten");
        configureHeadline(headline);

        JPanel jobTimePanel = new JPanel();
        fillJobTimePanel(jobTimePanel);

        JPanel bottomPanel = new JPanel();
        fillBottomPanel(bottomPanel);

        panel.add(headline, BorderLayout.NORTH);
        panel.add(jobTimePanel,BorderLayout.CENTER);
        panel.add(bottomPanel,BorderLayout.SOUTH);

        this.add(panel);
    }

    private void configureHeadline(JLabel headline) {
        headline.setFont(new Font("Calibri",Font.BOLD, 50));
        headline.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void fillJobTimePanel(JPanel jobTimePanel) {
        List<com.stefan.Time.Tracker.Domain.Action> actionList;
        TimeTrackerApplication.run();
        actionList = TimeTrackerApplication.getFetchedActions();

        GridLayout gridLayout = new GridLayout(actionList.size(),4);
        gridLayout.setVgap(25);
        gridLayout.setHgap(25);

        jobTimePanel.setLayout(gridLayout);

        if(actionList != null){
            for(Action action : actionList){
                JLabel lblJ = new JLabel(action.getName());
                JButton timer = new TimeTrackerButton(action);
                jobTimePanel.add(new Panel());
                jobTimePanel.add(lblJ);
                jobTimePanel.add(timer);
                jobTimePanel.add(new Panel());
            }
        }

    }

    private void fillBottomPanel(JPanel bottomPanel){
        GridLayout gridLayout = new GridLayout(1,3);
        JButton getBackButton = new JButton("Zurück");
        getBackButton.addActionListener(this::actionPerformed);
        bottomPanel.setLayout(gridLayout);
        bottomPanel.add(new JPanel());
        bottomPanel.add(new JPanel());
        bottomPanel.add(getBackButton);
    }

    public void actionPerformed(ActionEvent e) {
        mainGUI.setVisible(true);
        this.setVisible(false);
    }
}
