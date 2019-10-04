import java.util.Scanner;
public class testLode {
   private static boolean[][] field = new boolean[10][10]; //vytvoreni boolean pole pro lode
   private static boolean[][] field1 = new boolean[10][10]; //pole pro minute vystrely
   private static boolean[][] field2 = new boolean[10][10]; // pole pro zasahy
   static boolean showpole = true; //prepinac mezi viditelnosti lodi
   static int pocetparniku = 0; 
   static int pocetkrizniku = 0;
   static int pocetclunu = 0;
   static int pocetletadlovych = 0;
   public static void drawAim() { // vykresluje UI
      boolean bool = true; // prepinac on/off while loopu
      Scanner scan = new Scanner(System.in);
      int x = 0, y = 0, w = 10, h = 10, i = 0;
      while (bool) {
         for (i = 0; i < 10; i++) {
            // 10x
            for (int j = 0; j < 10; j++) {
               // 10
               if (field2 [i][j] == true) { //print zasahu
                  System.out.print("@ ");
               }
               else if (field1[i][j] == true) {// print vystrelu vedle
                  System.out.print("W ");
               }
               else if (field[i][j] == true && showpole == true) { // zobrazeni lodi pokud je showpole pravda
                  System.out.print("O ");
                  //kontrola boolean pole pro lodě
               } 
               else if (i != x || j != y){
                  // kontrola pozice X
                  System.out.print("* ");
               }               
               else  System.out.print("X ");
            }
            System.out.println("");
         }
         System.out.println("Enter direction (w,a,s,d); q to shoot, c to create new boat, e to exit, n to start the game");
         char c = scan.next().charAt(0);
         switch (c) { //hlavni input UI
            case 'w'://nahoru
               x = Math.max(0, x - 1); 
               break;
            case 's'://dolu
               x = Math.min(w - 1, x + 1); 
               break;
            case 'a'://doleva
               y = Math.max(0, y - 1);
               break;
            case 'd'://doprava
               y = Math.min(h - 1, y + 1);
               break;
            case 'e'://konec
               System.out.println("Exiting...");
               System.exit(0);
            case 'q'://vystrel
               isTrefa(x, y);
               bool = false;
               break;
            case 'c'://zavolani stvoritele lodi
               boatCreation(x,y);
               bool = false;
               break;
            case'n'://nova hra
               System.out.println("Hra zacina");
               showpole = false;
            }
         }
      }
   public static void createParnik(int x, int y) {
      if(pocetparniku < 1){
         if((field[x][y] || field[x][y + 1] || field[x][y + 2] || field[x - 1][y + 1] || field[x - 1][y + 2] || field[x][y + 3])!= true){ //kontrola kolize
         field[x][y] = true;
         field[x][y + 1] = true;
         field[x][y + 2] = true;
         field[x - 1][y + 1] = true;
         field[x - 1][y + 2] = true;
         field[x][y + 3] = true;
         pocetparniku = pocetparniku + 1;
         }
         else {
            System.out.println("can't create boat on another boat!");
            drawAim();
         }
      } else {
         System.out.println("you have too many boats of this type");
         drawAim();
      }
   }
   public static void createKriznik(int x, int y) {
      if (pocetkrizniku < 1){
         if((field[x][y] || field[x + 1][y] || field[x + 2][y] || field[x + 1][y + 1])!= true){ //kontrola kolize
         field[x][y] = true;
         field[x + 1][y] = true;
         field[x + 2][y] = true;
         field[x + 1][y + 1] = true;
         pocetkrizniku = pocetkrizniku + 1;
         }
         else {
         System.out.println("can't create boat on another boat!");
         drawAim();
         }
      } 
      else {
      System.out.print("You have too much boats of this type");
      drawAim();
      }
   }
   public static void createClun(int x, int y){
      if(pocetclunu < 2) {
         if((field[x][y] || field[x][y + 1])!= true) {// kontroluje jestli zde neni zadna lod
            field[x][y] = true;
            field[x][y + 1] = true;
            pocetclunu = pocetclunu + 1;
         }
         else {
            System.out.println("can't create boat on another boat!");
            drawAim();
         }
      }
      else {
         System.out.println("You have too much boats of this type");
         drawAim();
         }
   }
   public static void createLetadlova(int x, int y) {
      if (pocetletadlovych < 1) {
         if((field[x][y] || field[x][y + 1] || field[x][y + 2] || field[x][y + 3])!= true) {// kontroluje jestli zde neni zadna lod
         field[x][y] = true;
         field[x][y + 1] = true;
         field[x][y + 2] = true;
         field[x][y + 3] = true;
         pocetletadlovych = pocetletadlovych + 1;
         }
      else {
         System.out.println("can't create boat on another boat!");
         drawAim();
      }
   }else {
      System.out.print("You have too much boats of this type");
      drawAim();
      }
}

   public static void isTrefa(int x, int y) {
      if (field[x][y] == true) {
         System.out.println("Cil zasazen na koordinatech x:" + x + " a y:" + y);
         field[x][y] = false;//"zniceni" jednoho bodu
         field2[x][y] = true;// oznaceni trefy
         drawAim();
      } else {
         field1[x][y] = true; //oznaceni vystrelu vedle
         System.out.println("Sama voda");
         drawAim();
      }     
   }

   public static void boatCreation(int x, int y){ //stvoritel lodi
      Scanner sc = new Scanner(System.in);
      System.out.println("Which boat do you want to create? k for kriznik, l for letadlova, c for clun, p for parnik. There must be enough room for the ship!");
      char g = sc.next().charAt(0);
      switch (g){
         case 'k':  createKriznik(x,y); System.out.println("Creating kriznik at x:" + x + " y:" + y); drawAim(); break;
         case 'l':  createLetadlova(x,y);System.out.println("Creating letadlova at x:" + x + " y:" + y); drawAim();  break;
         case 'c':  createClun(x,y); System.out.println("Creating clun at x:" + x + " y:" + y); drawAim(); break;
         case 'p':  createParnik(x, y); System.out.println("Creating parnik at x:" + x + " y:" + y); drawAim(); break;
      }
   }

   public static void main(String[] args) {

     drawAim();
    
        }
    }
    
