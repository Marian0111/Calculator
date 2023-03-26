package org.example.Model;

import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.*;

import static java.lang.Math.*;

public class Polynomial {
    private TreeMap <Integer, Double> p = new TreeMap<Integer, Double>(Collections.reverseOrder());
    public Polynomial(){}
    public void createPolinom(String s){
        p.clear();
        Double coef = 0.0;
        Integer exp = 0;
        if(!s.equals("")) {
            Pattern pat = Pattern.compile("([+-]?)([0-9]*?)(x\\^)([0-9]*)");
            Matcher match = pat.matcher(s);
            while (!match.hitEnd()) {
                coef = 0.0;
                exp = 0;
                match.find();
                if (match.group(2).equals("")) {
                    if (match.group(1).equals("-"))
                        coef = -1.0;
                    else
                        coef = 1.0;
                } else {
                    if (match.group(1).equals("-"))
                        coef = -(Double.parseDouble(match.group(2)));
                    else
                        coef = Double.parseDouble(match.group(2));
                }
                exp = Integer.parseInt(match.group(4));
                Monomial m = new Monomial(coef, exp);
                this.addMonom(m);
            }
        }
        else{
            Monomial m = new Monomial(coef, exp);
            this.addMonom(m);
        }
    }
    public String toString(){
        String s = "";
        boolean ok = true;
        DecimalFormat df = new DecimalFormat("#.##");
        for(Map.Entry<Integer, Double> e : this.getP().entrySet()){
            if(e.getValue() > 0 || e.getValue() < 0){
                if(!ok && e.getValue() > 0)
                    s = s + "+";
                if(ok && abs(e.getValue() + 1) < 0.001 || abs(e.getValue() + 1) < 0.001)
                    s = s + "-";
                if(abs(e.getValue() - 1) < 0.001 || abs(e.getValue() + 1) < 0.001)
                    s = s + "x^" + e.getKey().toString();
                else if(abs(e.getValue() - floor(e.getValue())) < 0.001 || abs(e.getValue() + floor(e.getValue())) < 0.001)
                    s = s + (int) round(e.getValue()) + "x^" + e.getKey().toString();
                else
                    s = s + Double.valueOf(df.format(e.getValue())) + "x^" + e.getKey().toString();
                ok = false;
            }
        }
        if(s.equals(""))
            s = s + 0;
        return s;
    }
    public void addMonom(Monomial a)
    {
        p.put(a.getExp(), a.getCoef());
    }
    public TreeMap<Integer, Double> getP() {
        return p;
    }
}