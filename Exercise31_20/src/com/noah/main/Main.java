package com.noah.main;

import javafx.application.Application;
import javafx.scene.control.ToggleGroup;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.*;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {   
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {  
	  
	RadioButton topRadio = new RadioButton("Top");
	RadioButton bottomRadio = new RadioButton("Bottom");
	RadioButton leftRadio = new RadioButton("Left");
	RadioButton rightRadio = new RadioButton("Right");
	
	ToggleGroup tg = new ToggleGroup();
	tg.getToggles().addAll(topRadio, bottomRadio, leftRadio, rightRadio);
	
	HBox radioPane = new HBox();
	radioPane.getChildren().addAll(topRadio, bottomRadio, leftRadio, rightRadio);
	radioPane.setAlignment(Pos.BOTTOM_CENTER);
	radioPane.getStyleClass().add("radioPane");
	  
	StackPane pane1 = new StackPane();
	pane1.getChildren().add(new Line(10, 10, 80, 80));
	pane1.getChildren().add(radioPane);
	    
    TabPane tabPane = new TabPane();
    Tab tab1 = new Tab("Line");
    tab1.setContent(pane1);
    Tab tab2 = new Tab("Rectangle");
    tab2.setContent(new Rectangle(10, 10, 200, 200));
    Tab tab3 = new Tab("Circle");
    tab3.setContent(new Circle(50, 50, 20));
    Tab tab4 = new Tab("Ellipse");
    tab4.setContent(new Ellipse(10, 10, 100, 80));
    tabPane.getTabs().addAll(tab1, tab2, tab3, tab4);
    
    BorderPane p2 = new BorderPane();
    p2.setCenter(tabPane);
    p2.setBottom(radioPane);
    
    leftRadio.setOnAction(e -> {
    	p2.getChildren().remove(tabPane);
    	p2.setLeft(tabPane);
    	tabPane.setSide(Side.LEFT);
    	p2.getChildren().remove(radioPane);
    	p2.setBottom(radioPane);
    });
    rightRadio.setOnAction(e -> {
    	p2.getChildren().remove(tabPane);
    	p2.setRight(tabPane);
    	tabPane.setSide(Side.RIGHT);
    	p2.getChildren().remove(radioPane);
    	p2.setBottom(radioPane);
    });
    topRadio.setOnAction(e -> {
    	p2.getChildren().remove(tabPane);
    	p2.setTop(tabPane);
    	tabPane.setSide(Side.TOP);
    	p2.getChildren().remove(radioPane);
    	p2.setBottom(radioPane);
    });
    bottomRadio.setOnAction(e -> {
    	p2.getChildren().remove(tabPane);
    	p2.setBottom(tabPane);
    	tabPane.setSide(Side.BOTTOM);
    	p2.getChildren().remove(radioPane);
    	p2.setTop(radioPane);
    });
    
    Scene scene = new Scene(p2, 300, 270);
    scene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Roboto&display=swap");
    scene.getStylesheets().add(this.getClass().getResource("./styles.css").toExternalForm());
    primaryStage.setTitle("DisplayFigure"); // Set the window title
    primaryStage.setScene(scene); // Place the scene in the window
    primaryStage.show(); // Display the window
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   * line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
