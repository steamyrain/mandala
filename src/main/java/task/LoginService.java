package task;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class LoginService extends Service<String>{
    private String email;
    private String password;

    public LoginService() {}

    public LoginService(String email, String password) {
        setEmail(email);
        setPassword(password);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    protected Task<String> createTask() {
        return new LoginTask(email, password);
    }
}
