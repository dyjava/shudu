package com.godo.swing.panel;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.borland.jbcl.layout.XYConstraints;
import com.borland.jbcl.layout.XYLayout;

/** 
 * 
 */
public class ButtonPanel extends JPanel {

	private static final long serialVersionUID = -6186179840612599135L;

	int start =0;
	JLabel msg = new JLabel("1",JLabel.CENTER);
	public JOptionPane jop = new JOptionPane();
    public ButtonPanel() {
        printTabel() ;
    }
    
    private void printTabel(){
    	this.setName("buttonPanel") ;
        XYLayout xYLayout1 = new XYLayout();
        xYLayout1.setWidth(60);
        xYLayout1.setHeight(500);
        this.setLayout(xYLayout1);
//        this.setBackground(SystemColor.LIGHT_GRAY);
        this.setBackground(SystemColor.controlLtHighlight);
        
        start=30 ;
        setButton(1);
        setButton(2);
        setButton(3);
        setButton(4);
        setButton(5);
        setButton(6);
        setButton(7);
        setButton(8);
        setButton(9);
    }
    
    public void setButton(int p){
    	JButton button = new JButton();
//        button.setBackground(SystemColor.activeCaptionText);
//        button.setForeground(Color.blue);
//        button.setSize(30, 30);
//        button.setBounds(10, 10+10*p, 10, 10) ;
        button.setText(String.valueOf(p));
        button.addMouseListener(new ButtonMouseAdapter(p));
        if(p==MainPanel.p){
        	button.setBackground(Color.RED) ;
            button.setBorder(new LineBorder(Color.RED, 3)) ;
        } else {
        	button.setBackground(Color.WHITE) ;
            button.setBorder(new LineBorder(Color.WHITE, 3)) ;
        }
//        this.add(button,new XYConstraints(10,start+32*p,30,30));
        this.add(button,new XYConstraints(10,start+32*p,30,30));
    }
    
//	private void reloadMouseReleased(MouseEvent e){
//		System.out.println(">>"+this.getParent().getParent().getName()) ;
//		System.out.println(">>"+this.getParent().getComponentCount()) ;
//		Component[] cps = this.getParent().getComponents() ;
//		for(Component cp:cps){
//			System.out.println(cp.getName()) ;
//		}
//		this.getParent().getComponent(0).repaint();
//		this.getParent().getComponent(0).layout();
//    	this.removeAll() ;
//    	this.repaint();
//    	printTabel() ;
//    	this.validate() ;
//    }
	private void buttonMouseReleased(MouseEvent e,int p){
		MainPanel.p=p;
		
		this.removeAll() ;
    	this.repaint();
    	printTabel() ;
    	this.validate() ;
	}
	
    class ButtonMouseAdapter extends MouseAdapter{
    	int p ;
    	public ButtonMouseAdapter(int p){
    		this.p = p ;
    	}
    	public void mouseReleased(MouseEvent e) {
    		buttonMouseReleased(e,p);
        }
    }
//    class ReloadMouseAdapter extends MouseAdapter{
//    	public void mouseReleased(MouseEvent e) {
//    		reloadMouseReleased(e);
//        }
//    }
}
