package gui.sidemenu;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXListView;
import gui.components.BukuTamuController;
import gui.components.HomeController;
import gui.components.LoginController;
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
        Flow contentFlow = (Flow) context.getRegisteredObject("ContentFlow");
        JFXDrawer drawer = (JFXDrawer)context.getRegisteredObject("SideBar");
        sideList.propagateMouseEventsToParent();
        /*sideList.getSelectionModel().selectedItemProperty().addListener((o,oldVal,newVal) -> {
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
        });*/
        Label bukuTamu = Creator.createLabel("BukuTamu");
        Label home = Creator.createLabel("Home");
        Label login = Creator.createLabel("Login");
        context.register("BukuTamu",bukuTamu);
        context.register("Home",home);
        context.register("Login",login);
        context.register("SideList",sideList);
        sideList.getItems().addAll(bukuTamu);
        bindNodeToController(bukuTamu, LoginController.class, contentFlow,contentFlowHandler,drawer);
        bindNodeToController(bukuTamu, BukuTamuController.class, contentFlow,contentFlowHandler,drawer);
        bindNodeToController(home, HomeController.class,contentFlow,contentFlowHandler,drawer);
    }

    private void bindNodeToController(Node node, Class<?> controllerClass, Flow flow,FlowHandler flowHandler,JFXDrawer drawer) {
        flow.withGlobalLink(controllerClass.getSimpleName(), controllerClass);
        node.setOnMouseClicked((e)->{
            try{
                flowHandler.handle(controllerClass.getSimpleName());
                drawer.close();
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        });
    }
}
