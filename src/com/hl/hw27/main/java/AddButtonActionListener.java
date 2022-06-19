package com.hl.hw27.main.java;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.hl.hw27.main.java.CalculatorConstants.ERROR_MESSAGE;

public class AddButtonActionListener implements ActionListener {

    private final JTextField input;

    public AddButtonActionListener(JTextField input) {
        this.input = input;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var btn = (JButton) e.getSource();
        if (input.getText().contains(ERROR_MESSAGE)) input.setText("");
        input.setText(input.getText() + btn.getText());
    }
}
