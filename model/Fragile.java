package model;

//INHERITANCE --> USES BOX'S METHODS AND FIELDS [super()]
public class Fragile extends Box{
  private String handlingNote;

  public Fragile(String tracking, String name, double weight, int length, int width, int height, String note){
    super(tracking, name, weight, length, width, height);
    this.handlingNote = note;
  }

  public String getHandlingNote(){return this.handlingNote;}
}
