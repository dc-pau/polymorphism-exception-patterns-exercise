import java.util.Scanner;

public class Validations {
  public static Scanner input = new Scanner(System.in);

  public static int menuChecker(String prompt){
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

        if(menu >= 1 && menu <= 9){
          isValidMenu = true;
        }else{
          System.out.println("Invalid input. Please enter a number between 1 to 9.");
        }
      }catch(NumberFormatException e){
        System.out.println("Invalid input. You must enter an integer number.");
      }
    }
    return menu;
  }

  public static String stringEmptyChecker(String prompt, String regex, int type){
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
}
