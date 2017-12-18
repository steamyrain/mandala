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
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import model.Account;
import model.Chosen;
import util.DBHandler;
import util.FXUtil;

import javax.annotation.PostConstruct;

@ViewController(value= "/gui/components/Profile.fxml")
public class ProfileController {
    @FXML
    private Label usernameLabel;

    @FXML
    private ImageView profileImageView;

    @FXML
    private JFXComboBox<String> negara;

    @FXML
    private JFXButton saveButton;

    @FXML
    private JFXTextField emailTextField;

    @FXML
    private JFXTextField namaDepanTextField;

    @FXML
    private JFXTextField namaBelakangTextField;

    @FXML
    private JFXButton resetButton;
    @FXMLViewFlowContext
    private ViewFlowContext context;

    private Account buffAccount;
    private Account currAcc;
    private StackPane optionsBurger;
    @PostConstruct
    public void init() {
        bufferAccount(buffAccount, Chosen.getAccount());
        System.out.println(buffAccount.getEmail().toString());
        currAcc = Chosen.getAccount();
        usernameLabel.setText(currAcc.getNamaDepan() + " " + currAcc.getNamaBelakang());
        emailTextField.setText(currAcc.getEmail());
        currAcc.emailProperty().bind(emailTextField.textProperty());
        namaDepanTextField.setText(currAcc.getNamaDepan());
        currAcc.namaDepanProperty().bind(namaDepanTextField.textProperty());
        namaBelakangTextField.setText(currAcc.getNamaBelakang());
        currAcc.namaDepanProperty().bind(namaBelakangTextField.textProperty());
        negara.getItems().addAll(DBHandler.fetchCountries());
        FXUtil.autoCompleteComboBoxPlus(negara, (typedText, itemToCompare) -> itemToCompare.toString().toLowerCase().contains(typedText.toLowerCase()));
        if (currAcc.getCountryID() != null) negara.getSelectionModel().select(currAcc.getCountryID()-1);
        initRightToolbar();
        initSideBar();
        //initComponents();
    }
    private void initSideBar(){
        JFXListView sideList = (JFXListView) context.getRegisteredObject("SideList");
        Label profile = (Label) context.getRegisteredObject("Profile");
        Label login = (Label) context.getRegisteredObject("Login");
        if (sideList.getItems().contains(login)) {
            sideList.getItems().clear();
            sideList.getItems().add(profile);
        }
    }
    private void initRightToolbar(){

        optionsBurger = (StackPane) context.getRegisteredObject("OptionsBurger");
        optionsBurger.setVisible(true);
    }
    private void initComponents(){
        bufferAccount(buffAccount, Chosen.getAccount());
        currAcc = Chosen.getAccount();
        usernameLabel.setText(currAcc.getNamaDepan() + " " + currAcc.getNamaBelakang());
        emailTextField.setText(currAcc.getEmail());
        currAcc.emailProperty().bind(emailTextField.textProperty());
        namaDepanTextField.setText(currAcc.getNamaDepan());
        currAcc.namaDepanProperty().bind(namaDepanTextField.textProperty());
        namaBelakangTextField.setText(currAcc.getNamaBelakang());
        currAcc.namaDepanProperty().bind(namaBelakangTextField.textProperty());
        negara.getItems().addAll(DBHandler.fetchCountries());
        FXUtil.autoCompleteComboBoxPlus(negara, (typedText, itemToCompare) -> itemToCompare.toString().toLowerCase().contains(typedText.toLowerCase()));
        if (currAcc.getCountryID() != null) negara.getSelectionModel().select(currAcc.getCountryID()-1);
    }
    @FXML
    private void save(){
        String error = DBHandler.update(currAcc,buffAccount);
        if (error != null) {
            System.out.println("Error: " + error);
        } else {
            Chosen.setAccount(currAcc);
        }
    }
    @FXML
    private void reset(){
        if(buffAccount.getEmail()!=null)emailTextField.setText(buffAccount.getEmail());
        else emailTextField.setText("");
        /*namaDepanTextField.setText(buffAccount.getNamaDepan());
        namaBelakangTextField.setText(buffAccount.getNamaBelakang());
        negara.getSelectionModel().select(buffAccount.getCountryID().intValue());*/
    }
    private void bufferAccount(Account buffer,Account account){
        buffer = Account.createAcc(account);
        buffer.emailProperty().bind(account.emailProperty());
        buffer.namaDepanProperty().bind(account.namaDepanProperty());
        buffer.namaBelakangProperty().bind(account.namaBelakangProperty());
        buffer.countryIDProperty().bind(account.countryIDProperty());
    }
}
