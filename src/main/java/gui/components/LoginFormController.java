package gui.components;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXListView;
import io.datafx.controller.ViewController;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.fxml.FXML;

import javax.annotation.PostConstruct;
import javax.swing.text.View;

@ViewController(value = "/gui/components/LoginForm.fxml")
public class LoginFormController {
    @FXML
    private JFXButton loginButton;
    @FXMLViewFlowContext
    private ViewFlowContext context;
    private JFXListView sideList;
    @PostConstruct
    public void init() {
        sideList = (JFXListView) context.getRegisteredObject("SideList");
        sideList.getSelectionModel().clearSelection();
    }

    @FXML
    public void login(){
        //TODO
    }
}
