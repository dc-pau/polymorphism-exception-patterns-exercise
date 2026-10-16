package model;

//INHERITANCE --> USES BOX'S METHODS AND FIELDS [super()]
public class Fragile extends Box{
  private String handlingNote;

  public Fragile(String tracking, String name, double weight, int length, int width, int height, String note){
    super(tracking, name, weight, length, width, height);
    this.handlingNote = note;
  }

  public String getHandlingNote(){return this.handlingNote;}

  @Override 
  public String getType(){return "Fragile";}

  @Override 
  public double getBaseFee(){
    return super.getBaseFee() + 100;
  }

  @Override 
  public double getChargeableWeight(){
    double actualWeight = Math.ceil(this.getWeight());
    double volumetricWeight = Math.ceil(getVolumetricWeight());
    return Math.max(actualWeight, volumetricWeight);
  }

  @Override
  public double getMaxWeight(){
    return 30;
  }

  @Override
  public double getVolumetricWeight(){
    return super.getVolumetricWeight();
  }
}
