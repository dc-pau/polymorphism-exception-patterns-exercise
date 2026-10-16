package model;

//CHILD CLASS OF PARCEL
//INHERITANCE --> USES PARCEL'S METHODS AND FIELDS [super()]
//PARENT CLASS OF FRAGILE
public class Box extends Parcel {
  private int length;
  private int width;
  private int height;

  public Box(String trackingNum, String name, double weight, int length, int width, int height){
    super(trackingNum, name, weight);
    this.length = length;
    this.width = width;
    this.height = height;
  }

  //getters
  public int getLength(){return this.length;}
  public int getWidth(){return this.width;}
  public int getHeight(){return this.height;}


  @Override 
  public String getType(){return "Box";}

  @Override 
  public double getBaseFee(){
    return 40 * getChargeableWeight();
  }

  @Override 
  public double getChargeableWeight(){
    double actualWeight = this.getWeight();
    double volumetricWeight = getVolumetricWeight();
    return Math.ceil(Math.max(actualWeight, volumetricWeight));
  }

  @Override
  public double getMaxWeight(){
    return 50;
  }

  public double getVolumetricWeight(){
    return (this.length * this.width * this.height)/3500;
  }
}
