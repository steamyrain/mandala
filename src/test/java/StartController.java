import io.datafx.controller.ViewController;
import io.datafx.controller.flow.action.LinkAction;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javax.annotation.PostConstruct;

@ViewController(value= "/startView.fxml",title="Start")
public class StartController extends ActionController{

    @FXML
    @LinkAction(Step1Controller.class)
    private Button nextButton;

    @PostConstruct
    public void init(){
        getBackButton().setDisable(true);
        getFinishButton();
    }
}
