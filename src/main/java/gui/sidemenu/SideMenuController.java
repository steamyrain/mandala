package gui.sidemenu;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXListView;
import gui.components.BukuTamuController;
import gui.components.HomeController;
import gui.components.LoginController;
import gui.components.LoginFormController;
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

    @ViewNode
    private JFXListView<Label> sideList;


    @PostConstruct
    public void init() {
        Objects.requireNonNull(context, "context");
        sideList.propagateMouseEventsToParent();

        Flow contentFlow = (Flow) context.getRegisteredObject("ContentFlow");
        FlowHandler contentFlowHandler = (FlowHandler) context.getRegisteredObject("ContentFlowHandler");
        JFXDrawer drawer = (JFXDrawer)context.getRegisteredObject("SideBar");
        sideList.getSelectionModel().selectedItemProperty().addListener((o,oldVal,newVal) -> {
            new Thread(()->{
                Platform.runLater(()->{
                    if (newVal != null) {
                        System.out.println(newVal);
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

        Label daftar = Creator.createLabel("Daftar");
        Label profile = Creator.createLabel("Home");
        Label login = Creator.createLabel("Login");
        //Label loginForm = Creator.createLabel("Login Form");
        context.register("Daftar",daftar);
        context.register("Profile",profile);
        context.register("Login",login);
        context.register("SideList",sideList);

        sideList.getItems().addAll(login,daftar);

        bindNodeToController(login, LoginController.class,contentFlow);
        bindNodeToController(daftar, BukuTamuController.class,contentFlow);
        bindNodeToController(profile, HomeController.class,contentFlow);
        //bindNodeToController(loginForm,LoginFormController.class,contentFlow);
        bindNodeToController(LoginFormController.class,contentFlow);
        bindNodeToController(HomeController.class,contentFlow);
    }

    private void bindNodeToController(Node node, Class controllerClass, Flow flow) {
        flow.withGlobalLink(node.getId(), controllerClass);
    }
    private void bindNodeToController(Class controllerClass, Flow flow) {
        flow.withGlobalLink(controllerClass.getSimpleName(), controllerClass);
    }
}
