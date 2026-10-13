import java.util.ArrayList;

import model.Parcel;

public class Items {
  private ArrayList<Parcel> item;

  public Items(){
    item = new ArrayList<>();
  }

  public void addParcelItem(Parcel parcel, double fee){
    System.out.printf("Parcel added successfully! Delivery fee: Php %,.2f%n", fee);
    item.add(parcel);
  }
}
