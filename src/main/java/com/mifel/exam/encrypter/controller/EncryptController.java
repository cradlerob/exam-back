package com.mifel.exam.encrypter.controller;

import com.mifel.exam.encrypter.dto.RequestEncrypt;
import com.mifel.exam.encrypter.service.EncryptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/encrypter")
public class EncryptController {
    @Autowired
    private EncryptService encryptService;

    @PostMapping("/encrypt")
    public String encrypt(@RequestBody RequestEncrypt requestEncrypt) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        return encryptService.encrypt(requestEncrypt.getText());
    }
}
