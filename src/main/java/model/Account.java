package model;

import database.generated.tables.records.AccountRecord;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import util.DBHandler;

public class Account implements Disposable{
    private StringProperty namaDepan = new SimpleStringProperty();
    private StringProperty namaBelakang = new SimpleStringProperty();
    private StringProperty email = new SimpleStringProperty();
    private StringProperty noTelp = new SimpleStringProperty();
    private IntegerProperty countryID = new SimpleIntegerProperty();
    private IntegerProperty stateID = new SimpleIntegerProperty();
    private IntegerProperty cityID = new SimpleIntegerProperty();
    private UserType userType = UserType.UMUM;
    public enum UserType{
        ADMIN,PENELITI,UMUM
    }
    public static final UserType[] USER_TYPE = {
            UserType.ADMIN,UserType.PENELITI,UserType.PENELITI
    };
    public static Account createAcc(){
        Account account = new Account();
        return account;
    }
    public static Account createAcc(AccountRecord record){
        Account account = new Account();
        account.setNamaDepan(record.getNamaDepan());
        account.setNamaBelakang(record.getNamaBelakang());
        account.setUserType((UserType)DBHandler.deserialize(record.getUserType()));
        account.setEmail(record.getEmail());
        account.setNoTelp(record.getEmail());
        account.setCountryID(record.getCountryId());
        account.setStateID(record.getStateId());
        account.setCityID(record.getCityId());
        return account;
    }
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
    public void setUserType(UserType userType){this.userType = userType;}
    public UserType getUserType(){ return this.userType; }
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
