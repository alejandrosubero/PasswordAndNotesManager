package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.beans.PropertyVetoException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import constants.Constant;
import java.awt.Font;
import javax.swing.BoxLayout;

public class JinternalBase extends JInternalFrame {

	
	private JPanel panelHeader;
	private JPanel panelAccion;
    private Boolean changeMax = false;
    private Boolean minimix = false;
    private JPanel panelCloseButton;
    private JLabel labelCloseButton;
    private JPanel panelButtonMaximisize;
    private JLabel labelButtonMaximisize;
    private JPanel panelButtonMin;
    private JLabel labelButtonMini;
	


	public JinternalBase() {
	
		putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);		
		setResizable(true);
		setBounds(15, 15, 500, 380);
		getContentPane().setBackground(Color.WHITE);
		panelHeader = new JPanel();
		panelHeader.setBackground(Color.WHITE);
		panelAccion = new JPanel();
		panelAccion.setBackground(Color.WHITE);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelAccion, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
				.addComponent(panelHeader, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelHeader, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelAccion, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		GroupLayout gl_panelAccion = new GroupLayout(panelAccion);
		gl_panelAccion.setHorizontalGroup(
			gl_panelAccion.createParallelGroup(Alignment.LEADING)
				.addGap(0, 488, Short.MAX_VALUE)
		);
		gl_panelAccion.setVerticalGroup(
			gl_panelAccion.createParallelGroup(Alignment.LEADING)
				.addGap(0, 294, Short.MAX_VALUE)
		);
		
		panelAccion.setLayout(gl_panelAccion);
		panelHeader.setLayout(null);
		
		panelCloseButton = new JPanel();
		panelCloseButton.setBackground(Color.WHITE);
		panelCloseButton.setBounds(10, 0, 26, 41);
		
		panelHeader.add(panelCloseButton);
		panelCloseButton.setLayout(new BorderLayout(0, 0));
		
		labelCloseButton = new JLabel("");
		labelCloseButton.setIcon(new ImageIcon(JinternalBase.class.getResource("/imagenes/botonCerrarRed.png")));
		labelCloseButton.setHorizontalAlignment(SwingConstants.CENTER);
		panelCloseButton.add(labelCloseButton);
		labelCloseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitTxtMouseExited(evt);
            }
        });
		
		panelButtonMaximisize = new JPanel();
		panelButtonMaximisize.setBackground(Color.WHITE);
		panelButtonMaximisize.setBounds(79, 0, 41, 41);
		panelHeader.add(panelButtonMaximisize);
		panelButtonMaximisize.setLayout(new BorderLayout(0, 0));
		labelButtonMaximisize = new JLabel("");
		labelButtonMaximisize.setIcon(new ImageIcon(JinternalBase.class.getResource("/imagenes/expandir1.png")));
		panelButtonMaximisize.add(labelButtonMaximisize, BorderLayout.CENTER);
		labelButtonMaximisize.setHorizontalAlignment(SwingConstants.CENTER);
		labelButtonMaximisize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
            	maximisizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                maxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                maxMouseExited(evt);
            }
        });
		
		panelButtonMin = new JPanel();
		panelButtonMin.setBackground(Color.WHITE);
		panelButtonMin.setBounds(46, 0, 35, 41);
		panelHeader.add(panelButtonMin);
		panelButtonMin.setLayout(new BorderLayout(0, 0));
		
		labelButtonMini = new JLabel("");
		labelButtonMini.setIcon(new ImageIcon(JinternalBase.class.getResource("/imagenes/minimizar3.png")));
		labelButtonMini.setHorizontalAlignment(SwingConstants.CENTER);
		labelButtonMini.setFont(new Font("Roboto", Font.BOLD, 16));
		panelButtonMin.add(labelButtonMini);
		
		labelButtonMini.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
            	minimisizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	minimisizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	minimisizeMouseExited(evt);
            }
        });
		
		
		getContentPane().setLayout(groupLayout);

	}

	  private void closeA() {
	        closable = true;
	        firePropertyChange("closable", Boolean.TRUE, Boolean.TRUE);
  }
	   
 private void mini() {
	
	try {
		 minimix = minimix == false? true:false;
		 iconable =minimix;
		 firePropertyChange("iconable",  Boolean.TRUE, Boolean.TRUE);
		setIcon(minimix);
	} catch (PropertyVetoException e) {
		e.printStackTrace();
	}
 }
	  
	  
	private void maxim() {
		try {
			changeMax = changeMax == false? true:false;
		    maximizable = true;
		    firePropertyChange("maximizable", Boolean.TRUE, Boolean.TRUE);
			this.setMaximum(changeMax);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}
	
	
	private void exitTxtMouseClicked(java.awt.event.MouseEvent evt) {
		try {
			closeA();
			this.setClosed(true);
		} catch (PropertyVetoException e1) {
			e1.printStackTrace();
		}
  }

	private void maximisizeMouseClicked(java.awt.event.MouseEvent evt) {
		maxim();
  }
	
	
	
private void exitTxtMouseEntered(java.awt.event.MouseEvent evt) {
	labelCloseButton.setIcon(new ImageIcon(JinternalBase.class.getResource("/imagenes/botonCerrar.png")));
}  

 private void exitTxtMouseExited(java.awt.event.MouseEvent evt) {
	 labelCloseButton.setIcon(new ImageIcon(JinternalBase.class.getResource("/imagenes/botonCerrarRed.png")));
  }	
 
	
 private void maxMouseEntered(java.awt.event.MouseEvent evt) {
	 labelButtonMaximisize.setIcon(new ImageIcon(JinternalBase.class.getResource("/imagenes/expandir2.png")));
   }

  private void maxMouseExited(java.awt.event.MouseEvent evt) {
	  labelButtonMaximisize.setIcon(new ImageIcon(JinternalBase.class.getResource("/imagenes/expandir1.png")));
   }
  
  
  private void minimisizeMouseClicked(java.awt.event.MouseEvent evt) {
		mini();
		labelButtonMini.setIcon(new ImageIcon(JinternalBase.class.getResource("/imagenes/minimizar3.png")));
  }
  private void minimisizeMouseEntered(java.awt.event.MouseEvent evt) {
	  labelButtonMini.setIcon(new ImageIcon(JinternalBase.class.getResource("/imagenes/minimizar2.png")));
  }

 private void minimisizeMouseExited(java.awt.event.MouseEvent evt) {
	 labelButtonMini.setIcon(new ImageIcon(JinternalBase.class.getResource("/imagenes/minimizar3.png")));
  }
}
