package org.example.Testing;

import org.example.Logic.Operations;
import org.example.Model.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorTest {
    Operations op;
    Polynomial p1;
    Polynomial p2;
    Polynomial p3;
    Polynomial p4;
    Polynomial p5;
    @BeforeEach
    public void initialize() {
        p1 = new Polynomial();
        p2 = new Polynomial();
        p3 = new Polynomial();
        p4 = new Polynomial();
        p5 = new Polynomial();
        p1.createPolinom("7x^6-2x^3-x^2");
        p2.createPolinom("5x^4+2x^3-x^2+x^0");
        p3.createPolinom("4x^4-12x^2+8x^1-x^0");
        op = new Operations();
    }

    @Test
    public void testAdd1() {
        p4 = op.add(p1,p2);
        assertTrue(p4.toString().equals("7x^6+5x^4-2x^2+x^0"), "The result of adding 7x^6-2x^3-x^2 to 5x^4+2x^3-x^2+x^0 is incorrect");
    }
    @Test
    public void testAdd2() {
        p4 = op.add(p1,p3);
        assertTrue(p4.toString().equals("7x^6+4x^4-2x^3-13x^2+8x^1-x^0"), "The result of adding 7x^6-2x^3-x^2 to 4x^4-12x^2+8x^1-x^0 is incorrect");
    }

    @Test
    public void testSubtract1() {
        p4 = op.sub(p1, p2);
        assertTrue(p4.toString().equals("7x^6-5x^4-4x^3-x^0"), "The result of subtraction 7x^6-2x^3-x^2 from 5x^4+2x^3-x^2+x^0 is incorrect");
    }
    @Test
    public void testSubtract2() {
        p4 = op.sub(p1, p3);
        assertTrue(p4.toString().equals("7x^6-4x^4-2x^3+11x^2+8x^1+x^0"), "The result of subtraction 7x^6-2x^3-x^2 from 4x^4-12x^2+8x^1-x^0 is incorrect");
    }

    @Test
    public void testMultiply1() {
        p4 = op.mul(p1, p2);
        assertTrue(p4.toString().equals("35x^10+14x^9-7x^8-10x^7-2x^6+x^4-2x^3-x^2"), "The result of multiplying 7x^6-2x^3-x^2 and 5x^4+2x^3-x^2+x^0 is incorrect");
    }
    @Test
    public void testMultiply2() {
        p4 = op.mul(p1, p3);
        assertTrue(p4.toString().equals("28x^10-84x^8+48x^7-11x^6+24x^5-4x^4-6x^3"), "The result of multiplying 7x^6-2x^3-x^2 and 4x^4-12x^2+8x^1-x^0 is incorrect");
    }
    @Test
    public void testDivision1() {
        op.div(p1,p2,p4,p5);
        assertTrue(p4.toString().equals("1.4x^2-0.56x^1+0.5x^0"), "The result of division 7x^6-2x^3-x^2 by 5x^4+2x^3-x^2+x^0 is incorrect");
        assertTrue(p5.toString().equals("-3.57x^3-1.9x^2+0.56x^1-0.5x^0"), "The reminder of division 7x^6-2x^3-x^2 by 5x^4+2x^3-x^2+x^0 is incorrect");
    }
    @Test
    public void testDivision2() {
        op.div(p1,p3,p4,p5);
        assertTrue(p4.toString().equals("1.75x^2+5.25x^0"), "The result of division 7x^6-2x^3-x^2 by 4x^4-12x^2+8x^1-x^0 is incorrect");
        assertTrue(p5.toString().equals("-16x^4+63.75x^3-42x^2+5.25x^1"), "The reminder of division 7x^6-2x^3-x^2 by 4x^4-12x^2+8x^1-x^0 is incorrect");
    }

    @Test
    public void testDerivate1() {
        p4 = op.deriv(p1);
        assertTrue(p4.toString().equals("42x^5-6x^2-2x^1"), "The derivative of 7x^6-2x^3-x^2 is incorrect");
    }
    @Test
    public void testDerivate2() {
        p4 = op.deriv(p3);
        assertTrue(p4.toString().equals("16x^3-24x^1+8x^0"), "The derivative of 4x^4-12x^2+8x^1-x^0 is incorrect");
    }

    @Test
    public void testIntegrate1() {
        p4 = op.integral(p1);
        assertTrue(p4.toString().equals("x^7-0.5x^4-0.33x^3"), "The result of integrating 7x^6-2x^3-x^2 is incorrect");
    }
    @Test
    public void testIntegrate2() {
        p4 = op.integral(p3);
        assertTrue(p4.toString().equals("0.8x^5-4x^3+4x^2-x^1"), "The result of integrating 4x^4-12x^2+8x^1-x^0 is incorrect");
    }
}