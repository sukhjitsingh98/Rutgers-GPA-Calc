package sample;
import javafx.stage.FileChooser;

import java.io.*;
import java.util.*;

public class readfile {
    static String[] grades = new String[16];
    //static ArrayList<String> credit = new ArrayList<String>();
    private static Scanner reader;

    public static void openFile() {
        try {
            FileChooser fc = new FileChooser();
            File selectedFile = fc.showOpenDialog(null);
            reader = new Scanner(selectedFile);
        } catch (Exception e) {
            System.out.println("Could not find file");
        }
    }
    public static String[] readFile() {
        int i =0;
        int j =1;
        while (reader.hasNext()) {
                grades[i]=reader.next();
                grades[j]=reader.next();
                i+=2;
                j+=2;
        }
        return grades;
    }
    public static void closeFile(){
        reader.close();
    }
}
