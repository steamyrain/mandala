package gui.components;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import io.datafx.controller.ViewController;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Account;
import model.Chosen;
import util.DBHandler;
import util.FXUtil;

import javax.annotation.PostConstruct;

@ViewController(value="/gui/components/Home.fxml")
public class HomeController {
    @FXML
    private Label usernameLabel;
    @FXML
    private JFXComboBox negara;
    @FXML
    private JFXComboBox provinsi;
    @FXML
    private JFXComboBox kota;
    @FXML
    private JFXTextField emailTextField;
    @FXML
    private JFXTextField noTelpTextField;
    @FXMLViewFlowContext
    private ViewFlowContext context;
    @FXML
    private JFXButton saveButton;
    @FXML
    private JFXButton resetButton;

    private Account buffAccount;
    private Account currAcc;
    @PostConstruct
    private void init(){
        bufferAccount(buffAccount,Chosen.getAccount());
        currAcc = Chosen.getAccount();
        JFXListView sideList = (JFXListView) context.getRegisteredObject("SideList");
        Label home = (Label) context.getRegisteredObject("Home");
        Label bukuTamu = (Label) context.getRegisteredObject("BukuTamu");
        if(sideList.getItems().contains(bukuTamu)) {
            sideList.getItems().clear();
            sideList.getItems().add(home);
        }
        usernameLabel.setText(currAcc.getNamaDepan()+" "+currAcc.getNamaBelakang());
        emailTextField.setText(currAcc.getEmail());
        currAcc.emailProperty().bind(emailTextField.textProperty());
        noTelpTextField.setText(currAcc.getNoTelp());
        currAcc.noTelpProperty().bind(noTelpTextField.textProperty());
        //negara.getItems().addAll(DBHandler.fetchCountries());
        FXUtil.autoCompleteComboBoxPlus(negara,(typedText, itemToCompare) -> itemToCompare.toString().toLowerCase().contains(typedText.toLowerCase()));
        if(currAcc.getCountryID()!= null)negara.getSelectionModel().select(currAcc.getCountryID().intValue());
        //provinsi.getItems().addAll(DBHandler.fetchStates());
        FXUtil.autoCompleteComboBoxPlus(provinsi,(typedText, itemToCompare) -> itemToCompare.toString().toLowerCase().contains(typedText.toLowerCase()));
        if(currAcc.getStateID()!= null)provinsi.getSelectionModel().select(currAcc.getStateID().intValue());
        //kota.getItems().addAll(DBHandler.fetchCities());
        FXUtil.autoCompleteComboBoxPlus(kota,(typedText, itemToCompare) -> itemToCompare.toString().toLowerCase().contains(typedText.toLowerCase()));
        if(currAcc.getCityID()!= null)kota.getSelectionModel().select(currAcc.getCityID().intValue());
    }
    @FXML
    private void save(){
        /*String error = DBHandler.update(currAcc,buffAccount);
        if (error != null) {
            System.out.println("Error: " + error);
        } else {
            Chosen.setAccount(currAcc);
        }*/
    }
    @FXML
    private void reset(){
        /*if(buffAccount.getNoTelp()!=null)noTelpTextField.setText(buffAccount.getNoTelp());
        else noTelpTextField.setText("");
        if(buffAccount.getEmail()!=null)emailTextField.setText(buffAccount.getEmail());
        else emailTextField.setText("");
        if(buffAccount.getCountryID().intValue()>0)negara.getSelectionModel().select(buffAccount.getCountryID().intValue());
        else negara.getEditor().setText("");
        if(buffAccount.getStateID().intValue()>0)provinsi.getSelectionModel().select(buffAccount.getStateID().intValue());
        else provinsi.getEditor().setText("");
        if(buffAccount.getCityID().intValue()>0)kota.getSelectionModel().select(buffAccount.getCityID().intValue());
        else kota.getEditor().setText("");*/
    }
    private void bufferAccount(Account buffer,Account account){
        /*buffer = Account.createAcc(account);
        buffer.emailProperty().bind(account.emailProperty());
        buffer.noTelpProperty().bind(account.noTelpProperty());
        buffer.countryIDProperty().bind(account.countryIDProperty());
        buffer.stateIDProperty().bind(account.stateIDProperty());
        buffer.cityIDProperty().bind(account.cityIDProperty());*/
    }
}
