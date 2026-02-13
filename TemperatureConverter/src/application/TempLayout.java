package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class TempLayout extends VBox {

    public TempLayout() {

        this.setSpacing(15);
        this.setPadding(new Insets(20));
        this.setAlignment(Pos.CENTER);

        Label prompt = new Label("Enter Temperature:");
        TextField inputField = new TextField();
        inputField.setMaxWidth(200); 

        ComboBox<String> unitBox = new ComboBox<>();
        unitBox.getItems().addAll("Fahrenheit", "Celsius", "Kelvin");
        unitBox.setValue("Fahrenheit"); // Default selection

        Button convertBtn = new Button("Convert");

        Label resultLabel = new Label("Results will appear here");
        resultLabel.setTextAlignment(TextAlignment.CENTER);
        resultLabel.setFont(Font.font("Roboto", FontWeight.BOLD, 14));

        convertBtn.setOnAction(e -> {
            try {
            	String text = inputField.getText();
            	
            	if (text.isEmpty() || text.equals("-")) {
            		throw new NumberFormatException("Empty");
            	}
            	
            	if ((text.startsWith("0") && text.length() > 1) || (text.startsWith("-0") && text.length() > 2)) {
            		throw new NumberFormatException("Leading Zero Detected");
            	}

                int input = Integer.parseInt(inputField.getText());
                String unit = unitBox.getValue();
                
                int f = 0;
                int c = 0;
                int k = 0;

                switch (unit) {
                
                	case "Fahrenheit":
                		f = input;
                		c = TempConverter.fahrenheitToCelsius(f);
                		k = TempConverter.celsiusToKelvin(c);
                		break;
                		
                    case "Celsius":
                        c = input;
                        f = TempConverter.celsiusToFahrenheit(c);
                        k = TempConverter.celsiusToKelvin(c);
                        break;
                        
                    case "Kelvin":
                        k = input;
                        c = TempConverter.kelvinToCelsius(k);
                        f = TempConverter.celsiusToFahrenheit(c);
                        break;
                }

                String status = TempClassifier.classify(f);
                
                Color color = TempColor.getColor(status);

                resultLabel.setText(
                	"U.S. System: " + f + " °F\n" +
                    "Metric System: " + c + " °C\n" +
                    "Science: " + k + " K\n\n" +
                    "Status: " + status
                );

                this.setBackground(new Background(new BackgroundFill(
                    color, 
                    CornerRadii.EMPTY, 
                    Insets.EMPTY
                )));

                if (status.equals("Hot") || status.equals("Frigid") || status.equals("Cold") || status.equals("Furnace")) {
                    resultLabel.setTextFill(Color.WHITE);
                    prompt.setTextFill(Color.WHITE);
                } else {
                    resultLabel.setTextFill(Color.BLACK);
                    prompt.setTextFill(Color.BLACK);
                }

            } catch (NumberFormatException ex) {
            	
            	if (ex.getMessage() !=null && ex.getMessage().equals("Leading Zero Detected")) {
            		resultLabel.setText("Error: Leading zeros are not allowed!");
            	}
            	else {
            		resultLabel.setText("Error: Please enter a valid whole number!");
            	}
            }
        });

        this.getChildren().addAll(prompt, inputField, unitBox, convertBtn, resultLabel);
    }
}
