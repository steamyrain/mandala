package gui.components;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import io.datafx.controller.ViewController;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import model.Account;
import model.Chosen;
import task.SignupService;
import util.DBHandler;
import util.FXUtil;
import util.Validator;

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
    private JFXComboBox<String> negaraComboBox;

    @FXMLViewFlowContext
    private ViewFlowContext context;

    private Account newAcc;
    private StringProperty retypedPassword = new SimpleStringProperty();

    private String validatorMessage = "Wajib Diisi!";
    private SignupService signupService = new SignupService();
    @PostConstruct
    public void init(){
        newAcc = Account.createAcc();
        negaraComboBox.getItems().addAll(DBHandler.fetchCountries());
        FXUtil.autoCompleteComboBoxPlus(negaraComboBox,(typedText, itemToCompare) -> itemToCompare.toString().toLowerCase().contains(typedText.toLowerCase()));
        newAcc.emailProperty().bind(emailTextField.textProperty());
        newAcc.passwordProperty().bind(passwordTextField.textProperty());
        retypedPassword.bind(retypePasswordTextField.textProperty());
        newAcc.namaDepanProperty().bind(namaDepanTextField.textProperty());
        newAcc.namaBelakangProperty().bind(namaBelakangTextField.textProperty());
        newAcc.countryIDProperty().bind(negaraComboBox.getSelectionModel().selectedIndexProperty());
        newAcc.setUserType("UMUM");

        //Validator.addValidator();
        Validator.addValidator(passwordTextField);
        Validator.addValidator(emailTextField);
        Validator.addValidator(namaDepanTextField);
        Validator.addValidator(namaBelakangTextField);
        Validator.addValidator(retypePasswordTextField);
    }
    @FXML
    private void signUp(){
        //TODO
        if(signupService.isRunning())return;
        signupService.reset();
        signupService.setAccount(newAcc);
        signupService.setRetypedPassword(retypedPassword.get());
        signupService.setOnSucceeded(t -> {
                    String error = (String)t.getSource().getValue();
                    if(error==null){
                        error = DBHandler.pushAcc(newAcc);
                        newAcc.passwordProperty().unbind();
                        retypedPassword.unbind();
                        newAcc.setPassword(null);
                        retypedPassword.setValue(null);
                        if(error!=null) System.out.println( "Error : "+error);
                        else{
                            System.out.println("Submit Succeded");
                            Chosen.setViewFlowContext(context);
                            Chosen.setAccount(newAcc);
                            Chosen.goTo(ProfileController.class);
                        }
                    }
                    else{
                        System.out.println("Signup error : "+error);
                    }
                }
        );
        signupService.start();
    }
}
