/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author khaja Anwar Ali Siddiuqi
 */
//Package name.
package patternsearch;
// Required imports:
import javax.swing.JFrame;
// Implementing the clockMenu by creating an object.
public class PatternSearchRun{
    public static void main(String[] args){
        PatternSearch menuframe=new PatternSearch();    // Creating an object of clockMenu
        menuframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //Program should exit on close.
        menuframe.setSize(620,300);     //Frame size.
        menuframe.setVisible(true);     //Visiblity
    }
}
//////////////////////// END OF SOURCE FILE ////////////////////////////