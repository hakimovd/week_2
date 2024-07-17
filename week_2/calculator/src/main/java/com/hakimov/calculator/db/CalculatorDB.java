package com.hakimov.calculator.db;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CalculatorDB {

    private List<String> expressions = new ArrayList<>();

    public List<String> getExpressions() {
        return expressions;
    }

    public void save(String string) {
        expressions.add(string);
    }

}
