/**
 * 
 */
package ch.bananatreedad.bfh.java.ArrayListTest;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * @author bananatreedad
 *
 */
public class MainFormController {

    ArrayList<String> myStrings = new ArrayList<String>();

    @FXML
    private TextField myStringTextField;

    @FXML
    private Button myButton;

    @FXML
    public void buttonPress() {
	if (!myStringTextField.getText().isEmpty()) {
	    myStrings.add(myStringTextField.getText());
	    System.out.println(myStrings);
	    myStringTextField.clear();
	}
    }
}
