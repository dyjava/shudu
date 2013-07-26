package com.godo.swing.panel;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.borland.jbcl.layout.XYConstraints;
import com.borland.jbcl.layout.XYLayout;

public class HelpPanel  extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2671681456373147677L;

	public HelpPanel(){
    	this.setName("helpPanel") ;
        XYLayout xYLayout1 = new XYLayout();
//        xYLayout1.setWidth(600);
//        xYLayout1.setHeight(500);
        this.setLayout(xYLayout1);
        this.setBackground(SystemColor.controlLtHighlight);
        
        JButton backbt = new JButton("返回");
        backbt.addMouseListener(new BackMouseAdapter());
        this.add(backbt, new XYConstraints(10,10,60,30));
        
        JLabel text = new JLabel() ;
        text.setText("<html><body><p><h1>使用帮助：</h1></p>"+
        "1、先选择左侧的数字，再选择放置位置。<br/>"+
        "2、游戏包括9X9=81个格，每九个格划分为一个大格，总共分9个大格。<br/>"+
        "3、每行、每列数字都不允许重复，即每行每列填充完毕后都包括1到9数字。<br/>"+
        "4、每个大格数字不允许重复。<br/>"+
        "5、每行、每列或一个大格数字填充完毕后，会改变颜色，提醒。</body></html>") ;
        this.add(text, new XYConstraints(10,40,500,200));
    	
    }
	private void backMouseReleased(MouseEvent e){
    	this.removeAll();
    	this.repaint() ;
    	this.add(new MainPanel());
    	this.validate();
    }
	
	class BackMouseAdapter extends MouseAdapter{
    	public void mouseReleased(MouseEvent e) {
    		backMouseReleased(e);
        }
    }
}
