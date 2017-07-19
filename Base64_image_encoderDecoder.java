package pruebas;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
import javax.imageio.ImageIO;
import javax.naming.Context;
import javax.swing.JFileChooser;
import javax.xml.bind.DatatypeConverter;

public class Encriptador {
     Context con = (Context) Encriptador.this;
     static String RUTA_DESKTOP = "C:\\Users\\jjesusn\\Desktop\\libros\\";
    
    public static void main(String args[]) throws IOException { // test      
    	File file = new File("C:\\Users\\jjesusn\\workspace\\Sexto\\recursos\\rata.jpg");//ruta
    	if(file.exists()){
    		String cod = encodeFileToBase64Binary(file);
    		System.out.println("Base64: "+cod);
    		decodeFileToBase64Binary(cod, RUTA_DESKTOP);
    		}else{
    			System.out.println("No Existe");
    		}
    	
    }//final main
    
    private static String encodeFileToBase64Binary(File file){
        String encodedfile = null;
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            fileInputStreamReader.read(bytes);
            encodedfile = new String(Base64.getEncoder().encodeToString(bytes));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return encodedfile;
    }
    private static void decodeFileToBase64Binary(String encoded,String ruta) throws IOException{
    	BufferedImage image = null;
    	byte[] imageByte;
    	//BASE64Decoder decoder = new BASE64Decoder();
    	imageByte = Base64.getDecoder().decode(encoded);
    	ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
    	image = ImageIO.read(bis);
    	bis.close();
    	ruta +="image.png";
        File outfile = new File(ruta);
        ImageIO.write(image, "png", outfile);
        
        File file = new File(ruta);
        if(file.exists()){
        	System.out.println("Existe");
        }else{
        	System.out.println("No Existe");
        }
        
    }
}//final class