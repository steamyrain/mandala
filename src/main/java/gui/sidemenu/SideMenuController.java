package gui.sidemenu;

import com.jfoenix.controls.JFXListView;
import gui.components.BukuTamuController;
import gui.components.HomeController;
import io.datafx.controller.ViewController;
import io.datafx.controller.ViewNode;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.FlowException;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.action.ActionTrigger;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import io.datafx.controller.util.VetoException;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import util.Creator;

import javax.annotation.PostConstruct;
import java.util.Objects;

@ViewController(value="/gui/SideMenu.fxml")
public class SideMenuController {
    @FXMLViewFlowContext
    private ViewFlowContext context;

    /*@FXML
    @ActionTrigger("bukutamu")
    private Label bukutamu;*/

    @ViewNode
    private JFXListView<Label> sideList;


    @PostConstruct
    public void init() {
        Objects.requireNonNull(context, "context");
        FlowHandler contentFlowHandler = (FlowHandler) context.getRegisteredObject("ContentFlowHandler");
        sideList.propagateMouseEventsToParent();
        sideList.getSelectionModel().selectedItemProperty().addListener((o,oldVal,newVal) -> {
            new Thread(()->{
                Platform.runLater(()->{
                    if (newVal != null) {
                        try {
                            contentFlowHandler.handle(newVal.getId());
                        } catch (VetoException exc) {
                            exc.printStackTrace();
                        } catch (FlowException exc) {
                            exc.printStackTrace();
                        }
                    }
                });
            }).start();
        });
        Label bukutamu = Creator.createLabel("BukuTamu");
        Label home = Creator.createLabel("Home");
        Flow contentFlow = (Flow) context.getRegisteredObject("ContentFlow");
        context.register("bukutamu",bukutamu);
        context.register("home",home);
        sideList.getItems().addAll(bukutamu);
        sideList.getItems().addAll(home);
        bindNodeToController(bukutamu, BukuTamuController.class, contentFlow);
        bindNodeToController(home, HomeController.class,contentFlow);
    }

    private void bindNodeToController(Node node, Class<?> controllerClass, Flow flow) {
        flow.withGlobalLink(node.getId(), controllerClass);
    }
}
