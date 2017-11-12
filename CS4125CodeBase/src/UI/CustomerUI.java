package UI;

import Business.Profiles.Cafe;
import Business.Profiles.Profile;
import Business.Profiles.ProfileFactory;
import Data.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class CustomerUI implements UI {

    public CustomerUI() {
     
    }
    
    public void draw() {
        new CustomerLoginUI().draw();
    }
}

class CustomerLoginUI implements UI, ActionListener {
    
    JFrame frame;
    JButton signIn,register,quit;

    @Override
    public void draw() {
        frame = new JFrame("Login");
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(1, 1));
        
        //GridBagConstraints code found at https://stackoverflow.com/questions/29813566/how-do-i-create-spacing-in-between-jbuttons-with-gridbaglayout
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.insets = new Insets(5, 0, 5, 0);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.fill = GridBagConstraints.BOTH;
        
        //BorderFactory code found at https://stackoverflow.com/questions/14117481/how-can-i-set-the-insets-of-a-jframe
        JPanel buttons = new JPanel();
        buttons.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        buttons.setLayout(new GridBagLayout());
        
        signIn = new JButton("SIGN IN");
        signIn.addActionListener(this);
        buttons.add(signIn, constraints);
        
        register = new JButton("REGISTER");
        register.addActionListener(this);
        buttons.add(register, constraints);
        
        quit = new JButton("QUIT");
        quit.addActionListener(this);
        buttons.add(quit, constraints);
        
        frame.add(buttons);
             
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton pressed = (JButton) e.getSource();
        
        if(pressed.equals(signIn)) {
            this.frame.dispose();
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
    JFrame window;
    JTextField email;
    JPasswordField password;
    JButton signIn, goBack;
    
    @Override
    public void draw() {
        window = new JFrame("Sign In");
        window.setSize(325, 140);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        
        
        JPanel input = new JPanel();
        input.setLayout(new GridLayout(2, 2));
        
        input.add(new JLabel("Email:"));
        input.add((email = new JTextField()));
        
        input.add(new JLabel("Password:"));
        input.add((password = new JPasswordField()));
        
        
        window.add("Center", input);
        
        
        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout());
        
        signIn = new JButton("Sign In");
        signIn.addActionListener(this);
        buttons.add(signIn);
        
        goBack = new JButton("Go Back");
        goBack.addActionListener(this);
        buttons.add(goBack);
        
        window.add("South", buttons);
        window.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton pressed = (JButton)e.getSource();
        
        if(pressed.equals(signIn)) {
            new CustomerMenuUI().draw();
            this.window.dispose();
        }
        
        else if(pressed.equals(goBack)){
            new CustomerLoginUI().draw();
            this.window.dispose();
        }
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
        
        input.add(new JLabel("Enter your firstname:"));
        input.add((firstname = new JTextField()));
        
        input.add(new JLabel("Enter your surname:"));
        input.add((surname = new JTextField()));
        
        input.add(new JLabel("Enter your password:"));
        input.add((password = new JTextField()));
        
        input.add(new JLabel("Enter your email address:"));
        input.add((email = new JTextField()));
        
        input.add(new JLabel("Enter your number:"));
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
        
        
        if(pressed.equals(register)) {
            
            String[] customerDetails = new String[5];
            customerDetails[0] = firstname.getText();
            customerDetails[1] = surname.getText();
            customerDetails[2] = email.getText();
            customerDetails[3] = password.getText();
            customerDetails[4] = number.getText();

            try {
                Profile profile = ProfileFactory.createProfile("Customer",customerDetails);
            } catch (IOException ex) {
                Logger.getLogger(CustomerRegister.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Created customer");

            
            new CustomerLoginUI().draw();
            this.window.dispose();
            
        }
        
        else if(pressed.equals(goBack))
        {
            new CustomerLoginUI().draw();
            this.window.dispose();
        }
    }
    
}
    
class CustomerMenuUI implements UI, ActionListener  {
    JFrame frame;
    JButton order, viewProfile, quit, signOut;

    @Override
    public void draw() {
        frame = new JFrame("Menu");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(1, 1));

        //GridBagConstraints code found at https://stackoverflow.com/questions/29813566/how-do-i-create-spacing-in-between-jbuttons-with-gridbaglayout
        GridBagConstraints bag = new GridBagConstraints();
        bag.weightx = 1;
        bag.weighty = 1;
        bag.insets = new Insets(5, 0, 5, 0);
        bag.gridwidth = GridBagConstraints.REMAINDER;
        bag.fill = GridBagConstraints.BOTH;

        //BorderFactory code found at https://stackoverflow.com/questions/14117481/how-can-i-set-the-insets-of-a-jframe
        JPanel buttons = new JPanel();
        buttons.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        buttons.setLayout(new GridBagLayout());

        order = new JButton("ORDER");
        order.addActionListener(this);
        buttons.add(order, bag);

        viewProfile = new JButton("VIEW PROFILE");
        viewProfile.addActionListener(this);
        buttons.add(viewProfile, bag);

        signOut = new JButton("SIGN OUT");
        signOut.addActionListener(this);
        buttons.add(signOut, bag);

        quit = new JButton("QUIT");
        quit.addActionListener(this);
        buttons.add(quit, bag);

        frame.add(buttons);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton pressed = (JButton) e.getSource();

        if(pressed.equals(order)) {
           new PlaceOrder().draw();
        }
        else if(pressed.equals(viewProfile)) {
            this.frame.dispose();
            new ViewProfile().draw();
        }
        else if(pressed.equals(signOut)) {
            this.frame.dispose();
            new CustomerLoginUI().draw();
        }
        else
            System.exit(0);
    }
}


class PlaceOrder implements UI,ActionListener {
    JFrame window;
    JComboBox<Cafe> cafe;
    Cafe currentCafe;
    JList orderItems;
    ArrayList<JComboBox<Data.MenuItem>> items;
    JComboBox<String> size, location;
    JButton newItem, place, back;
    
