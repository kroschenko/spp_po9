import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class Main {
    public static String readFile(String filename) {
        try(FileReader reader = new FileReader(filename))
        {
            int c;
            String str = "";
            while((c=reader.read())!=-1) {
                str += (char) c;
            }
            System.out.print(str + "\n");
            return str;
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return "";
    }

    public static Map<Integer, Integer> tableOfWords(String str) {
        Map<Integer, Integer> table = new HashMap<>();
        String cleanedInput = str.replaceAll("[^a-zA-Z]+", " ");//Очистка строки от не букв
        String[] substrings = cleanedInput.split(" ");
        for(int i = 0; i < substrings.length; ++i) {
            int numberOfLetters = substrings[i].length();
            if(table.containsKey(numberOfLetters)) {
               int value = table.get(substrings[i].length());
               ++value;
               table.put(numberOfLetters, value);
            }
            else {
                table.put(numberOfLetters, 1);
            }
        }
        return table;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter filename without extension: ");
        String fileName = in.next();
        Map<Integer, Integer> table = tableOfWords(readFile(fileName));
        for(Map.Entry<Integer, Integer> entry : table.entrySet()) {
            System.out.print("Number of letters: " + entry.getKey() + " Number of words with this number of letters: " + entry.getValue() + "\n");
        }
    }
}