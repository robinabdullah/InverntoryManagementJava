
import javafx.event.EventHandler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import np.com.ngopal.control.AutoFillTextBox;

/*  ww w.jav  a  2  s.  com*/
public class Main extends Application {
	final ComboBox<String> supplierNameComboBox = new ComboBox<String>();
	final ComboBox<String> productModelComboBox = new ComboBox<String>();

	public static void main(String[] args) {
		/*
		 * String query = "insert into product (PRODUCTID,
		 * PRODUCTGROUP,PRODUCTMODEL,SIZEGROUP,UNITPRICE,SALEPRICE,FIXPRICE,
		 * QUANTITY) values (" + 4 + " ,'" + "ChinaBaby" + "','" + "Pumpy Shoes"
		 * + "' ,'" + "34-38" + "' ," + 450 + " ," + 510 + " ,'" + "Yes" + "' ,"
		 * + 12 + ")";
		 * 
		 * System.out.println( Database.executeQuery(query) );
		 * 
		 * System.out.println("Program Terminated");
		 */
		launch(args);
	}

	public void start(Stage logingStage) throws Exception {
		 logingWindow();
//		 mainWindow();
//		 tradingWindow();
//		 salesBillingInvoiceWindow();
//		 salesReturnWindow();
//		purchaseWindow();
//		 purchaseWindowPromt();
//		 purchaseReturnWindow();
//		 productSearchWindow();
//		 auctionWindow();
//		 accountWindow();

	}

	public void logingWindow() {
		Stage logingStage = new Stage();
		logingStage.setTitle("Login                  ");
		VBox root = new VBox();
		root.setSpacing(25);
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(30));

		HBox hBox = new HBox(10);

		TextField userNameTextField = new TextField();
		userNameTextField.setPromptText("User Name");
		root.getChildren().add(userNameTextField);

		PasswordField passwordPasswordField = new PasswordField();
		passwordPasswordField.setPromptText("Password");
		root.getChildren().add(passwordPasswordField);

		Button loginButton = new Button("Login");
		hBox.getChildren().add(loginButton);
		root.getChildren().add(hBox);

		loginButton.setOnAction(e -> {
			if (userNameTextField.getText().equals("robin") && passwordPasswordField.getText().equals("1111"))
				mainWindow();
			else {
				System.out.print("Error");
				// JOptionPane.showConfirmDialog(null, "Invalid username and
				// password");
			}
			logingStage.close();

		});

