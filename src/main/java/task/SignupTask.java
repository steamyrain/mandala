package task;

import javafx.concurrent.Task;
import model.Account;
import util.DBHandler;
import util.Validator;

public class SignupTask extends Task<String> {
    private final int max = 100;
    private Account account;
    private String retypedPassword;
    public SignupTask(Account account,String retypedPassword) {
        this.account = account;
        this.retypedPassword = retypedPassword;
    }

    @Override
    protected String call() throws Exception {

        updateMessage("Checking firstname if empty...");
        if (Validator.isEmpty(account.getNamaDepan())) {
            updateProgress(max,max);
            return "Isi Nama Depan";
        }
        updateProgress(14,max);

        updateMessage("Checking lastname if empty...");
        if (Validator.isEmpty(account.getNamaBelakang())) {
            updateProgress(max,max);
            return "Isi Nama Belakang";
        }
        updateProgress(14,max);

        updateMessage("Checking email if empty...");
        if (Validator.isEmpty(account.getEmail())) {
            updateProgress(max,max);
            return "Isi Email";
        }
        updateProgress(14,max);


        updateMessage("Checking password if empty...");
        if (Validator.isEmpty(account.getPassword())) {
            updateProgress(max,max);
            return "Isi password";
        }
        updateProgress(14,max);

        updateMessage("Checking retyped password if empty...");
        if (Validator.isEmpty(retypedPassword)) {
            updateProgress(max,max);
            return "Ketik ulang password";
        }
        updateProgress(14,max);

        updateMessage("Checking if password and retyped password match...");
        if (!retypedPassword.equals(account.getPassword())) {
            updateProgress(max,max);
            return "Password dan retyped password tidak cocok";
        }
        updateProgress(14,max);

        updateMessage("Checking CountryID if empty...");
        if (Validator.isEmpty(account.getCountryID())) {
            updateProgress(max,max);
            return "Isi Negara";
        }
        updateProgress(14,max);

        updateMessage("Checking if account already exists...");
        String error = DBHandler.signupCheck(account);
        if (error != null) {
            updateProgress(max,max);
            return error;
        }
        updateProgress(max,max);
        //returns null if no error
        return null;
    }
}
