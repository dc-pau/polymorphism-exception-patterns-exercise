package model;

public enum DeliveryType {
  STANDARD("Standard"),
  EXPRESS("Express"),
  SAME_DAY("Same Day");

  private final String deliveryType;

  DeliveryType(String deliveryType){this.deliveryType = deliveryType;}
  
  @Override
  public String toString(){
    return deliveryType;
  }
}
