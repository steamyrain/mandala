package gui.sidemenu;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXListView;
import gui.components.*;
import io.datafx.controller.ViewController;
import io.datafx.controller.ViewNode;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.FlowException;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import io.datafx.controller.util.VetoException;
import javafx.application.Platform;
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
        Label profile = Creator.createLabel("Profile");
        Label login = Creator.createLabel("Login");
        Label signUp = Creator.createLabel("Sign Up");
        Label adminPanel = Creator.createLabel("Admin Panel");
        Label galeriAktivitas = Creator.createLabel("Galeri");
        Label galeriNaskah = Creator.createLabel("Naskah");
        Label hasilPenelitian = Creator.createLabel("Hasil Penelitian");
        Label tentangKami = Creator.createLabel("Tentang Kami");
        Label permainan = Creator.createLabel("Permainan");
        context.register("AdminPanel",adminPanel);
        context.register("Daftar",daftar);
        context.register("Profile",profile);
        context.register("Login",login);
        context.register("SideList",sideList);
        context.register("SignUp",signUp);
        context.register("HasilPenelitian",hasilPenelitian);
        context.register("GaleriAktivitas",galeriAktivitas);
        context.register("GaleriNaskah",galeriNaskah);
        context.register("TentangKami",tentangKami);
        context.register("Permainan",permainan);
        sideList.getItems().addAll(login,signUp);

        bindNodeToController(login, LoginController.class,contentFlow);
        bindNodeToController(adminPanel,AdminPanelController.class,contentFlow);
        bindNodeToController(daftar, BukuTamuController.class,contentFlow);
        bindNodeToController(profile, ProfileController.class,contentFlow);
        bindNodeToController(signUp, SignUpFormController.class,contentFlow);
        bindNodeToController(galeriAktivitas, GaleriAktivitasController.class,contentFlow);
        bindNodeToController(galeriNaskah, GaleriNaskahController.class,contentFlow);
        bindNodeToController(hasilPenelitian, HasilPenelitianController.class,contentFlow);
        bindNodeToController(tentangKami, TentangKamiController.class,contentFlow);
        bindNodeToController(SignUpFormController.class,contentFlow);
        bindNodeToController(LoginFormController.class,contentFlow);
        bindNodeToController(LoginController.class,contentFlow);
        bindNodeToController(ProfileController.class,contentFlow);
    }

    private void bindNodeToController(Node node, Class controllerClass, Flow flow) {
        flow.withGlobalLink(node.getId(), controllerClass);
    }
    private void bindNodeToController(Class controllerClass, Flow flow) {
        flow.withGlobalLink(controllerClass.getSimpleName(), controllerClass);
    }
}
