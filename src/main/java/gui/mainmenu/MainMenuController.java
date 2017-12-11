package gui.mainmenu;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.svg.SVGGlyph;
import com.jfoenix.svg.SVGGlyphLoader;
import datafx.ExtendedAnimatedFlowContainer;
import gui.components.BukuTamuController;
import gui.components.LoginController;
import gui.sidemenu.SideMenuController;
import io.datafx.controller.ViewController;
import io.datafx.controller.ViewNode;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.FlowException;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import javax.annotation.PostConstruct;

import static io.datafx.controller.flow.container.ContainerAnimations.SWIPE_LEFT;

@ViewController(value="/gui/MainMenu.fxml")
public final class MainMenuController {
    @FXMLViewFlowContext
    private ViewFlowContext context;
    @FXML
    private StackPane root;
    @FXML
    private StackPane titleBurgerContainer;
    @FXML
    private JFXHamburger titleBurger;
    @FXML
    private JFXDrawer drawer;

    private FlowHandler sideBarFlowHandler;
    private FlowHandler innerFlowHandler;
    private Flow innerFlow;
    final Duration containerAnimationDuration = Duration.millis(320);
    @PostConstruct
    public void init()throws Exception{
        innerFlow = new Flow(LoginController.class);
        innerFlowHandler = innerFlow.createHandler(context);
        initCenter();
        initSideBar();
    }
    private void initToolbar() {
        //TODO ADD TOOLBAR
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

}
