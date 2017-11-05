package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CustomerLoginUI implements UI, ActionListener {
    
    JFrame frame;
    JButton signIn,register,quit;

    @Override
    public void draw() {
        frame = new JFrame("LOGIN");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new BorderLayout());
        
        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, 3));
        
        signIn = new JButton("SIGN IN");
        signIn.addActionListener(this);
        buttons.add(signIn);
        
        register = new JButton("REGISTER");
        register.addActionListener(this);
        buttons.add(register);
        
        quit = new JButton("QUIT");
        quit.addActionListener(this);
        buttons.add(quit);
        
        frame.add("Center", buttons);
             
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton pressed = (JButton) e.getSource();
        
        if(pressed.equals(signIn)) {
            new CustomerSignIn().draw();
        }
        else if(pressed.equals(register)) {
            this.frame.dispose();
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
    JFrame window;
    JTextField firstname, surname, password, email, number;
    JButton register, goBack;
    
    @Override
    public void draw() {
        window = new JFrame("Register your Account");
        window.setSize(350, 230);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        
        
        JPanel input = new JPanel();
        input.setLayout(new GridLayout(5, 2));
        
        input.add(new JLabel("Enter your firstname"));
        input.add((firstname = new JTextField()));
        
        input.add(new JLabel("Enter your surname"));
        input.add((surname = new JTextField()));
        
        input.add(new JLabel("Enter your password"));
        input.add((password = new JTextField()));
        
        input.add(new JLabel("Enter your email address"));
        input.add((email = new JTextField()));
        
        input.add(new JLabel("Enter your number"));
        input.add((number = new JTextField()));
        
        window.add("Center", input);
        
        
        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout());
        
        register = new JButton("Register");
        register.addActionListener(this);
        buttons.add(register);
        
        goBack = new JButton("Go Back");
        goBack.addActionListener(this);
        buttons.add(goBack);
        
        window.add("South", buttons);
        window.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton pressed = (JButton)e.getSource();
        
        if(pressed.equals(goBack))
        {
            new CustomerLoginUI().draw();
            this.window.dispose();
        }
    }
    
}
