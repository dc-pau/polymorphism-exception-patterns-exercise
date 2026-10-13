package model;

import strategy.DeliveryStrategy;

//PARENT CLASS OF DOCUMENT AND BOX
public abstract class Parcel {
  private String trackingNum;
  private String name;
  private double weight;
  private DeliveryService deliveryService;
  private Status status;
  private double deliveryFee;

  public Parcel(String trackingNum, String name, double weight){
    this.trackingNum = trackingNum;
    this.name = name;
    this.weight = weight;

    this.status = Status.PENDING;
  }

  //getters
  public String getTrackingNum(){return this.trackingNum;}
  public String getName(){return this.name;}
  public double getWeight(){return this.weight;}

  public String getStatus(){return this.status.toString();}
  public String getDeliveryService(){return deliveryService.toString();}

  public double getDeliveryFee(DeliveryStrategy delivery){return delivery.computeDeliveryFee(this);}
  public void setDeliveryFee(double deliveryFee){this.deliveryFee = deliveryFee;}

  //setters
  public void setDeliveryStatus(){this.status = Status.DELIVERED;}
  public boolean isDelivered(){return this.status == Status.DELIVERED;}

  public void setDeliveryService(DeliveryService deliveryService){this.deliveryService = deliveryService;}
  //public Status setStatus(){}

  //abstracts
  public abstract String getType();
  public abstract double getBaseFee();
  public abstract double getChargeableWeight();
  public abstract double getMaxWeight();

}
