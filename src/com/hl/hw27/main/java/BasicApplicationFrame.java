package com.hl.hw27.main.java;

import javax.swing.*;
import java.awt.*;

import static com.hl.hw27.main.java.CalculatorConstants.ERROR_MESSAGE;

public class BasicApplicationFrame {
        private final JFrame mainFrame = new JFrame();

        public BasicApplicationFrame() {
            mainFrame.setTitle("Basic Application v1.0.0");
            mainFrame.setBounds(100, 70, 500, 500);
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
            bottom.setLayout(new GridLayout(5, 4));

            var btnAddActionListener = new AddButtonActionListener(inputField);

            var lSnhackleBtn = new JButton("(");
            lSnhackleBtn.addActionListener(btnAddActionListener);
            bottom.add(lSnhackleBtn);

            var rSnhackleBtn = new JButton(")");
            rSnhackleBtn.addActionListener(btnAddActionListener);
            bottom.add(rSnhackleBtn);

            var dotBtn = new JButton(".");
            dotBtn.addActionListener(btnAddActionListener);
            bottom.add(dotBtn);

            var plusBtn = new JButton("+");
            plusBtn.addActionListener(btnAddActionListener);
            bottom.add(plusBtn);

            var minusBtn = new JButton("-");
            minusBtn.addActionListener(btnAddActionListener);
            bottom.add(minusBtn);

            var multiplBtn = new JButton("*");
            multiplBtn.addActionListener(btnAddActionListener);
            bottom.add(multiplBtn);

            var divBtn = new JButton("/");
            divBtn.addActionListener(btnAddActionListener);
            bottom.add(divBtn);

            var sqrtBtn = new JButton("Math.sqrt");
            sqrtBtn.addActionListener(btnAddActionListener);
            bottom.add(sqrtBtn);

            for (int i = 0; i <= 9; i++) {
                var btn = new JButton(String.valueOf(i));
                btn.addActionListener(btnAddActionListener);
                bottom.add(btn);
                bottom.setForeground(Color.red);
            }
            var acBtn = new JButton("AC");
            acBtn.addActionListener(event -> inputField.setText(""));
            bottom.add(acBtn);

            var calcBtn = new JButton("=");
            calcBtn.addActionListener(event -> {
                inputField.setText(String.valueOf(new Calculator().currentResult(inputField)));
            });
            bottom.add(calcBtn);

            mainFrame.add(bottom, BorderLayout.CENTER);

            mainFrame.setVisible(true);
        }
    }
