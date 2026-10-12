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
}
