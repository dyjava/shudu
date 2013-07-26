package com.godo.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.godo.dao.DaoFactory;
import com.godo.domain.Shudu;
import com.godo.swing.panel.ButtonPanel;
import com.godo.swing.panel.HelpPanel;
import com.godo.swing.panel.MainPanel;

/**
 * 主界面
 * @author dyong
 *
 */
public class MainFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7060552092289468819L;

	BorderLayout borderLayout1 = new BorderLayout();
    
    GridLayout gridLayout1 = new GridLayout();
    JOptionPane jop = new JOptionPane();
//    Icon icon=new ImageIcon(".\\src\\image\\1.gif");
//    Icon i=new ImageIcon(".\\src\\image\\user.ico");
//    JLabel lb = new JLabel(icon,JLabel.CENTER);

    JPanel mainP = new JPanel();
    public MainFrame(){
    	this.setName("frame") ;
    	getContentPane().setLayout(borderLayout1);

        JPanel topP = new JPanel();
        JPanel westP = new JPanel();
    	topP.setBackground(new Color(212, 154, 227));
    	this.setResizable(false);
        this.setTitle("数独-shudu");
        
//        JButton rebt = new JButton("重置");
//        rebt.addMouseListener(new ReloadMouseAdapter());
//        westP.add(rebt) ;
        JButton nextbt = new JButton("换一局");
        nextbt.addMouseListener(new NextMouseAdapter());
        westP.add(nextbt) ;
        JButton helpbt = new JButton("帮助");
        helpbt.addMouseListener(new HelpMouseAdapter());
        westP.add(helpbt) ;
        JButton outbt = new JButton("退出");
        outbt.addMouseListener(new OutMouseAdapter());
        westP.add(outbt) ;
        
        topP.setLayout(gridLayout1);
        mainP.setLayout(gridLayout1);
    	topP.add(new ButtonPanel());
    	mainP.add(new MainPanel());

    	this.getContentPane().add(westP, java.awt.BorderLayout.NORTH);
    	this.getContentPane().add(mainP, java.awt.BorderLayout.CENTER);
    	this.getContentPane().add(topP, java.awt.BorderLayout.WEST);
        this.setSize(600, 500) ;
    }
    @SuppressWarnings("static-access")
	private void outMouseReleased(MouseEvent e){
    	int rel=jop.showConfirmDialog(this,"退出吗？","退出",jop.YES_NO_OPTION ) ;
        if(rel==jop.YES_OPTION ){
            System.exit(0);
        }
    }
    private void helpMouseReleased(MouseEvent e){
//    	Shudu.getRandomShudu().flush();
    	mainP.removeAll();
    	mainP.repaint() ;
    	mainP.add(new HelpPanel());
    	mainP.validate();
    }
    private void reloadMouseReleased(MouseEvent e){
//    	Shudu.getRandomShudu().flush();
    	mainP.removeAll();
    	mainP.repaint() ;
    	mainP.add(new MainPanel());
    	mainP.validate();
    }
    private void nextMouseReleased(MouseEvent e){
    	DaoFactory.getInstens().initData() ;
    	Shudu.getRandomShudu().flush();
    	mainP.removeAll();
    	mainP.repaint() ;
    	mainP.add(new MainPanel());
    	mainP.validate();
    }
    class NextMouseAdapter extends MouseAdapter{
    	public void mouseReleased(MouseEvent e) {
    		nextMouseReleased(e);
        }
    }
    class ReloadMouseAdapter extends MouseAdapter{
    	public void mouseReleased(MouseEvent e) {
    		reloadMouseReleased(e);
        }
    }
    class HelpMouseAdapter extends MouseAdapter{
    	public void mouseReleased(MouseEvent e) {
    		helpMouseReleased(e);
        }
    }
    class OutMouseAdapter extends MouseAdapter{
    	public void mouseReleased(MouseEvent e) {
    		outMouseReleased(e);
        }
    }
}



