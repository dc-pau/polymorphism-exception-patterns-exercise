import model.Parcel;
//import Items;

import java.util.ArrayList;

public class Display {
  public static final int MENU_WIDTH = 121;
  public static void displayMenu(String ... choices){
    String lightLine = "-".repeat(MENU_WIDTH);
    for (int i = 0; i < choices.length; i++) {
        System.out.printf("  [%d] %s%n", i + 1, choices[i]);
    }

    System.out.println(lightLine);
  }

  public static void headerTitle(String title){
    String heavyLine = "=".repeat(MENU_WIDTH);
    int center = Math.max(0, (MENU_WIDTH - title.length()) / 2);

    System.out.println();
    System.out.println(heavyLine);
    System.out.println(" ".repeat(center) + title.toUpperCase());
    System.out.println(heavyLine);
  }

  public static void subHeaderTitle(String title){
    String subHeader = " " + title.toUpperCase() + " ";
        int dashCount = (MENU_WIDTH - subHeader.length()) / 2;

        System.out.println(
                "-".repeat(Math.max(0, dashCount))
                        + subHeader
                        + "-".repeat(Math.max(0,
                                MENU_WIDTH - dashCount - subHeader.length())));
        System.out.println();
  }

  public static void viewAllParcels(ArrayList<Parcel> parcels){
    String lightLine = "-".repeat(MENU_WIDTH);
    headerTitle("View All Parcels");
    if(parcels.isEmpty()){
      System.out.println("No parcels available.");
      return;
    }

    System.out.printf( "%n%-20s  %-15s  %-15s  %-20s  %-15s  %-14s  %-10s%n%n", "TRACKING NUMBER", "PARCEL TYPE", "RECEIVER", "CHARGEABLE WEIGHT", "SERVICE", "DELIVERY FEE", "STATUS");
    System.out.println(lightLine);
    for(Parcel parcel : parcels){
      System.out.printf("%n%-20s  %-15s  %-15s  %-20s  %-15s  %-14s  %-10s%n", parcel.getTrackingNum(), parcel.getType(), parcel.getName(), String.format("%s kg", String.valueOf(parcel.getChargeableWeight())), parcel.getDeliveryService(), String.format("Php %,.2f", parcel.getStoredDeliveryFee()), parcel.getStatus());
    }

  }

  public static void displayParcel(Parcel parcel, String[][] details){
    String lightLine = "-".repeat(MENU_WIDTH);
    headerTitle("Parcel Details");

    for(String[] detail : details) {
      System.out.printf(" %-30s : %s%n", detail[0], detail[1]);
    }

    System.out.println(lightLine);
  }
}
