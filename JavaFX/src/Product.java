import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.Barcode;
import com.itextpdf.text.pdf.BarcodeEAN;
import com.itextpdf.text.pdf.PdfWriter;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

enum paymentTypeEnum {
	Cash, Due, Partial
}

enum productGroupEnum {
	Gents(1), Ladies(2), Baby(3);

	private int value;

	productGroupEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}

enum productCountryEnum {
	Bangladesh(1), China(2), India(3), Thailand(4), Italy(5), Others(6);

	private int value;

	productCountryEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}

enum supplierGroupEnum {
	Market, Supplier
}

enum colorEnum {
	None(0), Chocolate(1), Black(2), Red(3), White(4), Yellow(5), Brown(6), Blue(7), Green(8);

	private int value;

	private colorEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}

enum sizeGroupEnum {
	SixNine
}

class Product {
	protected String productId;
	protected String productGroup;
	protected String productCountry;
	protected String productModel;
	protected String productDescription;
	protected String quantity;
	protected String sizeGroup;
	protected String purchasePrice;
	protected String unitPrice;
	protected String salePrice;
	protected String fixPrice;

	/**
	 * @param productId
	 * @param productGroup
	 * @param productCountry
	 * @param productModel
	 * @param productDescription
	 * @param quantity
	 * @param sizeGroup
	 * @param purchasePrice
	 * @param unitPrice
	 * @param salePrice
	 * @param fixPrice
	 */
	public Product(String productId, String productGroup, String productCountry, String productModel,
			String productDescription, String quantity, String sizeGroup, String purchasePrice, String unitPrice,
			String salePrice, String fixPrice) {
		super();
		this.productId = productId;
		this.productGroup = productGroup;
		this.productCountry = productCountry;
		this.productModel = productModel;
		this.productDescription = productDescription;
		this.quantity = quantity;
		this.sizeGroup = sizeGroup;
		this.purchasePrice = purchasePrice;
		this.unitPrice = unitPrice;
		this.salePrice = salePrice;
		this.fixPrice = fixPrice;
	}

}

class productBarcode extends Product {
	protected String productBarcode;
	protected String size;
	protected String color;

	/**
	 * @param productId
	 * @param productGroup
	 * @param productCountry
	 * @param productModel
	 * @param productDescription
	 * @param quantity
	 * @param sizeGroup
	 * @param purchasePrice
	 * @param unitPrice
	 * @param salePrice
	 * @param fixPrice
	 * @param productBarcode
	 * @param size
	 * @param color
	 */
	public productBarcode(String productId, String productGroup, String productCountry, String productModel,
			String productDescription, String quantity, String sizeGroup, String purchasePrice, String unitPrice,
			String salePrice, String fixPrice, String productBarcode, String size, String color) {
		super(productId, productGroup, productCountry, productModel, productDescription, quantity, sizeGroup,
				purchasePrice, unitPrice, salePrice, fixPrice);
		this.productBarcode = productBarcode;
		this.size = size;
		this.color = color;
	}

}

class Address {
	String city, area, country;
	int postalCode;

	public Address(String city, String state, int postalCode, String country) {
		this.city = city;
		this.area = state;
		this.postalCode = postalCode;
		this.country = country;
	}

	public Address() {
		this.city = "Not Available";
		this.area = "Not Available";
		this.postalCode = 0;
		this.country = "Not Available";
	}

}

class Person {
	protected String name;
	protected int id;
	protected Address address;
	// protected Date birthDate;
	protected String phoneNumber;
	protected String email;
	protected static int counter = 0;

	public Person() {
		super();
		this.name = "";
		this.id = counter++;
		this.phoneNumber = "";
		this.email = "";
	}

	public Person(String name, String phoneNumber, String email) {
		super();
		// super(date);
		this.name = name;
		this.id = counter++;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

}

class Supplier extends Person {
	protected supplierGroupEnum supplierGroup;

	Supplier(String supplierName, supplierGroupEnum supplierGroup) {
		super(supplierName, "", "");
		this.supplierGroup = supplierGroup;
	}

	Supplier(String name, supplierGroupEnum supplierGroup, Address address, String phoneNumber, String email) {

		this.supplierGroup = supplierGroup;
	}
}

class Customer {
	private String name;
	private int id;
	private static int counter = 0;

	public Customer() {
		this.name = "anonymous";
		this.id = ++counter;
	}

	public Customer(String name) {
		this.name = name;
		this.id = ++counter;
	}

}

class Barcodee {
	protected String barcodeData;

	public String getBarcodeData() {
		return barcodeData;
	}

	public void setBarcodeData(String barcodeData) {
		this.barcodeData = barcodeData;
	}

	public Barcodee() {
		// this.data = data;
	}

	public Barcodee(String data) {
		this.barcodeData = data;
	}

	public void generateBarcode(int quantity, int productId, int colorCode) throws Exception {
		// String barcodeData;
		int count = 0;
		int x = 36, y = 760;

		DecimalFormat formattingProductId = new DecimalFormat("000000");
		DecimalFormat formattingcount = new DecimalFormat("0000");
		DecimalFormat formattingSize = new DecimalFormat("00");

		Document document = new Document(PageSize.A4);

		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("barcode.pdf"));
		document.open();

		BarcodeEAN barcode39 = new BarcodeEAN();
		barcode39.setCodeType(barcode39.EAN13);
		Image image;

		for (int i = 1; i <= quantity; i++) {
			barcodeData = "" + formattingProductId.format(productId) + colorCode + "00"
					+ formattingcount.format(++count);

			System.out.println(barcodeData);
			barcode39.setCode(barcodeData);
			image = barcode39.createImageWithBarcode(writer.getDirectContent(), null, null);
			image.setAbsolutePosition(x, y);
			document.add(image);

			x += 108;
			if (x >= 480) {
				y -= 80;
				x = 36;
			}
			if (i % 50 == 0) {
				document.newPage();
				x = 36;
				y = 760;
			}

		}
		document.close();
	}

}

class Database {

	public static boolean executeQuery(String query) {
		ResultSet rs = null;
		try {
			// step1 load the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2 create the connection object
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","robinabdullah", "45659123in");

			// step3 create the statement object
			Statement stmt = con.createStatement();

			// step4 execute query
			rs = stmt.executeQuery(query);

			// while (rs.next())
			// System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " +
			// rs.getString(3));

			// step5 close the connection object
			con.close();
			return true;

		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}

	public static ArrayList<String> returnOneColumn(String query, int columnIndex) {

		ArrayList<String> resultArrayList = new ArrayList<String>();
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2 create the connection object
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "robinabdullah", "45659123in");

			// step3 create the statement object
			Statement stmt = con.createStatement();

			// step4 execute query rs = stmt.executeQuery(query);
			// rs = stmt.executeQuery(query);

			ResultSet rs = stmt.executeQuery(query);
			while (rs.next())
				resultArrayList.add(rs.getString(columnIndex));

			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return resultArrayList;
	}

	public static String returnString(String query, int column) {
		String string = "";
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2 create the connection object
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "robinabdullah", "45659123in");

			// step3 create the statement object
			Statement stmt = con.createStatement();

			// step4 execute query rs = stmt.executeQuery(query);
			// rs = stmt.executeQuery(query);

			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			string = rs.getString(column);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return string;
	}
	

}
class AlertBox{
	public static void alertBox(String message){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText(message);

		alert.showAndWait();
	}
}
