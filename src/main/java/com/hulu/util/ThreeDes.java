package com.hulu.util;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class ThreeDes {
    public static final String secretKey = "qwert12345^&*()ZXCVB!@#$";
    public static final String iv = "P_+@*szp";
    private static final String encoding = "utf-8";

    public static String encode(String paramString1, String paramString2, String paramString3) {
        SecretKey localSecretKey = null;
        DESedeKeySpec localDESedeKeySpec = null;
        try {
            localDESedeKeySpec = new DESedeKeySpec(paramString2.getBytes());
        } catch (InvalidKeyException localInvalidKeyException1) {
            localInvalidKeyException1.printStackTrace();
        }
        SecretKeyFactory localSecretKeyFactory = null;
        try {
            localSecretKeyFactory = SecretKeyFactory.getInstance("desede");
        } catch (NoSuchAlgorithmException localNoSuchAlgorithmException1) {
            localNoSuchAlgorithmException1.printStackTrace();
        }
        try {
            localSecretKey = localSecretKeyFactory.generateSecret(localDESedeKeySpec);
        } catch (InvalidKeySpecException localInvalidKeySpecException) {
            localInvalidKeySpecException.printStackTrace();
        }
        Cipher localCipher = null;
        try {
            localCipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
        } catch (NoSuchAlgorithmException localNoSuchAlgorithmException2) {
            localNoSuchAlgorithmException2.printStackTrace();
        } catch (NoSuchPaddingException localNoSuchPaddingException) {
            localNoSuchPaddingException.printStackTrace();
        }
        IvParameterSpec localIvParameterSpec = new IvParameterSpec(paramString3.getBytes());
        try {
            localCipher.init(1, localSecretKey, localIvParameterSpec);
        } catch (InvalidKeyException localInvalidKeyException2) {
            localInvalidKeyException2.printStackTrace();
        } catch (InvalidAlgorithmParameterException localInvalidAlgorithmParameterException) {
            localInvalidAlgorithmParameterException.printStackTrace();
        }
        byte[] arrayOfByte = new byte[0];
        try {
            arrayOfByte = localCipher.doFinal(paramString1.getBytes("utf-8"));
        } catch (IllegalBlockSizeException localIllegalBlockSizeException) {
            localIllegalBlockSizeException.printStackTrace();
        } catch (BadPaddingException localBadPaddingException) {
            localBadPaddingException.printStackTrace();
        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            localUnsupportedEncodingException.printStackTrace();
        }
        return ThreeDes.Base64.encode(arrayOfByte);
    }

    public static String decode(String paramString1, String paramString2, String paramString3) {
        SecretKey localSecretKey = null;
        DESedeKeySpec localDESedeKeySpec = null;
        try {
            localDESedeKeySpec = new DESedeKeySpec(paramString2.getBytes());
        } catch (InvalidKeyException localInvalidKeyException1) {
            localInvalidKeyException1.printStackTrace();
        }
        SecretKeyFactory localSecretKeyFactory = null;
        try {
            localSecretKeyFactory = SecretKeyFactory.getInstance("desede");
        } catch (NoSuchAlgorithmException localNoSuchAlgorithmException1) {
            localNoSuchAlgorithmException1.printStackTrace();
        }
        try {
            localSecretKey = localSecretKeyFactory.generateSecret(localDESedeKeySpec);
        } catch (InvalidKeySpecException localInvalidKeySpecException) {
            localInvalidKeySpecException.printStackTrace();
        }
        Cipher localCipher = null;
        try {
            localCipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
        } catch (NoSuchAlgorithmException localNoSuchAlgorithmException2) {
            localNoSuchAlgorithmException2.printStackTrace();
        } catch (NoSuchPaddingException localNoSuchPaddingException) {
            localNoSuchPaddingException.printStackTrace();
        }
        IvParameterSpec localIvParameterSpec = new IvParameterSpec(paramString3.getBytes());
        try {
            localCipher.init(2, localSecretKey, localIvParameterSpec);
        } catch (InvalidKeyException localInvalidKeyException2) {
            localInvalidKeyException2.printStackTrace();
        } catch (InvalidAlgorithmParameterException localInvalidAlgorithmParameterException) {
            localInvalidAlgorithmParameterException.printStackTrace();
        }
        byte[] arrayOfByte = new byte[0];
        try {
            arrayOfByte = localCipher.doFinal(ThreeDes.Base64.decode(paramString1));
        } catch (IllegalBlockSizeException localIllegalBlockSizeException) {
            localIllegalBlockSizeException.printStackTrace();
        } catch (BadPaddingException localBadPaddingException) {
            localBadPaddingException.printStackTrace();
        }
        try {
            return new String(arrayOfByte, "utf-8");
        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            localUnsupportedEncodingException.printStackTrace();
        }
        return "";
    }

    public static String padding(String paramString) {
        try {
            byte[] arrayOfByte1 = paramString.getBytes("UTF8");
            int i = 8 - arrayOfByte1.length % 8;
            byte[] arrayOfByte2 = new byte[arrayOfByte1.length + i];
            System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
            for (int j = arrayOfByte1.length; j < arrayOfByte2.length; j++) {
                arrayOfByte2[j] = 0;
            }
            return new String(arrayOfByte2, "UTF8");
        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            System.out.println("Crypter.padding UnsupportedEncodingException");
        }
        return null;
    }

    public static class Base64 {
        private static final char[] legalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

        public static String encode(byte[] paramArrayOfByte) {
            int i = 0;
            int j = paramArrayOfByte.length;
            StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length * 3 / 2);

            int k = j - 3;
            int m = i;
            int n = 0;
            int i1;
            while (m <= k) {
                i1 = (paramArrayOfByte[m] & 0xFF) << 16 | (paramArrayOfByte[(m + 1)] & 0xFF) << 8 | paramArrayOfByte[(m + 2)] & 0xFF;

                localStringBuffer.append(legalChars[(i1 >> 18 & 0x3F)]);
                localStringBuffer.append(legalChars[(i1 >> 12 & 0x3F)]);
                localStringBuffer.append(legalChars[(i1 >> 6 & 0x3F)]);
                localStringBuffer.append(legalChars[(i1 & 0x3F)]);

                m += 3;
                if (n++ >= 14) {
                    n = 0;
                    localStringBuffer.append(" ");
                }
            }
            if (m == i + j - 2) {
                i1 = (paramArrayOfByte[m] & 0xFF) << 16 | (paramArrayOfByte[(m + 1)] & 0xFF) << 8;

                localStringBuffer.append(legalChars[(i1 >> 18 & 0x3F)]);
                localStringBuffer.append(legalChars[(i1 >> 12 & 0x3F)]);
                localStringBuffer.append(legalChars[(i1 >> 6 & 0x3F)]);
                localStringBuffer.append("=");
            } else if (m == i + j - 1) {
                i1 = (paramArrayOfByte[m] & 0xFF) << 16;

                localStringBuffer.append(legalChars[(i1 >> 18 & 0x3F)]);
                localStringBuffer.append(legalChars[(i1 >> 12 & 0x3F)]);
                localStringBuffer.append("==");
            }
            return localStringBuffer.toString();
        }

        private static int decode(char paramChar) {
            if ((paramChar >= 'A') && (paramChar <= 'Z')) {
                return paramChar - 'A';
            }
            if ((paramChar >= 'a') && (paramChar <= 'z')) {
                return paramChar - 'a' + 26;
            }
            if ((paramChar >= '0') && (paramChar <= '9')) {
                return paramChar - '0' + 26 + 26;
            }
            switch (paramChar) {
                case '+':
                    return 62;
                case '/':
                    return 63;
                case '=':
                    return 0;
            }
            throw new RuntimeException("unexpected code: " + paramChar);
        }

        public static byte[] decode(String paramString) {
            ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
            try {
                decode(paramString, localByteArrayOutputStream);
            } catch (IOException localIOException1) {
                throw new RuntimeException();
            }
            byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
            try {
                localByteArrayOutputStream.close();
                localByteArrayOutputStream = null;
            } catch (IOException localIOException2) {
                System.err.println("Error while decoding BASE64: " + localIOException2.toString());
            }
            return arrayOfByte;
        }

        private static void decode(String paramString, OutputStream paramOutputStream)
                throws IOException {
            int i = 0;

            int j = paramString.length();
            for (; ; ) {
                if ((i < j) && (paramString.charAt(i) <= ' ')) {
                    i++;
                } else {
                    if (i == j) {
                        break;
                    }
                    int k = (decode(paramString.charAt(i)) << 18) + (decode(paramString.charAt(i + 1)) << 12) + (decode(paramString.charAt(i + 2)) << 6) + decode(paramString.charAt(i + 3));

                    paramOutputStream.write(k >> 16 & 0xFF);
                    if (paramString.charAt(i + 2) == '=') {
                        break;
                    }
                    paramOutputStream.write(k >> 8 & 0xFF);
                    if (paramString.charAt(i + 3) == '=') {
                        break;
                    }
                    paramOutputStream.write(k & 0xFF);

                    i += 4;
                }
            }
        }
    }
}
