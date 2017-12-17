package gui.components;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import io.datafx.controller.ViewController;
import javafx.fxml.FXML;

import javax.annotation.PostConstruct;

@ViewController(value="/gui/components/SignUpForm.fxml")
public class SignUpFormController {
    @FXML
    private JFXButton signUpButton;

    @FXML
    private JFXTextField emailTextField;

    @FXML
    private JFXPasswordField passwordTextField;

    @FXML
    private JFXPasswordField retypePasswordTextField;

    @FXML
    private JFXTextField namaDepanTextField;

    @FXML
    private JFXTextField namaBelakangTextField;

    @FXML
    private JFXComboBox<?> negaraComboBox;

    @PostConstruct
    public void init(){

    }
    @FXML
    private void signUp(){
        //TODO
    }
}
