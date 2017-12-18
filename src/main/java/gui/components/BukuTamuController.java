package gui.components;

import com.jfoenix.controls.*;
import io.datafx.controller.ViewController;
import io.datafx.controller.ViewNode;
import io.datafx.controller.flow.FlowException;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import io.datafx.controller.util.VetoException;
import javafx.beans.property.IntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import model.Account;
import model.Chosen;
import task.SignupService;
import util.DBHandler;
import util.FXUtil;
import util.Validator;

import javax.annotation.PostConstruct;

@ViewController(value="/gui/components/BukuTamu.fxml")
public class BukuTamuController {
    @FXML
    private JFXScrollPane scroll;
    @ViewNode
    private JFXButton submitButton;
    @FXML
    private JFXTextField namaDepan;
    @FXML
    private JFXTextField namaBelakang;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXTextField nomorTelefon;
    @FXML
    private JFXComboBox<String> negara;
    @FXML
    private JFXComboBox<String> provinsi;
    @FXML
    private JFXComboBox<String> kota;
    @FXMLViewFlowContext
    private ViewFlowContext context;
    private Account newAccount;
    private String validatorMessage = "Input required";
    private SignupService signupService = new SignupService();
    @PostConstruct
    public void init() throws Exception{
        /*negara.getItems().addAll(DBHandler.fetchCountries());
        provinsi.getItems().addAll(DBHandler.fetchStates());
        kota.getItems().addAll(DBHandler.fetchCities());*/
        /*FXUtil.autoCompleteComboBoxPlus(negara,(typedText, itemToCompare) -> itemToCompare.toString().toLowerCase().contains(typedText.toLowerCase()));
        FXUtil.autoCompleteComboBoxPlus(provinsi,(typedText, itemToCompare) -> itemToCompare.toString().toLowerCase().contains(typedText.toLowerCase()));
        FXUtil.autoCompleteComboBoxPlus(kota,(typedText, itemToCompare) -> itemToCompare.toString().toLowerCase().contains(typedText.toLowerCase()));
        newAccount = Account.createAcc();
        newAccount.namaDepanProperty().bind(namaDepan.textProperty());
        newAccount.namaBelakangProperty().bind(namaBelakang.textProperty());
        newAccount.emailProperty().bind(email.textProperty());
        newAccount.noTelpProperty().bind(nomorTelefon.textProperty());
        newAccount.countryIDProperty().bind(negara.getSelectionModel().selectedIndexProperty());
        newAccount.stateIDProperty().bind(provinsi.getSelectionModel().selectedIndexProperty());
        newAccount.cityIDProperty().bind(kota.getSelectionModel().selectedIndexProperty());
        Validator.addValidator(namaDepan);
        Validator.addValidator(namaBelakang);
        JFXScrollPane.smoothScrolling((ScrollPane)scroll.getChildren().get(0));*/
    }
    @FXML
    private void submit(){
        /*if(signupService.isRunning())return;
        signupService.reset();
        signupService.setAccount(newAccount);
        signupService.setOnSucceeded(t -> {
            String error = (String)t.getSource().getValue();
            if(error==null){
                error = DBHandler.pushAcc(newAccount);
                if(error!=null) System.out.println( "Error : "+error);
                else{
                    System.out.println("Submit Succeded");
                    Chosen.setViewFlowContext(context);
                    Chosen.setAccount(newAccount);
                    Chosen.goTo(HomeController.class);
                }
            }
            else{
                System.out.println("Signup error : "+error);
            }
        }
        );
        signupService.start();*/
        //reset();
    }

    @FXML
    private void reset(){
        /*namaDepan.setText(null);
        namaBelakang.setText(null);
        email.setText(null);
        nomorTelefon.setText(null);
        negara.getEditor().setText(null);
        provinsi.getEditor().setText(null);
        kota.getEditor().setText(null);*/
    }
}
