package kdn.lab6.task1.encryption;

import org.apache.log4j.Logger;

import javax.swing.*;

/**
 * kdn.lab6.task1.encryption.AtbashEncryption implements kdn.lab6.task1.encryption.Encryption by making Atbash (fixed shift) encryption of a text
 */
public class AtbashEncryption extends Encryption {
    private static Logger logger = Logger.getLogger(AtbashEncryption.class);

    /**
     * Creating a new object with the encryption method <code>'AtbashEncryption'</code>,
     * that uses fixed ASCII alphabet shift to encrypt text
     * <br/>
     * Use {@link Encryption#encrypt(String fileToWrite)} for encryption.
     * <br/>
     * And {@link Encryption#decrypt(String fileToWrite)} for decryption.
     * @param pathToInitialFile
     * @param bias
     */
    public AtbashEncryption(String pathToInitialFile, int bias){
        if(pathToInitialFile.indexOf(Encryption.TXT) < Encryption.NOT_FOUND){
            JOptionPane.showMessageDialog(null, Encryption.ERROR_MESSAGE);
            throw new IllegalArgumentException(Encryption.ERROR_MESSAGE);
        }
        toEncrypt = IFile.readFile(pathToInitialFile);
        encryptStrategy = new AtbashStrategy(toEncrypt, bias);
        logger.info("New Atbash kdn.lab6.task1.encryption.Encryption object was created: " + this.toString());
    }
    public void setBias(int bias){
        encryptStrategy = new AtbashStrategy(toEncrypt, bias);
        logger.info("New bias for Atbash kdn.lab6.task1.encryption.Encryption object: " + this.toString());
    }
}
