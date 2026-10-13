import java.util.Scanner;

public class ParcelDeliverySystem{

  public static Scanner input = new Scanner(System.in);

  public static void addParcel(){
    Display.headerTitle("Add Parcel");
    Display.subHeaderTitle("Choose Parcel Type");
    Display.displayMenu("Document", "Box", "Fragile");
  }
  public static void main(String[] args){
    System.out.println("\nSimple Inventory Management System by Ma. Angelica Pauleen R. De Chavez of C2A\n");

    boolean isExit = false;

    while(isExit){
      Display.headerTitle("Menu");
      Display.displayMenu("Add Parcel", "View All Parcels", "Change Delivery", "Mark as Delivered", "Exit");
      int menu = Validations.menuChecker("Enter Menu Choice: ");

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