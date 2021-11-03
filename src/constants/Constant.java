package constants;

import java.io.File;

public class Constant {

	public final static String DELETE = "delete";
	public final static String LOGUP = "logup";
	public final static String AUTHORIZED = "Authorized";
	public final static String UNAUTHORIZED = "Unuthorized";
	public final static String  ECOS = "eco";
	public final static String saltAES =  "11112586AnaAleCrys";
	
	// public final static String sDirectorioTrabajo = System.getProperty("user.dir");
	public final static String  barra = java.nio.file.FileSystems.getDefault().getSeparator();
	public final static String direccionDeCarpetaImagenes = System.getProperty("user.dir") + barra+ "lib"+ barra+"images"+ barra;
	public final static String currentUsersHomeDir = System.getProperty("user.home");
	public final static String IMAGINFOLDER = currentUsersHomeDir + File.separator + "Pictures"+File.separator;

}


