package com.hl.hw27.main.java;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;

import static com.hl.hw27.main.java.CalculatorConstants.ERROR_MESSAGE;

public class Calculator {
    ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
    ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("Nashorn");

    public Object currentResult(JTextField input) {
        Object currentResult;
        try {
            System.out.println(input.getText());
            currentResult = scriptEngine.eval(input.getText());
        } catch (ScriptException e) {
            input.setText(ERROR_MESSAGE);
            throw new RuntimeException(e);
        }
        return currentResult;
    }
}
