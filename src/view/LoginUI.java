package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import constants.Constant;
import security.TakePicture;
import service.UserService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class LoginUI extends JFrame {

	private JPanel backgrounBody;
	private JTextField textFieldUser;
	private JPasswordField passwordField;
	private JPanel panelButonIngresar;
	private JLabel LabelIngresar;
	private JPanel headerPanel;
	private JPanel panelHederClose;
	private JLabel labelClose;
	private static LoginUI frameLoginUI;
	private int contador;
	private int xMouse, yMouse;
	private JPanel panelSeePassword;
	private JLabel labelSeePassword;
	private int showPass = 0;
	private JLabel lblNewLabel_5;
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameLoginUI = new LoginUI();
					frameLoginUI.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	public LoginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		setLocationByPlatform(true);
		setUndecorated(true);
        setResizable(false);
        setLocationRelativeTo(null);
        
		backgrounBody = new JPanel();
		backgrounBody.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(backgrounBody);
		backgrounBody.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 800, 500);
		backgrounBody.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(513, 0, 287, 500);
		lblNewLabel.setIcon(new ImageIcon(LoginUI.class.getResource("/imagenes/win1.jpg")));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LoginUI.class.getResource("/imagenes/logo.png")));
		lblNewLabel_1.setBounds(513, 129, 287, 121);
		lblNewLabel_1.setVisible(true);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ingrese su datos de Accepso");
		lblNewLabel_2.setFont(new Font("Roboto Black", Font.BOLD, 16));
		lblNewLabel_2.setBounds(137, 75, 237, 37);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Usuario:");
		lblNewLabel_3.setFont(new Font("Roboto Black", Font.BOLD, 14));
		lblNewLabel_3.setBounds(46, 154, 82, 26);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Password:");
		lblNewLabel_4.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_4.setBounds(46, 243, 82, 13);
		panel.add(lblNewLabel_4);
	
		textFieldUser = new JTextField();
	//	public MatteBorder(int top, int left, int bottom, int right,  Color matteColor)
		textFieldUser.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		
		textFieldUser.setToolTipText("PassWord");
		textFieldUser.setBounds(46, 187, 328, 19);
		panel.add(textFieldUser);
		textFieldUser.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(46, 266, 328, 19);
		passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		passwordField.setEchoChar('*');
		panel.add(passwordField);
		
		panelButonIngresar = new JPanel();
		panelButonIngresar.setBackground(new Color(0, 102, 204));
		panelButonIngresar.setBounds(183, 343, 102, 37);
		panel.add(panelButonIngresar);
		panelButonIngresar.setLayout(new BorderLayout(0, 0));
		
		LabelIngresar = new JLabel("Ingresar");
		panelButonIngresar.add(LabelIngresar);
		LabelIngresar.setForeground(Color.WHITE);
		LabelIngresar.setHorizontalAlignment(SwingConstants.CENTER);
		LabelIngresar.setFont(new Font("Roboto", Font.BOLD, 14));
		LabelIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		LabelIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loginBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginBtnTxtMouseExited(evt);
            }
        });
		
		
		headerPanel = new JPanel();
		headerPanel.setBackground(Color.WHITE);
		headerPanel.setBounds(0, 0, 790, 37);
		headerPanel.setLayout(null);
		headerPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseDragged(java.awt.event.MouseEvent evt) {
				headerMouseDragged(evt);
			}
		});
		headerPanel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				headerMousePressed(evt);
			}
		});
		panel.add(headerPanel);
		
		
		panelHederClose = new JPanel();
		panelHederClose.setBounds(0, 0, 36, 37);
		panelHederClose.setBackground(Color.WHITE);
		headerPanel.add(panelHederClose);
		
		labelClose = new JLabel("");
		labelClose.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelClose.setIcon(new ImageIcon(LoginUI.class.getResource("/imagenes/botonCerrarRed.png")));
		labelClose.setHorizontalAlignment(SwingConstants.CENTER);
		labelClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	    labelClose.setForeground(Color.white);
	    panelHederClose.addMouseListener(new java.awt.event.MouseAdapter() {
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
		panelHederClose.add(labelClose);
		
		panelSeePassword = new JPanel();
		panelSeePassword.setBackground(Color.WHITE);
		panelSeePassword.setBounds(373, 248, 48, 37);
		panel.add(panelSeePassword);
		panelSeePassword.setLayout(new BorderLayout(0, 0));
		
		labelSeePassword = new JLabel("");
		labelSeePassword.setHorizontalAlignment(SwingConstants.CENTER);
		labelSeePassword.setIcon(new ImageIcon(LoginUI.class.getResource("/imagenes/icons8-eye-24.png")));
		labelSeePassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panelSeePassword.add(labelSeePassword);
		
		lblNewLabel_5 = new JLabel("Select here to create a new user profile... ");
		lblNewLabel_5.setForeground(new Color(0, 0, 205));
		lblNewLabel_5.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_5.setBounds(44, 295, 377, 26);
		lblNewLabel_5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    
		lblNewLabel_5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
            	newUserMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	newUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	newUserMouseExited(evt);
            }
        });
		

		panel.add(lblNewLabel_5);
		labelSeePassword.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mousePressed(java.awt.event.MouseEvent evt) {
	            	 if(showPass==0){
	                 	passwordField.setEchoChar((char)0);
	                 	showPass=1;
	                 } else {
	                 	passwordField.setEchoChar('*');
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
	}
	
	
	private void loginBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {
		
		try {
			ProgressBar.startVentana();
	//	Boolean autorized = false;
		String usuario = textFieldUser.getText();
		String password = String.valueOf(passwordField.getPassword());
		
//		if (usuario != null && password != null) {
//			autorized = UserService.getUserService().checkUser(usuario.trim(), password.trim());
//		}

		if (usuario != null && password != null && UserService.getUserService().checkUser(usuario.trim(), password.trim()) ) {
	//	if (autorized) {
			ProgressBar.detieneCuenta();
			IngresoFraseUI.startVentana();
			frameLoginUI.setVisible(false);
			
		} else {
			ProgressBar.detieneCuenta();
			if (usuario == null || password == null) {
				JOptionPane.showMessageDialog(null, "Clave o usuario estan vacias", "Error Inicio Datos incorrectos", JOptionPane.ERROR_MESSAGE);
			} else {
				if (contador == 2) {TakePicture.capture();	}
				JOptionPane.showMessageDialog(null, "Clave o usuario incorrecto", "Error Inicio Datos incorrectos",	JOptionPane.ERROR_MESSAGE);
			}

			contador += 1;
			if (contador == 3) {
				JOptionPane.showMessageDialog(null, "Ingreso los datos errados mas veces de las permitidas", "Error Inicio Datos incorrectos", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
				TakePicture.capture();
			}
		 }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	 
	
	
	
	 private void loginBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {
		 panelButonIngresar.setBackground(new Color(0, 156, 223));
	    }
	 
	 private void loginBtnTxtMouseExited(java.awt.event.MouseEvent evt) {
		 panelButonIngresar.setBackground(new Color(0,134,190));
	    }
	 
	  private void exitTxtMouseClicked(java.awt.event.MouseEvent evt) {
	        System.exit(0);
	    }
	  
		private void exitTxtMouseEntered(java.awt.event.MouseEvent evt) {
			labelClose.setIcon(new ImageIcon(LoginUI.class.getResource("/imagenes/botonCerrar.png")));
		}

		private void exitTxtMouseExited(java.awt.event.MouseEvent evt) {
			labelClose.setIcon(new ImageIcon(LoginUI.class.getResource("/imagenes/botonCerrarRed.png")));
		}

		private void seePassMouseEntered(java.awt.event.MouseEvent evt) {
			labelSeePassword.setIcon(new ImageIcon(LoginUI.class.getResource("/imagenes/eye.png")));
		}

		private void seePassMouseExited(java.awt.event.MouseEvent evt) {
			labelSeePassword.setIcon(new ImageIcon(LoginUI.class.getResource("/imagenes/icons8-eye-24.png")));
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
	   
	
		  private void newUserMouseClicked(java.awt.event.MouseEvent evt) {
			  NewUserProfileUI.startVentana();
		    }
		  
			private void newUserMouseEntered(java.awt.event.MouseEvent evt) {
				lblNewLabel_5.setForeground(new Color(0, 191, 255));
			}

			private void newUserMouseExited(java.awt.event.MouseEvent evt) {
				lblNewLabel_5.setForeground(new Color(0, 0, 205));
			}
		

		
}
