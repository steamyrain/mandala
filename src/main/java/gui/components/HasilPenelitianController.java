package gui.components;

import com.jfoenix.controls.JFXMasonryPane;
import com.jfoenix.controls.JFXScrollPane;
import com.jfoenix.effects.JFXDepthManager;
import io.datafx.controller.ViewController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

@ViewController(value="/gui/components/HasilPenelitian.fxml")
public class HasilPenelitianController {
    @FXML
    private JFXMasonryPane masonry;

    @FXML
    private ScrollPane scrollPane;
    @PostConstruct
    public void init(){
        ArrayList<Node> children = new ArrayList<>();
        String path = "D:\\Projects\\DataRiset\\";
        File folder = new File(path);
        Integer i = 0;
        File[] listOfFiles = folder.listFiles();
        for (final File file : listOfFiles) {
            ImageView imageView;
            imageView = createImageView(file);
            StackPane child = new StackPane();
            double width = imageView.getFitWidth();
            child.setMinWidth(width);
            child.setMaxWidth(width);
            child.setPrefWidth(width);

            double height = imageView.getFitHeight() + 100;
            child.setMinHeight(height);
            child.setMaxHeight(height);
            child.setPrefHeight(height);
            JFXDepthManager.setDepth(child, 1);
            children.add(child);
            // create content
            StackPane header = new StackPane();
            header.getChildren().add(imageView);
            VBox.setVgrow(header, Priority.ALWAYS);
            StackPane body = new StackPane();
            Label title = new Label("\t\t\t\t\tSEWAKA DARMA \n dalam Naskah Tradisi Sunda Kuno Abad XV-XVII Masehi");
            Label abstrak = new Label("\tTesis " +
                    "ini berjudul Kisah Putra Rama dan Rawana Abad XV Masehi : Rekonstruksi Teks yang Tercecer. " +
                    "\nPenelitian dilakukan terhadap tiga naskah Kisah Putra Rama dan Rawana (PRR) dari koleksi " +
                    "\nMuseum Negeri Jawa Barat \" Sri Baduga \" dan koleksi Kabuyutan Ciburuy Kabupaten Garut . " +
                    "\nNaskah koleksi Museum Negeri Jawa Barat \"Sri Baduga\" masih tersimpan dalam satu kropak " +
                    "\ndengan kode koleksi MSB. Naskah ini pernah dibuat edisi standar oleh Noorduyn dan Teeuw pada tahun " +
                    "\n2006 yang diterbitkan dengan judul Kisah Putra Rama dan Rawana.");
            body.getChildren().add(abstrak);
            body.setMinWidth(width);
            body.setMinHeight(Math.random() * 20 + 50);
            VBox content = new VBox();
            content.getChildren().addAll(title,header, body);
            String bodyColor = getDefaultColor(i % 12);
            child.setStyle("-fx-background-radius: 5 5 0 0;-fx-background-color: "+bodyColor);
            body.setStyle("-fx-background-radius: 0 0 5 5;-fx-background-color: " + bodyColor+";");
            child.getChildren().add(content);
            i++;
        }
        masonry.getChildren().addAll(children);
        Platform.runLater(() -> scrollPane.requestLayout());
        JFXScrollPane.smoothScrolling(scrollPane);
    }
    private ImageView createImageView(final File imageFile) {
        // DEFAULT_THUMBNAIL_WIDTH is a constant you need to define
        // The last two arguments are: preserveRatio, and use smooth (slower)
        // resizing

        ImageView imageView = null;
        try {
            final Image image = new Image(new FileInputStream(imageFile), 250, 0, true,
                    true);
            imageView = new ImageView(image);
            imageView.setFitWidth(image.getWidth());
            imageView.setFitHeight(image.getHeight());
            imageView.setSmooth(true);
            imageView.setPreserveRatio(true);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return imageView;
    }
    private String getDefaultColor(int i) {
        String color = "#FFFFFF";
        switch (i) {
            case 0:
                color = "#8F3F7E";
                break;
            case 1:
                color = "#B5305F";
                break;
            case 2:
                color = "#CE584A";
                break;
            case 3:
                color = "#DB8D5C";
                break;
            case 4:
                color = "#DA854E";
                break;
            case 5:
                color = "#E9AB44";
                break;
            case 6:
                color = "#FEE435";
                break;
            case 7:
                color = "#99C286";
                break;
            case 8:
                color = "#01A05E";
                break;
            case 9:
                color = "#4A8895";
                break;
            case 10:
                color = "#16669B";
                break;
            case 11:
                color = "#2F65A5";
                break;
            case 12:
                color = "#4E6A9C";
                break;
            default:
                break;
        }
        return color;
    }
}
