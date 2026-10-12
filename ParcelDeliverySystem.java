public class ParcelDeliverySystem{
  public static void main(String[] args){
    System.out.println("\nSimple Inventory Management System by Ma. Angelica Pauleen R. De Chavez of C2A\n");

    boolean isExit = false;

    while(isExit){
      System.out.println("\n= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
      System.out.println("                                          MENU OPTIONS");
      System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");

      System.out.println("""

                                  [1] Add Parcel                                     
                                  [2] View All Parcels                                  
                                  [3] Change Delivery Service                                  
                                  [4] Mark as Delivered  
                                  [5] Exit                
                        """);
      System.out.println("       - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");

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
  }
}