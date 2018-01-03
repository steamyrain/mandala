package task;

import javafx.concurrent.Task;
import util.DBHandler;
import util.Validator;

public class LoginTask extends Task<String> {

    private final int max = 100;

    private String email;
    private String password;
    private String role;

    public LoginTask(String email, String password,String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @Override
    protected String call() throws Exception {
        updateMessage("Checking username if empty...");
        if (Validator.isEmpty(email)) {
            updateProgress(100,max);
            return "Input Email";
        }
        updateProgress(10,max);

        updateMessage("Checking password if empty...");
        if (Validator.isEmpty(password)) {
            updateProgress(100,max);
            return "Input Password";
        }
        updateProgress(20,max);

        updateMessage("Checking if user exists and logging in...");
        String error = DBHandler.login(email,password,role);
        if (error != null) {
            return error;
        }
        updateProgress(70,max);
        //return null if no error
        return null;
    }
}
