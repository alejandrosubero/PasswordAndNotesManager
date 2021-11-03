package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TabletView  {
	
	public static void main(String[] args) {
		JFrame ed = new MarcoTablet();
		ed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ed.setVisible(true);
		
	}


}


class MarcoTablet extends JFrame {
	
	private JTable tabla;
	private DefaultTableModel model = new DefaultTableModel();
	
	private String[] nombreColumna = {"id","Categories", "Title","Content","Address"};
	
	private  Object[] [] datosfilas = {
			{ 1,"a", "b", 1 ,0},
			{ 2,"a", "b", 2 ,0},
			{ 3,"a", "b", 3 ,0},
	};
	
	
	public MarcoTablet() {
		
		setTitle("titulo de prueba");
		setBounds(350, 350, 800, 700);
		
		tabla = new JTable();
		JPanel panelControl = new JPanel();
		panelControl.setBounds(350, 350, 900, 700);
		JScrollPane scrollPanel = new JScrollPane(tabla);
		
		panelControl.add(scrollPanel, BorderLayout.CENTER);
		
		add(panelControl);
		
		model = new DefaultTableModel(nombreColumna, 0);
		model.setColumnIdentifiers(nombreColumna); 
		
		
		tabla.setModel(model);
		
	}

}
