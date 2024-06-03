package com.stefan.Time.Tracker.GUIs;

import com.stefan.Time.Tracker.AddNewActionController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame {

    private JButton trackTimeButton;
    private JButton addNewActionButton;
    private JButton showStatisticsButton;

    public MainGUI(){
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(1200,800);
        fillFrame();
        this.setVisible(true);
    }

    private void fillFrame(){
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(50,50,50,50) );
        BorderLayout mainBorderLayout = new BorderLayout(20,20);
        mainPanel.setLayout(mainBorderLayout);

        JLabel headline = new JLabel("Übersicht");
        configureHeadline(headline);

        JPanel centerPanel = new JPanel();
        fillCenterPanel(centerPanel);


        mainPanel.add(headline, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        this.add(mainPanel);
    }

    private void configureHeadline(JLabel headline) {
        headline.setFont(new Font("Calibri",Font.BOLD, 50));
        headline.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void fillCenterPanel(JPanel centerPanel) {

        centerPanel.setLayout(buildtGridLayout());

        centerPanel.add(buildtNewActionButton("Neue Aktion hinzufügen"));
        centerPanel.add(buildtTimetrackerButton("Zeit tracken"));
        centerPanel.add(new JButton("Statistiken"));
    }

    private GridLayout buildtGridLayout(){
        GridLayout gridLayout = new GridLayout(3,1);
        gridLayout.setVgap(75);
        gridLayout.setHgap(75);
        return gridLayout;
    }

    private JButton buildtNewActionButton(String text){
        JButton button = new JButton(text);
        button.addActionListener(this::performOpenAddNewActionGUI);
        return button;
    }

    private JButton buildtTimetrackerButton(String text){
        JButton button = new JButton(text);
        button.addActionListener(this::performOpenTimetrackerGUI);
        return button;
    }

    private void performOpenAddNewActionGUI(ActionEvent e){
        AddNewActionController addNewActionController = new AddNewActionController(this);
        this.setVisible(false);
    }

    private void performOpenTimetrackerGUI(ActionEvent e){
        TimetrackingGUI timetrackingGUI = new TimetrackingGUI(this);
        this.setVisible(false);
    }



}
