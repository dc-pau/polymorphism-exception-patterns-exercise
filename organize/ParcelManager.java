package organize;

import model.Parcel;
import java.util.ArrayList;

public class ParcelManager {
  private static ParcelManager instance;

  private ArrayList<Parcel> parcels = new ArrayList<>();

  private ParcelManager(){}

  public static ParcelManager getInstance(){
    if(instance == null){
      instance = new ParcelManager();
    }

    return instance;
  }

  public ArrayList<Parcel> getAllParcels(){return parcels;}
  public boolean trackingNumExists(String trackingNum){
    for(Parcel parcel : parcels){
      if(parcel.getTrackingNum().equalsIgnoreCase(trackingNum)){return true;}
    }
    return false;
  }

  public void addParcelItem(Parcel parcel) throws DuplicateTrackingNumberException{
    if(trackingNumExists(parcel.getTrackingNum())){
      throw new DuplicateTrackingNumberException("Tracking Number already exists.");
    }
    parcels.add(parcel);
  }

  public Parcel findParcel(String trackingNum) throws ParcelNotFoundException{
    for(Parcel parcel : parcels){
      if(parcel.getTrackingNum().equalsIgnoreCase(trackingNum)){return parcel;}
    }

    throw new ParcelNotFoundException("Parcel not found!");
  }
}
