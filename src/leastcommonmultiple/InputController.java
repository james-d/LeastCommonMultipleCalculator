package leastcommonmultiple;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

public class InputController {

	@FXML
	private TextField xTextField ;
	@FXML
	private TextField yTextField ;
	
	private final IntegerProperty x = new SimpleIntegerProperty(this, "x", 1);
	public IntegerProperty xProperty() {
		return x ;
	}
	public int getX() {
		return x.get();
	}
	public void setX(int x) {
		this.x.set(x);
	}
	
	private final IntegerProperty y = new SimpleIntegerProperty(this, "y", 1);
	public IntegerProperty yProperty() {
		return y ;
	}
	public int getY() {
		return y.get();
	}
	public void setY(int y) {
		this.y.set(y);
	}
	
	public void initialize() {
		final StringConverter<Number> converter = new StringConverter<Number>() {

			@Override
			public String toString(Number number) {
				return Integer.toString(number.intValue());
			}

			@Override
			public Number fromString(String string) {
				try {
					return Math.max(1, new Integer(string));
				} catch (NumberFormatException exc) {
					return new Integer(1);
				}
			}
			
		};
		xTextField.textProperty().bindBidirectional(x, converter);
		yTextField.textProperty().bindBidirectional(y, converter);
	}
}
