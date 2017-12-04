package util;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;

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
    public static boolean isEmpty(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        return false;
    }
}
