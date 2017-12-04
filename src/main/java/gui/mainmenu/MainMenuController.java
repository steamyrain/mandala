package gui.mainmenu;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import datafx.ExtendedAnimatedFlowContainer;
import gui.components.BukuTamuController;
import gui.sidemenu.SideMenuController;
import io.datafx.controller.ViewController;
import io.datafx.controller.ViewNode;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
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

    @PostConstruct
    public void init()throws Exception{
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
        context = new ViewFlowContext();
        Flow innerFlow = new Flow(BukuTamuController.class);

        final FlowHandler flowHandler = innerFlow.createHandler(context);
        context.register("ContentFlowHandler",flowHandler);
        context.register("ContentFlow",innerFlow);
        final Duration containerAnimationDuration = Duration.millis(320);
        drawer.setContent(flowHandler.start(new ExtendedAnimatedFlowContainer(containerAnimationDuration, SWIPE_LEFT)));
        context.register("ContentPane",drawer.getContent().get(0));
        Flow sideMenuFlow = new Flow(SideMenuController.class);
        final FlowHandler sideMenuFlowHandler = sideMenuFlow.createHandler(context);
        drawer.setSidePane(sideMenuFlowHandler.start(new ExtendedAnimatedFlowContainer(containerAnimationDuration, SWIPE_LEFT)));
    }

}
