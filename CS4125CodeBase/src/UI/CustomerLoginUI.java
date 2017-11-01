package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CustomerLoginUI implements UI, ActionListener {
    
    JButton signIn,register,quit;

    @Override
    public void draw() {
        JFrame frame = new JFrame("LOGIN");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
	frame.setLayout(new BoxLayout(frame,3));
        
        signIn = new JButton("SIGN IN");
        signIn.addActionListener(this);
        register = new JButton("REGISTER");
        register.addActionListener(this);
        quit = new JButton("QUIT");
        quit.addActionListener(this);
        frame.add(signIn);
        frame.add(register);
        frame.add(quit);
             
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton pressed = (JButton) e.getSource();
        
        if(pressed.equals("SIGN IN")) {
            new CustomerSignIn().draw();
        }
        else if(pressed.equals("REGISTER")) {
            new CustomerRegister().draw();
        }
        else
            System.exit(0);
    }
}

class CustomerSignIn implements UI,ActionListener {

    @Override
    public void draw() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

class CustomerRegister implements UI,ActionListener {

    @Override
    public void draw() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
