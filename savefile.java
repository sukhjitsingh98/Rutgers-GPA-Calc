package sample;
import java.io.File;
import java.io.FileWriter;
import java.util.Formatter;

import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class savefile {
    private static Formatter x;
    public static void open(){
        try{
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter =
                    new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showSaveDialog(null);
            x = new Formatter(file);
        }catch (Exception e){
            System.out.println("You have an error");
        }
    }
    public static void saveFile(String L, String C) {
        x.format("%s%s",L+" ", C+" ");
    }
    public static void closeFile(){
        x.close();
    }
}
