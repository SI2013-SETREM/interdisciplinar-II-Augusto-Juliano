/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sotos.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author julianopires
 */
public class Util {

    public static String convertPasswordToMD5(String password) throws NoSuchAlgorithmException {
        for (int i = 0; i < 100; i++) {
            MessageDigest md = MessageDigest.getInstance("MD5");

            BigInteger hash = new BigInteger(1, md.digest(password.getBytes()));

            password = String.format("%32x", hash);
        }
        return password;
    }
}
