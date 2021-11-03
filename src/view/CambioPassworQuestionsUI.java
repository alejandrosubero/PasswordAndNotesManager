package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.beans.PropertyVetoException;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import constants.Constant;
import model.Gestion;
import model.User;
import pojos.LoginSessionPojo;
import service.DataService;
import service.GestionService;
import service.UserService;

import javax.swing.JPasswordField;

public class CambioPassworQuestionsUI extends JInternalFrame {

    private JLabel LabelSeePasswordConfir;
    private JLabel labelButtonAceptar;
    private JLabel LabelSeePassword;
    private JLabel LabelSeePasswordAnswer;
    private JLabel LabelSeePasswordFrase;
    private JLabel LabelSeePasswordQuestion;
    private JLabel labelCloseButton;
    private JLabel labelButtonMaximisize;
    private JLabel labelButtonMini;
    private JLabel labelTitle;
    private JLabel labelPassword;
    private JLabel labelquestion;
    private JLabel labelAnswer;
    private JLabel LabelPasswordConfir;
    private JLabel labelphrase;
    
    private JPasswordField passwordField_1;
    private JPasswordField passwordFieldAnswer;
    private JPasswordField passwordFieldQestion;
    private JPasswordField passwordFieldPassword;
    private JPasswordField passwordFieldPhrase;
   
    private JPanel panelButtonMin;
    private JPanel panelButtonMaximisize;
	private JPanel panelHeader;
	private JPanel panelAccion;
    private JPanel panelButtonAceptar;
    private JPanel panelCloseButton;
    private JPanel panelSeePassword;
    private JPanel panelSeePassword_1;
    private JPanel panelSeePassword_2;
    private JPanel panelSeePassword_3;
    private JPanel panelSeePassword_4;
 
    private Boolean changeMax = false;
    private Boolean minimix = false;
    
