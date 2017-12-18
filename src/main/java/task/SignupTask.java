package task;

import javafx.concurrent.Task;
import model.Account;
import util.DBHandler;
import util.Validator;

public class SignupTask extends Task<String> {
    private final int max = 100;
    private Account account;

    public SignupTask(Account account) {
        this.account = account;
    }

    @Override
    protected String call() throws Exception {
        updateMessage("Checking username if empty...");
        if (Validator.isEmpty(account.getNamaDepan())) {
            updateProgress(max,max);
            return "Isi Nama Depan";
        }
        updateProgress(25,max);

        updateMessage("Checking email if empty...");
        if (Validator.isEmpty(account.getNamaBelakang())) {
            updateProgress(max,max);
            return "Isi Nama Belakang";
        }
        updateProgress(25,max);

        updateMessage("Checking if account already exists...");
        //String error = DBHandler.signupCheck(account);
        /*if (error != null) {
            updateProgress(max,max);
            return error;
        }*/
        updateProgress(max,max);
        //returns null if no error
        return null;
    }
}
