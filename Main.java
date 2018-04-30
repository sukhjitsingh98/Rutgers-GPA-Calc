package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("gpa.fxml"));
        primaryStage.setTitle("SOE GPA CALCULATOR BY S.SINGH");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("Logo.png")));
        primaryStage.setScene(new Scene(root, 494, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
