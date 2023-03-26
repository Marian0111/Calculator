package org.example.Model;

public class Monomial {
    private Double coef;
    private Integer exp;
    public Monomial(){}
    public Monomial(Double c, Integer e){
        coef = c;
        exp = e;
    }
    public void setCoef(Double coef) {
        this.coef = coef;
    }
    public void setExp(Integer exp) {
        this.exp = exp;
    }
    public Double getCoef() {
        return coef;
    }
    public Integer getExp() {
        return exp;
    }
}
