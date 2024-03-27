package kdn.lab6.task1.encryption;

import org.apache.log4j.Logger;

import java.nio.charset.StandardCharsets;

class XorStrategy implements EncryptStrategy {
    private static Logger logger = Logger.getLogger(XorStrategy.class);
    String toEncrypt, toDecrypt, key;

    XorStrategy(String toEncrypt, String key) {
        this.toEncrypt = toEncrypt;
        this.key = key;
    }

    @Override
    public String encrypt() {
        toEncrypt = xor(toEncrypt, key);
        logger.info("File was encrypted with Xor method");
        return toEncrypt;
    }

    @Override
    public String decrypt() {
        toDecrypt = xor(toEncrypt, key);
        logger.info("File was decrypted with Xor method");
        return toDecrypt;
    }

    public static String xor(String str, String key) {
        int str_length = str.length();
        int key_length = key.length();
        if(str_length < key_length){
            key = key.substring(0, str_length);
        }
        byte[] str_bytes = str.getBytes(StandardCharsets.UTF_8);
        byte[] key_bytes = key.getBytes(StandardCharsets.UTF_8);
        byte[] res_bytes = str_bytes;
        for (int i = 0, j = 0; i < str_bytes.length; ++i, ++j) {
            if(j > key_length-1){
                j = 0;
            }
            res_bytes[i] = (byte) (str_bytes[i] ^ key_bytes[j]);
        }
        return new String(res_bytes, StandardCharsets.UTF_8);
    }
}
