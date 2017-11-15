package UseCases.UI;

import Business.Orders.*;
import Business.Profiles.Cafe;
import Data.MenuItem;
import Data.OrderDB;
import Data.ProfileDB;
import UI.CustomerUI;
import UI.EmployeeUI;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class Employee 
{
    static Cafe waffe;
        
    public static void main(String [] args) throws IOException{
        waffe = ProfileDB.getInstance().getCafeByDetails("waffe", "110 Main Street");
        Business.Profiles.Employee employee = new Business.Profiles.Employee("Johnny", "Harpe", "", "", "", waffe);
        
        EmployeeUI eUI = new EmployeeUI();
        
        Cafe waffe;
        Order order = null;
        try
        {
            waffe = ProfileDB.getInstance().getCafeByDetails("waffe", "110 Main Street");
        
            Data.MenuItem[] items = {new Data.MenuItem(waffe, "Scone", 3.0f, 1)};
            order = new SmallOrder(new ToGo(items, "CC"));
        }catch(IOException io){
            System.exit(1);
        }
        
        //eUI.addOrder(order);
        
        new AddOrderWindow().draw();
        eUI.draw();
    }
}

class AddOrderWindow implements UI.UI{
    @Override
    public void draw(){
        JFrame window = new JFrame("Add Order");
        window.setSize(200, 75);
        window.setLayout(new FlowLayout());
        
        JButton addNewOrder = new JButton("Add Order");
        addNewOrder.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e)
            {
                MenuItem[] items = {new MenuItem(Employee.waffe, "Scone", 3.0f, 1)};
                OrderDB.getInstance().addOrder(new SmallOrder(new ToGo(items, "Cash")));
            }
        });
        
        JButton pickNewOrder = new JButton("Pick Order");
        window.add(addNewOrder);
        
        window.setVisible(true);
    }
}
