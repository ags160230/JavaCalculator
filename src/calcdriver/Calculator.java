package calcdriver;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Calculator extends JFrame implements ActionListener {

    JPanel[] row = new JPanel[11];

    JButton[] button = new JButton[24];
    
    JLabel label1 = new JLabel("  0000   0000   0000   0000   0000   0000   0000   0000");
    
    JLabel label2 = new JLabel("  0000   0000   0000   0000   0000   0000   0000   0000");

    String[] buttonString = {"<-", "CE", "C", "+/-", "√",
        
                             "7", "8", "9", "/", "%",

                             "4", "5", "6", "*", "1/x",

                             "1", "2", "3", "-", "=",

                             "0", ".", "+", ""};

    int[] dimW = {300, 45, 100, 90};

    int[] dimH = {35, 40, 90};

    Dimension displayDimension = new Dimension(300, dimH[0]);

    Dimension regularDimension = new Dimension(dimW[1], dimH[1]);

    Dimension equalButDimension = new Dimension(dimW[1], dimH[2]);

    Dimension zeroButDimension = new Dimension(dimW[3], dimH[1]);

    boolean[] function = new boolean[4];

    double[] temporary = {0, 0};

    JTextArea display1 = new JTextArea(1, 20);
    
    JTextArea display2 = new JTextArea(1, 20);
    
    JTextArea display3 = new JTextArea(1, 20);
    
    Font font1 = new Font("Arial", Font.BOLD, 12);
    
    Font font2 = new Font("Arial", Font.PLAIN, 12);
    
    Font font3 = new Font("Arial", Font.BOLD, 18);
    
    private JTextField tf_display, tf_64bit;
      
    private ArrayList<String> valRepList;
    
    private ArrayList<Double> valList;
   
    private double answer = 0;
    
    private ArrayList<String> lastMathFunc;

    Calculator() 
    {
        super("Calculator");
        
        this.lastMathFunc = new ArrayList<>();
        this.valList = new ArrayList<>();
        this.valRepList = new ArrayList<>();
        valRepList.add("0");
      
        GridLayout grid = new GridLayout(11, 10, 1, 1);
        
        setLayout(grid);

        for(int i = 0; i < 4; i++)
        {
            function[i] = false;
        }

        FlowLayout f1 = new FlowLayout(FlowLayout.CENTER, 1, 1);

        FlowLayout f2 = new FlowLayout(FlowLayout.CENTER, 1, 1);
        
        FlowLayout f3 = new FlowLayout(FlowLayout.CENTER, 1, 1);
        
        FlowLayout f4 = new FlowLayout(FlowLayout.CENTER, 1, 1);
        
        FlowLayout f5 = new FlowLayout(FlowLayout.CENTER, 1, 1);
        
        
        for(int i = 0; i < 11; i++)
        {
            row[i] = new JPanel();
        }
        
        row[0].setLayout(f1);
        
        row[1].setLayout(f2);
        
        row[2].setLayout(f3);
        
        row[3].setLayout(f4);
        
        row[4].setLayout(f5);
        
        for(int i = 5; i < 11; i++)
        {
            row[i].setLayout(f5);
        }
        
        for(int i = 0; i < 24; i++) 
        {
            button[i] = new JButton();

            button[i].setText(buttonString[i]);

            button[i].setFont(font1);

            button[i].addActionListener(this);
        }

        display1.setFont(font3);
        display1.setEditable(false);
        display1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        display1.setPreferredSize(displayDimension);
        
        label1.setPreferredSize(displayDimension);
        label1.setFont(font1);
        label1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
        display2.setFont(font2);
        display2.setEditable(false);
        display2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        display2.setPreferredSize(displayDimension);
        
        label2.setPreferredSize(displayDimension);
        label2.setFont(font1);
        label2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
        display3.setFont(font2);
        display3.setEditable(false);
        display3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        display3.setPreferredSize(displayDimension);

        for(int i = 0; i < 19; i++)
        {
            button[i].setPreferredSize(regularDimension);
        }
        
        button[19].setPreferredSize(regularDimension);
        button[20].setPreferredSize(zeroButDimension);
        button[21].setPreferredSize(regularDimension);
        button[22].setPreferredSize(regularDimension);
        button[23].setPreferredSize(regularDimension);
        
        row[0].add(display1);
        add(row[0]);
        
        row[1].add(label1);
        add(row[1]);
        
        row[2].add(display2);
        add(row[2]);
        
        row[3].add(label2);
        add(row[3]);
        
        row[4].add(display3);
        add(row[4]);

        for(int i = 0; i < 5; i++)
        {
            row[5].add(button[i]);
        }
        
        add(row[5]);

        for(int i = 5; i < 10; i++)
        {
            row[6].add(button[i]);
        }
           
        add(row[6]);

        for(int i = 10; i < 15; i++)
        {
            row[7].add(button[i]);
        }

        add(row[7]);

        for(int i = 15; i < 19; i++)
        {
            row[8].add(button[i]);
        }
        
        row[8].add(button[19]).setLocation(4, 3);
        
        add(row[8]);
        
        for(int i = 20; i < 24; i++)
        {
            row[9].add(button[i]);
        }
        
        add(row[9]);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == button[20])
        {
            b0();
        }
        
        if(e.getSource() == button[15])
        {
            b1();
        }
        
        if(e.getSource() == button[16])
        {
            b2();
        }
        
        if(e.getSource() == button[17])
        {
            b3();
        }
        
        if(e.getSource() == button[10])
        {
            b4();
        }
        
        if(e.getSource() == button[11])
        {
            b5();
        }
        
        if(e.getSource() == button[12])
        {
            b6();
        }
        
        if(e.getSource() == button[5])
        {
            b7();
        }
        
        if(e.getSource() == button[6])
        {
            b8();
        }
        
        if(e.getSource() == button[7])
        {
            b9();
        }
        
        if(e.getSource() == button[21])
        {
            b_deci();
        }
        
        if(e.getSource() == button[22])
        {
            b_add();
        }
        
        if(e.getSource() == button[18])
        {
            b_sub();
        }
        
        if(e.getSource() == button[13])
        {
            b_mult();
        }
        
        if(e.getSource() == button[8])
        {
            b_div();
        }
        
        if(e.getSource() == button[19])
        {
            b_equal();
        }
        
        if(e.getSource() == button[14])
        {
            b_inverse();
        }
        
        if(e.getSource() == button[9])
        {
            b_remain();
        }
        
        if(e.getSource() == button[4])
        {
            b_sqrt();
        }
        
        if(e.getSource() == button[0])
        {
            b_back();
        }
        
        if(e.getSource() == button[1])
        {
            b_clearE();
        }
        
        if(e.getSource() == button[2])
        {
            b_clear();
        }
        
        if(e.getSource() == button[3])
        {
            b_PM();
        }
    }
      
    public void b0() 
    { 
        if(valRepList.size() == 1 && valRepList.contains("0"))
        {
            valRepList.clear();
            valRepList.add("0");
        }
        else
        {
            valRepList.add("0");
        }
 
        display1.setText(
        valRepList.toString().replace("[", "").replace("]", "").replace(", ", ""));
    }
    
    public void b1() 
    {
        if(valRepList.size() == 1 && valRepList.contains("0"))
        {
            valRepList.clear();
            valRepList.add("1");
        }
        else
        {
            valRepList.add("1");
        }
        
        display1.setText(
        valRepList.toString().replace("[", "").replace("]", "").replace(", ", ""));
    }
    
    public void b2() 
    {
        if(valRepList.size() == 1 && valRepList.contains("0"))
        {
            valRepList.clear();
            valRepList.add("2");
        }
        else
        {
            valRepList.add("2");
        }
        
        display1.setText(
        valRepList.toString().replace("[", "").replace("]", "").replace(", ", ""));
    }
    
    public void b3() 
    {
        if(valRepList.size() == 1 && valRepList.contains("0"))
        {
            valRepList.clear();
            valRepList.add("3");
        }
        else
        {
            valRepList.add("3");
        }
        
        display1.setText(
        valRepList.toString().replace("[", "").replace("]", "").replace(", ", ""));
    }
    
    public void b4() 
    {
        if(valRepList.size() == 1 && valRepList.contains("0"))
        {
            valRepList.clear();
            valRepList.add("4");
        }
        else
        {
            valRepList.add("4");
        }
        
        display1.setText(
        valRepList.toString().replace("[", "").replace("]", "").replace(", ", ""));
    }
    
    public void b5() 
    {
        if(valRepList.size() == 1 && valRepList.contains("0"))
        {
            valRepList.clear();
            valRepList.add("5");
        }
        else
        {
            valRepList.add("5");
        }
        
        display1.setText(
        valRepList.toString().replace("[", "").replace("]", "").replace(", ", ""));
    }
    
    public void b6() 
    {
        if(valRepList.size() == 1 && valRepList.contains("0"))
        {
            valRepList.clear();
            valRepList.add("6");
        }
        else
        {
            valRepList.add("6");
        }
        
        display1.setText(
        valRepList.toString().replace("[", "").replace("]", "").replace(", ", ""));
    }
    
    public void b7() 
    {
        if(valRepList.size() == 1 && valRepList.contains("0"))
        {
            valRepList.clear();
            valRepList.add("7");
        }
        else
        {
            valRepList.add("7");
        }
        
        display1.setText(
        valRepList.toString().replace("[", "").replace("]", "").replace(", ", ""));
    }
    
    public void b8() 
    {
        if(valRepList.size() == 1 && valRepList.contains("0"))
        {
            valRepList.clear();
            valRepList.add("8");
        }
        else
        {
            valRepList.add("8");
        }
        
        display1.setText(
        valRepList.toString().replace("[", "").replace("]", "").replace(", ", ""));
    }
    
    public void b9() 
    {
        if(valRepList.size() == 1 && valRepList.contains("0"))
        {
            valRepList.clear();
            valRepList.add("9");
        }
        else
        {
            valRepList.add("9");
        }
        
        display1.setText(
        valRepList.toString().replace("[", "").replace("]", "").replace(", ", ""));
    }
    
    public void b_deci()
    {
        if(valRepList.isEmpty())
        {
            valRepList.add("0.");
        }
        else if(valRepList.contains("."))
        {
            return;
        }
        else
        {
            valRepList.add(".");
        }
        
        display1.setText(
        valRepList.toString().replace("[", "").replace("]", "").replace(", ", ""));
    }
    
    public void combineValRepList()
    {
        valList.add(
            Double.parseDouble(
                    valRepList.toString().replace("[", "").replace("]", "").replace(", ", "")));
   
        valRepList.clear();
        valRepList.add("0");
    }
    
    public void detMathFunc()
    {
        if(lastMathFunc.contains("+"))
        {
            double sol = valList.get(0) + valList.get(1);
            valList.clear();
            valList.add(sol);
        }
        
        if(lastMathFunc.contains("-"))
        {
            double sol = valList.get(0) - valList.get(1);
            valList.clear();
            valList.add(sol);
        }
        
        if(lastMathFunc.contains("*"))
        {
            double sol = valList.get(0) * valList.get(1);
            valList.clear();
            valList.add(sol);
        }
        
        if(lastMathFunc.contains("/"))
        {
            if(valList.get(1) == 0)
            {
                display1.setText("Undefined");
                valList.clear();
            }
            else
            {
                double sol = valList.get(0) / valList.get(1);
                valList.clear();
                valList.add(sol);
            }
        }
        
        if(lastMathFunc.contains("%"))
        {
            double sol = valList.get(0) % valList.get(1);
            valList.clear();
            valList.add(sol);
        }
    }
    
    public void b_add() 
    {
       if(valList.isEmpty())
       {
            combineValRepList();

            System.out.println(valList.toString());

            lastMathFunc.clear();
            lastMathFunc.add("+");
       }
       else if(valList.size() == 1)
       {
           lastMathFunc.clear();
           lastMathFunc.add("+");
       }
       else if(valList.size() == 2)
       {
           double sol = valList.get(0) + valList.get(1);
           valList.clear();
           valList.add(sol);
           
           display1.setText(
           valList.toString().replace("[", "").replace("]", "").replace(", ", ""));
       }
    }
    
    public void b_sub() 
    {
       if(valList.isEmpty())
       {
            combineValRepList();

            System.out.println(valList.toString());

            lastMathFunc.clear();
            lastMathFunc.add("-");
       }
       else if(valList.size() == 1)
       {
           lastMathFunc.clear();
           lastMathFunc.add("-");
       }
    }
    
    public void b_mult() 
    {
       if(valList.isEmpty())
       {
            combineValRepList();

            System.out.println(valList.toString());

            lastMathFunc.clear();
            lastMathFunc.add("*");
       }
       else if(valList.size() == 1)
       {
           lastMathFunc.clear();
           lastMathFunc.add("*");
       }
    }
    
    public void b_div() 
    {
       if(valList.isEmpty())
       {
            combineValRepList();

            System.out.println(valList.toString());

            lastMathFunc.clear();
            lastMathFunc.add("/");
       }
       else if(valList.size() == 1)
       {
           lastMathFunc.clear();
           lastMathFunc.add("/");
       }
    }
    
    public void b_equal() 
    {
        if(valList.isEmpty())
        {
            tf_display.setText("0.0");
        }
        else
        {
            combineValRepList();

            detMathFunc();

            display1.setText(valList.get(0) + "");
            
            display64Bits();
        }
    }
    
    public void b_inverse() 
    { 
       combineValRepList();
      
       if(valList.isEmpty())
       {
            tf_display.setText("Undefined");
       }
       else
       {
            double sol = 1 / valList.get(0);
            valList.clear();
            valList.add(sol);
       } 
        
       display1.setText(
       valList.toString().replace("[", "").replace("]", "").replace(", ", ""));
       
       display64Bits();
    }
    
    public void b_remain() 
    {
       if(valList.isEmpty())
       {
            combineValRepList();

            System.out.println(valList.toString());

            lastMathFunc.clear();
            lastMathFunc.add("%");
       }
       else if(valList.size() == 1)
       {
           lastMathFunc.clear();
           lastMathFunc.add("%");
       }
    }
    
    public void b_sqrt() 
    {
       combineValRepList();

       if(valList.isEmpty())
       {
            display1.setText("0.0");
       }
       else
       {
            double sol = Math.sqrt(valList.get(0));
            valList.clear();
            valList.add(sol);
       } 
       
       display1.setText(
       valList.toString().replace("[", "").replace("]", "").replace(", ", ""));
       
       display64Bits();
    }
    
    public void b_back()
    {
        if(valRepList.isEmpty())
        {
            String str = valList.toString().replace("[", "").replace("]", "").replace(", ", "");
            
            for(int i = 0; i < str.length(); i++)
            {
                valRepList.set(i, str.substring(i, i));
            }
            valRepList.add(
                valList.toString().replace("[", "").replace("]", "").replace(", ", ""));
            valRepList.remove(valRepList.size() - 1);
        }
        else
        {
            valRepList.remove(valRepList.size() - 1);
        }
        
        display1.setText(
        valRepList.toString().replace("[", "").replace("]", "").replace(", ", ""));
        
        display64Bits();
    }
    
    public void b_clearE()
    {
        valRepList.clear();
        
        display1.setText("0.0");
        
        display2.setText("");
        
        display3.setText("");
    }
    
    public void b_clear()
    {
        valRepList.clear();
        valList.clear();
        
        display1.setText("0.0");
        
        display2.setText("");
        
        display3.setText("");
    }
    
    public void b_PM()
    {
       combineValRepList();

       if(valList.isEmpty())
       {
            display1.setText("0");
       }
       else
       {
            double sol =  -1 * valList.get(0);
            valList.clear();
            valList.add(sol);
       } 
       
       display1.setText(
       valList.toString().replace("[", "").replace("]", "").replace(", ", ""));
       
       display64Bits();
    }
    
    public void display64Bits()
    {
        String result1 = "";
        
        result1 = Long.toBinaryString(Double.doubleToRawLongBits(valList.get(0)));
        
        for(int i = 0; result1.length() < 65; i++)
        {
            result1 = "0" + result1;
        }

        String[] result2 = new String[16];

        for(int i = 0, j = 0; i < 16; i++, j += 4)
        {
            result2[i] = result1.substring(j, j + 4);
        }

        String r1 = "";
        String r2 = "";

        for(int i = 0, j = 8; i < 8 && j < 16; i++, j++)
        {
            r1 += (result2[i] + "   ");

            r2 += (result2[j] + "   ");
        }

        display2.setText("  " + r1);
        display3.setText("  " + r2);
    }
}