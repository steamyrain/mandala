package model;

import io.datafx.controller.flow.FlowException;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.context.ViewFlowContext;
import io.datafx.controller.util.VetoException;

public class Chosen {
    private static Account account;
    private static ViewFlowContext context;

    public static void sleep() {
        setAccount(null);
    }

    public static void setAccount(Account account) {
        System.out.println("An account has registered: " + account);
        Chosen.account = account;
    }

    public static Account getAccount() {
        return account;
    }

    public static boolean isRegistered() {
        return account != null;
    }

    public static void disposeAll() {
        if (account == null) return;

        account.dispose();
    }

    public static void setViewFlowContext(ViewFlowContext context) {
        Chosen.context = context;
    }

    public static void goTo(Class controller) {
        String controllerName = controller.getSimpleName();
        FlowHandler centerFlowHandler = (FlowHandler)Chosen.context.getRegisteredObject("ContentFlowHandler");
        try {
            centerFlowHandler.handle(controllerName);
        } catch (VetoException e) {
            e.printStackTrace();
        } catch (FlowException e) {
            e.printStackTrace();
        }
        System.out.println("FINISHED LOADING: " + controllerName); //TODO -del
    }
    public static void goTo(String actionID) {
        FlowHandler contentFlowHandler = (FlowHandler)Chosen.context.getRegisteredObject("ContentFlowHandler");
        try {
            contentFlowHandler.handle(actionID);
        } catch (VetoException e) {
            e.printStackTrace();
        } catch (FlowException e) {
            e.printStackTrace();
        }
        System.out.println("FINISHED LOADING: " + actionID); //TODO -del
    }
}
