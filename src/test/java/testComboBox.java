import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import util.DBHandler;

import java.util.List;

public class testComboBox extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        /*ComboBoxAutoComplete<String> combo = new ComboBoxAutoComplete<>();
        combo.setEditable(true);
        */ObservableList<String> list = FXCollections.observableArrayList(new String[]{"America","Australia","Indonesia","India"});/*
        combo.setTooltip(new Tooltip());
        combo.getItems().addAll(list);
        BorderPane pane = new BorderPane();
        pane.setCenter(combo);
        //JFXDecorator decorator = new JFXDecorator(primaryStage,pane);
        Scene scene = new Scene(pane,300,300);
        primaryStage.setScene(scene);
        primaryStage.show();*/
        /*JFXComboBox<String> cmb = new JFXComboBox<>();
        cmb.setTooltip(new Tooltip());
        cmb.getItems().addAll(list);
        cmb.setEditable(true);
        BorderPane pane = new BorderPane();
        pane.setCenter(cmb);
        stage.setScene(new Scene(pane));
        stage.show();
        stage.setTitle("Filtrando um ComboBox");
        stage.setWidth(300);
        stage.setHeight(300);
        new ComboBoxAutoComplete<String>(cmb);*/
        //System.out.println(DBHandler.fetchCountries().);
        JFXComboBox<String> combo = new JFXComboBox<>();
        combo.setPrefSize(100,25);
        combo.setEditable(true);
        combo.getItems().addAll(list);
        FXUtilTest.autoCompleteComboBoxPlus(combo,(typedText, itemToCompare) -> itemToCompare.toString().toLowerCase().contains(typedText.toLowerCase()));
        BorderPane pane = new BorderPane();
        pane.setCenter(combo);
        stage.setScene(new Scene(pane,300,300));
        stage.show();
    }
}
