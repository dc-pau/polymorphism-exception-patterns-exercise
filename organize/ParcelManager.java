package organize;

import model.Parcel;
import java.util.List;
import java.util.ArrayList;

public class ParcelManager {
  private static ParcelManager instance;

  private List<Parcel> parcel = new ArrayList<>();

  private ParcelManager(){}

  public static ParcelManager getInstance(){
    if(instance == null){
      instance = new ParcelManager();
    }

    return instance;
  }

  
}
