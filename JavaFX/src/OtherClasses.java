import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class OtherClasses  {
	public static void main(String[] args) {
		alertBox("robin");
	}
	public static void alertBox(String message){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText(message);

		alert.showAndWait();
	}
}
