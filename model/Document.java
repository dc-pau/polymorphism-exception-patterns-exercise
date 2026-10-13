package model;

//CHILD CLASS OF PARCEL
//INHERITANCE --> USES PARCEL'S METHODS AND FIELDS [super()]
public class Document extends Parcel{
  private int pages;

  public Document(String trackingNum, String name, double weight, int pages){
    super(trackingNum, name, weight);
    this.pages = pages;
  }

  public int getPages(){return this.pages;}
  
  @Override 
  public String getType(){return "Document";}
  
  @Override 
  public double getBaseFee(){
    return 50;
  }

  @Override 
  public double getChargeableWeight(){
    return this.getWeight();
  }

  @Override
  public double getMaxWeight(){
    return 0.5;
  }
}
