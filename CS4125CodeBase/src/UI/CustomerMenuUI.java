/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

    import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CustomerMenuUI implements UI, ActionListener  {



    
    JFrame frame;
    JButton order,rpo,quit;

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
        
        rpo = new JButton("REVIEW PAST ORDERS");
        rpo.addActionListener(this);
        buttons.add(rpo, bag);
        
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
           // new PlaceOrder().draw();
        }
        else if(pressed.equals(rpo)) {
            this.frame.dispose();
           // new ReviewPastOrder().draw();
        }
        else
            System.exit(0);
    }
}
