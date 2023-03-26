package org.example.View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainView {
    private JFrame frame = new JFrame("Polynomial Calculator");
    private JPanel panel = new JPanel();
    private JLabel title = new JLabel("Polynomial Calculator");
    private JLabel y1Label = new JLabel("y1 : ");
    private JLabel y2Label = new JLabel("y2 : ");
    private JLabel resultLabel = new JLabel("result : ");
    private JTextField y1TxtField = new JTextField();
    private JTextField y2TxtField = new JTextField();
    private JTextField result1TxtField = new JTextField();
    private JTextField result2TxtField = new JTextField();
    private JButton addBtn = new JButton("Addition (+)");
    private JButton subBtn = new JButton("Subtraction (-)");
    private JButton mulBtn = new JButton("Multiplication (*)");
    private JButton divBtn = new JButton("Division (/)");
    private JButton derivBtn = new JButton("Derivative (')");
    private JButton integBtn = new JButton("Integral (∫)");
    private Border border = BorderFactory.createLineBorder(new Color(105,160,208));
    public MainView(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setResizable(false);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);

        title.setBounds((frame.getWidth() - 200)/ 2,30, 200, 30);
        title.setFont(new Font("Calibri", Font.BOLD, 18));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(title);

        y1Label.setBounds(50, 80, 30,30);
        y1Label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(y1Label);
        y2Label.setBounds(50, 115, 30,30);
        y2Label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(y2Label);

        y1TxtField.setBounds(100, 80, 300,30);
        y1TxtField.setBorder(border);
        panel.add(y1TxtField);
        y2TxtField.setBounds(100, 115, 300,30);
        y2TxtField.setBorder(border);
        panel.add(y2TxtField);

        resultLabel.setBounds(30, 165, 50,65);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(resultLabel);
        result1TxtField.setBounds(100, 165, 300,30);
        result1TxtField.setBorder(border);
        panel.add(result1TxtField);
        result2TxtField.setBounds(100, 200, 300,30);
        result2TxtField.setBorder(border);
        panel.add(result2TxtField);

        addBtn.setBounds(70, 260, 150, 35);
        addBtn.setBorder(border);
        panel.add(addBtn);
        subBtn.setBounds(260, 260, 150, 35);
        subBtn.setBorder(border);
        panel.add(subBtn);

        mulBtn.setBounds(70, 310, 150, 35);
        mulBtn.setBorder(border);
        panel.add(mulBtn);
        divBtn.setBounds(260, 310, 150, 35);
        divBtn.setBorder(border);
        panel.add(divBtn);

        derivBtn.setBounds(70, 360, 150, 35);
        derivBtn.setBorder(border);
        panel.add(derivBtn);
        integBtn.setBounds(260, 360, 150, 35);
        integBtn.setBorder(border);
        panel.add(integBtn);

        panel.setBackground(new Color(105,160,208));
        frame.setContentPane(panel);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public String getY1TxtField(){
        return y1TxtField.getText();
    }
    public String getY2TxtField(){
        return y2TxtField.getText();
    }
    public void setResult1TxtField(String s){
        result1TxtField.setText(s);
    }
    public void setResult2TxtField(String s){
        result2TxtField.setText(s);
    }
    public void addAdditionListener(ActionListener e){
        addBtn.addActionListener(e);
    }
    public void addSubtractionListener(ActionListener e){
        subBtn.addActionListener(e);
    }
    public void addMultiplicationListener(ActionListener e){
        mulBtn.addActionListener(e);
    }
    public void addDivisionListener(ActionListener e){
        divBtn.addActionListener(e);
    }
    public void addDerivativeListener(ActionListener e){
        derivBtn.addActionListener(e);
    }
    public void addIntegralListener(ActionListener e){
        integBtn.addActionListener(e);
    }
}