import io.datafx.controller.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javax.annotation.PostConstruct;

@ViewController(value= "/endView.fxml",title="End")
public class EndController extends ActionController{
    @FXML
    private Button nextButton;
    @PostConstruct
    public void init(){
        nextButton.setDisable(true);
        getFinishButton().setDisable(true);
    }
}