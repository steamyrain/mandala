package model;

//import database.generated.tables.records.AccountRecord;
import database.generated.tables.records.RolesRecord;
import database.generated.tables.records.UsersRecord;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import util.DBHandler;

public class Account implements Disposable{
    private StringProperty namaDepan = new SimpleStringProperty();
    private StringProperty namaBelakang = new SimpleStringProperty();
    private StringProperty email = new SimpleStringProperty();
    private StringProperty password = new SimpleStringProperty();
    private StringProperty noTelp = new SimpleStringProperty();
    private IntegerProperty countryID = new SimpleIntegerProperty();
    private IntegerProperty stateID = new SimpleIntegerProperty();
    private IntegerProperty cityID = new SimpleIntegerProperty();
    private StringProperty userType = new SimpleStringProperty();
    /*public enum UserType{
        ADMIN,PENELITI,UMUM
    }
    public static final UserType[] USER_TYPE = {
            UserType.ADMIN,UserType.PENELITI,UserType.PENELITI
    };*/
    public static Account createAcc(){
        Account account = new Account();
        return account;
    }
    public static Account createAcc(Account acc){
        Account account = new Account();
        account.setNamaDepan(acc.getNamaDepan());
        account.setNamaBelakang(acc.getNamaBelakang());
        account.setEmail(acc.getEmail());
        account.setCountryID(acc.getCountryID());
        account.setUserType(acc.getUserType());
        return account;
    }
    public void copy(Account acc) {
        setEmail(acc.getEmail());
        setNamaDepan(acc.getNamaDepan());
        setNamaBelakang(acc.getNamaBelakang());
        setCountryID(acc.getCountryID());
        setUserType(acc.getUserType());
    }
    public Account clone() {
        Account newAcc = new Account();
        newAcc.copy(this);
        return newAcc;
    }
    public static Account createAcc(UsersRecord usersRecord, RolesRecord rolesRecord){
        Account account = new Account();
        account.setNamaDepan(usersRecord.getFirstname());
        account.setNamaBelakang(usersRecord.getLastname());
        account.setUserType(rolesRecord.getRole());
        account.setEmail(usersRecord.getEmail());
        account.setCountryID(usersRecord.getCountryid()-1);
        return account;
    }
    public void setPassword(String password){ this.password.set(password);}
    public String getPassword(){return this.password.get();}
    public void setNamaDepan(String namaDepan){
        this.namaDepan.set(namaDepan);
    }
    public String getNamaDepan(){
        return this.namaDepan.get();
    }
    public void setNamaBelakang(String namaBelakang){
        this.namaBelakang.set(namaBelakang);
    }
    public String getNamaBelakang(){
        return this.namaBelakang.get();
    }
    public void setEmail(String email){ this.email.set(email); }
    public String getEmail(){return this.email.get(); }
    public void setNoTelp(String noTelp){ this.noTelp.set(noTelp); }
    public String getNoTelp(){ return this.noTelp.get(); }
    public void setCountryID(Integer countryID){ this.countryID.set(countryID); }
    public Integer getCountryID(){ return this.countryID.get(); }
    public void setStateID(Integer stateID){ this.stateID.set(stateID); }
    public Integer getStateID(){ return this.stateID.get(); }
    public void setCityID(Integer cityID){ this.cityID.set(cityID); }
    public Integer getCityID(){ return this.cityID.get(); }
    public void setUserType(String userType){this.userType.set(userType);}
    public String getUserType(){return this.userType.get();}
    public StringProperty passwordProperty(){return this.password;}
    public StringProperty userTypeProperty(){ return this.userType; }
    public StringProperty namaDepanProperty() {
        return namaDepan;
    }
    public StringProperty namaBelakangProperty() { return namaBelakang; }
    public StringProperty emailProperty() {
        return email;
    }
    public StringProperty noTelpProperty(){ return noTelp;}
    public IntegerProperty countryIDProperty(){return countryID;}
    public IntegerProperty stateIDProperty(){return stateID;}
    public IntegerProperty cityIDProperty(){return cityID;}
    @Override
    public void dispose(){
        //TODO-dispose
    }
}
