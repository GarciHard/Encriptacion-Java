package metodos;


import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Hecho con <3 por:
 * @author GarciHard
 */
public class MEncriptacion {

    private Encoder encoder;
    private Cipher cipher;
    private Decoder decoder;
    private SecretKeySpec llaveSimetrica;
    
    public String encriptacionAES(String llave, String cadenaEncriptar) {
        llaveSimetrica = new SecretKeySpec(llave.getBytes(), "AES");
        try {
            cipher = Cipher.getInstance("AES");
            //Comienzo a encriptar
            cipher.init(Cipher.ENCRYPT_MODE, llaveSimetrica);
            byte[] campoCifrado = cipher.doFinal(cadenaEncriptar.getBytes("UTF-8"));
            //Codificamos los bytes en base64 para que sea entendible
            encoder = Base64.getEncoder();
            return encoder.encodeToString(campoCifrado);
        } catch (Exception e) {
            return e.toString();
        }
    }
    
    public String desencriptarAES(String llave, String cadenaDesencriptar) {
        llaveSimetrica = new SecretKeySpec(llave.getBytes(), "AES");
        try {
            cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, llaveSimetrica);
            //Comienzo a desencriptar
            decoder = Base64.getDecoder();
            byte[] reg = decoder.decode(cadenaDesencriptar);
            byte[] datosDecifrados = cipher.doFinal(reg);
            return new String(datosDecifrados);
        } catch (Exception e) {
            return e.toString();
        }
    }
}