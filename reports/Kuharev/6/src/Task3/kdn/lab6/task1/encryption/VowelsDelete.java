package kdn.lab6.task1.encryption;

import org.apache.log4j.Logger;

import javax.swing.*;

/**
 * kdn.lab6.task1.encryption.VowelsDelete implements kdn.lab6.task1.encryption.Encryption by removing vowels(eng, rus) from a text
 */
public class VowelsDelete extends Encryption {
    private static Logger logger = Logger.getLogger(VowelsDelete.class);
    /**
     * Creating a new object with the encryption method <code>'VowelsDelete'</code>,
     * that removes all vowels from a text file.
     * <br/>
     * Use {@link Encryption#encrypt(String fileToWrite)} for encryption.
     * <br/>
     * And {@link Encryption#decrypt(String fileToWrite)} for decryption.
     * @param pathToInitialFile the path to the file
     */
    public VowelsDelete(String pathToInitialFile){
        if(pathToInitialFile.indexOf(TXT) < NOT_FOUND){
            JOptionPane.showMessageDialog(null, ERROR_MESSAGE);
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        toEncrypt = IFile.readFile(pathToInitialFile);
        encryptStrategy = new VowelsStrategy(toEncrypt);
        logger.info("New Vowels Delete object was created: " + this.toString());
    }
}
