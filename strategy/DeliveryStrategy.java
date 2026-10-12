package strategy;

import model.Parcel;

//INTERFACE
public interface DeliveryStrategy {
  double computeFee(Parcel parcel);
  boolean isValidParcel(Parcel parcel);
  String getService();
}
