/**
 * 
 */
package application;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * @author bananatreedad
 *
 */
public class TimeFormController {
    @FXML
    private TextField counterField;
    @FXML
    private TextArea myConsole;
    @FXML
    private Button myButton;

    public TimeFormController() {
	Console console = new Console(myConsole);
	PrintStream stream = new PrintStream(console, true);
	System.setOut(stream);
	System.setErr(stream);
    }

    @FXML
    protected void handleEnterButtonEvent() {
	writeToConsole();
    }

    @FXML
    protected void keyOnField(KeyEvent event) {
	if (event.getCode() == KeyCode.ENTER) {
	    writeToConsole();
	    counterField.setText("");
	    //disableElements();
	}
    }

    private void writeToConsole() {
	myConsole.appendText(counterField.getText() + "\n");
    }

    public void disableElements() {
	counterField.setDisable(true);
	myButton.setDisable(true);
    }

    public void enableElements() {
	counterField.setDisable(false);
	myButton.setDisable(true);
    }

    private class Console extends OutputStream {

	private TextArea output;

	public Console(TextArea ta) {
	    this.output = ta;
	}

	@Override
	public void write(int i) throws IOException {
	    output.appendText(String.valueOf((char) i));
	}
    }
}
