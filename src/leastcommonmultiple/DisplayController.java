package leastcommonmultiple;

import javafx.beans.binding.Bindings;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DisplayController {
	@FXML 
	private Label display ;
	
	private final LongProperty value = new SimpleLongProperty(this, "value", 0);
	public LongProperty valueProperty() {
		return value ;
	}
	public long getValue() {
		return value.get();
	}
	public void setValue(long value) {
		this.value.set(value);
	}
	
	public void initialize() {
		display.textProperty().bind(Bindings.format("Least common multiple: %,d", value));
	}
}
