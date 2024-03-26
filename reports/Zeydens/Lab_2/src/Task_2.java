import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Main {
    public static void copyWithParams(String[] args) {
        if(args[1].length() < 2 || args[1].length() > 4) {
            System.out.print("Wrong number of parameters, expected: 1-3 parameters.\n");
            return;
        }
        if(args[1].charAt(0) != '-') {
            System.out.print("Wrong parameters input form, expected: -parameters\n");
            return;
        }
        boolean forceRewrite = false, askRewrite = false, noRewrite = false;
        for(int i = 1; i < args[1].length(); ++i) {
            char symbol = args[1].charAt(i);
            if(symbol == 'f' && !forceRewrite)
            {
                forceRewrite = true;
                continue;
            }
            if(symbol == 'i' && !askRewrite)
            {
                askRewrite = true;
                continue;
            }
            if(symbol == 'n' && !noRewrite)
            {
                noRewrite = true;
                continue;
            }
            System.out.print("Unknown parameter, expected: 'f', 'i', 'n' as parameters.\n");
            return;
        }
        String sourceFilePath = args[args.length - 2];
        File sourceFile = new File(sourceFilePath);
        if(!sourceFile.exists())
        {
            System.out.print("File " + args[args.length - 2] + " doesn't exist");
            return;
        }
        String destinationFilePath = args[args.length - 1];
        File destinationFile = new File(destinationFilePath);
        if(destinationFile.exists() && forceRewrite)
        {
            destinationFile.delete();
            System.out.print("File " + destinationFilePath + " deleted successfully.\n");
            copy(args, false);
            return;
        }
        if(destinationFile.exists() && askRewrite && !noRewrite)
        {
            System.out.print("Do you want to rewrite file? (y/n) ");
            Scanner in = new Scanner(System.in);
            String fileName = in.next();
            copy(args, fileName.equalsIgnoreCase("y"));
            return;
        }
        copy(args, false);
    }
    public static void copy(String[] args, boolean isRewritingNeeded) {
        File sourceFile = new File(args[args.length - 2]);
        File destinationFile = new File(args[args.length - 1]);
        try {
            if(isRewritingNeeded)
            {
                System.out.print("Copying with rewrite.\n");
                Files.copy(sourceFile.toPath(), destinationFile.toPath(), REPLACE_EXISTING);
                System.out.println("File rewrited successfully.");
            }
            else
            {
                System.out.print("Copying without rewrite.\n");
                Files.copy(sourceFile.toPath(), destinationFile.toPath());
                System.out.println("File copied successfully.");
            }
        } catch (IOException e) {
            System.out.println("Error while copying file: " + e.getMessage());
        }
    }

    public static void start(String[] args) {
        if(args.length < 3 || args.length > 4)
        {
            System.out.print("Wrong number of arguments, expected: 3-4 arguments.\n");
            return;
        }
        if(!args[0].equals("cp")) {
            System.out.print("Unknown command, expected: 'cp'.\n");
            return;
        }
        if(args.length == 3)
        {
            copy(args, false);
        }
        else
        {
            copyWithParams(args);
        }
    }

    public static void main(String[] args) {
        start(args);
        System.out.println("Press any key to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        scanner.close();
    }
}