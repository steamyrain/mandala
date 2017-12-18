package task;

import javafx.concurrent.Task;
import util.DBHandler;
import util.Validator;

public class LoginTask extends Task<String> {

    private final int max = 100;

    private String email;
    private String password;

    public LoginTask(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    protected String call() throws Exception {
        updateMessage("Checking username if empty...");
        if (Validator.isEmpty(email)) {
            updateProgress(100,max);
            return "Input username";
        }
        updateProgress(10,max);

        updateMessage("Checking password if empty...");
        if (Validator.isEmpty(password)) {
            updateProgress(100,max);
            return "Input password";
        }
        updateProgress(20,max);

        updateMessage("Checking if user exists and logging in...");
        String error = DBHandler.login(email,password);
        if (error != null) {
            return error;
        }

        updateProgress(100,max);
        //return null if no error
        return null;
    }
}
