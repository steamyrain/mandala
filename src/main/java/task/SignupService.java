package task;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import model.Account;

public class SignupService extends Service<String> {
    private Account account;

    public SignupService() {}

    public SignupService(Account account) {
        this.account = account;
    }
    public Account getAccount(){
        return account;
    }
    public void setAccount(Account account){
        this.account = account;
    }
    @Override
    protected Task<String> createTask() {
        return new SignupTask(account);
    }
}
