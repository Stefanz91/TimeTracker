package com.stefan.Time.Tracker.GUIs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddNewActionGUI extends JFrame {
    private int rows;
    private JButton confirmSubmission;
    private JTextField txtName;
    private JCheckBox textBoxIsAction;
    private JTextField textFieldCategorie;
    private MainGUI mainGUI;

    public AddNewActionGUI(MainGUI mainGUI){
        this.mainGUI = mainGUI;
        rows = 10;
        this.setSize(1200,800);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addPanels();
        this.setVisible(true);
    }

    private void addPanels() {
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(50,50,50,50) );
        BorderLayout mainBorderLayout = new BorderLayout(20,20);
        mainPanel.setLayout(mainBorderLayout);

        JLabel headline = new JLabel("Actions");
        configureHeadline(headline);

        JPanel centerPanel = new JPanel();
        fillCenterpanel(centerPanel);

        JPanel bottomPanel = new JPanel();
        fillBottomPanel(bottomPanel);

        mainPanel.add(headline,BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        this.add(mainPanel);
    }



    private void configureHeadline(JLabel headline) {
        headline.setFont(new Font("Calibri",Font.BOLD, 50));
        headline.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void fillCenterpanel(JPanel centerPanel) {
        GridLayout gridLayout = new GridLayout(rows,4);
        gridLayout.setVgap(25);
        gridLayout.setHgap(25);
        centerPanel.setLayout(gridLayout);
        centerPanel.setMaximumSize(new Dimension(400,200));
        addBasicRows(centerPanel);
        fillEmptyRows(centerPanel);
    }

    public JTextField getTxtName() {
        return txtName;
    }

    public Boolean getTextBoxIsAction() {
        return textBoxIsAction.isSelected();
    }

    public JTextField getTextFieldCategorie() {
        return textFieldCategorie;
    }

    private void addBasicRows(JPanel centerPanel) {
        JLabel lblName = new JLabel("Bezeichnung:");
        txtName = new JTextField();
        JLabel lblIsAction = new JLabel("Ist eine Tätigkeit:");
        textBoxIsAction = new JCheckBox();
        JLabel cathegorie = new JLabel("Kategorie/Unterpunkt");
        textFieldCategorie = new JTextField();
        JButton addCategorie = new JButton("weitere Kategorie hinzufügen");
        JTextField addAdditionalCategorie = new JTextField();

        centerPanel.add(new JPanel());
        centerPanel.add(lblName);
        centerPanel.add(txtName);
        centerPanel.add(new JPanel());
        centerPanel.add(new JPanel());
        centerPanel.add(lblIsAction);
        centerPanel.add(textBoxIsAction);
        centerPanel.add(new JPanel());
        centerPanel.add(new JPanel());
        centerPanel.add(cathegorie);
        centerPanel.add(textFieldCategorie);
        centerPanel.add(new JPanel());
        centerPanel.add(new JPanel());
        centerPanel.add(addCategorie);
        centerPanel.add(addAdditionalCategorie);
        centerPanel.add(new JPanel());
    }

    private void fillEmptyRows(JPanel centerPanel) {
        for(int i = 0; i< (rows -4)* 4; i++){
            centerPanel.add(new JPanel());
        }
    }

    private void fillBottomPanel(JPanel bottomPanel){
        GridLayout gridLayout = new GridLayout(1,3);

        confirmSubmission = new JButton("Eingabe Bestätigen");
        bottomPanel.add(confirmSubmission);

        JButton getBackButton = new JButton("Zurück");
        getBackButton.addActionListener(this::actionPerformed);
        bottomPanel.setLayout(gridLayout);
        bottomPanel.add(new JPanel());
        bottomPanel.add(getBackButton);
    }

    public void addActionListener(ActionListener action){
        confirmSubmission.addActionListener(action);
    }

    public void actionPerformed(ActionEvent e) {
        mainGUI.setVisible(true);
        this.setVisible(false);
    }
}
