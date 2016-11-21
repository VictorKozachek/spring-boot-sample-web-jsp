package ru.schoolarlife.logic.helpers;

import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * Created by victor on 21.11.16.
 */
@Component
public class ActivationCodeEncoder {

    public String randomActivationString()
    {
        String salt = new BigInteger(32, new Random()).toString(36);
        return salt;
    }

    public String md5ActivationString() throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("MD5").toString();
    }
}
