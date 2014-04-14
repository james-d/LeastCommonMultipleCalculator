package leastcommonmultiple;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;

public class MainController {
	@FXML
	private InputController inputController ;
	@FXML
	private DisplayController displayController ;
	
	public void initialize() {
		displayController.valueProperty().bind(Bindings.createLongBinding(
				() -> computeLeastCommonMultiple(inputController.getX(), inputController.getY()), 
				inputController.xProperty(), inputController.yProperty()
		));
	}
	
	private long computeLeastCommonMultiple(int x0, int y0) {
		long x = x0 ;
		long y = y0 ;
		while (x != y) {
			if (x < y) {
				x += x0 ;
			} else {
				y += y0 ;
			}
		}
		return x ;
	}
}
