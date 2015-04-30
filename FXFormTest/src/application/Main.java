package application;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextAreaBuilder;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
	try {
	    Parent root = FXMLLoader.load(getClass().getResource(
		    "TimeForm.fxml"));

	    Scene scene = new Scene(root, 600, 400);
	    scene.getStylesheets().add(
		    getClass().getResource("application.css").toExternalForm());
	    primaryStage.setTitle("For Loop Tester");
	    primaryStage.setScene(scene);
	    primaryStage.show();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public static void main(String[] args) {
	launch(args);
    }
//    
//    @Override
//    public void start(Stage primaryStage) throws IOException {
//
//        TextArea ta = TextAreaBuilder.create().prefWidth(800).prefHeight(600).wrapText(true).build();
//        Console console = new Console(ta);
//        PrintStream ps = new PrintStream(console, true);
//        System.setOut(ps);
//        System.setErr(ps);
//        Scene app = new Scene(ta);
//
//        System.out.println("whaddap");
//        primaryStage.setScene(app);
//        primaryStage.show();
//
//        for (char c : "some text\n".toCharArray()) {
//            console.write(c);
//        }
//        System.out.println("altaaa");
//        ps.close();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    public static class Console extends OutputStream {
//
//        private TextArea output;
//
//        public Console(TextArea ta) {
//            this.output = ta;
//        }
//
//        @Override
//        public void write(int i) throws IOException {
//            output.appendText(String.valueOf((char) i));
//        }
//    }
}

