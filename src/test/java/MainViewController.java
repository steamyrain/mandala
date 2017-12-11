import io.datafx.controller.ViewController;
import io.datafx.controller.ViewNode;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.FlowException;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.action.ActionMethod;
import io.datafx.controller.flow.action.ActionTrigger;
import io.datafx.controller.flow.container.AnimatedFlowContainer;
import io.datafx.controller.flow.container.ContainerAnimations;
import io.datafx.controller.flow.context.ViewFlowContext;
import io.datafx.controller.util.VetoException;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import org.junit.Test;

import javax.annotation.PostConstruct;

@ViewController(value = "MainView.fxml")
public class MainViewController {
    @ViewNode
    private StackPane centerPane;

    @ViewNode
    @ActionTrigger("back")
    private Button backButton;

    @ViewNode
    @ActionTrigger("next")
    private Button nextButton;

    @ViewNode
    @ActionTrigger("finish")
    private Button finishButton;

    @ViewNode
    private ViewFlowContext context;

    private FlowHandler flowHandler;
    @PostConstruct
    public void init()throws FlowException{
        context = new ViewFlowContext();
        Flow inner = new Flow(Step1stController.class)
                .withLink(Step1stController.class,"next",TestLoginController.class)
                .withLink(TestLoginController.class,"next",Step3rdController.class);
        flowHandler = inner.createHandler(context);
        centerPane.getChildren().add(flowHandler.start(new AnimatedFlowContainer(Duration.millis(320), ContainerAnimations.ZOOM_IN)));

    }
    @ActionMethod("back")
    public void onBack() throws VetoException, FlowException {
        flowHandler.navigateBack();
        if(flowHandler.getCurrentViewControllerClass().equals(Step1stController.class)) {
            backButton.setDisable(true);
        } else {
            backButton.setDisable(false);
        }
        finishButton.setDisable(false);
        nextButton.setDisable(false);
    }

    @ActionMethod("next")
    public void onNext() throws VetoException, FlowException {
        flowHandler.handle("next");
        if(flowHandler.getCurrentViewControllerClass().equals(Step3rdController.class)) {
            nextButton.setDisable(true);
            finishButton.setDisable(true);
        } else {
            nextButton.setDisable(false);
        }
        backButton.setDisable(false);
    }

    @ActionMethod("finish")
    public void onFinish() throws VetoException, FlowException {
        flowHandler.navigateTo(Step3rdController.class);
        finishButton.setDisable(true);
        nextButton.setDisable(true);
        backButton.setDisable(false);
    }
}
