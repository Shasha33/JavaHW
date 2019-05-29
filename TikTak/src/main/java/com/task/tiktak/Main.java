package com.task.tiktak;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;

import java.util.*;

import static javafx.application.Application.launch;

public class Main extends Application {

    private static final int sizeX = 800;
    private static final int sizeY = 800;

    @Override
    public void start(Stage stage) {
        List<String> args = getParameters().getRaw();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("congratulations");
        alert.setHeaderText("You gave incorrect command line parameter");
        alert.setContentText("It should be even positive number\nParameter will be set to 2");

        int param;
        try {
            if (args.size() != 1 || Integer.parseInt(args.get(0)) % 2 != 0 || Integer.parseInt(args.get(0)) < 2) {
                alert.showAndWait();
                param = 2;
            } else {
                param = Integer.parseInt(args.get(0));
            }
        } catch (Exception e) {
            alert.showAndWait();
            param = 2;
        }


        Controller controller = new Controller(param, sizeX, sizeY);


        stage.setScene(new Scene(controller.getGridPane(), sizeX, sizeY));
        stage.setTitle("pairs");
        stage.show();
    }

    public static void main(String... args) {
        launch(args);
    }
}
