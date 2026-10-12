package strategy;

import model.Parcel;

//IMPLEMENTS DeliveryStrategy
public class SameDayDelivery implements DeliveryStrategy{
  @Override
  public double computeFee(Parcel parcel){
    return (parcel.getBaseFee() * 2) + 100;
  }

  @Override
  public boolean isValidParcel(Parcel parcel){
    return parcel.getChargeableWeight() <= 10;
  }

  @Override
  public String getService(){
    return "Same Day Delivery";
  }
}

