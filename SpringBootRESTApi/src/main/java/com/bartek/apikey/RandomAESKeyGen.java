/**
 * Created by Bartek 2017-12-07
 */

package com.bartek.apikey;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;
import java.security.NoSuchAlgorithmException;

/**
 * This class provides the functionality of a secret (symmetric) key generator
 */
public class RandomAESKeyGen {

    /**
     * This method generate a secret key
     * @param keyLen is the keysize
     * @return returns the key as a string
     * @throws NoSuchAlgorithmException
     */
    public static String generate(final int keyLen) throws NoSuchAlgorithmException {

        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(keyLen);
        SecretKey secretKey = keyGen.generateKey();
        byte[] encoded = secretKey.getEncoded();
        return DatatypeConverter.printHexBinary(encoded).toLowerCase();
    }

}
