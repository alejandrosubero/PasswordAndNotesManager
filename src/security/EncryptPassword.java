package security;



import org.apache.commons.codec.digest.DigestUtils;

public class EncryptPassword {

	public static String md5Hex(String password) {
		String EncriptadoConMD5 = DigestUtils.md5Hex(password); 
		return EncriptadoConMD5;
	}
	
	public static String sha1Hex(String password) {
		String textoEncriptadoConSHA = DigestUtils.sha1Hex(password);
		return textoEncriptadoConSHA;
	}
	
	public static String encriptaPassword(String password) {
		return sha1Hex(md5Hex(password));
	}
	
    
}
