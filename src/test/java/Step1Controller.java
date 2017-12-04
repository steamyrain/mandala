import io.datafx.controller.ViewController;
import io.datafx.controller.flow.action.LinkAction;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javax.annotation.PostConstruct;

@ViewController(value= "/step1View.fxml",title="Step 1")
public class Step1Controller extends ActionController{

    @FXML
    @LinkAction(Step2Controller.class)
    private Button nextButton;

    @PostConstruct
    public void init(){
        getBackButton();
        getFinishButton();
    }
}