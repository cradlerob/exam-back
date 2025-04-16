package com.mifel.exam.encrypter.service;

import org.springframework.stereotype.Service;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Service
public class EncryptService {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";
    private static final String KEY="9jcAD0kfxYgq15U6";
    private static final String IV="OAU0XbdoLTMXAmJ9";

    public String encrypt(String text) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(128), generateIv());
        byte[] cipherText = cipher.doFinal(text.getBytes());
        return Base64.getEncoder()
                .encodeToString(cipherText);

    }

    public static SecretKey getSecretKey(int n) throws NoSuchAlgorithmException {
        return new SecretKeySpec(KEY.getBytes(StandardCharsets.UTF_8), "AES");
    }
    public static IvParameterSpec generateIv() {
        return new IvParameterSpec(IV.getBytes(StandardCharsets.UTF_8));
    }
}
