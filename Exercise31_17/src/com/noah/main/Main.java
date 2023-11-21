package com.noah.main;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.effect.ColorAdjust;

public class Main extends Application {
	private double futureValue;
	@Override
	public void start(Stage stage) {
		
		TextField investmentAmountInput = new TextField();
		TextField numberOfYearsInput = new TextField();
		TextField annualInterestRateInput = new TextField();
		TextField futureValueInput = new TextField();
		
		Label investmentAmountLabel = new Label("Investment Amount:");
		Label numberOfYearsLabel = new Label("Number of Years:");
		Label annualInterestRateLabel = new Label("Annual Interest Rate:");
		Label futureValueLabel = new Label("Future Value:");
		
		ColorAdjust colorAdjust = new ColorAdjust();
		colorAdjust.setBrightness(0.0);
		
		ComboBox<String> dropDown = new ComboBox();
		dropDown.getStyleClass().add("dropDown");
		dropDown.getItems().addAll("Calculate","Exit");
		dropDown.setValue("Operation");
		dropDown.setEffect(colorAdjust);
		
		dropDown.setOnAction((e) -> {
			if(dropDown.getValue().equals("Exit")) {
				handleExit();
			} else if(dropDown.getValue().equals("Calculate")) {
				handleCalculate(Double.parseDouble(investmentAmountInput.getText()), Integer.parseInt(numberOfYearsInput.getText()), Double.parseDouble(annualInterestRateInput.getText()));
				futureValueInput.setText("$" + String.format("%.2f", futureValue));
			}
		});
		
		Button calculateBtn = new Button("Calculate");
		calculateBtn.getStyleClass().add("calculateBtn");
		calculateBtn.setOnMouseClicked((e) -> {
			handleCalculate(Double.parseDouble(investmentAmountInput.getText()), Integer.parseInt(numberOfYearsInput.getText()), Double.parseDouble(annualInterestRateInput.getText()));
			futureValueInput.setText("$" + String.format("%.2f", futureValue));
		});
		
		HBox top = new HBox();
		top.getStyleClass().add("top");
		top.getChildren().add(dropDown);
		
		VBox right = new VBox();
		right.getStyleClass().add("right");
		right.getChildren().addAll(
				investmentAmountInput,
				numberOfYearsInput,
				annualInterestRateInput,
				futureValueInput,
				calculateBtn
		);
		right.setMargin(calculateBtn, new Insets(0,0,0,90));
		
		VBox left = new VBox();
		left.getStyleClass().add("left");
		left.getChildren().addAll(
				investmentAmountLabel,
				numberOfYearsLabel,
				annualInterestRateLabel,
				futureValueLabel
		);

		
		BorderPane pane = new BorderPane();
		pane.setTop(top);
		pane.setRight(right);
		pane.setLeft(left);
		
		Scene scene = new Scene(pane, 300, 200);
		scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
		
		stage.setScene(scene);
		stage.setTitle("Exercise31_17");
		stage.show();
	}
	public void handleCalculate(double investmentAmount, int numberOfYears, double annualInterestRate) {
		Calculate calculate = new Calculate(investmentAmount, numberOfYears, annualInterestRate);
		futureValue = calculate.getFutureValue();
	}
	public void handleExit() {
		System.exit(0);
	}
	public static void main(String[] args) {
		launch();
	}
}
