package security;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;

import com.github.sarxos.webcam.Webcam;

import constants.Constant;



public class TakePicture {

	public static void capture() throws IOException {

		// get default webcam and open it
		Webcam webcam = Webcam.getDefault();
		webcam.open();
		// get image
		BufferedImage image = webcam.getImage();
		// save image to PNG file
		String name = Constant.IMAGINFOLDER+ UUID.randomUUID().toString()+".png";		
		ImageIO.write(image, "PNG", new File(name));
		webcam.close();
	}
}
	

