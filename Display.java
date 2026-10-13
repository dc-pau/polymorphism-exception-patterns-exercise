import model.Parcel;
//import Items;

import java.util.ArrayList;

public class Display {
  public static final int MENU_WIDTH = 60;
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
    headerTitle("View All Parcels");
    System.out.printf("%n-10s | -10%s | -10%s | -10%s | -10%s | -10%s | -10%s%n", "TRACKING NUMBER", "PARCEL TYPE", "RECEIVER", "CHARGEABLE WEIGHT", "SERVICE", "DELIVERY FEE", "STATUS");

    for(Parcel parcel : parcels){
      System.out.printf("%n-10s | -10%s | -10%s | -10%.2f | -10%s | -10%,.2f | -10%s%n", parcel.getTrackingNum(), parcel.getType(), parcel.getName(), parcel.getChargeableWeight(), parcel.getDeliveryService(), parcel.getDeliveryFee(null), parcel.getStatus());
    }

  }
}
