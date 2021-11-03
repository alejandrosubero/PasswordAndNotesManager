package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;


public class ProgressBar extends JFrame {

	private static final long serialVersionUID = 7383887451836555825L;
	private JPanel contentPane;
	static ProgressBar progressBar;
	private Thread hilo;
	private static Object objeto = new Object();
	private JProgressBar barra;
	static boolean pideParar = false;

	
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
			progressBar = new ProgressBar();
			progressBar.setVisible(true);
			progressBar.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public ProgressBar() {
		
		setAlwaysOnTop( true );
		setTitle("Construyendo session");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 348, 77);
		setLocationByPlatform(true);
		setUndecorated(true);
        setResizable(false);
        setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		barra = new JProgressBar();
		barra.setBounds(0, 10, 348, 57);
		barra.setBackground(new Color(248, 248, 255));
		barra.setForeground(new Color(0, 0, 205));
		
		contentPane.add(barra);
		
		iniciaCuenta();
	}
	

	
	public void iniciaCuenta() {
		if (hilo == null) {
			hilo = new ThreadCarga();
			pideParar = false;
			hilo.start();
		}
	}

	
	public static void detieneCuenta() {
		synchronized (objeto) {
			pideParar = true;
			objeto.notify();
		}
		progressBar.dispose();
	}

	
	class ThreadCarga extends Thread {

		public void run() {
			int min = 0;
			int max = 15;

			barra.setValue(min);
			barra.setMinimum(min);
			barra.setMaximum(max);

			for (int i = min; i <= max; i++) {
	
				barra.setValue(i);
				
				synchronized (objeto) {
					if (pideParar)
						break;
					try {
						objeto.wait(100);
					} catch (InterruptedException e) {
						// Se ignoran las excepciones
					}
				}
			}
			hilo = null;
			
			if (!pideParar)
			iniciaCuenta();
		}
	}
	

	
	

}
