import javafx.application.Application;
import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Test2 extends Application {

	@Override
	public void start(Stage stage) {
		final ObservableList<Image> images = fetchImages();
		ComboBox<Image> combo = createComboBox(images);

		StackPane layout = new StackPane(combo);
		layout.setPadding(new Insets(20));

		stage.setScene(new Scene(layout));
		stage.show();
	}

	private ComboBox<Image> createComboBox(ObservableList<Image> data) {
		ComboBox<Image> combo = new ComboBox<>();
		combo.getItems().addAll(data);
		combo.setButtonCell(new ImageListCell());
		combo.setCellFactory(listView -> new ImageListCell());
		combo.getSelectionModel().select(0);
		return combo;
	}

	class ImageListCell extends ListCell<Image> {
		private final ImageView view;

		ImageListCell() {
			setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
			view = new ImageView();
		}

		@Override
		protected void updateItem(Image item, boolean empty) {
			super.updateItem(item, empty);

			if (item == null || empty) {
				setGraphic(null);
			} else {
				view.setImage(item);
				setGraphic(view);
			}
		}

	}

	private ObservableList<Image> fetchImages() {
		final ObservableList<Image> data = FXCollections.observableArrayList();
		// icon license: CC Attribution-Noncommercial-Share Alike 3.0
		// iconset homepage:
		// http://vincentburton.deviantart.com/art/Iconos-Diaguitas-216196385
		// for (int i = 1; i < 3; i++) {
		data.add(new Image("E:/1.png"));
		data.add(new Image("E:/2.png"));
		// }
		return data;
	}

	public static void main(String[] args) {
		launch(args);
	}
}