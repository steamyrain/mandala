package gui.components;

import io.datafx.controller.ViewController;
import io.datafx.controller.ViewNode;
import io.datafx.controller.flow.action.ActionMethod;
import io.datafx.controller.flow.action.ActionTrigger;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import model.Chosen;

import javax.annotation.PostConstruct;

@ViewController(value="/gui/components/Login.fxml")
public class LoginController {
    @FXML
    private VBox loginVBox;
    @FXML
    @ActionTrigger("loginPublic")
    private VBox publoginVBox;
    @FXML
    private VBox resloginVBox;
    @FXML
    private VBox admloginVBox;
    @FXMLViewFlowContext
    private ViewFlowContext context;
    private StackPane optionsBurger;
    @PostConstruct
    public void init(){
        optionsBurger = (StackPane)context.getRegisteredObject("OptionsBurger");
        optionsBurger.setVisible(false);
    }
    @FXML
    private void LoginPublic(){
        //TODO
        Chosen.setViewFlowContext(context);
        Chosen.goTo(LoginFormController.class);
    }
    @FXML
    private void LoginResearcher(){
        //TODO
        Chosen.setViewFlowContext(context);
        Chosen.goTo(LoginFormController.class);
    }
    @FXML
    private void LoginAdmin(){
        //TODO
        Chosen.setViewFlowContext(context);
        Chosen.goTo(LoginFormController.class);
    }
}
