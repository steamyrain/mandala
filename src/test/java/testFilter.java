import database.generated.Tables;
import database.generated.tables.Users;
import database.generated.tables.records.UsersRecord;
import javafx.application.Application;
import javafx.stage.Stage;
import org.jasypt.salt.RandomSaltGenerator;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.jooq.DSLContext;
import org.jooq.Result;
import util.DBHandler;

import java.sql.SQLException;

public class testFilter extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        String password = "root";
        StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
        RandomSaltGenerator salt = new RandomSaltGenerator();
        byte[] saltResult = salt.generateSalt(32);
        System.out.println(saltResult);
        String newPass = saltResult.toString()+password;
        String passHash = encryptor.encryptPassword(newPass);
        DSLContext exec;
        exec = DBHandler.getExecutor();
        try{
            Result<UsersRecord> result = exec.selectFrom(Tables.USERS).fetch();
            /*exec.insertInto(Tables.LOGINS,Tables.LOGINS.ID,Tables.LOGINS.EMAIL).values(
                    1,exec.select(Tables.USERS.EMAIL).from(Tables.USERS).where(Tables.USERS.EMAIL.eq("admin")).fetchOne(Tables.USERS.EMAIL)
            ).executeAsync();
            exec.update(Tables.LOGINS).set(Tables.LOGINS.PASSWORDSALT,saltResult).set(Tables.LOGINS.PASSWORDHASH,passHash).where(Tables.USERS.EMAIL.eq("admin"))
                    .executeAsync();*/
            System.out.println(result.toString());
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
