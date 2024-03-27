package kdn.lab6.task1.encryption;

import org.apache.log4j.Logger;

import java.util.stream.Collectors;

class AtbashStrategy implements EncryptStrategy {
    private static Logger logger = Logger.getLogger(AtbashStrategy.class);
    String toEncrypt, toDecrypt;
    int bias;

    /**
     *
     * @param toEncrypt
     * @param bias
     */
    AtbashStrategy(String toEncrypt, int bias){
        this.toEncrypt = toEncrypt;
        this.bias = bias;
    }
    @Override
    public String encrypt() {
        toEncrypt = toEncrypt.chars()
                .mapToObj(c -> (int)c)
                .map(c -> bias(c, bias, true))
                .collect(Collectors.joining());
        logger.info("File was encrypted with Atbash method");
        return toEncrypt;
    }
    @Override
    public String decrypt() {
        if(toDecrypt == null){
            toDecrypt = toEncrypt.chars()
                    .mapToObj(c -> (int)c)
                    .map(c -> bias(c, bias, false))
                    .collect(Collectors.joining());
        }else {
            toDecrypt = toDecrypt.chars()
                    .mapToObj(c -> (int)c)
                    .map(c -> bias(c, bias, false))
                    .collect(Collectors.joining());
        }
        logger.info("File was decrypted with Atbash method");
        return toDecrypt;
    }
    public String bias(int c, int bias, boolean add) {
        if (add) {
            c = (c + bias) % (Character.MAX_VALUE + 1);
        } else {
            c = (c - bias + Character.MAX_VALUE + 1) % (Character.MAX_VALUE + 1);
        }
        return String.valueOf((char) c);
    }
}
