package util;

import database.generated.Tables;
//import database.generated.tables.records.AccountRecord;
import database.generated.tables.Users;
import database.generated.tables.records.LoginsRecord;
import database.generated.tables.records.RolesRecord;
import database.generated.tables.records.UsersRecord;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Account;
import model.Chosen;
import org.jasypt.salt.RandomSaltGenerator;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.jooq.*;
import org.jooq.impl.DSL;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Observable;

public class DBHandler {
    //private static final String DB_PATH = "databases/TestCiburuy.db";
    private static final String DB_PATH = "databases/testlogin.db";
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
    public static String login(String email, String password) {
        DSLContext exec = null;
        String fetchSalt = null;
        String fetchHash= null;
        StrongPasswordEncryptor check = new StrongPasswordEncryptor();
        UsersRecord resultUsers = null;
        RolesRecord resultRoles = null;
        Account loggedAcc=null;
        try {
            exec = DBHandler.getExecutor();
            LoginsRecord resultLogins = exec.selectFrom(Tables.LOGINS).where(Tables.LOGINS.EMAIL.eq(email)).fetchAny();
            if (resultLogins == null) {
                exec.close();
                return "User not found";
            }
            else{
                resultUsers = exec.selectFrom(Tables.USERS).where(Tables.USERS.EMAIL.eq(email)).fetchAny();
                resultRoles = exec.selectFrom(Tables.ROLES).where(Tables.ROLES.USERID.eq(resultUsers.getValue(Tables.USERS.ID))).fetchAny();
                fetchSalt = resultLogins.getValue(Tables.LOGINS.PASSWORDSALT);
                fetchHash = resultLogins.getValue(Tables.LOGINS.PASSWORDHASH);
                if(!check.checkPassword(fetchSalt+password,fetchHash)){
                    System.out.println(check.checkPassword(fetchSalt+password,fetchHash));
                    exec.close();
                    return "Password Do Not Match";
                }
                if(resultRoles.getValue(Tables.ROLES.STATUS).equals("PENDING")){
                    exec.close();
                    return "Registeration Status Pending, Please Confirm Your Registeration To Nearest Admin!";
                }
                if(resultUsers!=null&&resultRoles!=null)loggedAcc = Account.createAcc(resultUsers,resultRoles);
                if(loggedAcc!=null)Chosen.setAccount(loggedAcc);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error in logging in";
        } finally {
            if (exec != null) exec.close();
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
    /*public static ObservableList<String> fetchStates(){
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
    }*/
    public static String pushAcc(Account account){
        DSLContext exec = null;
        RandomSaltGenerator salt = new RandomSaltGenerator();
        byte[] newSalt = salt.generateSalt(32);
        StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
        try{
            exec = getExecutor();
            exec.insertInto(Tables.USERS,
                    Tables.USERS.FIRSTNAME, Tables.USERS.LASTNAME,Tables.USERS.EMAIL
                    ,Tables.USERS.COUNTRYID)
                    .values(account.getNamaDepan(),account.getNamaBelakang(),account.getEmail()
                    ,account.getCountryID()+1)
                    .executeAsync();
            exec.insertInto(Tables.LOGINS,
                    Tables.LOGINS.EMAIL,Tables.LOGINS.PASSWORDSALT,Tables.LOGINS.PASSWORDHASH)
                    .values(account.getEmail(),newSalt.toString(),encryptor.encryptPassword(newSalt.toString()+account.getPassword()))
                    .executeAsync();
            if(account.getUserType().equals("UMUM")){
            exec.insertInto(Tables.ROLES,
                    Tables.ROLES.USERID,Tables.ROLES.ROLE,Tables.ROLES.STATUS)
                    .values(exec.select(Tables.USERS.ID).from(Tables.USERS).where(Tables.USERS.EMAIL.eq(account.getEmail()))
                            ,account.getUserType()
                            ,"ACTIVE")
                    .executeAsync();
            }
        }
        catch (Exception e){
            e.printStackTrace();
            exec.close();
            return "error in pushing data";
        }
        finally{
            exec.close();
        }
        return null;
    }
    public static String signupCheck(Account account) {
        DSLContext exec = null;
        Record1<String> res = null;
        try {
            exec = DBHandler.getExecutor();
            res = exec
                    .select(Tables.USERS.EMAIL).from(Tables.USERS)
                    .where(Tables.USERS.EMAIL.equal(account.getEmail()))
                    .fetchAny();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (exec != null) exec.close();
        }
        if (res!=null) {
            return "E-mail telah terdaftar";
        }
        return null;
    }

    public static String update(Account account,Account oldAcc) {
        DSLContext exec = getExecutor();
        Record1<?> email = null;
        try {
            email = exec.select(Tables.USERS.EMAIL)
                    .from(Tables.USERS)
                    .where(Tables.USERS.EMAIL.eq(account.getEmail()))
                    .fetchOne();
            if(email != null) {
                exec.update(Tables.USERS)
                        .set(Tables.USERS.EMAIL, account.getEmail())
                        .set(Tables.USERS.FIRSTNAME, account.getNamaDepan())
                        .set(Tables.USERS.LASTNAME, account.getNamaBelakang())
                        .set(Tables.USERS.COUNTRYID, account.getCountryID()+1)
                        .where(Tables.USERS.EMAIL.equal(oldAcc.getEmail()))
                        .executeAsync();
            }
            else{
                exec.close();
                return "E-mail telah terdaftar";
            }
        } catch (Exception e) {
            e.printStackTrace();
            exec.close();
            return "error in updating data";
        } finally {
            exec.close();
        }
        return null;
    }
}