		Scene scene = new Scene(root, 250, 200);
		logingStage.setScene(scene);
		logingStage.show();

	}

	public void mainWindow() {
		Stage mainStage = new Stage();
		mainStage.setTitle("Inventory Management System");
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(100);
		gridPane.setVgap(100);

		String buttonTextStyle = "-fx-font: 15 arial; -fx-base: #FFFF;-fx-font-weight: bold;";

		Button tradingButton = new Button("Trading");
		tradingButton.setStyle(buttonTextStyle);
		tradingButton.setPrefSize(130, 50);
		gridPane.add(tradingButton, 1, 0);

		tradingButton.setOnAction(e -> {
			tradingWindow();
		});

		Button accountButton = new Button("Account");
		accountButton.setStyle(buttonTextStyle);
		accountButton.setPrefSize(130, 50);
		gridPane.add(accountButton, 2, 1);

		accountButton.setOnAction(e -> {
			accountWindow();
		});

		Button settingButton = new Button("Setting");
		settingButton.setStyle(buttonTextStyle);
		settingButton.setPrefSize(130, 50);
		gridPane.add(settingButton, 0, 1);

		Button aboutButton = new Button("About");
		aboutButton.setStyle(buttonTextStyle);
		aboutButton.setPrefSize(130, 50);
		gridPane.add(aboutButton, 1, 2);

		Scene mainScene = new Scene(gridPane);
		mainStage.setScene(mainScene);
		mainStage.setMaximized(true);
		mainStage.show();
	}

	public void tradingWindow() {
		Stage tradingStage = new Stage();
		tradingStage.setTitle("Trading");

		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setPadding(new Insets(40));
		gridPane.setVgap(50);
		gridPane.setHgap(120);

		String buttonTextStyle = "-fx-font: 15 arial; -fx-base: #FFFF;-fx-font-weight: bold;";

		Button salesBillButton = new Button("Sales Bill/ Invoice");
		salesBillButton.setStyle(buttonTextStyle);
		salesBillButton.setPrefSize(170, 50);
		gridPane.add(salesBillButton, 1, 0);

		salesBillButton.setOnAction(e -> {
			salesBillingInvoiceWindow();
		});

		Button salesReturnButton = new Button("Sales Return");
		salesReturnButton.setStyle(buttonTextStyle);
		salesReturnButton.setPrefSize(170, 50);
		gridPane.add(salesReturnButton, 2, 1);

		salesReturnButton.setOnAction(e -> {
			salesReturnWindow();
		});

		Button purchaseButton = new Button("Purchase");
		purchaseButton.setStyle(buttonTextStyle);
		purchaseButton.setPrefSize(170, 50);
		gridPane.add(purchaseButton, 0, 1);

		purchaseButton.setOnAction(e -> {
			purchaseWindow();
		});

		Button auctionButton = new Button("Auction");
		auctionButton.setStyle(buttonTextStyle);
		auctionButton.setPrefSize(170, 50);
		gridPane.add(auctionButton, 1, 2);

		auctionButton.setOnAction(e -> {
			auctionWindow();
		});

		Button purchaseReturnButton = new Button("Purchase Return");
		purchaseReturnButton.setStyle(buttonTextStyle);
		purchaseReturnButton.setPrefSize(170, 50);
		gridPane.add(purchaseReturnButton, 0, 3);

		purchaseReturnButton.setOnAction(e -> {
			purchaseReturnWindow();
		});

		Button productSearchButton = new Button("Product Search");
		productSearchButton.setStyle(buttonTextStyle);
		productSearchButton.setPrefSize(170, 50);
		gridPane.add(productSearchButton, 2, 3);

		productSearchButton.setOnAction(e -> {
			productSearchWindow();
		});

		Button purchaseQuotationButton = new Button("Purchase Quotation");
		purchaseQuotationButton.setStyle(buttonTextStyle);
		purchaseQuotationButton.setPrefSize(170, 50);
		gridPane.add(purchaseQuotationButton, 1, 4);

		Scene tradingScene = new Scene(gridPane);
		tradingStage.setScene(tradingScene);
		tradingStage.setMaximized(true);
		tradingStage.show();
	}

	public void salesBillingInvoiceWindow() {
		Stage salesBillingInvoiceStage = new Stage();
		salesBillingInvoiceStage.setTitle("Sales Billing/ Invoice");

		VBox root = new VBox(10);
		// part1 starts
		StackPane stackPane = new StackPane();
		stackPane.setPadding(new Insets(15));
		stackPane.setAlignment(Pos.TOP_CENTER);
		Rectangle r = new Rectangle(1020, 230, Color.WHITE);
		r.setStroke(Color.BLACK);
		r.setStrokeWidth(1);
		stackPane.getChildren().add(r);

		GridPane gridPane = new GridPane();
		gridPane.setVgap(10);
		gridPane.setHgap(10);
		gridPane.setPadding(new Insets(15));

		String fontStyle = "-fx-font-weight: bold";

		Label refNoLabel = new Label("Ref No.");
		refNoLabel.setStyle(fontStyle);
		gridPane.add(refNoLabel, 0, 0);

		GridPane refNSaleDateGridPane = new GridPane();
		refNSaleDateGridPane.setHgap(10);

		TextField refNoTextField = new TextField();
		// refNoTextField.setPrefWidth(40);
		refNSaleDateGridPane.add(refNoTextField, 0, 0);

		Label saleDateLabel = new Label("Sale Date");
		saleDateLabel.setStyle(fontStyle);
		refNSaleDateGridPane.add(saleDateLabel, 1, 0);

		DatePicker datePicker = new DatePicker();
		datePicker.setValue(LocalDate.now());
		refNSaleDateGridPane.add(datePicker, 2, 0);

		gridPane.add(refNSaleDateGridPane, 1, 0);

		Label mobileLabel = new Label("  Mobile");
		mobileLabel.setStyle(fontStyle);
		gridPane.add(mobileLabel, 2, 0);

		GridPane mobileInvoiceGridPane = new GridPane();
		mobileInvoiceGridPane.setHgap(10);

		TextField mobileTextField = new TextField();
		mobileInvoiceGridPane.add(mobileTextField, 0, 0);

		Label invoiceLabel = new Label("Invoice No.");
		invoiceLabel.setStyle(fontStyle);
		mobileInvoiceGridPane.add(invoiceLabel, 1, 0);

		TextField invoiceTextField = new TextField();
		invoiceTextField.setEditable(false);
		mobileInvoiceGridPane.add(invoiceTextField, 2, 0);

		gridPane.add(mobileInvoiceGridPane, 3, 0);

		Label customerNameLabel = new Label("Customer Name");
		customerNameLabel.setStyle(fontStyle);
		gridPane.add(customerNameLabel, 0, 1);

		TextField customerNameTextfield = new TextField();
		customerNameTextfield.setPrefWidth(250);
		gridPane.add(customerNameTextfield, 1, 1);

		Label paymentTypeLabel = new Label("  Payment Type");
		paymentTypeLabel.setStyle(fontStyle);
		gridPane.add(paymentTypeLabel, 2, 1);

		HBox paymentTypeHBox = new HBox(15);
		paymentTypeHBox.setPadding(new Insets(5, 0, 0, 0));

		CheckBox paymentTypeCash = new CheckBox(" Cash    ");
		paymentTypeCash.setStyle(fontStyle);
		paymentTypeHBox.getChildren().add(paymentTypeCash);

		CheckBox paymentTypeDue = new CheckBox(" Due    ");
		paymentTypeDue.setStyle(fontStyle);
		paymentTypeHBox.getChildren().add(paymentTypeDue);

		CheckBox paymentTypeHalf = new CheckBox("Half");
		paymentTypeHalf.setStyle(fontStyle);
		paymentTypeHBox.getChildren().add(paymentTypeHalf);

		gridPane.add(paymentTypeHBox, 3, 1);

		Label productGroupLabel = new Label("Product Group");
		productGroupLabel.setStyle(fontStyle);
		gridPane.add(productGroupLabel, 0, 2);

		final ComboBox<String> productGroupChoiceBox = new ComboBox<String>(
				FXCollections.observableArrayList(productGroupEnum.Gents.toString(), productGroupEnum.Ladies.toString(),
						productGroupEnum.Baby.toString()));
		productGroupChoiceBox.setMinWidth(407);
		gridPane.add(productGroupChoiceBox, 1, 2);

		Label productModelLabel = new Label("  Product Model");
		productModelLabel.setStyle(fontStyle);
		gridPane.add(productModelLabel, 2, 2);
		productGroupChoiceBox.setEditable(true);
		productGroupChoiceBox.getEditor().textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				ArrayList<String> stringArrayList = new ArrayList<String>();
				productModelComboBox.getItems().clear();
				stringArrayList = Database
						.returnOneColumn("Select *  from product Where productgroup = '" + newValue + "'", 3);

				Iterator itr = stringArrayList.iterator();

				while (itr.hasNext()) {
					// System.out.println(itr.next());
					productModelComboBox.getItems().add((String) itr.next());
				}
			}
		});
		productModelComboBox.setMinWidth(380);
		gridPane.add(productModelComboBox, 3, 2);

		Label barcodeSerialLabel = new Label("Barcode Serial");
		barcodeSerialLabel.setStyle(fontStyle);
		gridPane.add(barcodeSerialLabel, 0, 3);

		ComboBox<String> barcodeSerialComboBox = new ComboBox<String>();
		barcodeSerialComboBox.setMinWidth(405);
		gridPane.add(barcodeSerialComboBox, 1, 3);

		Label sizeLabel = new Label("  Size");
		sizeLabel.setStyle(fontStyle);
		gridPane.add(sizeLabel, 2, 3);

		GridPane sizeColorGridPane = new GridPane();
		sizeColorGridPane.setHgap(10);

		TextField sizeTextfield = new TextField();
		sizeColorGridPane.add(sizeTextfield, 0, 0);

		Label colorLabel = new Label("         Color");
		colorLabel.setStyle(fontStyle);
		sizeColorGridPane.add(colorLabel, 1, 0);

		TextField colorTextfield = new TextField();
		sizeColorGridPane.add(colorTextfield, 2, 0);

		gridPane.add(sizeColorGridPane, 3, 3);

		Label salesmanLabel = new Label("Salesman");
		salesmanLabel.setStyle(fontStyle);
		gridPane.add(salesmanLabel, 0, 4);

		final ComboBox<String> salesmanChoiceBox = new ComboBox<String>();
		salesmanChoiceBox.setMinWidth(407);
		ArrayList<String> stringlist = new ArrayList<String>();
		stringlist = Database.returnOneColumn("select * from salesman", 2);
		Iterator it = stringlist.iterator();
		while (it.hasNext()) {
			salesmanChoiceBox.getItems().add((String) it.next());
		}
		gridPane.add(salesmanChoiceBox, 1, 4);

		Label showroomLabel = new Label("  Showroom");
		showroomLabel.setStyle(fontStyle);
		gridPane.add(showroomLabel, 2, 4);

		ComboBox showroomComboBox = new ComboBox();
		showroomComboBox.setMinWidth(380);
		showroomComboBox.getItems().addAll("showroom1", "showroom2");
		gridPane.add(showroomComboBox, 3, 4);

		Label quantityLabel = new Label("Quantity");
		quantityLabel.setStyle(fontStyle);
		gridPane.add(quantityLabel, 0, 5);

		GridPane quantityPriceGridPane = new GridPane();
		quantityPriceGridPane.setHgap(10);

		TextField quantityTextfield = new TextField();
		quantityPriceGridPane.add(quantityTextfield, 0, 0);

		Label priceLabel = new Label("       Unit Price");
		priceLabel.setStyle(fontStyle);
		quantityPriceGridPane.add(priceLabel, 1, 0);

		TextField priceTextfield = new TextField();
		priceTextfield.setDisable(true);
		quantityPriceGridPane.add(priceTextfield, 2, 0);

		gridPane.add(quantityPriceGridPane, 1, 5);

		Label discountLabel = new Label("  Discount");
		discountLabel.setStyle(fontStyle);
		gridPane.add(discountLabel, 2, 5);

		GridPane discountWarrantyGridPane = new GridPane();
		discountWarrantyGridPane.setHgap(10);

		TextField discountTextfield = new TextField();
		discountWarrantyGridPane.add(discountTextfield, 0, 0);

		Label warrantyLabel = new Label("   Warranty");
		warrantyLabel.setStyle(fontStyle);
		discountWarrantyGridPane.add(warrantyLabel, 1, 0);

		TextField warrantyTextfield = new TextField();
		warrantyTextfield.setDisable(true);
		discountWarrantyGridPane.add(warrantyTextfield, 2, 0);

		gridPane.add(discountWarrantyGridPane, 3, 5);
		productModelComboBox.setEditable(true);
		productModelComboBox.getEditor().textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				ArrayList<String> stringArrayList = new ArrayList<String>();
				barcodeSerialComboBox.getItems().clear();
				stringArrayList = Database
						.returnOneColumn("Select *  from product where productmodel = '" + newValue + "'", 10);

				Iterator itr = stringArrayList.iterator();

				while (itr.hasNext()) {
					barcodeSerialComboBox.setValue((String) itr.next());
				}
				String a = Database.returnString(
						"select * from product where Barcodeserial = " + barcodeSerialComboBox.getValue(), 8);
				String b = Database.returnString(
						"select * from product where Barcodeserial = " + barcodeSerialComboBox.getValue(), 5);
				warrantyTextfield.setText(a);
				priceTextfield.setText(b);
			}
		});

		stackPane.getChildren().add(gridPane);
		// part1 finishes

		// part2 starts
		VBox tableVBox = new VBox();
		tableVBox.setPadding(new Insets(-10, 15, 20, 15));
		tableVBox.setMaxHeight(210);

		TableView tableView = new TableView();

		TableColumn serialColum = new TableColumn("SL");
		// serialColum.setStyle("-fx-cell-size: 208px;");
		TableColumn productCodeColumn = new TableColumn("Product Code");
		TableColumn productDescriptionColumn = new TableColumn("Product Description");
		TableColumn quantityColumn = new TableColumn("Quantity");
		TableColumn priceColumn = new TableColumn("Unit Price");
		TableColumn amountColumn = new TableColumn("Amount");

		tableView.getColumns().addAll(serialColum, productCodeColumn, productDescriptionColumn, quantityColumn,
				priceColumn, amountColumn);

		tableVBox.getChildren().add(tableView);
		// part2 finishes

		// part3 starts
		StackPane stackPane1 = new StackPane();
		stackPane1.setPadding(new Insets(-15, 0, 20, 0));
		// stackPane1.setAlignment(Pos.TOP_CENTER);
		Rectangle r1 = new Rectangle(1020, 130, Color.WHITE);
		r1.setStroke(Color.BLACK);
		r1.setStrokeWidth(1);
		stackPane1.getChildren().add(r1);

		GridPane printOKCancelGridPane = new GridPane();
		printOKCancelGridPane.setVgap(20);
		printOKCancelGridPane.setHgap(30);

		Button printPreviewButton = new Button("Print Preview");
		printPreviewButton.setStyle(fontStyle);
		printPreviewButton.setMaxWidth(100);

		Button printButton = new Button("Print");
		printButton.setStyle(fontStyle);
		// printButton.setMaxWidth(100);

		Button okButton = new Button("OK");
		okButton.setStyle(fontStyle);
		okButton.setMaxWidth(100);
		okButton.setOnAction(e -> {
			double unitPrice;
			unitPrice = Math.round(Double.parseDouble(priceTextfield.getText()));

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from product");

				while (rs.next()) {
					if (rs.getString(10).equals(barcodeSerialComboBox.getValue())) {
						String stock = rs.getString(9);
						String mid = quantityTextfield.getText();
						int a1, a2, a3;
						a1 = Integer.parseInt(stock);
						a2 = Integer.parseInt(mid);
						a3 = a1 - a2;
						ResultSet rs1 = stmt.executeQuery("update product set quantity=" + a3 + " where productmodel='"
								+ productModelComboBox.getValue() + "'");

						break;
					}
				}

				// addSupplier(String.format("%d", (max)));
				// Product product = new Product("1",max, ""
				// ,quantityTextfield.getText(),unitPrice,purchasePriceTextfield.getText());
				// Preparing data for TableView
				// ArrayList<Product> productList = new ArrayList<Product>();
				// productList.add(new Product("1", String.format("%d", max),
				// "", quantityTextfield.getText(), String.format("%f",
				// unitPrice),
				// purchasePriceTextfield.getText()));

			} catch (Exception e2) {
				System.out.println(7);
				e2.printStackTrace();
			}
		});

		Button closeButton = new Button("Close");
		closeButton.setStyle(fontStyle);
		closeButton.setOnAction(e -> {
			salesBillingInvoiceStage.close();
		});

		Label quantityAvailableLable = new Label("Quantity Available : ");
		quantityAvailableLable.setStyle(fontStyle);

		printOKCancelGridPane.setPadding(new Insets(15, 100, 0, 400));
		printOKCancelGridPane.add(printPreviewButton, 0, 0);
		printOKCancelGridPane.add(printButton, 1, 0);
		printOKCancelGridPane.add(okButton, 0, 1);
		printOKCancelGridPane.add(closeButton, 1, 1);
		printOKCancelGridPane.add(quantityAvailableLable, 0, 2);
		// printOKCancelGridPane.add(separatorVertical, 3, 0);

		HBox hBox = new HBox(20);

		Label totalAmountLabel = new Label("Total Amount : ");
		totalAmountLabel.setStyle(fontStyle);

		Label vatLabel = new Label("Vat : ");
		vatLabel.setStyle(fontStyle);

		Label discountLabel1 = new Label("Discount : ");
		discountLabel1.setStyle(fontStyle);

		Label netAmountLabel = new Label("Net Amount : ");
		netAmountLabel.setStyle(fontStyle);

		VBox amountVBox = new VBox(15);
		amountVBox.setPadding(new Insets(10, 0, 0, 0));
		amountVBox.setAlignment(Pos.TOP_RIGHT);
		amountVBox.getChildren().addAll(totalAmountLabel, vatLabel, discountLabel1, netAmountLabel);

		Separator separatorVertical = new Separator();
		separatorVertical.setOrientation(Orientation.VERTICAL);
		separatorVertical.setValignment(VPos.TOP);

		HBox separatorAmounthBox = new HBox(8);
		HBox separatorhBox = new HBox(8);
		separatorhBox.setPadding(new Insets(2, 0, 2, 120));
		separatorhBox.getChildren().add(separatorVertical);

		separatorAmounthBox.getChildren().addAll(separatorhBox, amountVBox);

		hBox.getChildren().addAll(printOKCancelGridPane, separatorAmounthBox);

		stackPane1.getChildren().addAll(hBox);
		// part3 finishes

		root.getChildren().addAll(stackPane, tableVBox, stackPane1);

		Scene scene = new Scene(root);
		salesBillingInvoiceStage.setScene(scene);
		salesBillingInvoiceStage.show();

	}

	public void salesReturnWindow() {
		Stage salesReturnStage = new Stage();
		salesReturnStage.setTitle("Sales Return");

		VBox root = new VBox(10);
		// part1 starts
		StackPane stackPane = new StackPane();
		stackPane.setPadding(new Insets(15));
		stackPane.setAlignment(Pos.TOP_CENTER);
		Rectangle r = new Rectangle(1020, 200, Color.WHITE);
		r.setStroke(Color.BLACK);
		r.setStrokeWidth(1);
		stackPane.getChildren().add(r);

		GridPane gridPane = new GridPane();
		gridPane.setVgap(10);
		gridPane.setHgap(10);
		gridPane.setPadding(new Insets(15));

		String fontStyle = "-fx-font-weight: bold";

		Label refNoLabel = new Label("Ref No.");
		refNoLabel.setStyle(fontStyle);
		gridPane.add(refNoLabel, 0, 0);

		GridPane refNSaleDateGridPane = new GridPane();
		refNSaleDateGridPane.setHgap(10);

		TextField refNoTextField = new TextField();
		// refNoTextField.setPrefWidth(40);
		refNSaleDateGridPane.add(refNoTextField, 0, 0);

		Label returnDateLabel = new Label("Return Date");
		returnDateLabel.setStyle(fontStyle);
		refNSaleDateGridPane.add(returnDateLabel, 1, 0);

		DatePicker datePicker = new DatePicker();
		datePicker.setValue(LocalDate.now());
		refNSaleDateGridPane.add(datePicker, 2, 0);

		gridPane.add(refNSaleDateGridPane, 1, 0);

		Label invoiceLabel = new Label("  Invoice No.");
		invoiceLabel.setStyle(fontStyle);
		gridPane.add(invoiceLabel, 2, 0);

		TextField invoiceTextField = new TextField();
		gridPane.add(invoiceTextField, 3, 0);

		// gridPane.add(mobileInvoiceGridPane, 3, 0);

		Label productGroupLabel = new Label("Product Group");
		productGroupLabel.setStyle(fontStyle);
		gridPane.add(productGroupLabel, 0, 1);

		TextField productGroupTextfield = new TextField();
		// productGroupTextfield.setPrefWidth(250);
		gridPane.add(productGroupTextfield, 1, 1);

		Label productModelLabel = new Label("  Product Model");
		productModelLabel.setStyle(fontStyle);
		gridPane.add(productModelLabel, 2, 1);

		TextField productModelTextfield = new TextField();
		// productModelTextfield.setPrefWidth(250);
		gridPane.add(productModelTextfield, 3, 1);

		Label barcodeSerialLabel = new Label("Barcode Serial");
		barcodeSerialLabel.setStyle(fontStyle);
		gridPane.add(barcodeSerialLabel, 0, 2);

		TextField barcodeSerialTextfield = new TextField();
		// productModelTextfield.setPrefWidth(250);
		gridPane.add(barcodeSerialTextfield, 1, 2);

		Label quantityLabel = new Label("  Quantity");
		quantityLabel.setStyle(fontStyle);
		gridPane.add(quantityLabel, 2, 2);

		GridPane quantityPriceGridPane = new GridPane();
		quantityPriceGridPane.setHgap(10);

		TextField quantityTextfield = new TextField();
		quantityPriceGridPane.add(quantityTextfield, 0, 0);

		Label priceLabel = new Label("Unit Price");
		priceLabel.setStyle(fontStyle);
		quantityPriceGridPane.add(priceLabel, 1, 0);

		TextField priceTextfield = new TextField();
		quantityPriceGridPane.add(priceTextfield, 2, 0);

		gridPane.add(quantityPriceGridPane, 3, 2);

		Label salesInvoiceLabel = new Label("Sales Invoice");
		salesInvoiceLabel.setStyle(fontStyle);
		gridPane.add(salesInvoiceLabel, 0, 3);

		TextField salesInvoiceTextfield = new TextField();
		gridPane.add(salesInvoiceTextfield, 1, 3);

		Label narrationLabel = new Label("  Narration");
		narrationLabel.setStyle(fontStyle);
		gridPane.add(narrationLabel, 2, 3);

		TextField narrationTextfield = new TextField();
		gridPane.add(narrationTextfield, 3, 3);

		Label salesmanLabel = new Label("Salesman");
		salesmanLabel.setStyle(fontStyle);
		gridPane.add(salesmanLabel, 0, 4);

		TextField salesmanTextfield = new TextField();
		gridPane.add(salesmanTextfield, 1, 4);

		Label showroomLabel = new Label("  Showroom");
		showroomLabel.setStyle(fontStyle);
		gridPane.add(showroomLabel, 2, 4);

		TextField showroomTextfield = new TextField();
		gridPane.add(showroomTextfield, 3, 4);

		stackPane.getChildren().add(gridPane);
		// part1 finishes

		// part2 starts
		VBox tableVBox = new VBox();
		tableVBox.setPadding(new Insets(-10, 15, 20, 15));
		tableVBox.setMaxHeight(210);

		TableView tableView = new TableView();

		TableColumn serialColum = new TableColumn("SL");
		TableColumn productCodeColumn = new TableColumn("Product Code");
		TableColumn productDescriptionColumn = new TableColumn("Product Description");
		TableColumn quantityColumn = new TableColumn("Quantity");
		TableColumn priceColumn = new TableColumn("Unit Price");
		TableColumn amountColumn = new TableColumn("Amount");

		tableView.getColumns().addAll(serialColum, productCodeColumn, productDescriptionColumn, quantityColumn,
				priceColumn, amountColumn);

		tableVBox.getChildren().add(tableView);
		// Part2 finishes

		// part3 starts
		StackPane stackPane1 = new StackPane();
		stackPane1.setPadding(new Insets(-15, 0, 20, 0));
		// stackPane1.setAlignment(Pos.TOP_CENTER);
		Rectangle r1 = new Rectangle(1020, 130, Color.WHITE);
		r1.setStroke(Color.BLACK);
		r1.setStrokeWidth(1);
		stackPane1.getChildren().add(r1);

		GridPane printOKCancelGridPane = new GridPane();
		printOKCancelGridPane.setVgap(20);
		printOKCancelGridPane.setHgap(30);

		Button printPreviewButton = new Button("Print Preview");
		printPreviewButton.setStyle(fontStyle);
		printPreviewButton.setMaxWidth(100);

		Button printButton = new Button("Print");
		printButton.setStyle(fontStyle);
		// printButton.setMaxWidth(100);

		Button okButton = new Button("OK");
		okButton.setStyle(fontStyle);
		okButton.setMaxWidth(100);

		Button closeButton = new Button("Close");
		closeButton.setStyle(fontStyle);

		Label quantityAvailableLable = new Label("Quantity Available : ");
		quantityAvailableLable.setStyle(fontStyle);

		printOKCancelGridPane.setPadding(new Insets(15, 100, 0, 400));
		printOKCancelGridPane.add(printPreviewButton, 0, 0);
		printOKCancelGridPane.add(printButton, 1, 0);
		printOKCancelGridPane.add(okButton, 0, 1);
		printOKCancelGridPane.add(closeButton, 1, 1);
		printOKCancelGridPane.add(quantityAvailableLable, 0, 2);
		// printOKCancelGridPane.add(separatorVertical, 3, 0);

		HBox hBox = new HBox(20);

		Label totalAmountLabel = new Label("Total Amount : ");
		totalAmountLabel.setStyle(fontStyle);

		Label discountLabel1 = new Label("Discount : ");
		discountLabel1.setStyle(fontStyle);

		Label netAmountLabel = new Label("Net Payable Amount : ");
		netAmountLabel.setStyle(fontStyle);

		VBox amountVBox = new VBox(15);
		amountVBox.setPadding(new Insets(15, 0, 0, 0));
		amountVBox.setAlignment(Pos.TOP_RIGHT);
		amountVBox.getChildren().addAll(totalAmountLabel, discountLabel1, netAmountLabel);

		Separator separatorVertical = new Separator();
		separatorVertical.setOrientation(Orientation.VERTICAL);
		separatorVertical.setValignment(VPos.TOP);

		HBox separatorAmounthBox = new HBox(8);
		HBox separatorhBox = new HBox(8);
		separatorhBox.setPadding(new Insets(2, 0, 2, 110));
		separatorhBox.getChildren().add(separatorVertical);

		separatorAmounthBox.getChildren().addAll(separatorhBox, amountVBox);

		hBox.getChildren().addAll(printOKCancelGridPane, separatorAmounthBox);

		stackPane1.getChildren().addAll(hBox);
		// part3 finishes

		root.getChildren().addAll(stackPane, tableVBox, stackPane1);

		Scene scene = new Scene(root);
		salesReturnStage.setScene(scene);
		salesReturnStage.show();
	}

	public void purchaseWindow() {
		Stage purchaseStage = new Stage();
		purchaseStage.setTitle("Purchase");

		VBox root = new VBox(10);
		// part1 starts
		StackPane stackPane = new StackPane();
		stackPane.setPadding(new Insets(15));
		stackPane.setAlignment(Pos.TOP_CENTER);
		Rectangle r = new Rectangle(1020, 230, Color.WHITE);
		r.setStroke(Color.BLACK);
		r.setStrokeWidth(1);
		stackPane.getChildren().add(r);

		GridPane gridPane = new GridPane();
		gridPane.setVgap(10);
		gridPane.setHgap(10);
		gridPane.setPadding(new Insets(15));

		String fontStyle = "-fx-font-weight: bold";

		Label refNoLabel = new Label("Ref No.");
		refNoLabel.setStyle(fontStyle);
		gridPane.add(refNoLabel, 0, 0);

		GridPane refNSaleDateGridPane = new GridPane();
		refNSaleDateGridPane.setHgap(10);

		TextField refNoTextField = new TextField();
		refNoTextField.setPrefWidth(100);
		refNSaleDateGridPane.add(refNoTextField, 0, 0);

		Label saleDateLabel = new Label("      Purchase Date");
		saleDateLabel.setStyle(fontStyle);
		refNSaleDateGridPane.add(saleDateLabel, 1, 0);

		DatePicker datePicker = new DatePicker();
		datePicker.setValue(LocalDate.now());
		refNSaleDateGridPane.add(datePicker, 2, 0);

		gridPane.add(refNSaleDateGridPane, 1, 0);

		Label paymentTypeLabel = new Label("  Payment Type");
		paymentTypeLabel.setStyle(fontStyle);
		gridPane.add(paymentTypeLabel, 2, 0);

		GridPane paymentInvoiceGridPane = new GridPane();
		paymentInvoiceGridPane.setHgap(10);

		HBox paymentTypeHBox = new HBox(15);
		paymentTypeHBox.setPadding(new Insets(5, 0, 0, 0));

		ToggleGroup tGroup = new ToggleGroup();

		RadioButton paymentTypeCash = new RadioButton(" Cash");
		paymentTypeCash.setStyle(fontStyle);
		paymentTypeHBox.getChildren().add(paymentTypeCash);
		paymentTypeCash.setToggleGroup(tGroup);

		RadioButton paymentTypeDue = new RadioButton(" Due");
		paymentTypeDue.setStyle(fontStyle);
		paymentTypeHBox.getChildren().add(paymentTypeDue);
		paymentTypeDue.setToggleGroup(tGroup);

		RadioButton paymentTypeHalf = new RadioButton("Partial");
		paymentTypeHalf.setStyle(fontStyle);
		paymentTypeHBox.getChildren().add(paymentTypeHalf);
		paymentTypeHalf.setToggleGroup(tGroup);

		paymentInvoiceGridPane.add(paymentTypeHBox, 0, 0);

		Label invoiceLabel = new Label("       Invoice No.");
		invoiceLabel.setStyle(fontStyle);
		paymentInvoiceGridPane.add(invoiceLabel, 1, 0);

		TextField invoiceTextField = new TextField();
		// invoiceTextField.setEditable(false);
		invoiceTextField.setDisable(true);
		invoiceTextField.setPrefWidth(100);
		paymentInvoiceGridPane.add(invoiceTextField, 2, 0);

		gridPane.add(paymentInvoiceGridPane, 3, 0);

		Label supplierGroupLabel = new Label("Supplier Group");
		supplierGroupLabel.setStyle(fontStyle);
		gridPane.add(supplierGroupLabel, 0, 1);

		final ComboBox<String> supplierGroupChoiceBox = new ComboBox<String>(
				FXCollections.observableArrayList("Market", "Local Supplier"));
		supplierGroupChoiceBox.setMinWidth(407);
		gridPane.add(supplierGroupChoiceBox, 1, 1);

		Label supplierNameLabel = new Label("  Supplier Name");
		supplierNameLabel.setStyle(fontStyle);
		gridPane.add(supplierNameLabel, 2, 1);
		HBox supplierNameNButton = new HBox(5);

		supplierNameComboBox.setEditable(true);
		supplierGroupChoiceBox.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				ArrayList<String> stringArrayList = new ArrayList<String>();
				supplierNameComboBox.getItems().clear();
				stringArrayList = Database.returnOneColumn(
						"Select *  from supplier Where supplier_Group = '" + supplierGroupChoiceBox.getValue() + "'",
						2);

				new AutoCompleteComboBoxListener<>(supplierNameComboBox);
				Iterator itr = stringArrayList.iterator();

				while (itr.hasNext()) {
					supplierNameComboBox.getItems().add((String) itr.next());
				}

			}
		});

		supplierNameComboBox.setPrefWidth(350);
		supplierNameNButton.getChildren().add(supplierNameComboBox);

		Button supplierNameButton = new Button("N");
		supplierNameButton.setStyle(fontStyle);
		supplierNameNButton.getChildren().add(supplierNameButton);
		supplierNameButton.setOnAction(e -> {
			int max = 0;
			String stringArrayList = Database.returnString("SELECT Max(supplier_Id) FROM supplier", 1);

			max = Integer.parseInt(stringArrayList);
			addSupplier(String.format("%d", (max + 1)));
		});

		gridPane.add(supplierNameNButton, 3, 1);

		Label productGroupLabel = new Label("Product Group");
		productGroupLabel.setStyle(fontStyle);
		gridPane.add(productGroupLabel, 0, 2);

		GridPane productGroupCountryGridPane = new GridPane();
		productGroupCountryGridPane.setHgap(10);

		ComboBox<String> productGroupChoiceBox = new ComboBox<String>(
				FXCollections.observableArrayList(productGroupEnum.Gents.toString(), productGroupEnum.Ladies.toString(),
						productGroupEnum.Baby.toString()));
		productGroupChoiceBox.setPrefWidth(150);
		productGroupCountryGridPane.add(productGroupChoiceBox, 0, 0);

		Label productCountryLabel = new Label("  Product Country");
		productCountryLabel.setStyle(fontStyle);
		productGroupCountryGridPane.add(productCountryLabel, 1, 0);

		ComboBox<String> productCountryComboBox = new ComboBox<String>(FXCollections.observableArrayList(
				productCountryEnum.Bangladesh.toString(), productCountryEnum.China.toString(),
				productCountryEnum.India.toString(), productCountryEnum.Thailand.toString(),
				productCountryEnum.Italy.toString(), productCountryEnum.Others.toString()));
		productGroupCountryGridPane.add(productCountryComboBox, 2, 0);
		productCountryComboBox.setPrefWidth(138);
		gridPane.add(productGroupCountryGridPane, 1, 2);

		Label productModelLabel = new Label("  Product Model");
		productModelLabel.setStyle(fontStyle);
		gridPane.add(productModelLabel, 2, 2);

		HBox productmodelNButtonHBox = new HBox(5);

		productCountryComboBox.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent ae) {
				if (!(productGroupChoiceBox.selectionModelProperty().equals(null))) {
					ArrayList<String> stringArrayList = Database.returnOneColumn(
							"Select *  from product Where product_group = '" + productGroupChoiceBox.getValue()
									+ "' and product_Country = '" + productCountryComboBox.getValue() + "'",
							4);
					productModelComboBox.getItems().clear();

					new AutoCompleteComboBoxListener<>(productModelComboBox);

					Iterator itr = stringArrayList.iterator();

					while (itr.hasNext()) {
						productModelComboBox.getItems().add((String) itr.next());
					}

				}

			}
		});
		productGroupChoiceBox.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				if (!(productCountryComboBox.selectionModelProperty().equals(null))) {
					ArrayList<String> stringArrayList = Database.returnOneColumn(
							"Select *  from product Where product_group = '" + productGroupChoiceBox.getValue()
									+ "' and product_Country = '" + productCountryComboBox.getValue() + "'",
							4);
					productModelComboBox.getItems().clear();

					new AutoCompleteComboBoxListener<>(productModelComboBox);

					Iterator itr = stringArrayList.iterator();

					while (itr.hasNext()) {
						productModelComboBox.getItems().add((String) itr.next());
					}
				}

			}
		});

		productModelComboBox.setEditable(true);
		productModelComboBox.setMinWidth(350);
		productmodelNButtonHBox.getChildren().add(productModelComboBox);

		Button productModelButton = new Button("M");
		productModelButton.setStyle(fontStyle);
		productmodelNButtonHBox.getChildren().add(productModelButton);

		gridPane.add(productmodelNButtonHBox, 3, 2);

		Label quantityLabel = new Label("Quantity");
		quantityLabel.setStyle(fontStyle);
		gridPane.add(quantityLabel, 0, 3);

		GridPane quantityPriceGridPane = new GridPane();
		quantityPriceGridPane.setHgap(10);

		TextField quantityTextfield = new TextField();
		quantityPriceGridPane.add(quantityTextfield, 0, 0);

		Label purchasePriceLabel = new Label("  Purchase Price");
		purchasePriceLabel.setStyle(fontStyle);
		quantityPriceGridPane.add(purchasePriceLabel, 1, 0);

		TextField purchasePriceTextfield = new TextField();
		quantityPriceGridPane.add(purchasePriceTextfield, 2, 0);

		gridPane.add(quantityPriceGridPane, 1, 3);

		Label unitPriceLabel = new Label("  Unit Price");
		unitPriceLabel.setStyle(fontStyle);
		gridPane.add(unitPriceLabel, 2, 3);

		GridPane unitPriceSalePriceGridPane = new GridPane();
		unitPriceSalePriceGridPane.setHgap(10);

		TextField unitPriceTextfield = new TextField();
		unitPriceSalePriceGridPane.add(unitPriceTextfield, 0, 0);

		Label salePriceLabel = new Label("   Sale Price");
		salePriceLabel.setStyle(fontStyle);
		unitPriceSalePriceGridPane.add(salePriceLabel, 1, 0);

		TextField salePriceTextfield = new TextField();
		unitPriceSalePriceGridPane.add(salePriceTextfield, 2, 0);

		quantityTextfield.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!purchasePriceTextfield.getText().isEmpty()) {
					double unitPrice = Double.parseDouble(purchasePriceTextfield.getText())
							/ Double.parseDouble(newValue);
					unitPrice = Math.round(unitPrice);
					unitPriceTextfield.setText(String.format("%.2f", unitPrice));
					double sale = unitPrice + ((unitPrice * 25) / 100);
					salePriceTextfield.setText(String.format("%.2f", sale));

				}
			}
		});

		purchasePriceTextfield.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!quantityTextfield.getText().isEmpty()) {
					double unitPrice = Double.parseDouble(newValue) / Double.parseDouble(quantityTextfield.getText());
					unitPrice = Math.round(unitPrice);
					unitPriceTextfield.setText(String.format("%.2f", unitPrice));
					double sale = unitPrice + ((unitPrice * 25) / 100);
					salePriceTextfield.setText(String.format("%.2f", sale));
				}
			}
		});

		gridPane.add(unitPriceSalePriceGridPane, 3, 3);

		Label barcodeSerialLabel = new Label("Barcode Serial");
		barcodeSerialLabel.setStyle(fontStyle);
		gridPane.add(barcodeSerialLabel, 0, 4);

		HBox barcodeNButtonHBox = new HBox(5);

		TextField barcodeSerialTextfield = new TextField();
		barcodeSerialTextfield.setMinWidth(378);
		barcodeSerialTextfield.setPromptText("                                                Auto Generated");
		barcodeSerialTextfield.setDisable(true);
		barcodeNButtonHBox.getChildren().add(barcodeSerialTextfield);

		Button barcodeButton = new Button("B");
		barcodeButton.setStyle(fontStyle);
		barcodeNButtonHBox.getChildren().add(barcodeButton);

		gridPane.add(barcodeNButtonHBox, 1, 4);

		Label sizeLabel = new Label("  Size Group");
		sizeLabel.setStyle(fontStyle);
		gridPane.add(sizeLabel, 2, 4);

		GridPane sizeColorGridPane = new GridPane();
		sizeColorGridPane.setHgap(10);

		TextField sizeGroupTextfield = new TextField();
		sizeColorGridPane.add(sizeGroupTextfield, 0, 0);

		Label fixedPriceLabel = new Label(" Fixed Price ");
		fixedPriceLabel.setStyle(fontStyle);
		sizeColorGridPane.add(fixedPriceLabel, 1, 0);

		ChoiceBox<String> fixedPriceComboBox = new ChoiceBox<String>(FXCollections.observableArrayList("No", "Yes"));
		fixedPriceComboBox.setValue("No");
		sizeColorGridPane.add(fixedPriceComboBox, 2, 0);

		gridPane.add(sizeColorGridPane, 3, 4);

		Label showroomLabel = new Label("  Showroom");
		showroomLabel.setStyle(fontStyle);
		gridPane.add(showroomLabel, 2, 5);

		final ChoiceBox<String> showroomChoiceBox = new ChoiceBox<String>(
				FXCollections.observableArrayList("Showroom1", "Showroom2"));

		gridPane.add(showroomChoiceBox, 3, 5);

		stackPane.getChildren().add(gridPane);
		// part1 finishes

		// part2 starts
		VBox tableVBox = new VBox();
		tableVBox.setPadding(new Insets(-10, 15, 20, 15));
		tableVBox.setMaxHeight(210);

		TableView tableView = new TableView();

		ArrayList<Product> productList = new ArrayList<Product>();
		// productList.add(new Product("1", "5", "kfg", "5", "500", "1000"));
		TableColumn serialColum = new TableColumn("SL");
		TableColumn productIdColumn = new TableColumn("Product ID");
		TableColumn productDescriptionColumn = new TableColumn("Product Description");
		TableColumn quantityColumn = new TableColumn("Quantity");
		TableColumn unitPriceColumn = new TableColumn("Unit Price");
		TableColumn amountColumn = new TableColumn("Amount");

		// Mapping columns with person object
		serialColum.setCellValueFactory(new PropertyValueFactory<Product, String>("serial"));
		//System.out.println(2);
		productIdColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("productId"));
		productDescriptionColumn.setCellFactory(new PropertyValueFactory<Product, String>("productDescription"));
		quantityColumn.setCellFactory(new PropertyValueFactory<Product, String>("quantity"));
		unitPriceColumn.setCellFactory(new PropertyValueFactory<Product, String>("unitPrice"));
		amountColumn.setCellFactory(new PropertyValueFactory<Product, String>("purchasePrice"));

		// Adding the columns
		tableView.getColumns().addAll(serialColum, productIdColumn, productDescriptionColumn, quantityColumn,
				unitPriceColumn, amountColumn);

		try { // Setting personList to table as a observable list
				// tableView.setItems(FXCollections.observableArrayList(productList));
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		tableVBox.getChildren().add(tableView);

		// part2 finishes

		// part3 starts
		StackPane stackPane1 = new StackPane();
		stackPane1.setPadding(new Insets(-15, 0, 20, 0));
		// stackPane1.setAlignment(Pos.TOP_CENTER);
		Rectangle r1 = new Rectangle(1020, 130, Color.WHITE);
		r1.setStroke(Color.BLACK);
		r1.setStrokeWidth(1);
		stackPane1.getChildren().add(r1);

		GridPane printOKCancelGridPane = new GridPane();
		printOKCancelGridPane.setVgap(20);
		printOKCancelGridPane.setHgap(30);

		Button printPreviewButton = new Button("Purchase Preview");
		printPreviewButton.setStyle(fontStyle);
		printPreviewButton.setMinWidth(120);

		Button printButton = new Button("Print");
		printButton.setStyle(fontStyle);
		// printButton.setMaxWidth(100);

		Button okButton = new Button("OK");
		okButton.setStyle(fontStyle);
		okButton.setMaxWidth(120);

		okButton.setOnAction(e -> {

			double unitPrice = Double.parseDouble(purchasePriceTextfield.getText())
					/ Double.parseDouble(quantityTextfield.getText());
			unitPrice = Math.round(unitPrice);
			double sale = unitPrice + ((unitPrice * 25) / 100);
			salePriceTextfield.setText(String.format("%.2f", sale));
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from product");
				boolean flag = false;
				while (rs.next()) {
					if (rs.getString(3).equals(productModelComboBox.getValue())) {
						String stock = rs.getString(9);
						String mid = quantityTextfield.getText();
						Double a1, a2, a3;
						a1 = Double.parseDouble(stock);
						a2 = Double.parseDouble(mid);
						a3 = a1 + a2;
						ResultSet rs1 = stmt.executeQuery("update product set quantity=" + a3 + " where productmodel='"
								+ productModelComboBox.getValue() + "'");
						flag = true;
					}

				}
				if (flag == false) {

					String list = Database.returnString(
							"select * from supplier where Suppliername = '" + supplierNameComboBox.getValue() + "'", 1);

					ResultSet rs1 = stmt.executeQuery(
							"insert into product (PRODUCTID, PRODUCTGROUP,PRODUCTMODEL,SIZEGROUP,UNITPRICE,SALEPRICE,FIXEDPRICE,WARRANTITY, QUANTITY, BARCODESERIAL, SUPPLIERID) values ("
									+ "product_seq.nextVal" + " ,'" + productGroupChoiceBox.getValue() + "','"
									+ productModelComboBox.getValue() + "' ,'" + sizeGroupTextfield.getText() + "' ,"
									+ unitPrice + " ," + sale + " ,'" + fixedPriceComboBox.getValue() + "' ,'" + "NO"
									+ "' ," + quantityTextfield.getText() + "," + "barcode_seq.nextval" + "," + list
									+ ")");

				}
				int max = 0, temp = 0;
				ArrayList<String> stringArrayList = Database.returnOneColumn("SELECT * FROM product", 1);
				Iterator it = stringArrayList.iterator();
				while (it.hasNext()) {
					temp = Integer.parseInt((String) it.next());
					if (temp > max)
						max = temp;
				}

				// addSupplier(String.format("%d", (max)));
				// Product product = new Product("1",max, ""
				// ,quantityTextfield.getText(),unitPrice,purchasePriceTextfield.getText());
				// Preparing data for TableView
				// ArrayList<Product> productList = new ArrayList<Product>();
				// productList.add(new Product("1", String.format("%d", max),
				// "", quantityTextfield.getText(), String.format("%f",
				// unitPrice),
				// purchasePriceTextfield.getText()));

			} catch (Exception e2) {
				System.out.println(7);
				e2.printStackTrace();
			}

		});

		Button closeButton = new Button("Close");
		closeButton.setStyle(fontStyle);
		closeButton.setOnAction(e -> {
			purchaseStage.close();
		});

		Label quantityAvailableLable = new Label("Quantity Available : ");
		quantityAvailableLable.setStyle(fontStyle);

		printOKCancelGridPane.setPadding(new Insets(15, 100, 0, 400));
		printOKCancelGridPane.add(printPreviewButton, 0, 0);
		printOKCancelGridPane.add(printButton, 1, 0);
		printOKCancelGridPane.add(okButton, 0, 1);
		printOKCancelGridPane.add(closeButton, 1, 1);
		printOKCancelGridPane.add(quantityAvailableLable, 0, 2);
		// printOKCancelGridPane.add(separatorVertical, 3, 0);

		HBox hBox = new HBox(20);

		GridPane aa = new GridPane();
		aa.setVgap(10);
		aa.setHgap(10);

		Label totalAmountLabel = new Label("Total Amount : ");
		totalAmountLabel.setStyle(fontStyle);
		aa.add(totalAmountLabel, 0, 0);

		Label resultamount = new Label();
		resultamount.setStyle(fontStyle);
		aa.add(resultamount, 1, 0);

		Label discountLabel1 = new Label("Extra Charges : ");
		discountLabel1.setStyle(fontStyle);
		aa.add(discountLabel1, 0, 1);

		Label rlabel = new Label();
		rlabel.setStyle(fontStyle);
		aa.add(rlabel, 1, 1);

		Label netAmountLabel = new Label("Net Amount : ");
		netAmountLabel.setStyle(fontStyle);
		aa.add(netAmountLabel, 0, 2);

		Label rLabel = new Label();
		rLabel.setStyle(fontStyle);
		aa.add(rLabel, 1, 2);

		purchasePriceTextfield.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				rLabel.setText(newValue);
				resultamount.setText(newValue);
				rlabel.setText("0.0");
			}
		});

		VBox amountVBox = new VBox(15);
		amountVBox.setPadding(new Insets(20, 0, 0, 0));
		amountVBox.setAlignment(Pos.TOP_RIGHT);
		amountVBox.getChildren().addAll(aa);

		Separator separatorVertical = new Separator();
		separatorVertical.setOrientation(Orientation.VERTICAL);
		separatorVertical.setValignment(VPos.TOP);

		HBox separatorAmounthBox = new HBox(8);
		HBox separatorhBox = new HBox(8);
		separatorhBox.setPadding(new Insets(2, 0, 2, 110));
		separatorhBox.getChildren().add(separatorVertical);

		separatorAmounthBox.getChildren().addAll(separatorhBox, amountVBox);

		hBox.getChildren().addAll(printOKCancelGridPane, separatorAmounthBox);

		stackPane1.getChildren().addAll(hBox);
		// part3 finishes

		root.getChildren().addAll(stackPane, tableVBox, stackPane1);

		Scene scene = new Scene(root);
		purchaseStage.setScene(scene);

		purchaseStage.show();
	}

	public void purchaseWindowPromt() {
		Stage stage = new Stage();
		stage.setTitle("Purchase Promt");

		VBox root = new VBox(10);
		root.setPadding(new Insets(15));

		GridPane gridPane = new GridPane();
		gridPane.setVgap(5);
		gridPane.setHgap(10);

		String fontStyle = "-fx-font-weight: bold";

		Label sizeGroupLabel = new Label("Size Group");
		sizeGroupLabel.setStyle(fontStyle);
		gridPane.add(sizeGroupLabel, 0, 0);

		ChoiceBox<String> sizeGroupTextField = new ChoiceBox<String>();
		gridPane.add(sizeGroupTextField, 1, 0);

		Label colorLabel = new Label("   Color");
		colorLabel.setStyle(fontStyle);
		gridPane.add(colorLabel, 2, 0);

		CheckBox chocolateCheckBox = new CheckBox("Chocolate");
		chocolateCheckBox.setStyle(fontStyle);
		gridPane.add(chocolateCheckBox, 3, 0);

		CheckBox blackCheckBox = new CheckBox("Black");
		blackCheckBox.setStyle(fontStyle);
		gridPane.add(blackCheckBox, 4, 0);

		CheckBox redCheckBox = new CheckBox("Red");
		redCheckBox.setStyle(fontStyle);
		gridPane.add(redCheckBox, 5, 0);

		CheckBox blueCheckBox = new CheckBox("Blue");
		blueCheckBox.setStyle(fontStyle);
		gridPane.add(blueCheckBox, 3, 1);

		CheckBox yellowCheckBox = new CheckBox("Yellow");
		yellowCheckBox.setStyle(fontStyle);
		gridPane.add(yellowCheckBox, 4, 1);

		CheckBox greenCheckBox = new CheckBox("Green");
		greenCheckBox.setStyle(fontStyle);
		gridPane.add(greenCheckBox, 5, 1);

		CheckBox brownCheckBox = new CheckBox("Brown");
		brownCheckBox.setStyle(fontStyle);
		gridPane.add(brownCheckBox, 3, 2);

		StackPane stackPane = new StackPane();
		stackPane.setPadding(new Insets(10));
		stackPane.setAlignment(Pos.TOP_CENTER);

		Rectangle r = new Rectangle(400, 200, Color.WHITE);
		r.setStroke(Color.BLACK);
		r.setStrokeWidth(1);
		stackPane.getChildren().add(r);

		root.getChildren().addAll(gridPane, stackPane);

		Scene scene = new Scene(root, 450, 320);
		stage.setScene(scene);
		stage.show();
	}

	public void purchaseReturnWindow() {
		Stage purchaseReturnStage = new Stage();
		purchaseReturnStage.setTitle("Purchase Return");

		VBox root = new VBox(10);

		// part1 starts
		StackPane stackPane = new StackPane();
		stackPane.setPadding(new Insets(15));
		stackPane.setAlignment(Pos.TOP_CENTER);
		Rectangle r = new Rectangle(1020, 230, Color.WHITE);
		r.setStroke(Color.BLACK);
		r.setStrokeWidth(1);
		stackPane.getChildren().add(r);

		GridPane gridPane = new GridPane();
		gridPane.setVgap(10);
		gridPane.setHgap(10);
		gridPane.setPadding(new Insets(15));

		String fontStyle = "-fx-font-weight: bold";

		Label refNoLabel = new Label("Ref No.");
		refNoLabel.setStyle(fontStyle);
		gridPane.add(refNoLabel, 0, 0);

		GridPane refNSaleDateGridPane = new GridPane();
		refNSaleDateGridPane.setHgap(10);

		TextField refNoTextField = new TextField();
		// refNoTextField.setPrefWidth(100);
		refNSaleDateGridPane.add(refNoTextField, 0, 0);

		Label saleDateLabel = new Label("     Return Date");
		saleDateLabel.setStyle(fontStyle);
		refNSaleDateGridPane.add(saleDateLabel, 1, 0);

		DatePicker datePicker = new DatePicker();
		datePicker.setValue(LocalDate.now());
		refNSaleDateGridPane.add(datePicker, 2, 0);

		gridPane.add(refNSaleDateGridPane, 1, 0);

		Label invoiceLabel = new Label("       Invoice No.");
		invoiceLabel.setStyle(fontStyle);
		gridPane.add(invoiceLabel, 2, 0);

		TextField invoiceTextField = new TextField();
		invoiceTextField.setPrefWidth(100);
		gridPane.add(invoiceTextField, 3, 0);

		Label supplierGroupLabel = new Label("Supplier Group");
		supplierGroupLabel.setStyle(fontStyle);
		gridPane.add(supplierGroupLabel, 0, 1);

		TextField supplierGroupTextfield = new TextField();
		supplierGroupTextfield.setPrefWidth(250);
		gridPane.add(supplierGroupTextfield, 1, 1);

		Label supplierNameLabel = new Label("  Supplier Name");
		supplierNameLabel.setStyle(fontStyle);
		gridPane.add(supplierNameLabel, 2, 1);

		TextField supplierNameTextfield = new TextField();
		supplierNameTextfield.setPrefWidth(350);
		gridPane.add(supplierNameTextfield, 3, 1);

		Label productGroupLabel = new Label("Product Group");
		productGroupLabel.setStyle(fontStyle);
		gridPane.add(productGroupLabel, 0, 2);

		TextField productGroupTextfield = new TextField();
		// productGroupTextfield.setPrefWidth(250);
		gridPane.add(productGroupTextfield, 1, 2);

		Label productModelLabel = new Label("  Product Model");
		productModelLabel.setStyle(fontStyle);
		gridPane.add(productModelLabel, 2, 2);

		TextField productModelTextfield = new TextField();
		productModelTextfield.setMinWidth(349);
		gridPane.add(productModelTextfield, 3, 2);

		Label quantityLabel = new Label("Quantity");
		quantityLabel.setStyle(fontStyle);
		gridPane.add(quantityLabel, 0, 4);

		GridPane quantityshowroomGridPane = new GridPane();
		quantityshowroomGridPane.setHgap(10);

		TextField quantityTextfield = new TextField();
		quantityshowroomGridPane.add(quantityTextfield, 0, 0);

		Label showroomLabel = new Label("  Showroom");
		showroomLabel.setStyle(fontStyle);
		quantityshowroomGridPane.add(showroomLabel, 1, 0);

		ChoiceBox<String> showroomChoiceBox = new ChoiceBox<String>();
		showroomChoiceBox.setMinWidth(150);
		quantityshowroomGridPane.add(showroomChoiceBox, 2, 0);

		gridPane.add(quantityshowroomGridPane, 1, 4);

		Label barcodeSerialLabel = new Label("Barcode Serial");
		barcodeSerialLabel.setStyle(fontStyle);
		gridPane.add(barcodeSerialLabel, 0, 3);

		TextField barcodeSerialTextfield = new TextField();
		gridPane.add(barcodeSerialTextfield, 1, 3);

		stackPane.getChildren().add(gridPane);
		// part1 finishes

		// part2 starts
		VBox tableVBox = new VBox();
		tableVBox.setPadding(new Insets(-10, 15, 20, 15));
		tableVBox.setMaxHeight(210);

		TableView tableView = new TableView();

		TableColumn serialColum = new TableColumn("SL");
		TableColumn productCodeColumn = new TableColumn("Product Code");
		TableColumn supplierNameColumn = new TableColumn("Supplier Name");
		TableColumn productDescriptionColumn = new TableColumn("Product Description");
		TableColumn quantityColumn = new TableColumn("Quantity");
		TableColumn priceColumn = new TableColumn("Unit Price");
		TableColumn amountColumn = new TableColumn("Amount");

		tableView.getColumns().addAll(serialColum, productCodeColumn, supplierNameColumn, productDescriptionColumn,
				quantityColumn, priceColumn, amountColumn);

		tableVBox.getChildren().add(tableView);
		// part2 finishes

		// part3 starts
		StackPane stackPane1 = new StackPane();
		stackPane1.setPadding(new Insets(-15, 0, 20, 0));
		// stackPane1.setAlignment(Pos.TOP_CENTER);
		Rectangle r1 = new Rectangle(1020, 130, Color.WHITE);
		r1.setStroke(Color.BLACK);
		r1.setStrokeWidth(1);
		stackPane1.getChildren().add(r1);

		GridPane printOKCancelGridPane = new GridPane();
		printOKCancelGridPane.setVgap(20);
		printOKCancelGridPane.setHgap(30);

		Button printPreviewButton = new Button("P. Return Preview");
		printPreviewButton.setStyle(fontStyle);
		printPreviewButton.setMinWidth(120);

		Button printButton = new Button("Print");
		printButton.setStyle(fontStyle);
		// printButton.setMaxWidth(100);

		Button okButton = new Button("OK");
		okButton.setStyle(fontStyle);
		okButton.setMaxWidth(120);

		Button closeButton = new Button("Close");
		closeButton.setStyle(fontStyle);

		Label quantityAvailableLable = new Label("Quantity Available : ");
		quantityAvailableLable.setStyle(fontStyle);

		printOKCancelGridPane.setPadding(new Insets(15, 100, 0, 400));
		printOKCancelGridPane.add(printPreviewButton, 0, 0);
		printOKCancelGridPane.add(printButton, 1, 0);
		printOKCancelGridPane.add(okButton, 0, 1);
		printOKCancelGridPane.add(closeButton, 1, 1);
		printOKCancelGridPane.add(quantityAvailableLable, 0, 2);

		HBox hBox = new HBox(20);

		Label totalAmountLabel = new Label("Total Amount : ");
		totalAmountLabel.setStyle(fontStyle);

		VBox amountVBox = new VBox(15);
		amountVBox.setPadding(new Insets(50, 0, 0, 0));
		amountVBox.setAlignment(Pos.TOP_RIGHT);
		amountVBox.getChildren().addAll(totalAmountLabel);

		Separator separatorVertical = new Separator();
		separatorVertical.setOrientation(Orientation.VERTICAL);
		separatorVertical.setValignment(VPos.TOP);

		HBox separatorAmounthBox = new HBox(8);
		HBox separatorhBox = new HBox(8);
		separatorhBox.setPadding(new Insets(2, 0, 2, 110));
		separatorhBox.getChildren().add(separatorVertical);

		separatorAmounthBox.getChildren().addAll(separatorhBox, amountVBox);

		hBox.getChildren().addAll(printOKCancelGridPane, separatorAmounthBox);

		stackPane1.getChildren().addAll(hBox);
		// part3 finishes

		root.getChildren().addAll(stackPane, tableVBox, stackPane1);

		Scene scene = new Scene(root);
		purchaseReturnStage.setScene(scene);
		purchaseReturnStage.show();
	}

	public void productSearchWindow() {
		Stage productSearchStage = new Stage();
		productSearchStage.setTitle("Product Search");

		String fontStyle = "-fx-font-weight: bold";

		VBox root = new VBox(10);

		StackPane stackPane = new StackPane();
		stackPane.setPadding(new Insets(15));
		Rectangle r = new Rectangle(1000, 130, Color.WHITE);
		r.setStroke(Color.BLACK);
		r.setStrokeWidth(1);
		stackPane.getChildren().add(r);

		GridPane searchByGridPane = new GridPane();
		searchByGridPane.setPadding(new Insets(10));
		searchByGridPane.setVgap(5);
		searchByGridPane.setHgap(15);

		Label searchByLabel = new Label("Search By ");
		searchByLabel.setStyle(fontStyle);
		searchByGridPane.add(searchByLabel, 0, 0);

		RadioButton serialRadioButton = new RadioButton("Serial");
		serialRadioButton.setStyle(fontStyle);
		searchByGridPane.add(serialRadioButton, 1, 0);

		TextField serialTextField = new TextField();
		searchByGridPane.add(serialTextField, 2, 0);

		RadioButton productGroupRadioButton = new RadioButton("Product Group");
		productGroupRadioButton.setStyle(fontStyle);
		searchByGridPane.add(productGroupRadioButton, 1, 1);

		TextField productGroupTextField = new TextField();
		productGroupTextField.setMinWidth(300);
		searchByGridPane.add(productGroupTextField, 2, 1);

		Label productModelLabel = new Label("  P. Model");
		productModelLabel.setStyle(fontStyle);
		searchByGridPane.add(productModelLabel, 3, 1);

		ComboBox productModelComboBox = new ComboBox();
		productModelComboBox.setEditable(true);
		searchByGridPane.add(productModelComboBox, 4, 1);

		Label sizeLabel = new Label("  Size");
		sizeLabel.setStyle(fontStyle);
		searchByGridPane.add(sizeLabel, 3, 2);

		ChoiceBox sizeChoiceBox = new ChoiceBox();
		searchByGridPane.add(sizeChoiceBox, 4, 2);

		Label colorLabel = new Label("  Color");
		colorLabel.setStyle(fontStyle);
		searchByGridPane.add(colorLabel, 3, 3);

		ChoiceBox colorChoiceBox = new ChoiceBox();
		searchByGridPane.add(colorChoiceBox, 4, 3);

		stackPane.getChildren().add(searchByGridPane);

		VBox currentHistoryVBox = new VBox(5);
		currentHistoryVBox.setPadding(new Insets(-15, 15, 15, 15));

		Text currentHistoryText = new Text("Current History");
		currentHistoryText.setStyle(fontStyle);
		currentHistoryVBox.getChildren().add(currentHistoryText);

		TableView tableView = new TableView();
		tableView.setMaxHeight(150);

		TableColumn refColum = new TableColumn("Ref. ");
		TableColumn supplierGroupColum = new TableColumn("Supplier Group");
		TableColumn supplierNameColumn = new TableColumn("Supplier Name");
		TableColumn productModelColumn = new TableColumn("Product Model");
		TableColumn serialNoColumn = new TableColumn("Serial No");
		TableColumn productCodeColumn = new TableColumn("Product Code");
		TableColumn quantityAvailableColumn = new TableColumn("Quantity Available");
		TableColumn sizeColumn = new TableColumn("Size");
		TableColumn colorColumn = new TableColumn("Color");
		TableColumn priceColumn = new TableColumn("Unit Price");

		tableView.getColumns().addAll(refColum, supplierGroupColum, supplierNameColumn, serialNoColumn,
				productCodeColumn, quantityAvailableColumn, sizeColumn, colorColumn, priceColumn);

		currentHistoryVBox.getChildren().add(tableView);

		root.getChildren().addAll(stackPane, currentHistoryVBox);

		Scene scene = new Scene(root);
		productSearchStage.setScene(scene);
		productSearchStage.show();

	}

	public void auctionWindow() {
		Stage salesBillingInvoiceStage = new Stage();
		salesBillingInvoiceStage.setTitle("Auction");

		VBox root = new VBox(10);

		// part1 starts
		StackPane stackPane = new StackPane();
		stackPane.setPadding(new Insets(15));
		stackPane.setAlignment(Pos.TOP_CENTER);
		Rectangle r = new Rectangle(1020, 230, Color.WHITE);
		r.setStroke(Color.BLACK);
		r.setStrokeWidth(1);
		stackPane.getChildren().add(r);

		GridPane gridPane = new GridPane();
		gridPane.setVgap(10);
		gridPane.setHgap(10);
		gridPane.setPadding(new Insets(15));

		String fontStyle = "-fx-font-weight: bold";

		Label refNoLabel = new Label("Ref No.");
		refNoLabel.setStyle(fontStyle);
		gridPane.add(refNoLabel, 0, 0);

		GridPane refNSaleDateGridPane = new GridPane();
		refNSaleDateGridPane.setHgap(10);

		TextField refNoTextField = new TextField();
		// refNoTextField.setPrefWidth(40);
		refNSaleDateGridPane.add(refNoTextField, 0, 0);

		Label saleDateLabel = new Label("Sale Date");
		saleDateLabel.setStyle(fontStyle);
		refNSaleDateGridPane.add(saleDateLabel, 1, 0);

		DatePicker datePicker = new DatePicker();
		datePicker.setValue(LocalDate.now());
		refNSaleDateGridPane.add(datePicker, 2, 0);

		gridPane.add(refNSaleDateGridPane, 1, 0);

		Label mobileLabel = new Label("  Mobile");
		mobileLabel.setStyle(fontStyle);
		gridPane.add(mobileLabel, 2, 0);

		GridPane mobileInvoiceGridPane = new GridPane();
		mobileInvoiceGridPane.setHgap(10);

		TextField mobileTextField = new TextField();
		mobileInvoiceGridPane.add(mobileTextField, 0, 0);

		Label invoiceLabel = new Label("Invoice No.");
		invoiceLabel.setStyle(fontStyle);
		mobileInvoiceGridPane.add(invoiceLabel, 1, 0);

		TextField invoiceTextField = new TextField();
		mobileInvoiceGridPane.add(invoiceTextField, 2, 0);

		gridPane.add(mobileInvoiceGridPane, 3, 0);

		Label customerNameLabel = new Label("Customer Name");
		customerNameLabel.setStyle(fontStyle);
		gridPane.add(customerNameLabel, 0, 1);

		TextField customerNameTextfield = new TextField();
		customerNameTextfield.setPrefWidth(250);
		gridPane.add(customerNameTextfield, 1, 1);

		Label paymentTypeLabel = new Label("  Payment Type");
		paymentTypeLabel.setStyle(fontStyle);
		gridPane.add(paymentTypeLabel, 2, 1);

		HBox paymentTypeHBox = new HBox(15);
		paymentTypeHBox.setPadding(new Insets(5, 0, 0, 0));

		CheckBox paymentTypeCash = new CheckBox(" Cash    ");
		paymentTypeCash.setStyle(fontStyle);
		paymentTypeHBox.getChildren().add(paymentTypeCash);

		CheckBox paymentTypeDue = new CheckBox(" Due    ");
		paymentTypeDue.setStyle(fontStyle);
		paymentTypeHBox.getChildren().add(paymentTypeDue);

		CheckBox paymentTypeHalf = new CheckBox("Half");
		paymentTypeHalf.setStyle(fontStyle);
		paymentTypeHBox.getChildren().add(paymentTypeHalf);

		gridPane.add(paymentTypeHBox, 3, 1);

		Label productGroupLabel = new Label("Product Group");
		productGroupLabel.setStyle(fontStyle);
		gridPane.add(productGroupLabel, 0, 2);

		TextField productGroupTextfield = new TextField();
		// productGroupTextfield.setPrefWidth(250);
		gridPane.add(productGroupTextfield, 1, 2);

		Label productModelLabel = new Label("  Product Model");
		productModelLabel.setStyle(fontStyle);
		gridPane.add(productModelLabel, 2, 2);

		TextField productModelTextfield = new TextField();
		// productModelTextfield.setPrefWidth(250);
		gridPane.add(productModelTextfield, 3, 2);

		Label barcodeSerialLabel = new Label("Barcode Serial");
		barcodeSerialLabel.setStyle(fontStyle);
		gridPane.add(barcodeSerialLabel, 0, 3);

		TextField barcodeSerialTextfield = new TextField();
		// productModelTextfield.setPrefWidth(250);
		gridPane.add(barcodeSerialTextfield, 1, 3);

		Label sizeLabel = new Label("  Size");
		sizeLabel.setStyle(fontStyle);
		gridPane.add(sizeLabel, 2, 3);

		GridPane sizeColorGridPane = new GridPane();
		sizeColorGridPane.setHgap(10);

		TextField sizeTextfield = new TextField();
		sizeColorGridPane.add(sizeTextfield, 0, 0);

		Label colorLabel = new Label("         Color");
		colorLabel.setStyle(fontStyle);
		sizeColorGridPane.add(colorLabel, 1, 0);

		TextField colorTextfield = new TextField();
		sizeColorGridPane.add(colorTextfield, 2, 0);

		gridPane.add(sizeColorGridPane, 3, 3);

		Label salesmanLabel = new Label("Salesman");
		salesmanLabel.setStyle(fontStyle);
		gridPane.add(salesmanLabel, 0, 4);

		TextField salesmanTextfield = new TextField();
		gridPane.add(salesmanTextfield, 1, 4);

		Label showroomLabel = new Label("  Showroom");
		showroomLabel.setStyle(fontStyle);
		gridPane.add(showroomLabel, 2, 4);

		TextField showroomTextfield = new TextField();
		gridPane.add(showroomTextfield, 3, 4);

		Label quantityLabel = new Label("Quantity");
		quantityLabel.setStyle(fontStyle);
		gridPane.add(quantityLabel, 0, 5);

		GridPane quantityPriceGridPane = new GridPane();
		quantityPriceGridPane.setHgap(10);

		TextField quantityTextfield = new TextField();
		quantityPriceGridPane.add(quantityTextfield, 0, 0);

		Label priceLabel = new Label("       Unit Price");
		priceLabel.setStyle(fontStyle);
		quantityPriceGridPane.add(priceLabel, 1, 0);

		TextField priceTextfield = new TextField();
		quantityPriceGridPane.add(priceTextfield, 2, 0);

		gridPane.add(quantityPriceGridPane, 1, 5);

		Label discountLabel = new Label("  Discount");
		discountLabel.setStyle(fontStyle);
		gridPane.add(discountLabel, 2, 5);

		GridPane discountWarrantyGridPane = new GridPane();
		discountWarrantyGridPane.setHgap(10);

		TextField discountTextfield = new TextField();
		discountWarrantyGridPane.add(discountTextfield, 0, 0);

		Label warrantyLabel = new Label("   Warranty");
		warrantyLabel.setStyle(fontStyle);
		discountWarrantyGridPane.add(warrantyLabel, 1, 0);

		TextField warrantyTextfield = new TextField();
		discountWarrantyGridPane.add(warrantyTextfield, 2, 0);

		gridPane.add(discountWarrantyGridPane, 3, 5);

		stackPane.getChildren().add(gridPane);
		// part1 finishes

		// part2 starts
		VBox tableVBox = new VBox();
		tableVBox.setPadding(new Insets(-10, 15, 20, 15));
		tableVBox.setMaxHeight(210);

		TableView tableView = new TableView();

		TableColumn serialColum = new TableColumn("SL");
		// serialColum.setStyle("-fx-cell-size: 208px;");
		TableColumn productCodeColumn = new TableColumn("Product Code");
		TableColumn productDescriptionColumn = new TableColumn("Product Description");
		TableColumn quantityColumn = new TableColumn("Quantity");
		TableColumn priceColumn = new TableColumn("Unit Price");
		TableColumn amountColumn = new TableColumn("Amount");

		tableView.getColumns().addAll(serialColum, productCodeColumn, productDescriptionColumn, quantityColumn,
				priceColumn, amountColumn);

		tableVBox.getChildren().add(tableView);
		// part2 finishes

		// part3 starts
		StackPane stackPane1 = new StackPane();
		stackPane1.setPadding(new Insets(-15, 0, 20, 0));
		// stackPane1.setAlignment(Pos.TOP_CENTER);
		Rectangle r1 = new Rectangle(1020, 130, Color.WHITE);
		r1.setStroke(Color.BLACK);
		r1.setStrokeWidth(1);
		stackPane1.getChildren().add(r1);

		GridPane printOKCancelGridPane = new GridPane();
		printOKCancelGridPane.setVgap(20);
		printOKCancelGridPane.setHgap(30);

		Button printPreviewButton = new Button("Print Preview");
		printPreviewButton.setStyle(fontStyle);
		printPreviewButton.setMaxWidth(100);

		Button printButton = new Button("Print");
		printButton.setStyle(fontStyle);
		// printButton.setMaxWidth(100);

		Button okButton = new Button("OK");
		okButton.setStyle(fontStyle);
		okButton.setMaxWidth(100);

		Button closeButton = new Button("Close");
		closeButton.setStyle(fontStyle);

		Label quantityAvailableLable = new Label("Quantity Available : ");
		quantityAvailableLable.setStyle(fontStyle);

		printOKCancelGridPane.setPadding(new Insets(15, 100, 0, 400));
		printOKCancelGridPane.add(printPreviewButton, 0, 0);
		printOKCancelGridPane.add(printButton, 1, 0);
		printOKCancelGridPane.add(okButton, 0, 1);
		printOKCancelGridPane.add(closeButton, 1, 1);
		printOKCancelGridPane.add(quantityAvailableLable, 0, 2);
		// printOKCancelGridPane.add(separatorVertical, 3, 0);

		HBox hBox = new HBox(20);

		Label totalAmountLabel = new Label("Total Amount : ");
		totalAmountLabel.setStyle(fontStyle);

		Label vatLabel = new Label("Vat : ");
		vatLabel.setStyle(fontStyle);

		Label discountLabel1 = new Label("Discount : ");
		discountLabel1.setStyle(fontStyle);

		Label netAmountLabel = new Label("Net Amount : ");
		netAmountLabel.setStyle(fontStyle);

		VBox amountVBox = new VBox(15);
		amountVBox.setPadding(new Insets(10, 0, 0, 0));
		amountVBox.setAlignment(Pos.TOP_RIGHT);
		amountVBox.getChildren().addAll(totalAmountLabel, vatLabel, discountLabel1, netAmountLabel);

		Separator separatorVertical = new Separator();
		separatorVertical.setOrientation(Orientation.VERTICAL);
		separatorVertical.setValignment(VPos.TOP);

		HBox separatorAmounthBox = new HBox(8);
		HBox separatorhBox = new HBox(8);
		separatorhBox.setPadding(new Insets(2, 0, 2, 120));
		separatorhBox.getChildren().add(separatorVertical);

		separatorAmounthBox.getChildren().addAll(separatorhBox, amountVBox);

		hBox.getChildren().addAll(printOKCancelGridPane, separatorAmounthBox);

		stackPane1.getChildren().addAll(hBox);
		// part3 finishes

		root.getChildren().addAll(stackPane, tableVBox, stackPane1);

		Scene scene = new Scene(root);
		salesBillingInvoiceStage.setScene(scene);
		salesBillingInvoiceStage.show();

	}

	public void accountWindow() {
		Stage accountStage = new Stage();
		accountStage.setTitle("Account");

		String fontStyle = "-fx-font-weight: bold";

		GridPane root = new GridPane();
		root.setVgap(30);
		root.setAlignment(Pos.CENTER);

		Button manageSalesmanButton = new Button("Manage Salesman");
		manageSalesmanButton.setStyle(fontStyle);
		manageSalesmanButton.setMinWidth(130);
		root.add(manageSalesmanButton, 0, 0);

		Button addSalesmanButton = new Button("Add Salesman");
		addSalesmanButton.setStyle(fontStyle);
		addSalesmanButton.setMinWidth(130);
		root.add(addSalesmanButton, 0, 1);

		Button removeSalesmanButton = new Button("Remove Salesman");
		removeSalesmanButton.setMinWidth(130);
		removeSalesmanButton.setStyle(fontStyle);
		root.add(removeSalesmanButton, 0, 2);

		Scene scene = new Scene(root, 400, 350);
		accountStage.setScene(scene);
		accountStage.show();
	}

	public void validation(TextField tf, String text) {

		if (tf.getText().trim().isEmpty()) {
			Alert fail = new Alert(AlertType.INFORMATION);
			fail.setHeaderText("failure");
			fail.setContentText("you havent typed " + text);
			fail.showAndWait();
		}
		// else {
		// Alert alert = new Alert(AlertType.INFORMATION);
		// alert.setHeaderText("Succes");
		// alert.setContentText("Account succesfully created!");
		// alert.showAndWait();
		// }
	}

	public void addProductModel() {

	}

	public void addSupplier(String idd) {

		Stage primaryStage = new Stage();
		primaryStage.setTitle("Add Supplier");
		VBox root3 = new VBox();
		root3.setPadding(new Insets(40));
		root3.setSpacing(10);

		// ObservableList<Supplier>
		// supplier=FXCollections.observableArrayList();

		// supplier.add(idText1.getText(),nameText1,cb,phoneText,companyText,emailText);

		// Name Field
		Label name1 = new Label("Name");
		name1.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		TextField nameText1 = new TextField();
		nameText1.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent ae){
				ObservableList data = FXCollections.observableArrayList();
				ArrayList<String> stringArrayList = Database.returnOneColumn("select * from supplier where name = '" + nameText1 + "'", 2);
				
				for(String s : stringArrayList)
					data.add(s);
				
				AutoFillTextBox fil= new AutoFillTextBox(data);
				
			}
		});

		// Id Field

		Label id1 = new Label("ID");
		id1.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		TextField idText1 = new TextField(idd);
		idText1.setDisable(true);
		// Separator separator3 = new Separator();

		Label City = new Label("City");
		City.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		// Separator separator=new Separator();

		ChoiceBox cb = new ChoiceBox();
		cb.getItems().addAll("Dhaka", "Sylet", "Khulna", "Rajshahi", "MYmensingh", "Chittagong", "Barisal");
		// Separator separator4=new Separator();

		Label email = new Label();
		email.setText("Email (e.g www.john@gmail.com)");
		email.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		TextField emailText = new TextField();
		// Separator separator6 = new Separator();

		Label phone = new Label();
		phone.setText("Phone Number ");
		phone.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		TextField phoneText = new TextField();
		phoneText.setPromptText("+880");
		// Separator separator7 = new Separator();

		Label company = new Label();
		company.setText("Supplier Group");
		company.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		ComboBox<String> SupplierGroup = new ComboBox();
		SupplierGroup.getItems().addAll("Market", "Local Supplier");
		// Separator separator8 = new Separator();

		HBox hbox8 = new HBox(100);
		hbox8.setPadding(new Insets(20, 0, 0, 0));
		Button submit = new Button("ADD");
		Button cancel1 = new Button("Cancel");
		hbox8.getChildren().addAll(submit, cancel1);

		submit.setOnAction(e -> {
			
			
			String stringName = Database.returnString("select * from supplier Where Name = '" + nameText1.getText() + "'",
					2);
			
			String stringPhone = Database.returnString("select * from supplier Where Phone = '" + phoneText.getText() + "'",
					4);
			
			if (stringName.equals("")) {
				String query = ("insert into supplier (SUPPLIER_ID,NAME ,SUPPLIER_GROUP ,PHONE,EMAIL,CITY) values ("
						+ idd + " ,'" + nameText1.getText() + "','" + SupplierGroup.getValue() + "' ,'"
						+ phoneText.getText() + "','" + emailText.getText() + "','" + cb.getValue() + "')");
				
				Database.executeQuery(query);
				primaryStage.close();
			} else {
				AlertBox.alertBox("Duplicate Name !! The name should be unique.");
				nameText1.clear();
				
			}
			supplierNameComboBox.getItems().clear();
			productModelComboBox.getItems().clear();
			

		});
		cancel1.setOnAction(e -> {

			primaryStage.close();

		});

		root3.getChildren().addAll(name1, nameText1, id1, idText1);
		root3.getChildren().addAll(City, cb);
		root3.getChildren().addAll(email, emailText);
		root3.getChildren().addAll(phone, phoneText);
		root3.getChildren().addAll(company, SupplierGroup, hbox8);
		Scene scene4 = new Scene(root3);
		primaryStage.setScene(scene4);
		primaryStage.showAndWait();
	}
}
