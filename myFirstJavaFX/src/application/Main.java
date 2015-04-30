package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
	try {
	    //test();
	    AnchorPane root = new FXMLLoader.load(getClass().getResource("insertView.fxml"));
		    
            root.getStyleClass().add("testclass");
	    Scene scene = new Scene(root);
	    scene.getStylesheets().add(
		    getClass().getResource("application.css").toExternalForm());
	    primaryStage.setTitle("testtitel");
	    primaryStage.setScene(scene);
	    primaryStage.show();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public static void main(String[] args) {
	launch(args);
    }

    public static void test() {
    
	int testi= -1;
	while(testi < 0) {
	    testi--;
	}
	System.out.println("ended.\ncount: " + testi);
	System.out.println(testi+1);
    }
}
