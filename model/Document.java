package model;
public class Document extends Parcel{
  private int pages;

  public Document(String trackingNum, String name, double weight, int pages){
    super(trackingNum, name, weight);
    this.pages = pages;
  }

  public int getPages(){return this.pages;}
}
