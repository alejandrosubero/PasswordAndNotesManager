package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;


import constants.Constant;
import pojos.CategoriesPojo;
import pojos.DataPojo;
import pojos.LoginSessionPojo;
import service.CategoriesServices;
import service.CentrarLasColumnas;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;

public class TabletJInternal extends JInternalFrame {

	private JPanel panelHeader;
	private JPanel panelAccion;
	private JPanel panelCloseButton;
    private Boolean changeMax = false;
    private Boolean minimix = false;
    private JLabel labelCloseButton;
    private JPanel panelButtonMaximisize;
    private JLabel labelButtonMaximisize;
    private JPanel panelButtonMin;
    private JLabel labelButtonMini;
    private JLabel labelTituloCategories;
    private JScrollPane scrollPane;
    private static JTable table;
    private static TableCellRenderer centerAlinght = new CentrarLasColumnas();
    private static DefaultTableModel model = new DefaultTableModel();
    private static String categoria;
    private static JComboBox<String> comboBox; 
    private static String[] userCategories = new String [0];
	private String[] nombreColumna = {"Categories", "Title","Address", "Content"};
	
	

	public TabletJInternal() {
		initCategories();
		putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);		
		setResizable(true);
		setBounds(15, 15, 500, 303);
		getContentPane().setBackground(Color.WHITE);
		panelHeader = new JPanel();
		panelHeader.setBackground(Color.WHITE);
		panelAccion = new JPanel();
		panelAccion.setBackground(Color.WHITE);
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelHeader, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(panelAccion, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelHeader, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelAccion, GroupLayout.PREFERRED_SIZE, 228, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		
		scrollPane = new JScrollPane();
		table = new JTable();
		scrollPane.setViewportView(table);
		model = new DefaultTableModel(nombreColumna, 0);
		model.setColumnIdentifiers(nombreColumna);
		table.setModel(model);
		
		labelTituloCategories = new JLabel("Categorias:");
		labelTituloCategories.setFont(new Font("Roboto", Font.BOLD, 13));
		
		
		comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedComboBox(e);
			}
		});
		comboBox.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK));
		
		
		GroupLayout gl_panelAccion = new GroupLayout(panelAccion);
		gl_panelAccion.setHorizontalGroup(
			gl_panelAccion.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAccion.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelAccion.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAccion.createSequentialGroup()
							.addComponent(labelTituloCategories, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelAccion.setVerticalGroup(
			gl_panelAccion.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAccion.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelAccion.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelTituloCategories)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(41, Short.MAX_VALUE))
		);
		
		panelAccion.setLayout(gl_panelAccion);
		panelHeader.setLayout(null);
		
		panelCloseButton = new JPanel();
		panelCloseButton.setBackground(Color.WHITE);
		panelCloseButton.setBounds(10, 0, 26, 41);
		panelHeader.add(panelCloseButton);
		panelCloseButton.setLayout(new BorderLayout(0, 0));
		labelCloseButton = new JLabel("");
		labelCloseButton.setIcon(new ImageIcon(TabletJInternal.class.getResource("/imagenes/botonCerrarRed.png")));
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
		labelButtonMaximisize.setIcon(new ImageIcon(TabletJInternal.class.getResource("/imagenes/expandir1.png")));
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
		labelButtonMini.setIcon(new ImageIcon(TabletJInternal.class.getResource("/imagenes/minimizar3.png")));
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
		
		this.setArrayCategories(userCategories);
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
			CentralView.tabletActive = false;
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
		labelCloseButton.setIcon(new ImageIcon(TabletJInternal.class.getResource("/imagenes/botonCerrar.png")));
	}

	private void exitTxtMouseExited(java.awt.event.MouseEvent evt) {
		labelCloseButton.setIcon(new ImageIcon(TabletJInternal.class.getResource("/imagenes/botonCerrarRed.png")));
	}

	private void maxMouseEntered(java.awt.event.MouseEvent evt) {
		labelButtonMaximisize.setIcon(new ImageIcon(TabletJInternal.class.getResource("/imagenes/expandir2.png")));
	}

	private void maxMouseExited(java.awt.event.MouseEvent evt) {
		labelButtonMaximisize.setIcon(new ImageIcon(TabletJInternal.class.getResource("/imagenes/expandir1.png")));
	}

	private void minimisizeMouseClicked(java.awt.event.MouseEvent evt) {
		mini();
		//String imagenMini = Constant.direccionDeCarpetaImagenes + "minimizar3.png";
		labelButtonMini.setIcon(new ImageIcon(TabletJInternal.class.getResource("/imagenes/minimizar3.png")));
	}

	private void minimisizeMouseEntered(java.awt.event.MouseEvent evt) {
		labelButtonMini.setIcon(new ImageIcon(TabletJInternal.class.getResource("/imagenes/minimizar2.png")));
	}

	private void minimisizeMouseExited(java.awt.event.MouseEvent evt) {
		labelButtonMini.setIcon(new ImageIcon(TabletJInternal.class.getResource("/imagenes/minimizar3.png")));
	}

	
	public void setArrayCategories(String[] categories) {
		userCategories = null;
		userCategories = new String [0];
		comboBox.removeAll();
		
		if (categories.length > 0) {
			userCategories = categories;
			comboBox.addItem("");
			comboBox.addItem("ALL");
			for (String name : userCategories) {
				comboBox.addItem(name);
			}
		} 
	}
	
	protected void actionPerformedComboBox(ActionEvent e) {
		startTablaData();
	}
	
	
	private static void startTablaData() {
		categoria = comboBox.getSelectedItem().toString();
		List<DataPojo> datos = new ArrayList<DataPojo>();
		datos = LoginSessionPojo.loginSeccion().getListDatapojoByKey(categoria);
		if (datos != null && datos.size() > 0) {
			restarTablet();
			filltablet(datos);
		}
	}
	
	
