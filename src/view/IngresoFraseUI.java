package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import constants.Constant;
import pojos.DataPojo;
import pojos.LoginSessionPojo;
import security.TakePicture;
import service.DataService;
import service.UserService;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPasswordField;

public class IngresoFraseUI extends JFrame {

	private JPanel backgroundPane;
	private static  IngresoFraseUI ingresoFraseUI;
	private  JLabel labelCloseButton;
	private  JPanel panelCloseButton;
	private  JLabel labelIcono;
	private  JPanel panelHeader;
	private int contador;
	private  int xMouse, yMouse;
	private JLabel labelTitleIngresoFrase;
	private JLabel labelIngresoFrase;
	private JPasswordField passwordFieldIngresoFrase;
	private JPanel panelSeePassword;
	private JLabel LabelSeePassword;
	private int showPass = 0;
	private JPanel panelButtonAceptar;
	private JLabel labelAceptar;
	
	
	

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
			ingresoFraseUI = new IngresoFraseUI();
			ingresoFraseUI.setVisible(true);
			ingresoFraseUI.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public IngresoFraseUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		setLocationByPlatform(true);
		setUndecorated(true);
        setResizable(false);
        setLocationRelativeTo(null);
		backgroundPane = new JPanel();
		backgroundPane.setBackground(Color.WHITE);
		backgroundPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(backgroundPane);
		backgroundPane.setLayout(null);
		  
		labelIcono = new JLabel("");
		String imagenLlabelIcono= Constant.direccionDeCarpetaImagenes+"win1.jpg";
		labelIcono.setIcon(new ImageIcon(IngresoFraseUI.class.getResource("/imagenes/win1.jpg")));
		labelIcono.setBounds(578, 0, 222, 500);
		backgroundPane.add(labelIcono);
		
		panelHeader = new JPanel();
		panelHeader.setBackground(Color.WHITE);
		panelHeader.setBounds(0, 0, 800, 42);
		backgroundPane.add(panelHeader);
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

		panelCloseButton = new JPanel();
		panelCloseButton.setBounds(0, 0, 47, 42);
		panelCloseButton.setBackground(Color.WHITE);
		panelHeader.add(panelCloseButton);
		panelCloseButton.setLayout(null);
		
		labelCloseButton = new JLabel("");
		labelCloseButton.setBounds(0, 0, 47, 42);
		labelCloseButton.setFont(new Font("Roboto", Font.BOLD, 14));
		labelCloseButton.setIcon(new ImageIcon(IngresoFraseUI.class.getResource("/imagenes/botonCerrarRed.png")));
		labelCloseButton.setHorizontalAlignment(SwingConstants.CENTER);
		panelCloseButton.add(labelCloseButton);
		panelCloseButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		labelCloseButton.setForeground(Color.black);
		labelCloseButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
		
		
		labelTitleIngresoFrase = new JLabel("Ingreso de frase");
		labelTitleIngresoFrase.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitleIngresoFrase.setFont(new Font("Roboto", Font.BOLD, 16));
		labelTitleIngresoFrase.setBounds(194, 106, 132, 29);
		backgroundPane.add(labelTitleIngresoFrase);
		
		labelIngresoFrase = new JLabel("Frase:");
		labelIngresoFrase.setHorizontalAlignment(SwingConstants.CENTER);
		labelIngresoFrase.setFont(new Font("Roboto", Font.BOLD, 14));
		labelIngresoFrase.setBounds(88, 241, 60, 22);
		backgroundPane.add(labelIngresoFrase);
		
		passwordFieldIngresoFrase = new JPasswordField();
		passwordFieldIngresoFrase.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordFieldIngresoFrase.setBounds(126, 273, 302, 19);
		passwordFieldIngresoFrase.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		passwordFieldIngresoFrase.setEchoChar('*');

		
		backgroundPane.add(passwordFieldIngresoFrase);
		
