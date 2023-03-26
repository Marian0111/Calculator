package org.example.Controller;

import org.example.Logic.Operations;
import org.example.Model.*;
import org.example.View.*;
import java.awt.event.*;
import java.util.regex.*;

public class Controller {
    private MainView view;
    private ErrorView errView;
    private Operations op;
    private Polynomial p1 = new Polynomial();
    private Polynomial p2 = new Polynomial();
    private Polynomial pRez1 = new Polynomial();
    private Polynomial pRez2 = new Polynomial();

    public Controller(MainView view, Operations op, ErrorView errView) {
        this.op = op;
        this.view = view;
        this.errView = errView;
        view.addAdditionListener(new AdditionListener());
        view.addSubtractionListener(new SubtractionListener());
        view.addDerivativeListener(new DerivativeListener());
        view.addIntegralListener(new IntegralListener());
        view.addMultiplicationListener(new MultiplicationListener());
        view.addDivisionListener(new DivisionListener());
        errView.addErrorListener(new ErrorListener());
    }

    public class AdditionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.setResult1TxtField("");
            view.setResult2TxtField("");
            if(validation(view.getY1TxtField(), "The first") == 0){
                if(validation(view.getY2TxtField(), "The second") == 0) {
                    p1.createPolinom(view.getY1TxtField());
                    p2.createPolinom(view.getY2TxtField());
                    pRez1 = op.add(p1, p2);
                    view.setResult1TxtField(pRez1.toString());
                }
                else errView.openFrame();
            }
            else errView.openFrame();
        }
    }
    public class SubtractionListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            view.setResult1TxtField("");
            view.setResult2TxtField("");
            if(validation(view.getY1TxtField(), "The first") == 0){
                if(validation(view.getY2TxtField(), "The second") == 0) {
                    p1.createPolinom(view.getY1TxtField());
                    p2.createPolinom(view.getY2TxtField());
                    pRez1 = op.sub(p1, p2);
                    view.setResult1TxtField(pRez1.toString());
                }
                else errView.openFrame();
            }
            else errView.openFrame();
        }
    }
    public class MultiplicationListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            view.setResult1TxtField("");
            view.setResult2TxtField("");
            if(validation(view.getY1TxtField(), "The first") == 0){
                if(validation(view.getY2TxtField(), "The second") == 0) {
                    p1.createPolinom(view.getY1TxtField());
                    p2.createPolinom(view.getY2TxtField());
                    pRez1 = op.mul(p1, p2);
                    view.setResult1TxtField(pRez1.toString());
                }
                else errView.openFrame();
            }
            else errView.openFrame();
        }
    }
    public class DivisionListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            view.setResult1TxtField("");
            view.setResult2TxtField("");
            if(validation(view.getY1TxtField(), "The first") == 0){
                if(validation(view.getY2TxtField(), "The second") == 0) {
                    p1.createPolinom(view.getY1TxtField());
                    p2.createPolinom(view.getY2TxtField());
                    op.div(p1, p2, pRez1, pRez2);
                    if(p2.toString().equals("0")){
                        errView.changeErrorText("Division by ZERO!");
                        errView.openFrame();
                    }
                    else {
                        view.setResult1TxtField(pRez1.toString());
                        view.setResult2TxtField(pRez2.toString());
                    }
                }
                else errView.openFrame();
            }
            else errView.openFrame();
        }
    }
    public class DerivativeListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            view.setResult1TxtField("");
            view.setResult2TxtField("");
            if(validation(view.getY1TxtField(), "The first") == 0) {
                p1.createPolinom(view.getY1TxtField());
                pRez1 = op.deriv(p1);
                view.setResult1TxtField(pRez1.toString());
            }
            else errView.openFrame();
        }
    }
    public class IntegralListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            view.setResult1TxtField("");
            view.setResult2TxtField("");
            if(validation(view.getY1TxtField(), "The first") == 0) {
                p1.createPolinom(view.getY1TxtField());
                pRez1 = op.integral(p1);
                if(!pRez1.toString().equals("0"))
                    view.setResult1TxtField(pRez1.toString() + "+C");
                else
                    view.setResult1TxtField("C");
            }
            else errView.openFrame();
        }
    }
    public class ErrorListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            errView.closeFrame();
        }
    }
    private int validation(String p, String err){
        if(!p.equals("")) {
            try{
                String verif = "";
                Pattern pat = Pattern.compile("([+-]?)([0-9]*?)(x\\^)([0-9]*)");
                Matcher match = pat.matcher(p);
                while(!match.hitEnd()){
                    match.find();
                    if(match.group(1) != null)
                        verif += match.group(1).toString();
                    if(match.group(2) != null)
                        verif += match.group(2).toString();
                    verif += match.group(3).toString() + match.group(4).toString();
                }
                if(!p.equals(verif)){
                    errView.changeErrorText(err + " polynomial entered is wrong!");
                    return -1;
                }
            }catch(Exception e){
                errView.changeErrorText(err + " polynomial entered is wrong!");
                return -1;
            }
        }
        else{
            errView.changeErrorText(err + " polynomial entered is null!");
            return -1;
        }
        return 0;
    }
}