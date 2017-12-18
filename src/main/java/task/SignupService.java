package task;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import model.Account;

public class SignupService extends Service<String> {
    private Account account;
    private String retypedPassword;
    public SignupService() {}
    public SignupService(Account account, String retypedPassword) {
        this.account = account;
        this.retypedPassword = retypedPassword;
    }
    public SignupService(Account account) {
        this.account = account;
    }
    public String getRetypedPassword() {
        return retypedPassword;
    }
    public void setRetypedPassword(String retypedPassword) {
        this.retypedPassword = retypedPassword;
    }
    public Account getAccount(){
        return account;
    }
    public void setAccount(Account account){
        this.account = account;
    }
    @Override
    protected Task<String> createTask() {
        return new SignupTask(account,retypedPassword);
    }
}
