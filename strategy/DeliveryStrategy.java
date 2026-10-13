package strategy;

import model.Parcel;

//INTERFACE
public interface DeliveryStrategy {
  double computeDeliveryFee(Parcel parcel);
  boolean isValidParcel(Parcel parcel);
  String getService();
}
