import io.datafx.controller.ViewController;
import io.datafx.controller.flow.action.LinkAction;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

@ViewController(value = "/View2.fxml")
public class View2Controller {
    @FXML
    @LinkAction(View1Controller.class)
    private Button actionButton;
}
