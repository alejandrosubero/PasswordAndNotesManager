package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import constants.Constant;
import model.User;
import pojos.LoginSessionPojo;
import service.UserService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class NewUserProfileUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static NewUserProfileUI newUserProfileUI;
	private JPanel panelHeader;
	private JPanel panelButonClose;
	private JLabel labelbutonClose;
	private JLabel labelNameUser;
	private JTextField textFieldUserName;
	private JLabel labelPassword;
	private JPasswordField passwordFieldPasswordUser;
	private JLabel labelComfirmPassword;
	private JPasswordField passwordFieldComfirm;
	private JLabel lavelTitlePreguntas;
	private JLabel labelPhrase;
	private JPasswordField passwordFieldPhrase;
	private JLabel labelSecurityQuestion;
	private JPasswordField passwordFieldQuestion;
	private JLabel labelSecurityAnswer;
	private JPasswordField passwordFieldAnswer;
	private JLabel lavelicon;
	private  int xMouse, yMouse;
	private JLabel titleLabel;
	private JPanel panelSeePassword;
	private JLabel LabelSeePassword;
	private JPanel panelSeePasswordConfir;
	private JLabel LabelSeePasswordConfir;
	private JPanel panelSeePasswordFrase;
	private JLabel LabelSeePasswordFrase;
	private JPanel panelSeePasswordQuestion;
	private JLabel LabelSeePasswordQuestion;
	private JPanel panelSeePasswordAnswer;
	private JLabel LabelSeePasswordAnswer;
	private JPanel panelButtonAceptar;
	private JLabel labelButtonAceptar;
	private int showPass = 0;
	private int showPassConfir = 0;
	private int showPassFrase = 0;
	private int showPassPregunta = 0;
	private int showPassQuestion = 0;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					startVentana();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public static void startVentana() {
		try {
			newUserProfileUI = new NewUserProfileUI();
			newUserProfileUI.setVisible(true);
			newUserProfileUI.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public NewUserProfileUI() {
	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 200, 843, 497);
		setLocationByPlatform(true);
		setUndecorated(true);
        setResizable(false);
        setLocationRelativeTo(null);
        
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(3, 3, 3, 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lavelicon = new JLabel("");
		lavelicon.setIcon(new ImageIcon(NewUserProfileUI.class.getResource("/imagenes/win1.jpg")));
		lavelicon.setBounds(592, 0, 251, 497);
		contentPane.add(lavelicon);
		
		panelHeader = new JPanel();
		panelHeader.setBackground(Color.WHITE);
		panelHeader.setBounds(0, 0, 829, 45);
		contentPane.add(panelHeader);
		panelHeader.setLayout(null);
		panelHeader.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseDragged(java.awt.event.MouseEvent evt) {
				headerMouseDragged(evt);
			}
		});
		panelHeader.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				headerMousePressed(evt);
			}
		});
		
		panelButonClose = new JPanel();
		panelButonClose.setBackground(Color.WHITE);
		panelButonClose.setBounds(0, 0, 53, 48);
		panelHeader.add(panelButonClose);
		panelButonClose.setLayout(new BorderLayout(0, 0));
		
		labelbutonClose = new JLabel("");
		labelbutonClose.setHorizontalAlignment(SwingConstants.CENTER);
		labelbutonClose.setIcon(new ImageIcon(NewUserProfileUI.class.getResource("/imagenes/botonCerrarRed.png")));
		panelButonClose.add(labelbutonClose);
		
		labelbutonClose.addMouseListener(new java.awt.event.MouseAdapter() {
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
		
		
		
		
		labelNameUser = new JLabel("Name:");
		labelNameUser.setFont(new Font("Roboto", Font.BOLD, 16));
		labelNameUser.setBounds(30, 106, 73, 17);
		contentPane.add(labelNameUser);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldUserName.setBounds(80, 124, 413, 19);
		textFieldUserName.setColumns(10);
		textFieldUserName.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		contentPane.add(textFieldUserName);
		
		labelPassword = new JLabel("User Password:");
		labelPassword.setBounds(30, 161, 127, 13);
		labelPassword.setFont(new Font("Roboto", Font.BOLD, 16));
		
		contentPane.add(labelPassword);
		
		passwordFieldPasswordUser = new JPasswordField();
		passwordFieldPasswordUser.setBounds(80, 184, 413, 19);
		passwordFieldPasswordUser.setFont(new Font("Roboto", Font.PLAIN, 14));
		passwordFieldPasswordUser.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		passwordFieldPasswordUser.setEchoChar('*');
		contentPane.add(passwordFieldPasswordUser);
		
		labelComfirmPassword = new JLabel("Comfirm password:");
		labelComfirmPassword.setBounds(30, 213, 168, 19);
		labelComfirmPassword.setFont(new Font("Roboto", Font.BOLD, 16));
		contentPane.add(labelComfirmPassword);
		
		passwordFieldComfirm = new JPasswordField();
		passwordFieldComfirm.setBounds(80, 242, 413, 19);
		passwordFieldComfirm.setFont(new Font("Roboto", Font.PLAIN, 14));
		passwordFieldComfirm.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		passwordFieldComfirm.setEchoChar('*');
		contentPane.add(passwordFieldComfirm);
		
		lavelTitlePreguntas = new JLabel("Security Questions");
		lavelTitlePreguntas.setHorizontalAlignment(SwingConstants.CENTER);
		lavelTitlePreguntas.setBounds(221, 271, 200, 29);
		lavelTitlePreguntas.setFont(new Font("Roboto", Font.BOLD, 18));
		contentPane.add(lavelTitlePreguntas);
		
		labelPhrase = new JLabel("Phrase / Frase:");
		labelPhrase.setBounds(30, 302, 116, 29);
		labelPhrase.setFont(new Font("Roboto", Font.BOLD, 16));
		contentPane.add(labelPhrase);
		
		passwordFieldPhrase = new JPasswordField();
		passwordFieldPhrase.setBounds(80, 330, 413, 19);
		passwordFieldPhrase.setFont(new Font("Roboto", Font.PLAIN, 14));
		passwordFieldPhrase.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		passwordFieldPhrase.setEchoChar('*');
		contentPane.add(passwordFieldPhrase);
		
		labelSecurityQuestion = new JLabel("Security Question:");
		labelSecurityQuestion.setBounds(30, 359, 168, 19);
		labelSecurityQuestion.setFont(new Font("Roboto", Font.BOLD, 16));
		contentPane.add(labelSecurityQuestion);
		
		
		passwordFieldQuestion = new JPasswordField();
		passwordFieldQuestion.setBounds(80, 388, 413, 19);
		passwordFieldQuestion.setFont(new Font("Roboto", Font.PLAIN, 14));
		passwordFieldQuestion.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		passwordFieldQuestion.setEchoChar('*');
		contentPane.add(passwordFieldQuestion);
		
		
		labelSecurityAnswer = new JLabel("Security Answer:");
		labelSecurityAnswer.setFont(new Font("Roboto", Font.BOLD, 16));
		labelSecurityAnswer.setBounds(30, 417, 168, 19);
		contentPane.add(labelSecurityAnswer);
		
		
		passwordFieldAnswer = new JPasswordField();
		passwordFieldAnswer.setBounds(80, 446, 413, 19);
		passwordFieldAnswer.setFont(new Font("Roboto", Font.PLAIN, 14));
		passwordFieldAnswer.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		passwordFieldAnswer.setEchoChar('*');
		contentPane.add(passwordFieldAnswer);
		
		titleLabel = new JLabel("Ingrese su perfil de usuario");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Roboto", Font.BOLD, 18));
		titleLabel.setBounds(128, 62, 228, 34);
		contentPane.add(titleLabel);
		
	
		panelSeePassword = new JPanel();
		panelSeePassword.setBackground(Color.WHITE);
		panelSeePassword.setBounds(503, 172, 38, 31);
		contentPane.add(panelSeePassword);
		
		LabelSeePassword = new JLabel("");
		LabelSeePassword.setHorizontalAlignment(SwingConstants.CENTER);
		LabelSeePassword.setIcon(new ImageIcon(NewUserProfileUI.class.getResource("/imagenes/icons8-eye-24.png")));
		panelSeePassword.add(LabelSeePassword);
		
		LabelSeePassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
            	 if(showPass==0){
            		 passwordFieldPasswordUser.setEchoChar((char)0);
                 	showPass=1;
                 } else {
                	 passwordFieldPasswordUser.setEchoChar('*');
                 	showPass=0;
                 }	
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	seePassMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	seePassMouseExited(evt);
            }
        });
		
		
		panelSeePasswordConfir = new JPanel();
		panelSeePasswordConfir.setBackground(Color.WHITE);
		panelSeePasswordConfir.setBounds(503, 230, 38, 31);
		contentPane.add(panelSeePasswordConfir);
		
		LabelSeePasswordConfir = new JLabel("");
		LabelSeePasswordConfir.setHorizontalAlignment(SwingConstants.CENTER);
		LabelSeePasswordConfir.setIcon(new ImageIcon(NewUserProfileUI.class.getResource("/imagenes/icons8-eye-24.png")));
		panelSeePasswordConfir.add(LabelSeePasswordConfir);
		
		panelSeePasswordConfir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
            	 if(showPassConfir==0){
            		 passwordFieldComfirm.setEchoChar((char)0);
            		 showPassConfir=1;
                 } else {
                	 passwordFieldComfirm.setEchoChar('*');
                	 showPassConfir=0;
                 }	
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	confirnPassMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	confirnPassMouseExited(evt);
            }
        });
		
		
		
		panelSeePasswordFrase = new JPanel();
		panelSeePasswordFrase.setBackground(Color.WHITE);
		panelSeePasswordFrase.setBounds(503, 318, 38, 31);
		contentPane.add(panelSeePasswordFrase);
		
		LabelSeePasswordFrase = new JLabel("");
		LabelSeePasswordFrase.setHorizontalAlignment(SwingConstants.CENTER);
		LabelSeePasswordFrase.setIcon(new ImageIcon(NewUserProfileUI.class.getResource("/imagenes/icons8-eye-24.png")));
		panelSeePasswordFrase.add(LabelSeePasswordFrase);
		
		LabelSeePasswordFrase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
            	 if(showPassFrase==0){
            		 passwordFieldPhrase.setEchoChar((char)0);
            		 showPassFrase=1;
                 } else {
                	 passwordFieldPhrase.setEchoChar('*');
                	 showPassFrase=0;
                 }	
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	frasePassMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	frasePassMouseExited(evt);
            }
        });
		

		panelSeePasswordQuestion = new JPanel();
		panelSeePasswordQuestion.setBackground(Color.WHITE);
		panelSeePasswordQuestion.setBounds(503, 375, 38, 31);
		contentPane.add(panelSeePasswordQuestion);
		
		LabelSeePasswordQuestion = new JLabel("");
		LabelSeePasswordQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		LabelSeePasswordQuestion.setIcon(new ImageIcon(NewUserProfileUI.class.getResource("/imagenes/icons8-eye-24.png")));
		panelSeePasswordQuestion.add(LabelSeePasswordQuestion);
		
		LabelSeePasswordQuestion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
            	 if(showPassPregunta==0){
            		 passwordFieldQuestion.setEchoChar((char)0);
            		 showPassPregunta=1;
                 } else {
                	 passwordFieldQuestion.setEchoChar('*');
                	 showPassPregunta=0;
                 }	
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	questionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	questionMouseExited(evt);
            }
        });
		
		
		panelSeePasswordAnswer = new JPanel();
		panelSeePasswordAnswer.setBackground(Color.WHITE);
		panelSeePasswordAnswer.setBounds(503, 434, 38, 31);
		contentPane.add(panelSeePasswordAnswer);
		
		LabelSeePasswordAnswer = new JLabel("");
		LabelSeePasswordAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		LabelSeePasswordAnswer.setIcon(new ImageIcon(NewUserProfileUI.class.getResource("/imagenes/icons8-eye-24.png")));
		panelSeePasswordAnswer.add(LabelSeePasswordAnswer);
		
		LabelSeePasswordAnswer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
            	 if(showPassQuestion == 0){
            		 passwordFieldAnswer.setEchoChar((char)0);
            		 showPassQuestion = 1;
                 } else {
                	 passwordFieldAnswer.setEchoChar('*');
                	 showPassQuestion = 0;
                 }	
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	answerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	answerMouseExited(evt);
            }
        });
		
		
		
		panelButtonAceptar = new JPanel();
		panelButtonAceptar.setBackground(new Color(0, 102, 204));
		panelButtonAceptar.setBounds(456, 62, 117, 42);
		panelButtonAceptar.setLayout(new BorderLayout(0, 0));
		contentPane.add(panelButtonAceptar);
		
		
		labelButtonAceptar = new JLabel("Aceptar");
		labelButtonAceptar.setHorizontalAlignment(SwingConstants.CENTER);
		labelButtonAceptar.setForeground(Color.WHITE);
		labelButtonAceptar.setFont(new Font("Roboto", Font.BOLD, 14));
		
		labelButtonAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
            	saveButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	saveButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	saveButtonMouseExited(evt);
            }
        });
		panelButtonAceptar.add(labelButtonAceptar, BorderLayout.CENTER);
	

	}
	
	
	private void headerMousePressed(java.awt.event.MouseEvent evt) {
		xMouse = evt.getX();
		yMouse = evt.getY();
	}

	private void headerMouseDragged(java.awt.event.MouseEvent evt) {
		int x = evt.getXOnScreen();
		int y = evt.getYOnScreen();
		this.setLocation(x - xMouse, y - yMouse);
	}

	private void exitTxtMouseClicked(java.awt.event.MouseEvent evt) {
		dispose();
		// System.exit(0);
	}

	private void exitTxtMouseEntered(java.awt.event.MouseEvent evt) {
		labelbutonClose.setIcon(new ImageIcon(NewUserProfileUI.class.getResource("/imagenes/botonCerrar.png")));
	}

	private void exitTxtMouseExited(java.awt.event.MouseEvent evt) {
		labelbutonClose.setIcon(new ImageIcon(NewUserProfileUI.class.getResource("/imagenes/botonCerrarRed.png")));
	}

	private void seePassMouseEntered(java.awt.event.MouseEvent evt) {
		LabelSeePassword.setIcon(new ImageIcon(NewUserProfileUI.class.getResource("/imagenes/eye.png")));
	}

	private void seePassMouseExited(java.awt.event.MouseEvent evt) {
		LabelSeePassword.setIcon(new ImageIcon(NewUserProfileUI.class.getResource("/imagenes/icons8-eye-24.png")));
	}

	private void confirnPassMouseEntered(java.awt.event.MouseEvent evt) {
		LabelSeePasswordConfir.setIcon(new ImageIcon(NewUserProfileUI.class.getResource("/imagenes/eye.png")));
	}

	private void confirnPassMouseExited(java.awt.event.MouseEvent evt) {
		LabelSeePasswordConfir.setIcon(new ImageIcon(NewUserProfileUI.class.getResource("/imagenes/icons8-eye-24.png")));
	}

	private void frasePassMouseEntered(java.awt.event.MouseEvent evt) {

		LabelSeePasswordFrase.setIcon(new ImageIcon(NewUserProfileUI.class.getResource("/imagenes/eye.png")));
	}

	private void frasePassMouseExited(java.awt.event.MouseEvent evt) {
		LabelSeePasswordFrase.setIcon(new ImageIcon(NewUserProfileUI.class.getResource("/imagenes/icons8-eye-24.png")));
	}

	private void answerMouseEntered(java.awt.event.MouseEvent evt) {
		LabelSeePasswordAnswer.setIcon(new ImageIcon(NewUserProfileUI.class.getResource("/imagenes/eye.png")));
	}

	private void answerMouseExited(java.awt.event.MouseEvent evt) {
		LabelSeePasswordAnswer.setIcon(new ImageIcon(NewUserProfileUI.class.getResource("/imagenes/icons8-eye-24.png")));
	}

	private void questionMouseEntered(java.awt.event.MouseEvent evt) {
		LabelSeePasswordQuestion.setIcon(new ImageIcon(NewUserProfileUI.class.getResource("/imagenes/eye.png")));
	}

	private void questionMouseExited(java.awt.event.MouseEvent evt) {
		LabelSeePasswordQuestion.setIcon(new ImageIcon(NewUserProfileUI.class.getResource("/imagenes/icons8-eye-24.png")));
	}

	private void saveButtonMouseEntered(java.awt.event.MouseEvent evt) {
		panelButtonAceptar.setBackground(new Color(0, 156, 223));
	}

	private void saveButtonMouseExited(java.awt.event.MouseEvent evt) {
		panelButtonAceptar.setBackground(new Color(0, 102, 204));
	}

	private void saveButtonMouseClicked(java.awt.event.MouseEvent evt) {
		
		try {
			ProgressBar.startVentana();
			String userName = textFieldUserName.getText();
			String userPassword = String.valueOf(passwordFieldPasswordUser.getPassword());
			String userPasswordConfir = String.valueOf(passwordFieldComfirm.getPassword());
			String userFrase = String.valueOf(passwordFieldPhrase.getPassword());
			String userQuestion = String.valueOf(passwordFieldQuestion.getPassword());
			String userAnswer = String.valueOf(passwordFieldAnswer.getPassword());

			// TODO: IMPLEMENTAR UNA BARRA DE LOGIN O BARRA DE PROGRESO PARA ESTA PARTE

			if (userPassword.equals(userPasswordConfir)) {
				User user = new User(userName.trim(), userPassword.trim(), userAnswer.trim(), userQuestion.trim(), userFrase.trim(), true);
				UserService.getUserService().userSave(user);
				ProgressBar.detieneCuenta();
				newUserProfileUI.setVisible(false);
			}
			ProgressBar.detieneCuenta();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, 
					"Ocurrio un error al tratar de salvar el usuario",
					"Error en servicio de salvar usuario Nuevo", 
					JOptionPane.ERROR_MESSAGE);
		}

	}
	
}














