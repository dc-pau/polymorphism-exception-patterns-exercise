package strategy;

import model.Parcel;

//IMPLEMENTS DeliveryStrategy
public class ExpressDelivery implements DeliveryStrategy{
  @Override
  public double computeFee(Parcel parcel){
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
