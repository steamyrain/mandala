import com.jfoenix.controls.JFXDecorator;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.container.DefaultFlowContainer;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import util.Creator;

public class TestLabel extends Application {
    public static void main(String[] Args){launch(Args);}

    @Override
    public void start(Stage stage) throws Exception{
        /*Label label1 = Creator.createLabel("Test");
        FontAwesomeIconView icon = new FontAwesomeIconView(FontAwesomeIcon.USER);
        label1.setGraphic(icon);
        Pane pane = new Pane(label1);
        //pane.getChildren().add(label1);
        Scene scene = new Scene(pane,600,400);
        stage.setScene(scene);
        stage.show();*/
        Flow flow = new Flow(TestLoginController.class);
        ViewFlowContext context = new ViewFlowContext();
        DefaultFlowContainer container = new DefaultFlowContainer();
        flow.createHandler(context).start(container);
        JFXDecorator decorator = new JFXDecorator(stage,container.getView());
        decorator.setCustomMaximize(true);
        double width = 800;
        double height = 600;
        Scene scene = new Scene(decorator, width, height);
        stage.setScene(scene);
        stage.show();
    }
}
