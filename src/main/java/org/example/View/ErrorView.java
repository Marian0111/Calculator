package org.example.View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class ErrorView {
    private JFrame frame = new JFrame("Error message");
    private JPanel panel = new JPanel();
    private JLabel title = new JLabel("Error");
    private JLabel errorLbl = new JLabel();
    private JButton errorBtn = new JButton("OK");
    private Border border = BorderFactory.createLineBorder(new Color(25,155,155));
    public ErrorView(){
        frame.setSize(350, 200);
        frame.setResizable(false);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);

        title.setBounds((frame.getWidth() - 200)/ 2,20, 200, 30);
        title.setFont(new Font("Calibri", Font.BOLD, 25));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(title);

        errorLbl.setBounds((frame.getWidth() - 300)/ 2, 50, 300,30);
        title.setFont(new Font("Calibri", Font.BOLD, 20));
        errorLbl.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(errorLbl);

        errorBtn.setBounds((frame.getWidth() - 120)/ 2, 90, 120, 30);
        errorBtn.setBorder(border);
        panel.add(errorBtn);

        panel.setBackground(new Color(25,155,155));
        frame.setContentPane(panel);
        frame.setLayout(null);
    }
    public void openFrame(){
        frame.setVisible(true);
    }
    public void closeFrame(){frame.setVisible(false);}
    public void changeErrorText(String s){errorLbl.setText(s);}
    public void addErrorListener(ActionListener e){
        errorBtn.addActionListener(e);
    }
}
