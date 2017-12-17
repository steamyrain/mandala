package gui.components;

import com.jfoenix.controls.JFXButton;
import io.datafx.controller.ViewController;
import javafx.fxml.FXML;

import javax.annotation.PostConstruct;

@ViewController(value="/gui/components/SignUpForm.fxml")
public class SignUpFormController {
    @FXML
    private JFXButton signUpButton;
    @PostConstruct
    public void init(){

    }
    @FXML
    private void signUp(){
        //TODO
    }
}
