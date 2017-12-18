package gui.mainmenu;

import com.jfoenix.controls.*;
import com.jfoenix.svg.SVGGlyph;
import com.jfoenix.svg.SVGGlyphLoader;
import datafx.ExtendedAnimatedFlowContainer;
import gui.components.BukuTamuController;
import gui.components.LoginController;
import gui.components.ProfileController;
import gui.sidemenu.SideMenuController;
import io.datafx.controller.ViewController;
import io.datafx.controller.ViewNode;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.FlowException;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.animation.Transition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import model.Chosen;
import util.Creator;

import javax.annotation.PostConstruct;

import static io.datafx.controller.flow.container.ContainerAnimations.SWIPE_LEFT;

@ViewController(value="/gui/MainMenu.fxml")
public final class MainMenuController {
    @FXMLViewFlowContext
    private ViewFlowContext context;
    @FXML
    private StackPane root;
    @FXML
    private StackPane optionsBurger;
    @FXML
    private StackPane titleBurgerContainer;
    @FXML
    private JFXHamburger titleBurger;
    @FXML
    private JFXDrawer drawer;

    private FlowHandler sideBarFlowHandler;;
    private FlowHandler innerFlowHandler;
    private Flow innerFlow;
    final Duration containerAnimationDuration = Duration.millis(320);
    private JFXPopup toolbarPopup;
    @PostConstruct
    public void init()throws Exception{
        initRightToolbar();
        innerFlow = new Flow(LoginController.class);
        innerFlowHandler = innerFlow.createHandler(context);
        initCenter();
        initSideBar();
    }
    private void initRightToolbar() throws Exception{
        //TODO ADD TOOLBAR
        context.register("OptionsBurger",optionsBurger);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/popup/UserPopUp.fxml"));
        loader.setController(new InputController());
        toolbarPopup = new JFXPopup(loader.load());

        optionsBurger.setOnMouseClicked(e -> toolbarPopup.show(optionsBurger,
                JFXPopup.PopupVPosition.TOP,
                JFXPopup.PopupHPosition.RIGHT,
                -12,
                65));
    }

    private void initCenter() throws FlowException {
        context.register("ContentFlowHandler",innerFlowHandler);
        context.register("ContentFlow",innerFlow);
        drawer.setContent(innerFlowHandler.start(new ExtendedAnimatedFlowContainer(containerAnimationDuration, SWIPE_LEFT)));;
    }

    private void initSideBar() throws FlowException {
        Flow sideBarFlow = new Flow(SideMenuController.class);
        context.register("SideBarFlow", sideBarFlow);
        context.register("SideBar",drawer);
        context.register("ContentPane",drawer.getContent().get(0));
        sideBarFlowHandler = sideBarFlow.createHandler(context);
        drawer.setSidePane(sideBarFlowHandler.start(new ExtendedAnimatedFlowContainer(containerAnimationDuration, SWIPE_LEFT)));
        drawer.setOnDrawerOpening(e -> {
            final Transition animation = titleBurger.getAnimation();
            animation.setRate(1);
            animation.play();
        });
        drawer.setOnDrawerClosing(e -> {
            final Transition animation = titleBurger.getAnimation();
            animation.setRate(-1);
            animation.play();
        });
        titleBurgerContainer.setOnMouseClicked(e -> {
            if (drawer.isHidden() || drawer.isHiding()) {
                drawer.open();
            } else {
                drawer.close();
            }
        });
    }
    private void clearAfterLogout() {
        Chosen.sleep();
        Chosen.goTo(LoginController.class);
        JFXListView sideList= (JFXListView) context.getRegisteredObject("SideList");
        if (sideList != null) {
            sideList.getItems().clear();
            Label loginLabel = (Label) context.getRegisteredObject("Login");
            Label signupLabel = (Label) context.getRegisteredObject("SignUp");
            sideList.getItems().addAll(loginLabel,signupLabel);
        }
    }

    public final class InputController {
        @FXML
        private JFXListView<?> toolbarPopupList;

        @FXML
        private void submit() {
            if (toolbarPopupList.getSelectionModel().getSelectedIndex() == 0) {
                Chosen.goTo(ProfileController.class);
            }
            if (toolbarPopupList.getSelectionModel().getSelectedIndex() == 1) {
                clearAfterLogout();
            }
            if (toolbarPopupList.getSelectionModel().getSelectedIndex() == 2) {
                Platform.exit();
            }
        }
    }
}
