package com.hulu.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
    private static final String[] strDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    private static String byteToArrayString(byte paramByte) {
        int i = paramByte;
        if (i < 0) {
            i += 256;
        }
        int j = i / 16;
        int k = i % 16;
        return strDigits[j] + strDigits[k];
    }

    private static String byteToNum(byte paramByte) {
        int i = paramByte;
        System.out.println("iRet1=" + i);
        if (i < 0) {
            i += 256;
        }
        return String.valueOf(i);
    }

    private static String byteToString(byte[] paramArrayOfByte) {
        StringBuffer localStringBuffer = new StringBuffer();
        for (int i = 0; i < paramArrayOfByte.length; i++) {
            localStringBuffer.append(byteToArrayString(paramArrayOfByte[i]));
        }
        return localStringBuffer.toString();
    }

    public static String md5(String paramString) {
        String str = null;
        try {
            str = new String(paramString);
            MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");

            str = byteToString(localMessageDigest.digest(paramString.getBytes()));
        } catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {
            localNoSuchAlgorithmException.printStackTrace();
        }
        return str;
    }

    public static void main(String[] paramArrayOfString) {
        System.out.println(md5("000000"));
    }
}

