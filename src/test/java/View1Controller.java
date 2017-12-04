import io.datafx.controller.ViewController;
import io.datafx.controller.flow.action.LinkAction;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

@ViewController(value = "/View1.fxml")
public class View1Controller {
    @FXML
    @LinkAction(View2Controller.class)
    private Button actionButton;
}
