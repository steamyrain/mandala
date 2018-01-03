package gui.components;

import com.jfoenix.controls.*;
import io.datafx.controller.ViewController;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import model.Chosen;
import task.LoginService;

import javax.annotation.PostConstruct;

@ViewController(value = "/gui/components/LoginForm.fxml")
public class LoginFormController {
    @FXML
    private JFXButton loginButton;
    @FXML
    private JFXButton linkSignUpButton;
    @FXML
    private JFXTextField emailTextField;
    @FXML
    private JFXPasswordField passwordTextField;
    @FXMLViewFlowContext
    private ViewFlowContext context;

    private JFXListView sideList;
    private StringProperty email = new SimpleStringProperty();
    private StringProperty password = new SimpleStringProperty();
    private LoginService loginService = new LoginService();
    private String loginAs = null;
    @PostConstruct
    public void init() {
        sideList = (JFXListView) context.getRegisteredObject("SideList");
        sideList.getSelectionModel().clearSelection();
        email.bind(emailTextField.textProperty());
        password.bind(passwordTextField.textProperty());
        loginAs = (String)context.getRegisteredObject("LoginAs");
    }
    @FXML
    private void goToSignUp(){
        //TODO

        Chosen.setViewFlowContext(context);
        Chosen.goTo(SignUpFormController.class);
    }
    @FXML
    private void login(){
        //TODO
        if (loginService.isRunning()) return;
        loginService.reset();
        loginService.setEmail(email.getValue());
        loginService.setPassword(password.getValue());
        loginService.setRole(loginAs);

        loginService.setOnSucceeded(t -> {
            String error = (String)t.getSource().getValue();
            if (error == null) {
                System.out.println("Login success");
                //TODO HOME
                Chosen.goTo(ProfileController.class);
                //TODO add LOGOUT
            } else {
                System.out.println("Login error: " + error);
            }
        });
        loginService.start();
    }
}
