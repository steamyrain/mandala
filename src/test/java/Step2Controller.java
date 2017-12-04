import io.datafx.controller.ViewController;
import io.datafx.controller.flow.action.LinkAction;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javax.annotation.PostConstruct;
@ViewController(value="/step2View.FXML",title = "Step 2")
public class Step2Controller extends ActionController{
    @FXML
    @LinkAction(EndController.class)
    private Button nextButton;
    @PostConstruct
    public void init(){
        getBackButton();
        getFinishButton();
    }
}
