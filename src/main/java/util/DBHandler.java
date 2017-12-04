package util;

import database.generated.Tables;
import database.generated.tables.records.AccountRecord;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Account;
import org.jooq.*;
import org.jooq.impl.DSL;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Observable;

public class DBHandler {
    private static final String DB_PATH = "databases/TestCiburuy.db";
    private static final String DB_URL = "jdbc:sqlite:"+DB_PATH;
    private static Connection connection;
    private static void connectToDB(){
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(DB_URL);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public static DSLContext getExecutor(){
        if(connection ==  null)connectToDB();
        DSLContext exec = DSL.using(connection, SQLDialect.SQLITE);
        return exec;
    }
    public static ObservableList<String> fetchCountries(){
        DSLContext exec = null;
        Result<?> result = null;
        try{
            exec = getExecutor();
            result = exec.select(Tables.COUNTRIES.ID,Tables.COUNTRIES.NAME).from(Tables.COUNTRIES).fetch();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }finally{
            if(exec !=  null) exec.close();
            else return null;
        }
        return FXCollections.observableArrayList(result.getValues(Tables.COUNTRIES.NAME));
    }
    public static ObservableList<String> fetchStates(){
        DSLContext exec = null;
        Result<?> result = null;
        try{
            exec = getExecutor();
            result = exec.select(Tables.STATES.ID,Tables.STATES.NAME).from(Tables.STATES).fetch();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }finally{
            if(exec !=  null) exec.close();
            else return null;
        }
        return FXCollections.observableArrayList(result.getValues(Tables.STATES.NAME));
    }
    public static ObservableList<String> fetchCities(){
        DSLContext exec = null;
        Result<?> result = null;
        try{
            exec = getExecutor();
            result = exec.select(Tables.CITIES.ID,Tables.CITIES.NAME).from(Tables.CITIES).fetch();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }finally{
            if(exec !=  null) exec.close();
            else return null;
        }
        return FXCollections.observableArrayList(result.getValues(Tables.CITIES.NAME));
    }
    public static String pushAcc(Account account){
        DSLContext exec = null;
        try{
            exec = getExecutor();
            exec.insertInto(Tables.ACCOUNT,
                    Tables.ACCOUNT.NAMA_DEPAN, Tables.ACCOUNT.NAMA_BELAKANG,Tables.ACCOUNT.EMAIL,Tables.ACCOUNT.PHONENUMBER
                    ,Tables.ACCOUNT.COUNTRY_ID, Tables.ACCOUNT.STATE_ID,Tables.ACCOUNT.CITY_ID)
                    .values(account.getNamaDepan(),account.getNamaBelakang(),account.getEmail(),account.getNoTelp()
                    ,account.getCountryID()+1,account.getStateID()+1,account.getCityID()+1)
                    .executeAsync();
        }
        catch (Exception e){
            e.printStackTrace();
            return "error in pushing data";
        }
        finally{
            exec.close();
        }
        return null;
    }
    public static String signupCheck(Account account) {
        DSLContext exec = null;
        Result<AccountRecord> result = null;
        try {
            exec = DBHandler.getExecutor();
            result = exec
                    .selectFrom(Tables.ACCOUNT)
                    .where(Tables.ACCOUNT.NAMA_DEPAN.equal(account.getNamaDepan()).and(Tables.ACCOUNT.NAMA_BELAKANG.equal(account.getNamaBelakang())))
                    .fetch();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (exec != null) exec.close();
        }
        int i = 0;
        for (AccountRecord accountRecord : result) {
            System.out.println(accountRecord.get(0));
            i++;
        }

        if (i > 0) {
            System.out.println("Same username/email with: " + i + " account");
            return "Account already exists";
        }

        return null;
    }
    public static byte[] serialize(Serializable object) {
        ByteArrayOutputStream baos;
        ObjectOutputStream oos;

        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            oos.close();

            return baos.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
    public static Object deserialize(Object object) {
        if (object == null) return null;
        return deserialize((byte[]) object);
    }

    public static Object deserialize(byte[] bytes) {
        if (bytes == null) return null;
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(new ByteArrayInputStream(bytes));
            Object object = ois.readObject();
            ois.close();
            return object;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
