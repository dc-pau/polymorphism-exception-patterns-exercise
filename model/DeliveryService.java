package model;

public enum DeliveryService {
  STANDARD("Standard"),
  EXPRESS("Express"),
  SAME_DAY("Same Day");

  private final String deliveryServiceStr;

  DeliveryService(String deliveryServiceStr){this.deliveryServiceStr = deliveryServiceStr;}
  
  @Override
  public String toString(){
    return deliveryServiceStr;
  }
}
