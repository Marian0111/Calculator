package org.example;

import org.example.Logic.Operations;
import org.example.View.*;
import org.example.Controller.Controller;

public class PolynomialCalculatorMVC {
    public static void main(String[] args) {
        MainView v = new MainView();
        ErrorView e = new ErrorView();
        Operations o = new Operations();
        new Controller(v, o, e);
    }
}