    private int showPass = 0;
	private int showPassConfir = 0;
	private int showPassFrase = 0;
	private int showPassAnswer = 0;
	private int showPassQuestion = 0;
	
	
    public CambioPassworQuestionsUI() {
    	
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
				.addComponent(panelHeader, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(panelAccion, GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelHeader, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelAccion, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
					.addGap(2))
		);
		
		labelPassword = new JLabel("New Password:");
		labelPassword.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		passwordFieldPassword = new JPasswordField();
		passwordFieldPassword.setFont(new Font("Roboto", Font.PLAIN, 14));
		passwordFieldPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		passwordFieldPassword.setEchoChar('*');
		
		labelphrase = new JLabel("New Phrase:");
		labelphrase.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		passwordFieldPhrase = new JPasswordField();
		passwordFieldPhrase.setFont(new Font("Roboto", Font.PLAIN, 14));
		passwordFieldPhrase.setEchoChar('*');
		passwordFieldPhrase.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		
		labelquestion = new JLabel("New question:");
		labelquestion.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		passwordFieldQestion = new JPasswordField();
		passwordFieldQestion.setFont(new Font("Roboto", Font.PLAIN, 14));
		passwordFieldQestion.setEchoChar('*');
		passwordFieldQestion.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		
		labelAnswer = new JLabel("New Answer:");
		labelAnswer.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		passwordFieldAnswer = new JPasswordField();
		passwordFieldAnswer.setFont(new Font("Roboto", Font.PLAIN, 14));
		passwordFieldAnswer.setEchoChar('*');
		passwordFieldAnswer.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		
		LabelPasswordConfir = new JLabel("Confir Password:");
		LabelPasswordConfir.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Roboto", Font.PLAIN, 14));
		passwordField_1.setEchoChar('*');
		passwordField_1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		
		panelButtonAceptar = new JPanel();
		panelButtonAceptar.setBackground(new Color(0, 102, 204));
		panelButtonAceptar.setLayout(new BorderLayout(0, 0));
		
		labelButtonAceptar = new JLabel("Aceptar");
		labelButtonAceptar.setHorizontalAlignment(SwingConstants.CENTER);
		labelButtonAceptar.setForeground(Color.WHITE);
		labelButtonAceptar.setFont(new Font("Roboto", Font.BOLD, 14));
		panelButtonAceptar.add(labelButtonAceptar, BorderLayout.CENTER);
		
		labelButtonAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
            	if (LoginSessionPojo.loginSeccion().getAutorizado()) {
            		saveButtonMouseClicked(evt);
        		}
            	
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	saveButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	saveButtonMouseExited(evt);
            }
        });
		
		
		
		panelSeePassword = new JPanel();
		panelSeePassword.setBackground(Color.WHITE);
		
		LabelSeePassword = new JLabel("");
		LabelSeePassword.setHorizontalAlignment(SwingConstants.CENTER);
		LabelSeePassword.setIcon(new ImageIcon(CambioPassworQuestionsUI.class.getResource("/imagenes/icons8-eye-24.png")));
		panelSeePassword.add(LabelSeePassword);
		
		LabelSeePassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
            	 if(showPass == 0){
            		 passwordFieldPassword.setEchoChar((char)0);
            		 showPass = 1;
                 } else {
                	 passwordFieldPassword.setEchoChar('*');
                	 showPass = 0;
                 }	
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	seePassMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	seePassMouseExited(evt);
            }
        });
		
		
		panelSeePassword_1 = new JPanel();
		panelSeePassword_1.setBackground(Color.WHITE);
		
		LabelSeePasswordConfir = new JLabel("");
		LabelSeePasswordConfir.setHorizontalAlignment(SwingConstants.CENTER);
		LabelSeePasswordConfir.setIcon(new ImageIcon(CambioPassworQuestionsUI.class.getResource("/imagenes/icons8-eye-24.png")));
		panelSeePassword_1.add(LabelSeePasswordConfir);
		
		LabelSeePasswordConfir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
            	 if(showPassConfir == 0){
            		 passwordField_1.setEchoChar((char)0);
            		 showPassConfir = 1;
                 } else {
                	 passwordField_1.setEchoChar('*');
                	 showPassConfir = 0;
                 }	
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	confirnPassMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	confirnPassMouseExited(evt);
            }
        });
		
		panelSeePassword_2 = new JPanel();
		panelSeePassword_2.setBackground(Color.WHITE);
		
		LabelSeePasswordFrase = new JLabel("");
		LabelSeePasswordFrase.setHorizontalAlignment(SwingConstants.CENTER);
		LabelSeePasswordFrase.setIcon(new ImageIcon(CambioPassworQuestionsUI.class.getResource("/imagenes/icons8-eye-24.png")));
		panelSeePassword_2.add(LabelSeePasswordFrase);
		
		LabelSeePasswordFrase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
            	 if(showPassFrase == 0){
            		 passwordFieldPhrase.setEchoChar((char)0);
            		 showPassFrase = 1;
                 } else {
                	 passwordFieldPhrase.setEchoChar('*');
                	 showPassFrase = 0;
                 }	
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	frasePassMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	frasePassMouseExited(evt);
            }
        });
		
		panelSeePassword_3 = new JPanel();
		panelSeePassword_3.setBackground(Color.WHITE);
		LabelSeePasswordQuestion = new JLabel("");
		LabelSeePasswordQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		LabelSeePasswordQuestion.setIcon(new ImageIcon(CambioPassworQuestionsUI.class.getResource("/imagenes/icons8-eye-24.png")));
		panelSeePassword_3.add(LabelSeePasswordQuestion);
		LabelSeePasswordQuestion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
            	 if(showPassQuestion == 0){
            		 passwordFieldQestion.setEchoChar((char)0);
            		 showPassQuestion = 1;
                 } else {
                	 passwordFieldQestion.setEchoChar('*');
                	 showPassQuestion = 0;
                 }	
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	questionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	questionMouseExited(evt);
            }
        });
		
		panelSeePassword_4 = new JPanel();
		panelSeePassword_4.setBackground(Color.WHITE);
		LabelSeePasswordAnswer = new JLabel("");
		LabelSeePasswordAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		LabelSeePasswordAnswer.setIcon(new ImageIcon(CambioPassworQuestionsUI.class.getResource("/imagenes/icons8-eye-24.png")));
		panelSeePassword_4.add(LabelSeePasswordAnswer);
		
		LabelSeePasswordAnswer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
            	 if(showPassAnswer == 0){
            		 passwordFieldAnswer.setEchoChar((char)0);
            		 showPassAnswer = 1;
                 } else {
                	 passwordFieldAnswer.setEchoChar('*');
                	 showPassAnswer = 0;
                 }	
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	answerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	answerMouseExited(evt);
            }
        });

		
		
		
		GroupLayout gl_panelAccion = new GroupLayout(panelAccion);
		gl_panelAccion.setHorizontalGroup(
			gl_panelAccion.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAccion.createSequentialGroup()
					.addGap(10)
					.addComponent(labelPassword, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(passwordFieldPassword, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
					.addGap(72)
					.addComponent(panelSeePassword, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(78))
				.addGroup(gl_panelAccion.createSequentialGroup()
					.addContainerGap()
					.addComponent(LabelPasswordConfir)
					.addGap(18)
					.addComponent(passwordField_1, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
					.addGap(72)
					.addComponent(panelSeePassword_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(78))
				.addGroup(gl_panelAccion.createSequentialGroup()
					.addGap(10)
					.addComponent(labelphrase, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(passwordFieldPhrase, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
					.addGap(72)
					.addComponent(panelSeePassword_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(78))
				.addGroup(gl_panelAccion.createSequentialGroup()
					.addGap(10)
					.addComponent(labelquestion, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(passwordFieldQestion, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
					.addGap(68)
					.addComponent(panelSeePassword_3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(78))
				.addGroup(gl_panelAccion.createSequentialGroup()
					.addGap(10)
					.addComponent(labelAnswer, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(passwordFieldAnswer, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
					.addGap(68)
					.addComponent(panelSeePassword_4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(78))
				.addGroup(gl_panelAccion.createSequentialGroup()
					.addGap(187)
					.addComponent(panelButtonAceptar, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
					.addGap(184))
		);
		gl_panelAccion.setVerticalGroup(
			gl_panelAccion.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAccion.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panelAccion.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAccion.createSequentialGroup()
							.addGap(10)
							.addComponent(labelPassword, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelAccion.createSequentialGroup()
							.addGap(12)
							.addComponent(passwordFieldPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(panelSeePassword, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panelAccion.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAccion.createSequentialGroup()
							.addGap(26)
							.addComponent(LabelPasswordConfir, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelAccion.createSequentialGroup()
							.addGap(16)
							.addGroup(gl_panelAccion.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelAccion.createSequentialGroup()
									.addGap(12)
									.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(panelSeePassword_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))))
					.addGap(17)
					.addGroup(gl_panelAccion.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAccion.createSequentialGroup()
							.addGap(10)
							.addComponent(labelphrase, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelAccion.createSequentialGroup()
							.addGap(12)
							.addComponent(passwordFieldPhrase, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(panelSeePassword_2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_panelAccion.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAccion.createSequentialGroup()
							.addGap(8)
							.addComponent(labelquestion, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelAccion.createSequentialGroup()
							.addGap(10)
							.addComponent(passwordFieldQestion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(panelSeePassword_3, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_panelAccion.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAccion.createSequentialGroup()
							.addGap(8)
							.addComponent(labelAnswer, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelAccion.createSequentialGroup()
							.addGap(11)
							.addComponent(passwordFieldAnswer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(panelSeePassword_4, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addComponent(panelButtonAceptar, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(10, Short.MAX_VALUE))
		);
		
		panelAccion.setLayout(gl_panelAccion);
		panelHeader.setLayout(null);
		
		panelCloseButton = new JPanel();
		panelCloseButton.setBackground(Color.WHITE);
		panelCloseButton.setBounds(10, 0, 26, 41);
		
		panelHeader.add(panelCloseButton);
		panelCloseButton.setLayout(new BorderLayout(0, 0));
		
		labelCloseButton = new JLabel("");
		labelCloseButton.setIcon(new ImageIcon(CambioPassworQuestionsUI.class.getResource("/imagenes/botonCerrarRed.png")));
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
		labelButtonMaximisize.setIcon(new ImageIcon(CambioPassworQuestionsUI.class.getResource("/imagenes/expandir1.png")));
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
		labelButtonMini.setIcon(new ImageIcon(CambioPassworQuestionsUI.class.getResource("/imagenes/minimizar3.png")));
		labelButtonMini.setHorizontalAlignment(SwingConstants.CENTER);
		labelButtonMini.setFont(new Font("Roboto", Font.BOLD, 16));
		panelButtonMin.add(labelButtonMini);
		
		labelTitle = new JLabel("Segurity Data");
		labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitle.setFont(new Font("Roboto", Font.BOLD, 16));
		labelTitle.setBounds(219, 0, 128, 41);
		panelHeader.add(labelTitle);
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
			minimix = minimix == false ? true : false;
			iconable = minimix;
			firePropertyChange("iconable", Boolean.TRUE, Boolean.TRUE);
			setIcon(minimix);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}

	
	private void maxim() {
		try {
			changeMax = changeMax == false ? true : false;
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
		labelCloseButton.setIcon(new ImageIcon(CambioPassworQuestionsUI.class.getResource("/imagenes/botonCerrar.png")));
	}

	private void exitTxtMouseExited(java.awt.event.MouseEvent evt) {
		labelCloseButton.setIcon(new ImageIcon(CambioPassworQuestionsUI.class.getResource("/imagenes/botonCerrarRed.png")));
	}

	private void maxMouseEntered(java.awt.event.MouseEvent evt) {
		labelButtonMaximisize.setIcon(new ImageIcon(CambioPassworQuestionsUI.class.getResource("/imagenes/expandir2.png")));
	}

	private void maxMouseExited(java.awt.event.MouseEvent evt) {
		labelButtonMaximisize.setIcon(new ImageIcon(CambioPassworQuestionsUI.class.getResource("/imagenes/expandir1.png")));
	}

	private void minimisizeMouseClicked(java.awt.event.MouseEvent evt) {
		mini();
		labelButtonMini.setIcon(new ImageIcon(CambioPassworQuestionsUI.class.getResource("/imagenes/minimizar3.png")));
	}

	private void minimisizeMouseEntered(java.awt.event.MouseEvent evt) {
		labelButtonMini.setIcon(new ImageIcon(CambioPassworQuestionsUI.class.getResource("/imagenes/minimizar2.png")));
	}

	private void minimisizeMouseExited(java.awt.event.MouseEvent evt) {
		labelButtonMini.setIcon(new ImageIcon(CambioPassworQuestionsUI.class.getResource("/imagenes/minimizar3.png")));
	}
	
//==================================================================================================================================//
	
	private void seePassMouseEntered(java.awt.event.MouseEvent evt) {
		LabelSeePassword.setIcon(new ImageIcon(CambioPassworQuestionsUI.class.getResource("/imagenes/eye.png")));
	}

	private void seePassMouseExited(java.awt.event.MouseEvent evt) {
		LabelSeePassword.setIcon(new ImageIcon(CambioPassworQuestionsUI.class.getResource("/imagenes/icons8-eye-24.png")));
	}

	private void confirnPassMouseEntered(java.awt.event.MouseEvent evt) {
		LabelSeePasswordConfir.setIcon(new ImageIcon(CambioPassworQuestionsUI.class.getResource("/imagenes/eye.png")));
	}

	private void confirnPassMouseExited(java.awt.event.MouseEvent evt) {
		LabelSeePasswordConfir.setIcon(new ImageIcon(CambioPassworQuestionsUI.class.getResource("/imagenes/icons8-eye-24.png")));
	}

	private void frasePassMouseEntered(java.awt.event.MouseEvent evt) {
		LabelSeePasswordFrase.setIcon(new ImageIcon(CambioPassworQuestionsUI.class.getResource("/imagenes/eye.png")));
	}

	private void frasePassMouseExited(java.awt.event.MouseEvent evt) {
		LabelSeePasswordFrase.setIcon(new ImageIcon(CambioPassworQuestionsUI.class.getResource("/imagenes/icons8-eye-24.png")));
	}

	private void answerMouseEntered(java.awt.event.MouseEvent evt) {
		LabelSeePasswordAnswer.setIcon(new ImageIcon(CambioPassworQuestionsUI.class.getResource("/imagenes/eye.png")));
	}

	private void answerMouseExited(java.awt.event.MouseEvent evt) {
		LabelSeePasswordAnswer.setIcon(new ImageIcon(CambioPassworQuestionsUI.class.getResource("/imagenes/icons8-eye-24.png")));
	}

	private void questionMouseEntered(java.awt.event.MouseEvent evt) {
		LabelSeePasswordQuestion.setIcon(new ImageIcon(CambioPassworQuestionsUI.class.getResource("/imagenes/eye.png")));
	}

	private void questionMouseExited(java.awt.event.MouseEvent evt) {
		LabelSeePasswordQuestion.setIcon(new ImageIcon(CambioPassworQuestionsUI.class.getResource("/imagenes/icons8-eye-24.png")));
	}

	private void saveButtonMouseEntered(java.awt.event.MouseEvent evt) {
		panelButtonAceptar.setBackground(new Color(0, 156, 223));
	}

	private void saveButtonMouseExited(java.awt.event.MouseEvent evt) {
		panelButtonAceptar.setBackground(new Color(0, 102, 204));
	}
	
	//==================================================================================================================================//	
	
	private void saveButtonMouseClicked(java.awt.event.MouseEvent evt) {

		try {
			ProgressBar.startVentana();
			
			String userPassword = String.valueOf(passwordFieldPassword.getPassword());
			String userPasswordConfir = String.valueOf(passwordField_1.getPassword());
			String userFrase = String.valueOf(passwordFieldPhrase.getPassword());
			String userQuestion = String.valueOf(passwordFieldQestion.getPassword());
			String userAnswer = String.valueOf(passwordFieldAnswer.getPassword());
			Boolean changefrase = false;
			
			if (userPassword.equals(userPasswordConfir)) {
				UserService.getUserService().changePassword(LoginSessionPojo.loginSeccion().getCodigoUser(), userPassword);
			}
			
			if (userFrase != null && !userFrase.equals("")) {
				String codigo = LoginSessionPojo.loginSeccion().getCodigoUser();
				GestionService.getGestionServices().updateGestion(codigo, new Gestion().newDelta(userFrase, codigo));
				changefrase = DataService.getDataService().changeFrase(codigo, userFrase);
			}
			
			
			if (userQuestion != null && !userQuestion.equals("")) {
				UserService.getUserService().updatePregunta(LoginSessionPojo.loginSeccion().getCodigoUser(), userQuestion);
			}
			
			
			if (userAnswer != null && !userAnswer.equals("")) {
				UserService.getUserService().updateRespuesta(LoginSessionPojo.loginSeccion().getCodigoUser(), userAnswer);
			}
			
			
			if(changefrase) {
				ProgressBar.detieneCuenta();
				JOptionPane.showMessageDialog(null, "Save Phrase",	"view Sucess", JOptionPane.OK_OPTION);
			}else {
				ProgressBar.detieneCuenta();
				JOptionPane.showMessageDialog(null, "Ocurrio un error al tratar de salvar la frase", "Error en servicio de salvar", JOptionPane.ERROR_MESSAGE);
			}
							
			ProgressBar.detieneCuenta();

		} catch (Exception e) {
			ProgressBar.detieneCuenta();
			JOptionPane.showMessageDialog(null, "Ocurrio un error al tratar de salvar los datos del usuario",	
												"Error en servicio de Cambiar datos del usuario", 
														JOptionPane.ERROR_MESSAGE);
		}

	}
	
	
	
	
	
	
}
