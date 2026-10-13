package strategy;

import model.Parcel;

//IMPLEMENTS DeliveryStartegy
public class StandardDelivery implements DeliveryStrategy{
  @Override
  public double computeDeliveryFee(Parcel parcel){
    return parcel.getBaseFee();
  }

  @Override
  public boolean isValidParcel(Parcel parcel){
    return true;
  }

  @Override
  public String getService(){
    return "Standard Delivery";
  }
}
