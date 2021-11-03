package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import constants.Constant;
import mapper.MapperDato;
import model.Categories;
import model.Data;
import pojos.DataPojo;
import pojos.LoginSessionPojo;
import service.CategoriesServices;
import service.DataService;

public class CargaDataJinternal extends JInternalFrame {

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
    private JLabel labelTitleData;
    private JLabel labelCategories;
    private JComboBox<String> comboBox;
    private JLabel labelTitle;
    private JTextField textFieldTitle;
    private JLabel labelAdress;
    private JTextField textFieldAdress;
    private JLabel labelContenido;
    private JTextArea textArea;
    private String[] userCategories = new String [0]; ;
    private String categoria;
    private JPanel panelButtonE;
    private JLabel labelButton;
    private JPanel panelButtonNewCategories;
    private JLabel labelNewCategories; 
    private Boolean newCategotia = false;
    
	public CargaDataJinternal() {
		
	
		putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);		
		setResizable(true);
		setBounds(15, 15, 480, 380);
		getContentPane().setBackground(Color.WHITE);
		panelHeader = new JPanel();
		panelHeader.setBackground(Color.WHITE);
		panelAccion = new JPanel();
		panelAccion.setBackground(Color.WHITE);
				
		labelCategories = new JLabel("Categorias:");
		labelCategories.setHorizontalAlignment(SwingConstants.LEFT);
		labelCategories.setFont(new Font("Roboto", Font.BOLD, 14));
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedComboBox(e);
			}
		});
		comboBox.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK));
		
		labelTitle = new JLabel("Title:");
		labelTitle.setHorizontalAlignment(SwingConstants.LEFT);
		labelTitle.setFont(new Font("Roboto", Font.BOLD, 14));
		
		textFieldTitle = new JTextField();
		textFieldTitle.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldTitle.setColumns(10);
		textFieldTitle.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		
		labelAdress = new JLabel("Adress:");
		labelAdress.setFont(new Font("Roboto", Font.BOLD, 14));
		
		textFieldAdress = new JTextField();
		textFieldAdress.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldAdress.setColumns(10);
		textFieldAdress.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		
		labelContenido = new JLabel("Contenido:");
		labelContenido.setFont(new Font("Roboto", Font.BOLD, 14));
		
		textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		
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
		
		panelButtonE = new JPanel();// 
		panelButtonE.setBackground(new Color(0, 102, 204));
		
		panelButtonNewCategories = new JPanel();
		panelButtonNewCategories.setBackground(new Color(0, 102, 204));
		panelButtonNewCategories.setLayout(new BorderLayout(0, 0));
		
		GroupLayout gl_panelAccion = new GroupLayout(panelAccion);
		gl_panelAccion.setHorizontalGroup(
			gl_panelAccion.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAccion.createSequentialGroup()
					.addGroup(gl_panelAccion.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAccion.createSequentialGroup()
							.addGroup(gl_panelAccion.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelAccion.createSequentialGroup()
									.addGap(60)
									.addComponent(textFieldTitle, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
								.addGroup(gl_panelAccion.createSequentialGroup()
									.addGap(26)
									.addGroup(gl_panelAccion.createParallelGroup(Alignment.LEADING)
										.addComponent(labelTitle, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
										.addComponent(labelCategories, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panelAccion.createSequentialGroup()
											.addGap(35)
											.addComponent(comboBox, 0, 179, Short.MAX_VALUE))
										.addComponent(labelAdress, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
										.addComponent(labelContenido, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))))
							.addGap(84))
						.addGroup(gl_panelAccion.createSequentialGroup()
							.addGap(66)
							.addComponent(textFieldAdress, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
							.addGap(76)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelAccion.createParallelGroup(Alignment.LEADING)
						.addComponent(panelButtonE, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelButtonNewCategories, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
					.addGap(25))
				.addGroup(gl_panelAccion.createSequentialGroup()
					.addGap(63)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(49, Short.MAX_VALUE))
		);
		
		gl_panelAccion.setVerticalGroup(
			gl_panelAccion.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAccion.createSequentialGroup()
					.addGap(22)
					.addComponent(labelCategories)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelAccion.createParallelGroup(Alignment.LEADING)
						.addComponent(panelButtonNewCategories, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(labelTitle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldTitle, GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_panelAccion.createParallelGroup(Alignment.LEADING)
						.addComponent(panelButtonE, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
						.addGroup(gl_panelAccion.createSequentialGroup()
							.addComponent(labelAdress)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldAdress, GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)))
					.addGap(18)
					.addComponent(labelContenido)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		labelNewCategories = new JLabel("New Categories");
		labelNewCategories.setHorizontalAlignment(SwingConstants.CENTER);
		labelNewCategories.setFont(new Font("Roboto", Font.BOLD, 14));
		labelNewCategories.setForeground(Color.WHITE);
		panelButtonNewCategories.add(labelNewCategories, BorderLayout.CENTER);
		labelNewCategories.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
            	categoriesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	categoriesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	categoriesMouseExited(evt);
            }
        });
		
		
		panelButtonE.setLayout(new BorderLayout(0, 0));
		labelButton = new JLabel("Save");
		labelButton.setFont(new Font("Roboto", Font.BOLD, 14));
		labelButton.setForeground(Color.WHITE);
		labelButton.setHorizontalAlignment(SwingConstants.CENTER);
		panelButtonE.add(labelButton);
		labelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
            	if (LoginSessionPojo.loginSeccion().getAutorizado()) {
            		saveMouseClicked(evt);
            	} 
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                saveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                saveMouseExited(evt);
            }
        });
		
		panelAccion.setLayout(gl_panelAccion);
		panelHeader.setLayout(null);
		
		panelCloseButton = new JPanel();
		panelCloseButton.setBackground(Color.WHITE);
		panelCloseButton.setBounds(10, 0, 26, 41);
		
		panelHeader.add(panelCloseButton);
		panelCloseButton.setLayout(new BorderLayout(0, 0));
		labelCloseButton = new JLabel("");
		labelCloseButton.setIcon(new ImageIcon(CargaDataJinternal.class.getResource("/imagenes/botonCerrarRed.png")));
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
		labelButtonMaximisize.setIcon(new ImageIcon(CargaDataJinternal.class.getResource("/imagenes/expandir1.png")));
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
		labelButtonMini.setIcon(new ImageIcon(CargaDataJinternal.class.getResource("/imagenes/minimizar3.png")));
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
		
		labelTitleData = new JLabel("Cargar de Datos ");
		labelTitleData.setFont(new Font("Roboto", Font.BOLD, 17));
		labelTitleData.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitleData.setBounds(128, 0, 240, 41);
		panelHeader.add(labelTitleData);
		
		getContentPane().setLayout(groupLayout);
	}

	
	   private void closeA() {
	        closable = true;
	        firePropertyChange("closable", Boolean.TRUE, Boolean.TRUE);
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
	
  private void exitTxtMouseEntered(java.awt.event.MouseEvent evt) {
	  labelCloseButton.setIcon(new ImageIcon(CargaDataJinternal.class.getResource("/imagenes/botonCerrar.png")));
  }  
 
   private void exitTxtMouseExited(java.awt.event.MouseEvent evt) {
	   labelCloseButton.setIcon(new ImageIcon(CargaDataJinternal.class.getResource("/imagenes/botonCerrarRed.png")));
    }	
   
	
   private void maxMouseEntered(java.awt.event.MouseEvent evt) {
	   labelButtonMaximisize.setIcon(new ImageIcon(CargaDataJinternal.class.getResource("/imagenes/expandir2.png")));
     }
  
    private void maxMouseExited(java.awt.event.MouseEvent evt) {
    	labelButtonMaximisize.setIcon(new ImageIcon(CargaDataJinternal.class.getResource("/imagenes/expandir1.png")));
     }
    
    private void minimisizeMouseClicked(java.awt.event.MouseEvent evt) {
  		mini();
  		labelButtonMini.setIcon(new ImageIcon(CargaDataJinternal.class.getResource("/imagenes/minimizar3.png")));
    }
    
    private void minimisizeMouseEntered(java.awt.event.MouseEvent evt) {
    	labelButtonMini.setIcon(new ImageIcon(CargaDataJinternal.class.getResource("/imagenes/minimizar2.png")));
    }

   private void minimisizeMouseExited(java.awt.event.MouseEvent evt) {
	   labelButtonMini.setIcon(new ImageIcon(CargaDataJinternal.class.getResource("/imagenes/minimizar3.png")));
    }
    
    
    @SuppressWarnings("unchecked")
	public void setArrayCategories(String[] categories) {
    	if(categories.length > 0) {
    		userCategories = categories;
    		comboBox.addItem("");
    		for(String name: userCategories) {
    			comboBox.addItem(name);
    		}
    	}else {
    		userCategories = new String [0]; 
    	}
    }
    
	protected void actionPerformedComboBox(ActionEvent e) {
		categoria = comboBox.getSelectedItem().toString();
	}
	
	 private void saveMouseEntered(java.awt.event.MouseEvent evt) {
		 panelButtonE.setBackground(new Color(0, 156, 223));
	    }
	 
	 private void saveMouseExited(java.awt.event.MouseEvent evt) {
		 panelButtonE.setBackground(new Color(0, 102, 204));
	    }
	
		@SuppressWarnings("unlikely-arg-type")
		private void saveMouseClicked(java.awt.event.MouseEvent evt) {
			try {
				ProgressBar.startVentana();					
				
				if (textArea != null && !textArea.equals("")) {
					Data datos = Data.newInstanceData(categoria, textFieldTitle.getText(), textArea.getText(),textFieldAdress.getText(), null, LoginSessionPojo.loginSeccion().getCodigoUser());

					if (datos != null) {
						DataService.getDataService().saveData(datos, LoginSessionPojo.loginSeccion().getFraseUser());
						LoginSessionPojo.loginSeccion().updateLibreria(new MapperDato().entityToPojo(datos));
						ProgressBar.detieneCuenta();
						resetText();
						
						if (CentralView.tabletActive) {
							TabletJInternal.updateTablet();
						}
					}
				}
			} catch (Exception e) {
				ProgressBar.detieneCuenta();
			}
			
		}
	 
		
		private void resetText() {
			textFieldTitle.setText("");
			textArea.setText("");
			textFieldAdress.setText("");
		}
		
	 private void categoriesMouseEntered(java.awt.event.MouseEvent evt) {
		 panelButtonNewCategories.setBackground(new Color(0, 156, 223));
	    }
	 
	 private void categoriesMouseExited(java.awt.event.MouseEvent evt) {
		 panelButtonNewCategories.setBackground(new Color(0, 102, 204));
	    }
	
	 private void categoriesMouseClicked(java.awt.event.MouseEvent evt) {
	
			JTextField category = new JTextField();
			JTextField description = new JTextField();
			Object[] message = { "Category:", category,  "Description:", description };
			int option = JOptionPane.showConfirmDialog(null, message, "Enter the new Category", JOptionPane.OK_CANCEL_OPTION);
			
			if (option == JOptionPane.OK_OPTION) {
				 newCategotia = true;
				 comboBox.addItem(category.getText());
				 description.getText();
			        if (newCategotia) {
			        	Categories categoria = new Categories(category.getText(), description.getText(), LoginSessionPojo.loginSeccion().getCodigoUser());
			        	CategoriesServices.getCategoriesServices().saveCategorie(categoria);
						TabletJInternal.initCategories();
					}     
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
						LoginSessionPojo.loginSeccion().setLibreriaData(categoriesData);
						return true;
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			return false;
		}
}
