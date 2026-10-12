public abstract class Parcel {
  private String trackingNum;
  private String name;
  private double weight;
  //private DeliveryService deliveryService;
 // private Status status;

  public Parcel(String trackingNum, String name, double weight){
    this.trackingNum = trackingNum;
    this.name = name;
    this.weight = weight;

    //this.deliveryService = null;
    //this.status = null;
  }

  //getters
  public String getTrackingNum(){return this.trackingNum;}
  public String getName(){return this.name;}
  public double getWeight(){return this.weight;}

  //setters
  //public DeliveryService setDeliveryService(){}
  //public Status setStatus(){}
}
