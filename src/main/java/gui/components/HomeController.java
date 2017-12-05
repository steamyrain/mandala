package gui.components;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import io.datafx.controller.ViewController;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.annotation.PostConstruct;

@ViewController(value="/gui/components/Home.fxml")
public class HomeController {
    @FXMLViewFlowContext
    private ViewFlowContext context;
    @FXML
    private JFXButton saveButton;
    @FXML
    private JFXButton resetButton;
    @PostConstruct
    private void init(){
        JFXListView sideList = (JFXListView) context.getRegisteredObject("SideList");
        Label home = (Label) context.getRegisteredObject("Home");
        Label bukuTamu = (Label) context.getRegisteredObject("BukuTamu");
        if(sideList.getItems().contains(bukuTamu)) {
            sideList.getItems().clear();
            sideList.getItems().add(home);
        }
    }
    @FXML
    private void save(){
        //DoSave
    }
    @FXML
    private void reset(){
        //DoReset
    }
}
