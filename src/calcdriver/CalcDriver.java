
package calcdriver;

import javax.swing.*;

public class CalcDriver {
    
    public static void main(String[] args) 
    {
        Calculator window = new Calculator();
        
        window.setSize(500, 300);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.pack();
    }     
}