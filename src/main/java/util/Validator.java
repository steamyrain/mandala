package util;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.skins.JFXTabPaneSkin;
import com.jfoenix.validation.RequiredFieldValidator;
import com.jfoenix.validation.ValidationFacade;

public class Validator {
    private static String validatorMessage = "Input required";

    public static void addValidator(JFXTextField textField) {
        RequiredFieldValidator validator = new RequiredFieldValidator();
        validator.setMessage(validatorMessage);
        textField.getValidators().add(validator);
        textField.focusedProperty().addListener((o,oldVal,newVal) -> {
            if (!newVal) textField.validate();
        });
    }
    /*public static void addValidator(JFXComboBox comboBox) {
        RequiredFieldValidator validator = new RequiredFieldValidator();
        validator.setMessage(validatorMessage);
        ValidationFacade validationFacade = new ValidationFacade();
        validationFacade.setControl(comboBox);
        validationFacade.getValidators().add(validator);
        comboBox.focusedProperty().addListener((o,oldVal,newVal) -> {
            if (!newVal) validationFacade.setOnKeyPressed();
        });
    }*/
    public static void addValidator(JFXPasswordField passwordField) {
        RequiredFieldValidator validator = new RequiredFieldValidator();
        validator.setMessage(validatorMessage);
        passwordField.getValidators().add(validator);
        passwordField.focusedProperty().addListener((o,oldVal,newVal) -> {
            if (!newVal) passwordField.validate();
        });
    }
    public static boolean isEmpty(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        return false;
    }
    public static boolean isEmpty(Integer i) {
        if (i == null || i+1<=0) {
            return true;
        }

        return false;
    }
}
