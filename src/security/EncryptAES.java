
package security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import constants.Constant;
import pojos.LoginSessionPojo;

import java.io.Serializable;
import java.security.spec.KeySpec;
import java.util.Base64;

public class EncryptAES implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4655185833690455052L;

	// cambiar : Constant.saltAES.getBytes() por LoginSessionPojo.loginSeccion().getCodigoUser().getBytes()
	
	private SecretKeySpec createScretKey(String secretKeyAES) {
        SecretKeySpec secretKey = null;
        try {
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec keySpec = new PBEKeySpec(secretKeyAES.toCharArray(), LoginSessionPojo.loginSeccion().getCodigoUser().getBytes(), 65536, 256);
            SecretKey secretKeyTemp = secretKeyFactory.generateSecret(keySpec);
            secretKey = new SecretKeySpec(secretKeyTemp.getEncoded(), "AES");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return secretKey;
    }


    public String encript(String data, String pass) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[16]);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, createScretKey(pass), ivParameterSpec);
            return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes("UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    
    public String decrypt(String data, String pass) {

        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[16]);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, createScretKey(pass), ivParameterSpec);
            return new String(cipher.doFinal(Base64.getDecoder().decode(data)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
	
}
