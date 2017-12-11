package util;

import javafx.scene.control.Label;

public class Creator {
    public static Label createLabel(String name){
        Label label = new Label(name);
        label.setId(name.trim());
        return label;
    }
}
