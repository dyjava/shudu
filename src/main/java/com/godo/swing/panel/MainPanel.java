package com.godo.swing.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.borland.jbcl.layout.XYConstraints;
import com.borland.jbcl.layout.XYLayout;
import com.godo.domain.Item;
import com.godo.domain.Shudu;

/** 
 * 
 */
public class MainPanel extends JPanel {

	private static final long serialVersionUID = -6186179840612899135L;
	public static int p =1;

	public Shudu shudu = Shudu.getRandomShudu() ;
	private Font font1 = new Font("宋体", Font.BOLD, 24) ;
	private Font font2 = new Font("宋体", Font.ITALIC, 24) ;
	public JOptionPane jop = new JOptionPane();
    public MainPanel() {
        printTabel() ;
    }
    
    private void printTabel(){
    	this.setName("mainPanel") ;
        XYLayout xYLayout1 = new XYLayout();
        xYLayout1.setWidth(600);
        xYLayout1.setHeight(500);
        this.setLayout(xYLayout1);
//        this.setBackground(SystemColor.LIGHT_GRAY);
        this.setBackground(SystemColor.controlLtHighlight);
        
//    	Shudu shudu = Shudu.getRandomShudu() ;
    	ArrayList<ArrayList<Item>> list = shudu.getThesis() ;
    	
    	int x_start =30;
    	int y_start =10;
    	int len = 45 ;	//每格间隔
    	int ge = 1 ;	//间隔
    	for(int i=0;i<list.size();i++){
    		ArrayList<Item> items = list.get(i) ;
    		for(int j=0;j<items.size();j++){
    			int item = items.get(j).getV() ;
    			JComponent comp = new JButton(String.valueOf(item));
    			if(item==0){
    				comp = new JButton();
    			}
    			if(items.get(j).isCanRead()){
    				comp.setFont(font1) ;
//        			comp.setForeground(Color.red) ;
    				comp.addMouseListener(new ItemMouseAdapter(i,j)) ;
    			} else {
    				comp.setFont(font2) ;
    				comp.setForeground(Color.red) ;
//    				comp.setEnabled(false) ;
    			}
    			comp.setBackground(Color.BLUE);
    			if(items.get(j).isOver()){
    				comp.setBackground(Color.YELLOW) ;
    			}
//    			comp.setBackground(getColor(i,j)) ;
//    			comp.setBorder(new LineBorder(getColor(i,j),1)) ;
//    			this.add(comp, new XYConstraints(x_start+j*len, y_start+i*len, len-ge, len-ge));
    			int xx=0,yy=0;
    			if(i>=3){
    				yy=ge*5;
    			}
    			if(i>=6){
    				yy=2*ge*5;
    			}
    			if(j>=3){
    				xx=ge*5;
    			}
    			if(j>=6){
    				xx=2*ge*5;
    			}
//    			comp.setBorder(new LineBorder(Color.BLUE,1)) ;
//    			comp.setBackground(Color.BLUE);
//    			this.setBackground(new Color(8,5,72));
    			this.add(comp, new XYConstraints(x_start+j*len+xx, y_start+i*len+yy, len, len));
    			
    		}
    	}

        Icon t=new ImageIcon(System.getProperty("user.dir")+"/img.jpg");
        JLabel ep = new JLabel(t,JLabel.CENTER);
        this.add(ep, new XYConstraints(0, 0, 0, 0));
    }
    
    private Color getColor(int i, int j) {
		if((i<3 && j<3)
				||(i>=6 && j>=3 && j<6)
				||(i<3 && j>=6)){
			return Color.green;
		}
		if((i>=6 && j<3)
				||(i>=3 && i<6 && j>=3 && j<6)
				||(i>=6 && j>=6)){
			return Color.YELLOW;
		}
		return Color.GRAY;
	}

	private void itemMouseReleased(MouseEvent e,int row,int col){
    	if(shudu.getThesis().get(row).get(col).getV()!=0){
    		shudu.put(row, col, 0) ;
    	} else if(shudu.checkItem(row, col, p)){
    		shudu.put(row, col, p) ;
    	} else {
    		jop.showMessageDialog(this, "放错啦！") ;
    	}

    	this.removeAll() ;
    	this.repaint();
    	printTabel() ;
    	this.validate() ;
    	if(shudu.checkThesis()){
    		jop.showMessageDialog(this, "恭喜你，全部完成了。") ;
    	}
    }
    
    class ItemMouseAdapter extends MouseAdapter{
    	int x,y ;
		public ItemMouseAdapter(int i, int j) {
			x=i ;
			y=j ;
		}
		public void mouseReleased(MouseEvent e) {
    		itemMouseReleased(e,x,y);
        }
    }

}
