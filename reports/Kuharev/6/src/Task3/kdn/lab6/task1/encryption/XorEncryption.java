package kdn.lab6.task1.encryption;

import org.apache.log4j.Logger;

import javax.swing.*;

/**
 * kdn.lab6.task1.encryption.XorEncryption implements kdn.lab6.task1.encryption.Encryption by making Xor encryption of a text using key
 */
public class XorEncryption extends Encryption {
    private static Logger logger = Logger.getLogger(XorEncryption.class);

    /**
     * Creating a new object with the encryption method <code>'XorEncryption'</code>,
     * that uses XOR operation for Input File and Key
     * <br/>
     * Use {@link Encryption#encrypt(String fileToWrite)} for encryption.
     * <br/>
     * And {@link Encryption#decrypt(String fileToWrite)} for decryption.
     * @param pathToInitialFile
     * @param key
     */
    public XorEncryption(String pathToInitialFile, String key){
        if(pathToInitialFile.indexOf(TXT) < NOT_FOUND){
            JOptionPane.showMessageDialog(null, ERROR_MESSAGE);
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        toEncrypt = IFile.readFile(pathToInitialFile);
        encryptStrategy = new XorStrategy(toEncrypt, key);
        logger.info("New Xor kdn.lab6.task1.encryption.Encryption object was created: " + this.toString());
    }
    public void setKey(String key){
        encryptStrategy = new XorStrategy(toEncrypt, key);
        logger.info("New key Xor kdn.lab6.task1.encryption.Encryption object: " + this.toString());
    }
}
