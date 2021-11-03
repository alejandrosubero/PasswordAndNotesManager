package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import pojos.CategoriesPojo;
import pojos.LoginSessionPojo;
import service.CategoriesServices;
import javax.swing.JDesktopPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

public class CentralView extends JFrame {

	private JPanel contentPane;
	private static CentralView centralViewFrame;
	private String[] userCategories;
	private Boolean initCategoriesFlat = false;
	public static Boolean tabletActive = false; 
	
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem menuItemSalir;
	private JMenuItem menuItemNewDato;
	private JMenuItem menuItemBase;
	private JDesktopPane desktopPanelControl;
	private JMenuItem menuItemTabla;
	private JScrollPane scrollPane;
	private JMenu menuProfile;
	private JMenuItem menuItemUserProfile;
	
	
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
			centralViewFrame = new CentralView();
			//centralViewFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
			centralViewFrame.setVisible(true);
		    centralViewFrame.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public CentralView() {
		
		setTitle("PASSWORD MANAGER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 800);
		initCategories();
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		menuItemSalir = new JMenuItem("Salir");
		menuItemSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMenuItemSalir(e);
			}
		});
		
		menuItemNewDato = new JMenuItem("Agregar Dato");
		menuItemNewDato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMenuItemNewDato(e);
			}
		});
		mnNewMenu.add(menuItemNewDato);
		
		menuItemBase = new JMenuItem("Base infra");
		menuItemBase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMenuItemBase(e);
			}
		});
		
		menuItemTabla = new JMenuItem("Open Tabla");
		menuItemTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMenuItemTabla(e);
			}
		});
		mnNewMenu.add(menuItemTabla);
		mnNewMenu.add(menuItemBase);
		menuItemSalir.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu.add(menuItemSalir);
		
		menuProfile = new JMenu("Profile");
		menuBar.add(menuProfile);
		
		menuItemUserProfile = new JMenuItem("Change User profile");
		menuItemUserProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMenuItemUserProfile(e);
			}
		});
		menuProfile.add(menuItemUserProfile);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		scrollPane = new JScrollPane();
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		desktopPanelControl = new JDesktopPane();
		desktopPanelControl.setBackground(Color.BLACK);
		scrollPane.setViewportView(desktopPanelControl);
		desktopPanelControl.setLayout(null);
		contentPane.setLayout(gl_contentPane);
		initCategories();
	}
	
		
	private void initCategories() {
		if (!initCategoriesFlat) {
			String code = LoginSessionPojo.loginSeccion().getCodigoUser();
			List<CategoriesPojo> categories = CategoriesServices.getCategoriesServices().findByCodigoUser(code);
			userCategories = new String[categories.size()];
			for (int i = 0; i < categories.size(); i++) {
				userCategories[i] = categories.get(i).getCategory();
			}
			initCategoriesFlat = true;
		}
	}
	
	
	protected void actionPerformedMenuItemSalir(ActionEvent e) {
		 System.exit(0);
	}
	
	protected void actionPerformedMenuItemNewDato(ActionEvent e) {
		initCategoriesFlat = false;
		initCategories();
		CargaDataJinternal frameJinternal = new CargaDataJinternal();
		frameJinternal.setArrayCategories(userCategories);
		desktopPanelControl.add(frameJinternal);
		frameJinternal.setVisible(true);
			
	}
	protected void actionPerformedMenuItemBase(ActionEvent e) {
		JinternalBase frameBse = new JinternalBase();
		frameBse.setVisible(true);
		desktopPanelControl.add(frameBse);
	}
	
	protected void actionPerformedMenuItemTabla(ActionEvent e) {
		TabletJInternal frameTable = new TabletJInternal();		
		frameTable.setBounds(5, 400, 900, 280);
		CentralView.tabletActive = true;
		desktopPanelControl.add(frameTable);
		frameTable.setVisible(true);
	}
	
	protected void actionPerformedMenuItemUserProfile(ActionEvent e) {
		CambioPassworQuestionsUI frameUserChangePass = new CambioPassworQuestionsUI();
		frameUserChangePass.setVisible(true);
		desktopPanelControl.add(frameUserChangePass);
	}
}



