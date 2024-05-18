package calculatorapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.application.Application;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalculatorApp extends Application {

    private TextField display;
    private String currentInput = "";
    private double currentResult = 0;
    private String operator = "";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simple Calculator");

        // Create a GridPane for the UI layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setHgap(5);
        grid.setVgap(5);

        // Create a TextField for the display
        display = new TextField();
        display.setEditable(false);
        display.setPrefWidth(200);
        grid.add(display, 0, 0, 4, 1);

        // Create buttons for digits and operators
        String[][] buttonLabels = {
                {"7", "8", "9", "/"},
                {"4", "5", "6", "*"},
                {"1", "2", "3", "-"},
                {"0", "C", "=", "+"}
        };

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String label = buttonLabels[i][j];
                Button button = new Button(label);
                button.setPrefWidth(50);
                button.setOnAction(e -> handleButtonClick(label));
                grid.add(button, j, i + 1);
            }
        }

        // Create the scene and set it to the stage
        Scene scene = new Scene(grid, 250, 250);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    // Implement the button click handler
    private void handleButtonClick(String value) {
        // Handle digit buttons
        if (Character.isDigit(value.charAt(0))) {
            currentInput += value;
            display.setText(currentInput);
        }

        // Handle operator buttons
        else if ("+-*/".contains(value)) {
            if (!currentInput.isEmpty()) {
                currentResult = Double.parseDouble(currentInput);
                currentInput = "";
            }
            operator = value;
        }

        // Handle "=" button
        else if ("=".equals(value)) {
            if (!currentInput.isEmpty()) {
                double secondOperand = Double.parseDouble(currentInput);
                switch (operator) {
                    case "+":
                        currentResult += secondOperand;
                        break;
                    case "-":
                        currentResult -= secondOperand;
                        break;
                    case "*":
                        currentResult *= secondOperand;
                        break;
                    case "/":
                        if (secondOperand != 0) {
                            currentResult /= secondOperand;
                        } else {
                            display.setText("Error");
                            return;
                        }
                        break;
                }
                display.setText(Double.toString(currentResult));
                currentInput = "";
            }
        }

        // Handle "C" button (clear)
        else if ("C".equals(value)) {
            currentInput = "";
            currentResult = 0;
            operator = "";
            display.setText("");
        }
    }
}