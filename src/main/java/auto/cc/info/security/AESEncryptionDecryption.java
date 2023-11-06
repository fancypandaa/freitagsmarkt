package auto.cc.info.security;


import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
public class AESEncryptionDecryption {
    private static SecretKeySpec secretKey;
    private static byte[] keys;
    private static final String ALGORITHM = "AES";
    final String secret = "secrete";
    public void prepareSecretKey(String key){
        MessageDigest  sha = null;
        try {
            keys = key.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance("SHA-1");
            keys = sha.digest(keys);
            keys = Arrays.copyOf(keys, 16);
            secretKey = new SecretKeySpec(keys, ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    public String encrypt(String plainText,String secret){
        try {
            prepareSecretKey(secret);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE,secretKey);
            return Base64.encodeBase64String(cipher.doFinal(plainText.getBytes("UTF-8")));
        }
        catch (Exception e){
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }
    public String decrypt(String cipher, String secret) {
        try {
            prepareSecretKey(secret);
            Cipher ciphers = Cipher.getInstance(ALGORITHM);
            ciphers.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(ciphers.doFinal(Base64.decodeBase64(cipher)));
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
}
