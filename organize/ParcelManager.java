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
  public boolean trackNumExists(String trackingNum){
    for(Parcel parcel : parcels){
      if(parcel.getTrackingNum().equalsIgnoreCase(trackingNum)){return true;}
    }
    return false;
  }

  public void addParcel(Parcel parcel) throws DuplicateTrackingNumberException{
    if(trackNumExists(parcel.getTrackingNum())){
      throw new DuplicateTrackingNumberException("Tracking Number already exists.");
    }
    parcels.add(parcel);
  }

  public Parcel findParcel(String trackingNum) throws ParcelNotFoundException{
    for(Parcel parcel : parcels){
      if(trackNumExists(trackingNum)){return parcel;}
    }

    return ParcelNotFoundException("Parcel not found!");
  }
}
