import kdn.lab6.task1.encryption.AtbashEncryption;
import kdn.lab6.task1.encryption.Encryption;
import kdn.lab6.task1.encryption.VowelsDelete;
import kdn.lab6.task1.encryption.XorEncryption;

public class Main {
    public static void main(String[] args) {
        final String initialPath = "new_notes.txt";
        final String key = ")%631yegd758YGUO+@*\"";
        final int bias = 5;

        String vowelsEncryptedPath = "vowels_encrypted_notes.txt";
        String vowelsDecryptedPath = "vowels_decrypted_notes.txt";
        String xorEncryptedPath = "xor_encrypted_notes.txt";
        String xorDecryptedPath = "xor_decrypted_notes.txt";
        String atbashEncryptedPath = "atbash_encrypted_notes.txt";
        String atbashDecryptedPath = "atbash_decrypted_notes.txt";


        VowelsDelete vowelsDelete = new VowelsDelete(initialPath);
        XorEncryption xorEncryption = new XorEncryption(initialPath, key);
        AtbashEncryption atbashEncryption = new AtbashEncryption(initialPath, bias);

        vowelsDelete.encrypt(vowelsEncryptedPath);
        vowelsDelete.decrypt(vowelsDecryptedPath);

        xorEncryption.encrypt(xorEncryptedPath);
        xorEncryption.decrypt(xorDecryptedPath);

        atbashEncryption.encrypt(atbashEncryptedPath);
        atbashEncryption.decrypt(atbashDecryptedPath);
    }
}