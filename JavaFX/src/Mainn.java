import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/*from  w  w w . j  a va  2  s  .  c  o  m*/
public class Mainn extends Application {
	@Override
	public void start(Stage primaryStage) {
		Group root = new Group();

		final ObservableList<Image> data = FXCollections.observableArrayList(
				new Image(Test3.class.getResourceAsStream("C:/Users/ROBIN/Documents/1.png")));
		//data.add(new Image(Test3.class.getResourceAsStream("C:/Users/ROBIN/Documents/1.png")));
		//data.add(new Image("C:/Users/ROBIN/Documents/2.png"));

		ComboBox<HBox> shapes = new ComboBox<>();
		shapes.getItems().addAll(new HBox(new ImageView("‪barcode-code128.jpg"), new Label("Robin")));

		root.getChildren().add(shapes);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}