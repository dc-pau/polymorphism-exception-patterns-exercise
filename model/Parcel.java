package model;

//PARENT CLASS OF DOCUMENT AND BOX
public abstract class Parcel {
  private String trackingNum;
  private String name;
  private double weight;
  private DeliveryService deliveryService;
  private Status status = Status.PENDING;

  public Parcel(String trackingNum, String name, double weight){
    this.trackingNum = trackingNum;
    this.name = name;
    this.weight = weight;
  }

  //getters
  public String getTrackingNum(){return this.trackingNum;}
  public String getName(){return this.name;}
  public double getWeight(){return this.weight;}

  public String getStatus(){return this.status.toString();}
  public String getDeliveryType(){return deliveryService.toString();}

  //setters
  public void setDeliveryStatus(){this.status = Status.DELIVERED;}
  public boolean isDelivered(){return this.status == Status.DELIVERED;}

  public void setDeliveryService(DeliveryService deliveryService){this.deliveryService = deliveryService;}
  //public Status setStatus(){}
}
