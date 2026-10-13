import java.util.Scanner;
import java.util.ArrayList;

import model.Parcel;


public class Validations {
  public static Scanner input = new Scanner(System.in);

  public static int menuChecker(String prompt, int max){
    boolean isValidMenu = false;
    int menu = 0;

    while(!isValidMenu){
      System.out.print(prompt);
      String number = input.nextLine();

      if(number.length() > 1 && !(Character.isLetterOrDigit(number.charAt(0)))){
        System.out.println("Invalid input. Number cannot start with a symbol or space.");
        continue;
      }

      if(number.length() > 1 && number.charAt(0) == '0'){
        System.out.println("Invalid input. Number cannot start with 0.");
        continue;
      }

      try{
        menu = Integer.parseInt(number);

        if(menu >= 1 && menu <= max){
          isValidMenu = true;
        }else{
          System.out.println("Invalid input. Please enter a number between 1 to " + max + ".");
        }
      }catch(NumberFormatException e){
        System.out.println("Invalid input. You must enter an integer number.");
      }
    }
    return menu;
  }

  public static String stringEmptyChecker(String prompt){
    boolean hasInput = false;
    String str = " ";

    while(!hasInput){
      System.out.print(prompt);
      str = input.nextLine().trim().replaceAll("\\s+", " ");

      if(str.isEmpty()){
        System.out.println("You cannot leave this field empty.");
        hasInput = false;
      }else{
        hasInput = true;
      }
    }
    return str;
  }

  public static double weightChecker(String prompt){
    boolean isValidWeight = false;
    double weight = 0;

    while(!isValidWeight){
      System.out.print(prompt);
      String number = input.nextLine();

      if(number.length() > 1 && !(Character.isLetterOrDigit(number.charAt(0)))){
        System.out.println("Invalid input. Number cannot start with a symbol or space.");
        continue;
      }

      if(number.length() > 1 && number.charAt(0) == '0' && number.charAt(1) != '.'){
        System.out.println("Invalid input. Number cannot start with 0.");
        continue;
      }

      try{
        weight = Double.parseDouble(number);

        if(!(weight >= 0 || weight <= 70)){
          System.out.println("Invalid input. Please enter a number between 0 to 70.");
        }else{isValidWeight = true;}
      }catch(NumberFormatException e){
        System.out.println("Invalid input. You must enter a number.");
      }
    }
    return weight;
  }

  public static boolean validTrackingNum(String trackingnNum){
    return trackingnNum.matches("^(?i)ABC\\d{4}$") ? true : false;
  }

  public static boolean trackingNumExists(ArrayList<Parcel> parcels, String trackingNum){
    for(Parcel parcel : parcels){
      if(parcel.getTrackingNum().equalsIgnoreCase(trackingNum)){
        return true;
      }
    }
    return false;
  }

  public static char charValidation(String prompt){
        boolean isValidChar = false;
        char ans = ' ';

        while(!isValidChar){
          System.out.print(prompt);
          String txt = input.nextLine();

          if(txt.isEmpty()){
            System.out.println("Invalid input. You cannot leave this empty.");
            continue;
          }

          if(txt.length() > 1){
            System.out.println("Invalid input. Enter y or n only.");
            continue;
          }

          char char1 = Character.toLowerCase(txt.charAt(0));

          if(!((char1 == 'y') || (char1 == 'n'))){
            System.out.println("Invalid input. Enter y or n only.");
            continue;
          }else{
            ans = char1;
            isValidChar = true;
          }
          
        }
        return ans;
    }
}