//	public void newDatoIntablet( DataPojo datos) {
//		Object[] row = new Object[4];
//	
//			row[0] = datos.getCategories();
//			row[1] = datos.getTitle();
//			row[2] = datos.getAddress();
//			row[3] = datos.getContent();
//			model.addRow(row);
//		
//		table.setModel(model);
//		table.getColumnModel().getColumn(0).setCellRenderer(centerAlinght);
//		table.getColumnModel().getColumn(1).setCellRenderer(centerAlinght);
//		table.getColumnModel().getColumn(2).setCellRenderer(centerAlinght);
//		table.getColumnModel().getColumn(3).setCellRenderer(centerAlinght);
//	}

	public static void filltablet(List<DataPojo> datos) {
		Object[] row = new Object[4];
		for (int i = 0; i < datos.size(); i++) {
			row[0] = datos.get(i).getCategories();
			row[1] = datos.get(i).getTitle();
			row[2] = datos.get(i).getAddress();
			row[3] = datos.get(i).getContent();
			model.addRow(row);
		}
		table.setModel(model);
		table.getColumnModel().getColumn(0).setCellRenderer(centerAlinght);
		table.getColumnModel().getColumn(1).setCellRenderer(centerAlinght);
		table.getColumnModel().getColumn(2).setCellRenderer(centerAlinght);
		table.getColumnModel().getColumn(3).setCellRenderer(centerAlinght);
	}

	public static void restarTablet() {
		model.setRowCount(0);
	}

	protected static void initCategories() {
		userCategories = null;
		String code = LoginSessionPojo.loginSeccion().getCodigoUser();
		List<CategoriesPojo> categories = CategoriesServices.getCategoriesServices().findByCodigoUser(code);
		userCategories = new String[categories.size()];
		for (int i = 0; i < categories.size(); i++) {
			userCategories[i] = categories.get(i).getCategory();
		}
	}
	
   public static void updateTablet() {
	   restarTablet();
	   startTablaData(); 
   }
	
 
}
