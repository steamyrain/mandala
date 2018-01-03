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
        //initComponents();
        buffAccount = Chosen.getAccount().clone();
        currAcc = Account.createAcc();
        usernameLabel.setText(buffAccount.getNamaDepan() + " " + buffAccount.getNamaBelakang());
        emailTextField.setText(buffAccount.getEmail());
        currAcc.emailProperty().bind(emailTextField.textProperty());
        namaDepanTextField.setText(buffAccount.getNamaDepan());
        currAcc.namaDepanProperty().bind(namaDepanTextField.textProperty());
        namaBelakangTextField.setText(buffAccount.getNamaBelakang());
        currAcc.namaBelakangProperty().bind(namaBelakangTextField.textProperty());
        negara.getItems().addAll(DBHandler.fetchCountries());
        FXUtil.autoCompleteComboBoxPlus(negara, (typedText, itemToCompare) -> itemToCompare.toString().toLowerCase().contains(typedText.toLowerCase()));
        if (currAcc.getCountryID() != null) negara.getSelectionModel().select(buffAccount.getCountryID());
        currAcc.countryIDProperty().bind(negara.getSelectionModel().selectedIndexProperty());
        initRightToolbar();
        initSideBar();
        //initComponents();
    }
    private void initSideBar(){
        JFXListView sideList = (JFXListView) context.getRegisteredObject("SideList");
        Label profile = (Label) context.getRegisteredObject("Profile");
        Label adminPanel = (Label) context.getRegisteredObject("AdminPanel");
        Label galeriAktivitas = (Label) context.getRegisteredObject("GaleriAktivitas");
        Label galeriNaskah = (Label) context.getRegisteredObject("GaleriNaskah");
        Label hasilPenelitian = (Label) context.getRegisteredObject("HasilPenelitian");
        Label tentangKami = (Label) context.getRegisteredObject("TentangKami");
        Label permainan = (Label) context.getRegisteredObject("Permainan");
        Label login = (Label) context.getRegisteredObject("Login");
        if (sideList.getItems().contains(login)) {
            sideList.getItems().clear();
            if (context.getRegisteredObject("LoginAs").equals("ADMIN")) {
                sideList.getItems().addAll(profile,adminPanel,hasilPenelitian,galeriAktivitas,galeriNaskah,permainan,tentangKami);
            }
            else {
                sideList.getItems().addAll(profile, hasilPenelitian, galeriAktivitas, galeriNaskah, permainan, tentangKami);
            }

        }
    }
    private void initRightToolbar(){
        JFXTextField searchBar = (JFXTextField) context.getRegisteredObject("SearchBar");
        searchBar.setVisible(true);
        optionsBurger = (StackPane) context.getRegisteredObject("OptionsBurger");
        optionsBurger.setVisible(true);
    }
    private void initComponents(){
        buffAccount = Chosen.getAccount();
        currAcc = Account.createAcc(Chosen.getAccount());
        usernameLabel.setText(currAcc.getNamaDepan() + " " + currAcc.getNamaBelakang());
        emailTextField.setText(currAcc.getEmail());
        currAcc.emailProperty().bind(emailTextField.textProperty());
        namaDepanTextField.setText(currAcc.getNamaDepan());
        currAcc.namaDepanProperty().bind(namaDepanTextField.textProperty());
        namaBelakangTextField.setText(currAcc.getNamaBelakang());
        currAcc.namaDepanProperty().bind(namaBelakangTextField.textProperty());
        negara.getItems().addAll(DBHandler.fetchCountries());
        FXUtil.autoCompleteComboBoxPlus(negara, (typedText, itemToCompare) -> itemToCompare.toString().toLowerCase().contains(typedText.toLowerCase()));
        if (currAcc.getCountryID() != null) negara.getSelectionModel().select(currAcc.getCountryID());
    }
    @FXML
    private void save(){
        System.out.println("Curr Acc Email "+currAcc.getEmail());
        System.out.println("Buff Acc Email "+buffAccount.getEmail());
        System.out.println("Curr Acc Fname "+currAcc.getNamaDepan());
        System.out.println("Buff Acc Fname "+buffAccount.getNamaDepan());
        String error = DBHandler.update(currAcc,buffAccount);
        if (error != null) {
            System.out.println("Error: " + error);
        } else {
            Chosen.setAccount(currAcc);
            System.out.println("Chosen Acc Email : "+Chosen.getAccount().getEmail());
            System.out.println("Chosen Acc LName : "+Chosen.getAccount().getNamaBelakang());
            buffAccount= Chosen.getAccount().clone();
        }
    }
    @FXML
    private void reset(){
        System.out.println(currAcc.getNamaDepan());
        emailTextField.textProperty().setValue(buffAccount.getEmail());
        namaDepanTextField.setText(buffAccount.getNamaDepan());
        namaBelakangTextField.setText(buffAccount.getNamaBelakang());
        negara.getSelectionModel().select(buffAccount.getCountryID().intValue());
    }

}
