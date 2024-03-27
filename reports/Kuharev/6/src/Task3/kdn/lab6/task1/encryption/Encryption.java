package kdn.lab6.task1.encryption;

import org.apache.log4j.Logger;

/**
 * Parent class kdn.lab6.task1.encryption.Encryption for all encryption and decryption methods (VowelsDelete, XOR, Atbash)
 */
public class Encryption {
    String encryptedName;
    String toEncrypt;
    EncryptStrategy encryptStrategy;
    final static protected String TXT = ".txt";
    final static protected String ERROR_MESSAGE = "Wrong file type!";
    final static protected int NOT_FOUND = 0;

    /**
     * A common method for all kdn.lab6.task1.encryption.Encryption classes that performs direct encryption
     * @param fileToWrite
     * @return
     */
    public void encrypt(String fileToWrite){
        IFile.writeFile(encryptStrategy.encrypt(), fileToWrite);
    }
    /**
     * A common method for all kdn.lab6.task1.encryption.Encryption classes that performs direct decryption
     * @param fileToWrite
     * @return
     */
    public void decrypt(String fileToWrite){
        IFile.writeFile(encryptStrategy.decrypt(), fileToWrite);
    }
}
