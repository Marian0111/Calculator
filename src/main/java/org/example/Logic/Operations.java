package org.example.Logic;
import org.example.Model.*;

import java.util.*;
import static java.lang.Math.abs;

public class Operations {
    private Monomial m = new Monomial();
    public Polynomial add(Polynomial p1, Polynomial p2){
        Polynomial p3 = new Polynomial();
        for(Map.Entry<Integer, Double> y1 : p1.getP().entrySet()){
            p3.addMonom(new Monomial(y1.getValue(),y1.getKey()));
        }
        for(Map.Entry<Integer, Double> y2 : p2.getP().entrySet()){
            boolean ok = true;
            for(Map.Entry<Integer, Double> y3 : p3.getP().entrySet()){
                if(y3.getKey() == y2.getKey()){
                    m.setExp(y3.getKey());
                    m.setCoef(y3.getValue() + y2.getValue());
                    p3.addMonom(m);
                    ok = false;
                    break;
                }
            }
            if(ok){
                m.setExp(y2.getKey());
                m.setCoef(y2.getValue());
                p3.addMonom(m);
            }
        }
        return p3;
    }
    public Polynomial sub(Polynomial p1, Polynomial p2){
        Polynomial p3 = new Polynomial();
        for(Map.Entry<Integer, Double> y1 : p1.getP().entrySet()){
            p3.addMonom(new Monomial(y1.getValue(),y1.getKey()));
        }
        for(Map.Entry<Integer, Double> y2 : p2.getP().entrySet()){
            boolean ok = true;
            for(Map.Entry<Integer, Double> y3 : p3.getP().entrySet()){
                if(y3.getKey() == y2.getKey()){
                    m.setExp(y3.getKey());
                    m.setCoef(y3.getValue() - y2.getValue());
                    p3.addMonom(m);
                    ok = false;
                    break;
                }
            }
            if(ok){
                m.setExp(y2.getKey());
                m.setCoef(-y2.getValue());
                p3.addMonom(m);
            }
        }
        return p3;
    }
    public Polynomial mul(Polynomial p1, Polynomial p2){
        Polynomial p3 = new Polynomial();
        for(Map.Entry<Integer, Double> y1 : p1.getP().entrySet()){
            for(Map.Entry<Integer, Double> y2 : p2.getP().entrySet()){
                boolean ok = true;
                for(Map.Entry<Integer, Double> y3 : p3.getP().entrySet()){
                    if(y1.getKey() + y2.getKey() == y3.getKey()){
                        y3.setValue(y3.getValue() + y1.getValue() * y2.getValue());
                        ok = false;
                    }
                }
                if(ok) {
                    m.setExp(y1.getKey() + y2.getKey());
                    m.setCoef(y1.getValue() * y2.getValue());
                    p3.addMonom(m);
                }
            }
        }
        return p3;
    }
    private void divRecursive(Polynomial p1, Polynomial p2, Polynomial pResult, Polynomial pReminder){
        boolean ok = true;
        Monomial first = new Monomial();
        for (Map.Entry<Integer, Double> y1 : p1.getP().entrySet()) {
            if(abs(y1.getValue()) > 0.001 && y1.getKey() >= p2.getP().firstEntry().getKey()) {
                first.setCoef(y1.getValue());
                first.setExp(y1.getKey());
                ok = false;
                break;
            }
        }
        if(ok){
            for(Map.Entry<Integer, Double> y : p1.getP().entrySet())
                pReminder.addMonom(new Monomial(y.getValue(),y.getKey()));
            return;
        }
        pResult.addMonom(new Monomial(first.getCoef() / p2.getP().firstEntry().getValue(), first.getExp() - p2.getP().firstEntry().getKey()));
        Polynomial pAux = new Polynomial();
        for (Map.Entry<Integer, Double> y2 : p2.getP().entrySet()) {
            pAux.addMonom(new Monomial(y2.getValue() * (first.getCoef() / p2.getP().firstEntry().getValue()), y2.getKey() + (first.getExp() - p2.getP().firstEntry().getKey())));
        }
        p1 = sub(p1, pAux);
        divRecursive(p1, p2, pResult, pReminder);
    }
    public void div(Polynomial p1, Polynomial p2, Polynomial pResult, Polynomial pReminder){
        pReminder.getP().clear();
        pResult.getP().clear();
        if(!p2.toString().equals("0"))
            divRecursive(p1, p2, pResult, pReminder);
    }
    public Polynomial deriv(Polynomial p1){
        Polynomial p3 = new Polynomial();
        for(Map.Entry<Integer, Double> y1 : p1.getP().entrySet()) {
            if(y1.getKey() != 0) {
                m.setExp(y1.getKey() - 1);
                m.setCoef(y1.getValue() * y1.getKey());
                p3.addMonom(m);
            }
        }
        return p3;
    }
    public Polynomial integral(Polynomial p1){
        Polynomial p3 = new Polynomial();
        for(Map.Entry<Integer, Double> y1 : p1.getP().entrySet()) {
            m.setExp(y1.getKey() + 1);
            m.setCoef(y1.getValue() / (y1.getKey() + 1));
            p3.addMonom(m);
        }
        return p3;
    }
}