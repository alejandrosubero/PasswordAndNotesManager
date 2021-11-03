package com.gestor;

import java.io.File;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.Categories;
import model.Data;
import model.User;
import pojos.UserPojo;
import security.TakePicture;
import service.BashService;
import service.CategoriesServices;
import service.DataService;
import service.UserService;
import view.ProgressBar;

public class StartTest  {

	public static void main(String[] args) {

		
		BashService.startBash("Gozilla");
		
//		      JTextField xField = new JTextField(5);
//		      JTextField yField = new JTextField(5);
//
//		      JPanel myPanel = new JPanel();
//		      myPanel.add(new JLabel("Category:"));
//		      myPanel.add(xField);
//
////		      myPanel.add(Box.createVerticalBox()); 
////		      myPanel.add(Box.createVerticalStrut(15)); 
//		      myPanel.add(Box.createHorizontalStrut(15)); 
//		      myPanel.add(new JLabel("Description:"));
//		      myPanel.add(yField);
//
//		      int result = JOptionPane.showConfirmDialog(null, myPanel, "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
//		      if (result == JOptionPane.OK_OPTION) {
//		         System.out.println("x value: " + xField.getText());
//		         System.out.println("y value: " + yField.getText());
//		      }
		   
//		JTextField username = new JTextField();
//		JTextField password = new JTextField();
//		Object[] message = { "Category:", username,  "Description:", password };
//		int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
//		
//		if (option == JOptionPane.OK_OPTION) {
//		        System.out.println(username.getText());
//		        System.out.println(password.getText());
//		    }
//		
		
		// startTest();
//		try {
//			TakePicture.capture();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}	
		
//		ProgressBar.startVentana();
//		try {
//			Thread.sleep(50);
//			System.out.println("Desperte");
//			ProgressBar.detieneCuenta();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

		System.exit(0);
	}

	
	public static void testUser() {
	
		System.out.println(UserService.getUserService().checkUser("alejandro", "232323"));
		
		UserPojo alejandro = UserService.getUserService().userByUserNameAndPass("alejandro", "232323");
		UserPojo crismary = UserService.getUserService().userByUserNameAndPass("crismary", "282828");
		
		alejandro.setPregunta("Cual es el color del caballo blanco de Simon Bolibar");
		alejandro.setRespuesta("blanco");
		
		crismary.setPregunta("Cual es el color del caballo blanco de Simon Bolibar");
		crismary.setRespuesta("blanco");
				

		
		
	}
	
	
	
	public static void startTest() {
		
//User(String userName, String password, String respuesta, String pregunta, String nada)
		User alejandrox = new User("alejandro", "232323", "Cual es el color del caballo blanco de Simon Bolibar", "blanco", null, true);
		User crismaryx = new User("crismary", "282828", "Cual es el color del caballo blanco de Simon Bolibar", "blanco", null,true);
		
		System.out.println("1 crear User");
		UserService.getUserService().userSave(alejandrox);
		UserService.getUserService().userSave(crismaryx);
		System.out.println("2 userSave");

		UserPojo alejandro = UserService.getUserService().userByUserNameAndPass("alejandro", "232323");
		UserPojo crismary = UserService.getUserService().userByUserNameAndPass("crismary", "282828");

//	String alejandroCodigo = alejandro.getCodigoUser();
//	String crismaryCodigo = crismary.getCodigoUser();
//	System.out.println("3 getCodigoUser");
//	System.out.println("alejandroCodigo: "+ alejandroCodigo);
//	System.out.println("crismaryCodigo: "+ crismaryCodigo);

		System.out.println(UserService.getUserService().checkUser("alejandro", "232323"));
		System.out.println("4 checkUser");

		System.out.println(UserService.getUserService().userByCodigoUser(alejandro.getCodigoUser()).toString());
		System.out.println(UserService.getUserService().userByCodigoUser(crismary.getCodigoUser()).toString());
		System.out.println("5 print userByCodigoUser");

		Categories categorieAlejandro = new Categories("Inversiones", "fondos de pruebas ", alejandro.getCodigoUser());
		Categories categorieAlejandro2 = new Categories("Correos", " pruebas ", alejandro.getCodigoUser());
		Categories categorieCrismary = new Categories("Inversiones", "fondos de pruebas ", crismary.getCodigoUser());
		Categories categorieCrismary2 = new Categories("Correos", "pruebas ", crismary.getCodigoUser());
		System.out.println("6 Categories");

		CategoriesServices.getCategoriesServices().saveCategorie(categorieCrismary);
		CategoriesServices.getCategoriesServices().saveCategorie(categorieCrismary2);
		CategoriesServices.getCategoriesServices().saveCategorie(categorieAlejandro);
		CategoriesServices.getCategoriesServices().saveCategorie(categorieAlejandro2);
		System.out.println("7 saveCategorie");

//	System.out.println("8 Categories findByCodigoUser");
//	String cate = "";
//	for ( CategoriesPojo ca :  CategoriesServices.getCategoriesServices().findByCodigoUser(alejandro.getCodigoUser()) ) {
//			cate = ca.getCategory();
//			break;
//	}

		System.out.println("9 newInstanceData");
		Data registro1 = Data.newInstanceData("Inversiones", "Mi  registo 1", "crismary_clave", "", "Y",crismary.getCodigoUser());
		Data registro2 = Data.newInstanceData("Correos", "Mi  registo 2", "crismary_clave", "", "Y",crismary.getCodigoUser());
		Data registro6 = Data.newInstanceData("Correos", "Mi registo 3", "crismary_clave", "", "Y",	crismary.getCodigoUser());
		
		Data registro3 = Data.newInstanceData("Inversiones", "Mi registo 1", "Alejandro_clave", "", "Y",alejandro.getCodigoUser());
		Data registro4 = Data.newInstanceData("Correos", "Mi registo 2", "Alejandro_clave", "", "Y",alejandro.getCodigoUser());
		Data registro5 = Data.newInstanceData("Correos", "Mi registo 3", "Alejandro_clave", "", "Y",alejandro.getCodigoUser());

		System.out.println("10 saveData");
		DataService.getDataService().saveData(registro1, "alejandrosubero");
		DataService.getDataService().saveData(registro2, "alejandrosubero");
		DataService.getDataService().saveData(registro3, "alejandrosubero");
		DataService.getDataService().saveData(registro4, "alejandrosubero");
		DataService.getDataService().saveData(registro5, "alejandrosubero");
		DataService.getDataService().saveData(registro6, "alejandrosubero");

//	System.out.println("11 println(data.toString())");
//	List<DataPojo> ux = DataService.getDataService().findDataBycodigoUser(crismary.getCodigoUser());

//	System.out.println("12 Data findDataBycodigoUser");
//	for( DataPojo data: ux) {
//		System.out.println(data.toString());
//	}

		
	}
	
	
}
