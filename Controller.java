package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class Controller {
    @FXML
    private TextField L1;
    @FXML
    private TextField L2;
    @FXML
    private TextField L3;
    @FXML
    private TextField L4;
    @FXML
    private TextField L5;
    @FXML
    private TextField L6;
    @FXML
    private TextField L7;
    @FXML
    private TextField L8;

    @FXML
    private TextField C1;
    @FXML
    private TextField C2;
    @FXML
    private TextField C3;
    @FXML
    private TextField C4;
    @FXML
    private TextField C5;
    @FXML
    private TextField C6;
    @FXML
    private TextField C7;
    @FXML
    private TextField C8;

    @FXML
    private TextField ResultBox;
    @FXML
    private TextField SemesterOutput;
    @FXML
    private Button Calculate;
    @FXML
    private Button Clear;
    @FXML
    private Button AddSemester;
    @FXML
    private Pane everythingPane;
    @FXML
    private Button calcTotalGPA;
    @FXML
    private MenuItem helpButton;
    @FXML
    private MenuItem openButton;
    @FXML
    private MenuItem saveItem;

    @FXML //Clear Button Action
    public void handleClearAction(){
        clearText();
        denominator = 0;
        numerator = 0;
        ResultBox.clear();
        totalGPA = 0;
        totalNumerator = 0;
        SemesterOutput.setText(String.valueOf(1));
    }
    double totalNumerator;
    double totalGPA;
    int total;
    double numerator = 0;
    double denominator = 0;
    int semesterNum = 1;

    @FXML //Calculate Button Action
    public void handleButtonAction(ActionEvent event){
        total = 0; //Denominator Value
        //Numerator Storage Values
        double answer1 =0;
        double answer2 =0;
        double answer3 =0;
        double answer4 =0;
        double answer5 =0;
        double answer6 =0;
        double answer7 =0;
        double answer8 =0;
        //LetterBox 1
        if ((L1.getText() != null && !L1.getText().isEmpty())&&(C1.getText() != null && !C1.getText().isEmpty())) {
            answer1 = operator(L1.getText(), C1.getText());
            total += Double.parseDouble(C1.getText());
        } //LetterBox 2
        if ((L2.getText() != null && !L2.getText().isEmpty())&&(C2.getText() != null && !C2.getText().isEmpty())) {
            answer2 = operator(L2.getText(), C2.getText());
            total += Double.parseDouble(C2.getText());
        } //LetterBox 3
        if ((L3.getText() != null && !L3.getText().isEmpty())&&(C3.getText() != null && !C3.getText().isEmpty())) {
            answer3 = operator(L3.getText(), C3.getText());
            total += Double.parseDouble(C3.getText());
        } //LetterBox 4
        if ((L4.getText() != null && !L4.getText().isEmpty())&&(C4.getText() != null && !C4.getText().isEmpty())) {
            answer4= operator(L4.getText(), C4.getText());
            total += Double.parseDouble(C4.getText());
        } //LetterBox 5
        if ((L5.getText() != null && !L5.getText().isEmpty())&&(C5.getText() != null && !C5.getText().isEmpty())) {
            answer5 = operator(L5.getText(), C5.getText());
            total += Double.parseDouble(C5.getText());
        } //LetterBox 6
        if ((L6.getText() != null && !L6.getText().isEmpty())&&(C6.getText() != null && !C6.getText().isEmpty())) {
            answer6 = operator(L6.getText(), C6.getText());
            total += Double.parseDouble(C6.getText());
        } //LetterBox 7
        if ((L7.getText() != null && !L7.getText().isEmpty())&&(C7.getText() != null && !C7.getText().isEmpty())) {
            answer7 = operator(L7.getText(), C7.getText());
            total += Double.parseDouble(C7.getText());
        } //LetterBox 8
        if ((L8.getText() != null && !L8.getText().isEmpty())&&(C8.getText() != null && !C8.getText().isEmpty())) {
            answer8 = operator(L8.getText(), C8.getText());
            total += Double.parseDouble(C8.getText());
        }

        totalNumerator = answer1+answer2+answer3+answer4+answer5+answer6+answer7+answer8;
        totalGPA = totalNumerator/(total);
        String displayAnswer = Double.toString(totalGPA);
        ResultBox.setText(displayAnswer);
        }

        //Clear Text Method
        private void clearText(){
            L1.clear();
            L2.clear();
            L3.clear();
            L4.clear();
            L5.clear();
            L6.clear();
            L7.clear();
            L8.clear();
            //Clear Credit Boxes
            C1.clear();
            C2.clear();
            C3.clear();
            C4.clear();
            C5.clear();
            C6.clear();
            C7.clear();
            C8.clear();
        }
        //Data Validation Method
        private double operator(String L, String C){
            double L1=0;
            switch (L) {
                case "A": {
                    L1 = 4.0;
                    break;
                }
                case "B+": {
                    L1 = 3.5;
                    break;
                }
                case "B": {
                    L1 = 3.0;
                    break;
                }
                case "C+": {
                    L1 = 2.5;
                    break;
                }
                case "C": {
                    L1 = 2.0;
                    break;
                }
                case "F": {
                    L1 = 0.0;
                    break;
                }
                default:
                    ResultBox.setText("Invalid Entry");
                    break;
            }
            double C1 = Double.parseDouble(C);
            double answer = L1 * C1;
            return answer;
        }
    @FXML //Calculate Button Action
    public void handleSemesterAction(ActionEvent event){
        clearText();
        semesterNum++;
        SemesterOutput.setText(String.valueOf(semesterNum));
        numerator += totalNumerator;
        denominator += total;
        //ResultBox.setText(Double.toString(totalNumerator/denominator));
    }
    @FXML //Calculate Final GPA
    public void handleTotalAction(ActionEvent event){
        clearText();
        double finalNumer =totalNumerator + numerator;
        double finalDenom = total + denominator;
        ResultBox.setText(Double.toString(finalNumer/finalDenom));
    }
    @FXML // Help Button
    public void handleHelpAction(ActionEvent event)throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HelpPage.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @FXML //Saves current semester data into a text file
    public void handleSaveAction(ActionEvent event)throws Exception {
        savefile.open();
        savefile.saveFile(L1.getText(),C1.getText());
        savefile.saveFile(L2.getText(),C2.getText());
        savefile.saveFile(L3.getText(),C3.getText());
        savefile.saveFile(L4.getText(),C4.getText());
        savefile.saveFile(L5.getText(),C5.getText());
        savefile.saveFile(L6.getText(),C6.getText());
        savefile.saveFile(L7.getText(),C7.getText());
        savefile.saveFile(L8.getText(),C8.getText());
        savefile.closeFile();
    }
    @FXML //Opens Files and reads them
    public void handleOpenAction(ActionEvent event) throws FileNotFoundException {
        clearText();
        readfile.openFile();
        String[] a = readfile.readFile();
        readfile.closeFile();
        L1.setText(a[0]);
        C1.setText(a[1]);
        L2.setText(a[2]);
        C2.setText(a[3]);
        L3.setText(a[4]);
        C3.setText(a[5]);
        L4.setText(a[6]);
        C4.setText(a[7]);
        L5.setText(a[8]);
        C5.setText(a[9]);
        L6.setText(a[10]);
        C6.setText(a[11]);
        L7.setText(a[12]);
        C7.setText(a[13]);
        L8.setText(a[14]);
        C8.setText(a[15]);
    }
}



