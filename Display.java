public class Display {
  public static final int MENU_WIDTH = 60;
  public static void displayMenu(String ... choices){
    String lightLine = "-".repeat(MENU_WIDTH);
    for (int i = 0; i < choices.length; i++) {
        System.out.printf("  [%d] %s%n", i++, choices[i]);
    }

    System.out.println(lightLine);
  }

  public static void headerTitle(String title){
    String heavyLine = "=".repeat(MENU_WIDTH);
    int center = Math.max(0, (MENU_WIDTH - title.length()) / 2);

    System.out.println();
    System.out.println(heavyLine);
    System.out.println(" ".repeat(center) + title.toUpperCase());
    System.out.println(heavyLine);
  }

  public static void subHeaderTitle(String title){
    String lightLine = "-".repeat(MENU_WIDTH);
    int center = Math.max(0, (MENU_WIDTH - title.length()) / 2);

    System.out.println();
    System.out.println(lightLine);
    System.out.println(" ".repeat(center) + title.toUpperCase());
    System.out.println(lightLine);
  }
}
