package kdn.lab6.task1.encryption;

/**
 * Basic interface for all encryption strategies
 */
public interface EncryptStrategy {

    public String encrypt();
    public abstract String decrypt();
}
