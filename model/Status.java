package model;

public enum Status {
  PENDING("Pending"),
  DELIVERED("Delivered");

  private final String statusString;

  Status(String statusString){this.statusString = statusString;}
  
  @Override
  public String toString(){
    return statusString;
  }
}