    @Override
    public void draw() {
        window = new JFrame("Place an Order");
        window.setLayout(new BoxLayout(window.getContentPane(), BoxLayout.PAGE_AXIS));
        window.setLocationRelativeTo(null);
        
        cafe = new JComboBox<Cafe>();
        try{
            cafe.addItem(ProfileDB.getInstance().getCafeByDetails("Cafe Waffe", "110 Main Street"));
        } catch (IOException ex){
            closeWindow();
        }
        currentCafe = cafe.getItemAt(cafe.getSelectedIndex());
        window.add(cafe);
        
        window.setVisible(true);
    }

    private void closeWindow()
    {
        window.dispose();
        new CustomerMenuUI();
    }
    
    private void addNewItem()
    {
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton pressed = (JButton)e.getSource();
        
        if(pressed.equals(newItem))
        {
            addNewItem();
        }
        
        if(pressed.equals(place))
        {
            
        }
        
        else if(pressed.equals(back))
        {
            closeWindow();
        }
    }
}

class ViewProfile implements UI,ActionListener {
        JFrame window;
        JLabel firstname, surname, password, email, number;
        JButton pastOrders, goBack;

        @Override
        public void draw() {       

        window = new JFrame("Account Info");
        window.setSize(350, 230);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());


        JPanel input = new JPanel();
        input.setLayout(new GridLayout(5, 2));

        input.add(new JLabel("First name:"));
        input.add((firstname = new JLabel()));

        input.add(new JLabel("Surname:"));
        input.add((surname = new JLabel()));

        input.add(new JLabel("Password:"));
        input.add((password = new JLabel()));

        input.add(new JLabel("Email address:"));
        input.add((email = new JLabel()));

        input.add(new JLabel("Number:"));
        input.add((number = new JLabel()));

        window.add("Center", input);


        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout());

        pastOrders = new JButton("Past Orders");
        pastOrders.addActionListener(this);
        buttons.add(pastOrders);

        goBack = new JButton("Go Back");
        goBack.addActionListener(this);
        buttons.add(goBack);

        window.add("South", buttons);
        window.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton pressed = (JButton)e.getSource();

        if(pressed.equals(pastOrders)) {

        }

        else if(pressed.equals(goBack))
        {
            new CustomerMenuUI().draw();
            this.window.dispose();
        }
    }
    }
