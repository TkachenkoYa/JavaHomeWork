package com.hl.hw27.main.java;

import javax.swing.*;
import java.awt.*;

import static com.hl.hw27.main.java.CalculatorConstants.ERROR_MESSAGE;

public class BasicApplicationFrame {
    private final JFrame mainFrame = new JFrame();

    public BasicApplicationFrame() {
        mainFrame.setTitle("Basic Application v1.0.0");
        mainFrame.setBounds(100, 70, 300, 500);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainFrame.setLayout(new BorderLayout());

        // top
        var top = new JPanel();
        top.setLayout(new BorderLayout());

        var inputField = new JTextField();
        inputField.setEditable(false);
        top.add(inputField, BorderLayout.CENTER);

        mainFrame.add(top, BorderLayout.NORTH);

        // bottom
        var bottom = new JPanel();
        bottom.setLayout(new GridLayout(5, 3));

        var btnAddActionListener = new AddButtonActionListener(inputField);

        var acBtn = new JButton("AC");
        acBtn.addActionListener(event -> inputField.setText(""));
        bottom.add(acBtn);

        var plusBtn = new JButton("+");
        plusBtn.addActionListener(btnAddActionListener);
        bottom.add(plusBtn);

        var calcBtn = new JButton("=");
        calcBtn.addActionListener(event -> {
            int sum = 0;
            for (String operand : inputField.getText().split("\\+")) {
                try {
                    sum += Integer.parseInt(operand);
                } catch (NumberFormatException e) {
                    inputField.setText(ERROR_MESSAGE);
                    break;
                }
            }

            inputField.setText(String.valueOf(sum));
        });
        bottom.add(calcBtn);

        for (int i = 0; i <= 9; i++) {
            var btn = new JButton(String.valueOf(i));
            btn.addActionListener(btnAddActionListener);
            bottom.add(btn);
        }

        mainFrame.add(bottom, BorderLayout.CENTER);


        mainFrame.setVisible(true);
    }
}