		panelSeePassword = new JPanel();
		panelSeePassword.setBackground(Color.WHITE);	
		panelSeePassword.setBounds(423, 261, 38, 31);
		backgroundPane.add(panelSeePassword);
		LabelSeePassword = new JLabel("");
		LabelSeePassword.setIcon(new ImageIcon(IngresoFraseUI.class.getResource("/imagenes/icons8-eye-24.png")));
		LabelSeePassword.setHorizontalAlignment(SwingConstants.CENTER);
		panelSeePassword.add(LabelSeePassword);
		LabelSeePassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	
		LabelSeePassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
            	 if(showPass==0){
            		 passwordFieldIngresoFrase.setEchoChar((char)0);
                 	showPass=1;
                 } else {
                	 passwordFieldIngresoFrase.setEchoChar('*');
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
		
		panelButtonAceptar = new JPanel();
		panelButtonAceptar.setBounds(240, 390, 117, 42);
		panelButtonAceptar.setBackground(new Color(0, 102, 204));
		backgroundPane.add(panelButtonAceptar);
		panelButtonAceptar.setLayout(new BorderLayout(0, 0));
		
		labelAceptar = new JLabel("Aceptar");
		labelAceptar.setForeground(Color.WHITE);
		labelAceptar.setFont(new Font("Roboto", Font.BOLD, 14));
		labelAceptar.setHorizontalAlignment(SwingConstants.CENTER);
		labelAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		labelAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
            	if (LoginSessionPojo.loginSeccion().getAutorizado()) {
            		ProgressBar.startVentana();
                	fraseMouseClicked(evt);
            	}
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fraseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fraseMouseExited(evt);
            }
        });
		panelButtonAceptar.add(labelAceptar);
	}
	
	
	  private void seePassMouseEntered(java.awt.event.MouseEvent evt) {
		  LabelSeePassword.setIcon(new ImageIcon(IngresoFraseUI.class.getResource("/imagenes/eye.png")));
	    }
	 
	   private void seePassMouseExited(java.awt.event.MouseEvent evt) {
		   LabelSeePassword.setIcon(new ImageIcon(IngresoFraseUI.class.getResource("/imagenes/icons8-eye-24.png")));
	    }
	
	 private void exitTxtMouseClicked(java.awt.event.MouseEvent evt) {
	        System.exit(0);
	    }	
	
	   private void exitTxtMouseEntered(java.awt.event.MouseEvent evt) {
		   labelCloseButton.setIcon(new ImageIcon(IngresoFraseUI.class.getResource("/imagenes/botonCerrar.png")));
		}  

		 private void exitTxtMouseExited(java.awt.event.MouseEvent evt) {
			 labelCloseButton.setIcon(new ImageIcon(IngresoFraseUI.class.getResource("/imagenes/botonCerrarRed.png")));
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
	    
		 
		 private void fraseMouseEntered(java.awt.event.MouseEvent evt) {
			 panelButtonAceptar.setBackground(new Color(0, 156, 223));
		    }
		 
		 private void fraseMouseExited(java.awt.event.MouseEvent evt) {
			 panelButtonAceptar.setBackground(new Color(0, 102, 204));
		    }
	    
			private void fraseMouseClicked(java.awt.event.MouseEvent evt) {
				
				String frase = String.valueOf(passwordFieldIngresoFrase.getPassword());
				
				if (frase != null && !frase.equals("") 	&& chargeProgress(frase.trim())) {
					ProgressBar.detieneCuenta();
					CentralView.startVentana();
					ingresoFraseUI.setVisible(false);

				} else {
					failFrase();

				}
			}
	    
			private boolean chargeProgress(String frase) {
				Map<String, List<DataPojo>> categoriesData = new HashMap<String, List<DataPojo>>();
				List<DataPojo> listaData = null;
				try {
					List<DataPojo> listaDataEncript = DataService.getDataService().findDataBycodigoUser(LoginSessionPojo.loginSeccion().getCodigoUser());

					if (listaDataEncript != null && listaDataEncript.size() > 0) {

						if (DataService.getDataService().validFrace(listaDataEncript.get(0), frase)) {

							listaData = DataService.getDataService().decryptDataList(listaDataEncript, frase);

							for (DataPojo data : listaData) {
								if (categoriesData.isEmpty()) {
									List<DataPojo> da = new ArrayList<DataPojo>();
									da.add(data);
									categoriesData.put(data.getCategories(), da);

								} else if (categoriesData.containsKey(data.getCategories())) {
									categoriesData.get(data.getCategories()).add(data);

								} else {
									List<DataPojo> dat = new ArrayList<DataPojo>();
									dat.add(data);
									categoriesData.put(data.getCategories(), dat);
								}
							}
							LoginSessionPojo.loginSeccion().setFraseUser(frase);
							LoginSessionPojo.loginSeccion().setLibreriaData(categoriesData);
							return true;
						}
					} else {
						if (listaDataEncript.size() == 0) {
							LoginSessionPojo.loginSeccion().setFraseUser(frase);
							return true;
						}
					}
					
					
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
				return false;
			}
		
			
	private void failFrase() {
		
		try {
			// TODO: PARA ESTEAS FALLAS DEBE DE APLICARSE LA CONFIGURACION DEL USUARIO Y
			// DEBE DE SALIR UNA VENTANA QUE
			// INDIQUE QUE SE TRATO DE VIOLAR LA SEGURIDAD
			// VERIFICAR SI SE PUEDE ENCRIPTAR MAS LA INFORMACION DEL USUARIO.
			// O SI SE PERMITIRA QUE SE BORRE LOS DATOS.

			JOptionPane.showMessageDialog(null, "La Frase o llave es incorrecta","Error Inicio Datos incorrectos", JOptionPane.ERROR_MESSAGE);
			contador += 1;
			if (contador == 2) {TakePicture.capture();}
			if (contador == 3) {
				TakePicture.capture();
				JOptionPane.showMessageDialog(null, "Ingreso los datos errados mas veces de las permitidas", "Error Inicio Datos incorrectos", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
			
}



















