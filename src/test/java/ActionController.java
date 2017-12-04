import io.datafx.controller.flow.action.BackAction;
import io.datafx.controller.flow.action.LinkAction;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ActionController {
    @FXML
    @BackAction
    private Button backButton;

    @FXML
    @LinkAction(EndController.class)
    private Button finishButton;

    public Button getBackButton() {
        return backButton;
    }

    public Button getFinishButton() {
        return finishButton;
    }
}
