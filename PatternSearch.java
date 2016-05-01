/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patternsearch;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Khaja Anwar Ali Siddiqui
 */
public class PatternSearch extends JFrame{
    private final JMenu start;
    private final JMenuItem clearData, find, exit;
    private final JTextArea data;
    private final String pattern;
    private final JMenuBar bar;
    private final Box box;
    PatternSearch(){
        super("Pattern Search Application");
        pattern="";
        start=new JMenu("Start");
        start.setMnemonic('s');
        clearData=new JMenuItem("Clear Text");
        clearData.setMnemonic('C');
        start.add(clearData);
        find=new JMenuItem("Find");
        find.setMnemonic('F');
        start.add(find);
        exit=new JMenuItem("Exit");
        exit.setMnemonic('x');
        start.add(exit);
        data= new JTextArea("Paste your text here.");
        bar=new JMenuBar();
        bar.add(start);
        super.setJMenuBar(bar);
        super.add(data);
        data.setLineWrap(true);          //Formatting the JTextArea.
        data.setEditable(true);
        data.setForeground(Color.BLUE);
        data.setFont(new Font("Serif", Font.PLAIN, 15));
        data.setBackground(Color.WHITE);
        box=Box.createHorizontalBox();
        box.add(new JScrollPane(data));
        super.add(box);
        MenuHandler handler=new MenuHandler();
        find.addActionListener(handler);
        clearData.addActionListener(handler);
        exit.addActionListener(handler);
    }
    private class MenuHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            if(evt.getSource()==clearData){
                JOptionPane.showMessageDialog(null,"Text is cleared!", "Warning", JOptionPane.INFORMATION_MESSAGE);
                data.setText("");
//                box.repaint();
            }
            if(evt.getSource()==find){
                int count=0;
                int firstIndex=-1;
                String found;
                String patn=JOptionPane.showInputDialog("Find for: ");
                Pattern p=Pattern.compile(patn);
                Matcher m=p.matcher(data.getText());
                while(m.find()){
                    count++;
                    if(firstIndex==-1) firstIndex=m.start();
                   }
                if(firstIndex !=-1) found=String.valueOf(firstIndex+1);
                else found="";
                JOptionPane.showMessageDialog(null,"Search for: \""+patn+"\"\nReturned: "+count+" matches"+"\nFirst found at Index: "+found,"Found",JOptionPane.INFORMATION_MESSAGE);  
            }
            if(evt.getSource()==exit){
                System.exit(0);
            }
        }
    }
}