package kdn.lab6.task1.encryption;

import org.apache.log4j.Logger;

import java.io.*;

/**
 * Class to work with files
 * <br/>
 * Use {@link IFile#readFile(String path)} to read the file.
 * <br/>
 * And {@link IFile#writeFile(String text, String outputFile)} to write the file.
 */
public class IFile {
    private static Logger logger = Logger.getLogger(IFile.class);
    final static private int EMPTY = -1;
    final static private String ERROR = "File processing error";
    final static private String SUCCESS_READ = "File read successfully ";
    final static private String SUCCESS_WRITE = "File successfully written";

    /**
     * Reads file from path and returns text String
     * @param path
     * @return
     */
    public static String readFile(String path){
        String file = "";
        int bytesRead;
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            while ((bytesRead = br.read()) != EMPTY){
                file += (char) bytesRead;
            }
        }catch (IOException e){
            logger.info("File " + path + " processing error: " + e.getMessage());
        }
        logger.info("File " + path + " read successfully");
        return file;
    }

    /**
     * Writes text string to the file with 'filename'
     * @param text
     * @param filename
     */
    public static void writeFile(String text, String filename){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))){
            bw.write(text);
        }catch (IOException e){
            logger.info("File " + filename + " processing error: " + e.getMessage());
        }
        logger.info("File " + filename + " written successfully");

    }
}
