import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Account;
import model.Chosen;

public class TestBidirectionalBind extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Account account = new Account();
        account.setEmail("samba@gmail.com");
        Chosen.setAccount(account);
        //Account buffAcc = Account.createAcc(Chosen.getAccount());
        JFXTextField email = new JFXTextField();
        Label show = new Label();
        show.textProperty().bind(Chosen.getAccount().emailProperty());
        email.setPrefWidth(50.0);
        //email.textProperty().bindBidirectional(Chosen.getAccount().emailProperty());
        BorderPane root = new BorderPane();
        VBox box = new VBox();
        box.getChildren().addAll(email,show);
        box.setAlignment(Pos.CENTER);
        box.setSpacing(20);
        box.setPrefWidth(50);
        root.setCenter(box);
        Chosen.getAccount().emailProperty().addListener((o,oldVal,newVal)->
        {
            System.out.println((String) newVal);
        });
        Scene scene = new Scene(root,400,400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
