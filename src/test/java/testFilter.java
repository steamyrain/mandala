import database.generated.Keys;
import database.generated.Tables;
import database.generated.tables.Users;
import database.generated.tables.records.LoginsRecord;
import database.generated.tables.records.UsersRecord;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import org.jasypt.salt.RandomSaltGenerator;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.jooq.DSLContext;
import org.jooq.ForeignKey;
import org.jooq.Result;
import util.DBHandler;

import java.sql.SQLException;
import java.util.List;

public class testFilter extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        /*String password = "root";
        StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
        RandomSaltGenerator salt = new RandomSaltGenerator();
        byte[] saltResult = salt.generateSalt(32);
        System.out.println(saltResult);
        System.out.println(DBHandler.serialize(saltResult));
        String newPass = saltResult.toString()+password;
        String passHash = encryptor.encryptPassword(newPass);
        System.out.println(passHash);
        System.out.println(encryptor.checkPassword(saltResult.toString()+password,passHash));*/
        String password = "root";
        StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
        DSLContext exec = DBHandler.getExecutor();
        try{
            /*exec.insertInto(Tables.LOGINS,Tables.LOGINS.ID,Tables.LOGINS.EMAIL,Tables.LOGINS.PASSWORDSALT,Tables.LOGINS.PASSWORDHASH)
                    .values(1,"Admin",DBHandler.serialize(saltResult),passHash).executeAsync();*/
            /*exec.insertInto(Tables.LOGINS,Tables.LOGINS.ID,Tables.LOGINS.EMAIL,Tables.LOGINS.PASSWORDSALT,Tables.LOGINS.PASSWORDHASH)
                    .values(1,"Admin",saltResult.toString(),passHash).executeAsync();*/
            LoginsRecord res = exec.selectFrom(Tables.LOGINS).where(Tables.LOGINS.ID.eq(1)).fetchAny();
            //System.out.println(saltResult);
            System.out.println(res.getValue(Tables.LOGINS.PASSWORDSALT));
            System.out.println(encryptor.checkPassword(res.getValue(Tables.LOGINS.PASSWORDSALT)+password,res.getValue(Tables.LOGINS.PASSWORDHASH)));
            /*Result<UsersRecord> result = exec.selectFrom(Tables.USERS).fetch();
            List<?> list = Tables.USERS.getReferencesFrom(Tables.LOGINS);
            String fetch = result.fetchChildren(Keys.FK_LOGINS_USERS_1).getValue(0,Tables.LOGINS.EMAIL);
            System.out.println(fetch);*/
            //result.
            //ForeignKey<UsersRecord,LoginsRecord> fk =;
            //System.out.println(fk.getKey().toString());
            //Result<?> fetchfk = result.fetchChildren();
            /*exec.insertInto(Tables.LOGINS,Tables.LOGINS.ID,Tables.LOGINS.EMAIL,Tables.LOGINS.PASSWORDSALT,Tables.LOGINS.PASSWORDHASH).values(
                    1,
                    exec.select(Tables.USERS.EMAIL).from(Tables.USERS).where(Tables.USERS.EMAIL.eq("admin")).fetchOne(Tables.USERS.EMAIL),
                    saltResult,
                    passHash).executeAsync();*/

            //System.out.println(result.toString());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally {
            exec.close();
        }

    }
}
