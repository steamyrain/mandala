package task;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class LoginService extends Service<String>{
    private String email;
    private String password;
    private String role;
    public LoginService() {}

    public LoginService(String email, String password,String role) {
        setEmail(email);
        setPassword(password);
        setRole(role);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole(){ return role;}

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role){this.role = role;}

    @Override
    protected Task<String> createTask() {
        return new LoginTask(email, password, role);
    }
}
