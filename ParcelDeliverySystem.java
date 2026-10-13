import java.util.Scanner;

import model.Box;
import model.DeliveryService;
import model.Document;
import model.Fragile;
import model.Parcel;

import strategy.ExpressDelivery;
import strategy.SameDayDelivery;
import strategy.StandardDelivery;
import strategy.DeliveryStrategy;

public class ParcelDeliverySystem{

  public static Scanner input = new Scanner(System.in);

  public static Items item = new Items();

  public static void addParcel(){
    Display.headerTitle("Add Parcel");
    Display.subHeaderTitle("Choose Parcel Type");
    Display.displayMenu("Document", "Box", "Fragile");

    int chooseParcel = Validations.menuChecker("Enter Parcel Type (1, 2, 3): ", 3);

    String parcelType = "";
    switch(chooseParcel){
      case 1 -> parcelType = "Document";
      case 2 -> parcelType = "Box";
      case 3 -> parcelType = "Fragile";
    }

    Display.subHeaderTitle(parcelType);

    String receiversName = Validations.stringEmptyChecker("Receiver's Name: ");
    double weight = Validations.weightChecker(String.format("Enter %s's weight: ", parcelType));

    //ADD TRACKING NUMBER
    String trackingNum = "ABC123";

    //delivery service -> express, standard, same day
    Display.subHeaderTitle("Delivery Service");
    Display.displayMenu("Standard Delivery", "Express Delivery", "Same Day Delivery");
    int serviceChoice = Validations.menuChecker("Choose your desired delivery service: ", 3);


    Parcel parcel = switch(chooseParcel){
      case 1 -> addDocument(trackingNum, receiversName, weight);
      case 2 -> addBox(trackingNum, receiversName, weight);
      case 3 -> new Fragile(parcelType, receiversName, weight, serviceChoice, chooseParcel, serviceChoice, receiversName);
      default -> throw new IllegalArgumentException("Invalid delivery service");
    };

    DeliveryStrategy delivery = switch(serviceChoice){
      case 1 -> new StandardDelivery();
      case 2 -> new ExpressDelivery();
      case 3 -> new SameDayDelivery();
      default -> throw new IllegalArgumentException();
    };

    double deliveryFee = parcel.getDeliveryFee(delivery);
    item.addParcelItem(parcel, deliveryFee);

    //status -> pending, delivered
  }

  public static Document addDocument(String trackingNum, String name, double weight){
    int pages = Validations.menuChecker("Enter number of pages", 100);
    return new Document(trackingNum, name, weight, pages);
  }

  public static Box addBox(String trackingNum, String name, double weight){
    int length = Validations.menuChecker("Enter length in cm: ", 100);
    int width = Validations.menuChecker("Enter width in cm: ", 100);
    int height = Validations.menuChecker("Enter height in cm: ", 100);
    return new Box(trackingNum, name, weight, length, width, height);
  }

  public static Box addFragile(String trackingNum, String name, double weight){
    int length = Validations.menuChecker("Enter length in cm: ", 100);
    int width = Validations.menuChecker("Enter width in cm: ", 100);
    int height = Validations.menuChecker("Enter height in cm: ", 100);
    String note = Validations.stringEmptyChecker("Enter note (put N/A if none): ");
    return new Fragile(trackingNum, name, weight, length, width, height, note);
  }
  public static void main(String[] args){
    System.out.println("\nSimple Inventory Management System by Ma. Angelica Pauleen R. De Chavez of C2A\n");

    boolean isExit = false;

    while(isExit){
      Display.headerTitle("Menu");
      Display.displayMenu("Add Parcel", "View All Parcels", "Change Delivery", "Mark as Delivered", "Exit");
      int menu = Validations.menuChecker("Enter Menu Choice (1, 2, 3, 4, 5): ", 5);

      switch(menu){
        case 1 -> addParcel();
        case 2 -> viewAllParcels();
        case 3 -> changeDeliveryService();
        case 4 -> markAsDelivered();
        case 5 -> isDone = true;
      }
    }
    System.out.println("Thank you for using Simple Inventory Management System by Ma. Angelica Pauleen R. De Chavez of C2A\n");
  }
}