import java.util.Scanner;

import model.Box;
import model.DeliveryService;
import model.Document;
import model.Fragile;
import model.Parcel;
import model.Status;

import strategy.ExpressDelivery;
import strategy.SameDayDelivery;
import strategy.StandardDelivery;
import strategy.DeliveryStrategy;

import organize.Display;
import organize.Validations;
import organize.ParcelManager;
import organize.ParcelNotFoundException;
import organize.DuplicateTrackingNumberException;

public class ParcelDeliverySystem{

  public static Scanner input = new Scanner(System.in);

  private static final ParcelManager manager = ParcelManager.getInstance();

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
    String trackingNum = readTrackingNum();

    while(ParcelManager.getInstance().trackingNumExists(trackingNum)){
      System.out.println("Tracking Number already exists. Use another tracking number.");
      trackingNum = Validations.stringEmptyChecker("Enter Tracking Number: ");
    }

    Parcel parcel = switch(chooseParcel){
      case 1 -> addDocument(trackingNum, receiversName, weight);
      case 2 -> addBox(trackingNum, receiversName, weight);
      case 3 -> addFragile(trackingNum, receiversName, weight);
      default -> throw new IllegalArgumentException("Invalid parcel.");
    };

    //delivery service -> express, standard, same day
    Display.subHeaderTitle("Delivery Service");
    Display.displayMenu("Standard Delivery", "Express Delivery", "Same Day Delivery");
    int serviceChoice = Validations.menuChecker("Choose your desired delivery service: ", 3);

    while(parcel.getChargeableWeight() <= 10 && serviceChoice == 3){
      System.out.println("Same Day delivery is only for parcels up to 10 kg!");
      serviceChoice = Validations.menuChecker("Choose your desired delivery service: ", 3);
    }

    //SET DELIVERY SERVICE
    DeliveryService service = switch(serviceChoice){
      case 1 -> DeliveryService.STANDARD;
      case 2 -> DeliveryService.EXPRESS;
      case 3 -> DeliveryService.SAME_DAY;
      default -> throw new IllegalArgumentException();
    };

    parcel.setDeliveryService(service);

    //CALCULATE DELIVERY FEE
    DeliveryStrategy delivery = switch(serviceChoice){
      case 1 -> new StandardDelivery();
      case 2 -> new ExpressDelivery();
      case 3 -> new SameDayDelivery();
      default -> throw new IllegalArgumentException();
    };

    double deliveryFee = parcel.getDeliveryFee(delivery);
    parcel.setDeliveryFee(deliveryFee);

    try{
      manager.addParcelItem(parcel);
    }catch(DuplicateTrackingNumberException e){
      System.out.println(e.getMessage());
    }

    System.out.printf("\nParcel added successfully! Delivery fee: Php %,.2f%n", deliveryFee);
  }

  private static String readTrackingNum(){
    System.out.println("\nTRACKING NUMBER FORMAT: ABC followed by 4 digits, e.g. ABC0001");
    String trackingNum = Validations.stringEmptyChecker("Enter Tracking Number: ");

    while(!Validations.validTrackingNum(trackingNum)){
      System.out.println("Wrong format. Use ABC followed by 4 digits, e.g. ABC0001");
      trackingNum = Validations.stringEmptyChecker("Enter Tracking Number: ");
    }

    return trackingNum;
  }

  public static Document addDocument(String trackingNum, String name, double weight){
    int pages = Validations.menuChecker("Enter number of pages: ", 100);
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

  public static void changeDeliveryService(){
    Display.headerTitle("Change Delivery Service");
    if(manager.getAllParcels().isEmpty()){
      System.out.println("No parcels available.");
      return;
    }

    String trackingNum = readTrackingNum();

    Parcel parcel;
    try{
      parcel = manager.findParcel(trackingNum);
    }catch(ParcelNotFoundException e){
      System.out.println(e.getMessage());
      return;
    };

    if(parcel.getStatus().equalsIgnoreCase(Status.DELIVERED.toString())){
      System.out.println("Parcel already delivered!");
      return;
    }

    Display.subHeaderTitle("Delivery Service");
    Display.displayMenu("Standard Delivery", "Express Delivery", "Same Day Delivery");
    int serviceChoice = Validations.menuChecker("Choose your desired delivery service: ", 3);

    if(parcel.getChargeableWeight() <= 10 && serviceChoice == 3){
      System.out.println("Same Day delivery is only for parcels up to 10 kg!");
      System.out.println("The parcel remains on " + parcel.getDeliveryService() + " delivery.");
      return;
    }

    //SET DELIVERY SERVICE
    DeliveryService service = switch(serviceChoice){
      case 1 -> DeliveryService.STANDARD;
      case 2 -> DeliveryService.EXPRESS;
      case 3 -> DeliveryService.SAME_DAY;
      default -> throw new IllegalArgumentException();
    };

    if(parcel.getDeliveryService().equalsIgnoreCase(service.toString())){
      System.out.println("This parcel is already set to " + service + ". No changes made.");
      return;
    }

    parcel.setDeliveryService(service);

    //CALCULATE DELIVERY FEE
    DeliveryStrategy delivery = switch(serviceChoice){
      case 1 -> new StandardDelivery();
      case 2 -> new ExpressDelivery();
      case 3 -> new SameDayDelivery();
      default -> throw new IllegalArgumentException();
    };

    double deliveryFee = parcel.getDeliveryFee(delivery);
    parcel.setDeliveryFee(deliveryFee);
    System.out.printf("Delivery service changed! New fee: Php %,.2f%n", deliveryFee);
  }

  public static void markAsDelivered(){
    Display.headerTitle("Mark As Delivered");
    if(manager.getAllParcels().isEmpty()){
      System.out.println("No parcels available.");
      return;
    }

    String trackingNum = readTrackingNum();

    try{
      Parcel parcel = manager.findParcel(trackingNum);

      if(parcel.isDelivered()){
      System.out.println("Parcel was already delivered.");
      return;
    }

    parcel.setDeliveryStatus();
    System.out.println("Parcel delivered successfully!");
    }catch(ParcelNotFoundException e){
      System.out.println(e.getMessage());
    };

  }

  public static void main(String[] args){
    System.out.println("\nSimple Parcel Delivery System by Ma. Angelica Pauleen R. De Chavez of C2A\n");

    boolean isExit = false;

    while(!isExit){
      Display.headerTitle("Menu");
      Display.displayMenu("Add Parcel", "View All Parcels", "Change Delivery", "Mark as Delivered", "Exit");
      int menu = Validations.menuChecker("Enter Menu Choice (1, 2, 3, 4, 5): ", 5);

      switch(menu){
        case 1 -> addParcel();
        case 2 -> Display.viewAllParcels(manager.getAllParcels());
        case 3 -> changeDeliveryService();
        case 4 -> markAsDelivered();
        case 5 -> isExit = true;
      }
    }
    System.out.println("Thank you for using Simple Parcel Delivery System by Ma. Angelica Pauleen R. De Chavez of C2A\n");
  }
}