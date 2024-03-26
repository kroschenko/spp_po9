package RailwayTicketOffice;

import RailwayTicketOffice.Const;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class IFile {
    private static String read_string = "";
    public static ArrayList<String> ReadStrings(String filename){
        ArrayList<String> file_words_array = new ArrayList<String>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            file_words_array.add(Const.CLEAR);
            read_string = reader.readLine();
            if(read_string != null){
                file_words_array.add(read_string);
            }
            while(read_string != null){
                read_string = reader.readLine();
                if(read_string != null){
                    file_words_array.add(read_string);
                }
            }
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return file_words_array;
    }
    public static void WriteFile(String str, String filename){
        FileOutputStream fout = null;
        try{
            fout = new FileOutputStream(filename, true);
            byte[] buffer = str.getBytes();
            fout.write(buffer, Const.OFF, buffer.length);
            System.out.println("The file was updated");
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        } finally {
            try{
                if(fout != null){
                    fout.close();
                }
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    public static void ClearFile(String filename){
        FileOutputStream fout = null;
        try{
            fout = new FileOutputStream(filename);
            byte[] buffer = Const.CLEAR.getBytes();
            fout.write(buffer, Const.OFF, buffer.length);
            System.out.println("The file was cleaned");
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        } finally {
            try{
                if(fout != null){
                    fout.close();
                }
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
