import java.util.Scanner;
public class testLode {
   private static boolean[][] polelode1 = new boolean[10][10]; //vytvoreni boolean pole pro lode hrac 1
   private static boolean[][] minutevystrely1 = new boolean[10][10]; //pole pro minute vystrely hrac 1
   private static boolean[][] poletrefy1 = new boolean[10][10]; // pole pro zasahy hrac 1

   private static boolean[][] polelode2 = new boolean[10][10]; //vytvoreni boolean pole pro lode hrac 2
   private static boolean[][] minutevystrely2 = new boolean[10][10]; //pole pro minute vystrely hrac 2
   private static boolean[][] poletrefy2 = new boolean[10][10]; // pole pro zasahy hrac 2
   
   static boolean showpole = true; //prepinac mezi viditelnosti lodi
   static int pocetparniku = 0;
   static int pocetparniku1 = 0; 
   static int pocetkrizniku = 0;
   static int pocetkrizniku1 = 0;
   static int pocetclunu = 0;
   static int pocetclunu1 = 0;
   static int pocetletadlovych = 0;
   static int pocetletadlovych1 = 0;  
   static boolean hrac = true; //dva hraci: true a false
   public static void drawAim() { // vykresluje UI
      boolean bool = true; // prepinac on/off while loopu
      Scanner scan = new Scanner(System.in);
      int x = 0, y = 0, w = 10, h = 10, i = 0;
      while (bool) {
         if (hrac == true) {
            System.out.println("hraje hrac cislo 1");
         } else {
            System.out.println("hraje hrac cislo 2");
         }
         for (i = 0; i < 10; i++) {
            // 10x
            for (int j = 0; j < 10; j++) {
               // 10
              if (hrac == true) {
               
                  if (poletrefy2 [i][j] == true) { //print zasahu
                     System.out.print("@ ");
                  }
                  else if (minutevystrely2[i][j] == true) {// print vystrelu vedle
                     System.out.print("W ");
                  }
                  else if (polelode1[i][j] == true && showpole == true) { // zobrazeni lodi pokud je showpole pravda
                     System.out.print("O ");
                     //kontrola boolean pole pro lodě
                  } 
                  else if (i != x || j != y){
                     // kontrola pozice X
                     System.out.print("* ");
                  }  
                  else  System.out.print("X ");
               }
               else {
                  if (poletrefy1[i][j] == true) { //print zasahu
                     System.out.print("@ ");
                  }
                  else if (minutevystrely1[i][j] == true) {// print vystrelu vedle
                     System.out.print("W ");
                  }
                  else if (polelode2[i][j] == true && showpole == true) { // zobrazeni lodi pokud je showpole pravda
                     System.out.print("O ");
                     //kontrola boolean pole pro lodě
                  } 
                  else if (i != x || j != y){
                     // kontrola pozice X
                     System.out.print("* ");
                  }  
                  else  System.out.print("X ");
               }               
               
            }
            System.out.println("");
         }
         System.out.println("Enter direction (w,a,s,d); q - shoot, c - create new boat, e - exit, n - start the game, p - switch player");
         char c = scan.next().charAt(0);
         switch (c) { //hlavni input UI
            case 'w': //nahoru
               x = Math.max(0, x - 1); 
               break;
            case 's': //dolu
               x = Math.min(w - 1, x + 1); 
               break;
            case 'a': //doleva
               y = Math.max(0, y - 1);
               break;
            case 'd': //doprava
               y = Math.min(h - 1, y + 1);
               break;
            case 'e': //konec
               System.out.println("Exiting...");
               System.exit(0);
            case 'q': //vystrel
               isTrefa(x, y);
               bool = false;
               break;
            case 'c': //zavolani stvoritele lodi
               boatCreation(x,y);
               bool = false;
               break;
            case 'n': //nova hra
               System.out.println("Hra zacina");
               showpole = false;
               hrac = !hrac;
               break;
            case 'p': //prepnuti hrace
               System.out.println("hrac prepnut");
               hrac = !hrac;
            }
         }
      }
   public static void createParnik(int x, int y) {
      if (hrac == true) {
         if(pocetparniku < 1){
            if((polelode1[x][y] || polelode1[x][y + 1] || polelode1[x][y + 2] || polelode1[x - 1][y + 1] || polelode1[x - 1][y + 2] || polelode1[x][y + 3])!= true){ //kontrola kolize
            polelode1[x][y] = true;
            polelode1[x][y + 1] = true;
            polelode1[x][y + 2] = true;
            polelode1[x - 1][y + 1] = true;
            polelode1[x - 1][y + 2] = true;
            polelode1[x][y + 3] = true;
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
      } else {
         if(pocetparniku1 < 1){
            if((polelode2[x][y] || polelode2[x][y + 1] || polelode2[x][y + 2] || polelode2[x - 1][y + 1] || polelode2[x - 1][y + 2] || polelode2[x][y + 3])!= true){ //kontrola kolize
            polelode2[x][y] = true;
            polelode2[x][y + 1] = true;
            polelode2[x][y + 2] = true;
            polelode2[x - 1][y + 1] = true;
            polelode2[x - 1][y + 2] = true;
            polelode2[x][y + 3] = true;
            pocetparniku1 = pocetparniku1 + 1;
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
   }
   public static void createKriznik(int x, int y) {
      if (hrac == true) {
         if (pocetkrizniku < 1){
            if((polelode1[x][y] || polelode1[x + 1][y] || polelode1[x + 2][y] || polelode1[x + 1][y + 1])!= true){ //kontrola kolize
            polelode1[x][y] = true;
            polelode1[x + 1][y] = true;
            polelode1[x + 2][y] = true;
            polelode1[x + 1][y + 1] = true;
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
      } else {
         if (pocetkrizniku1 < 1){
            if((polelode2[x][y] || polelode2[x + 1][y] || polelode2[x + 2][y] || polelode2[x + 1][y + 1])!= true){ //kontrola kolize
            polelode2[x][y] = true;
            polelode2[x + 1][y] = true;
            polelode2[x + 2][y] = true;
            polelode2[x + 1][y + 1] = true;
            pocetkrizniku1 = pocetkrizniku1 + 1;
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
   }
   public static void createClun(int x, int y){
      if (hrac == true) {
         if(pocetclunu < 2) {
            if((polelode1[x][y] || polelode1[x][y + 1])!= true) {// kontroluje jestli zde neni zadna lod
               polelode1[x][y] = true;
               polelode1[x][y + 1] = true;
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
      else {
         if(pocetclunu1 < 2) {
            if((polelode2[x][y] || polelode2[x][y + 1])!= true) {// kontroluje jestli zde neni zadna lod
               polelode2[x][y] = true;
               polelode2[x][y + 1] = true;
               pocetclunu1 = pocetclunu1 + 1;
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
   }
   public static void createLetadlova(int x, int y) {
      if (hrac == true) { //ktery hrac hraje
         if (pocetletadlovych < 1) {//kolik ma hrac true letadlovych lodi
            if((polelode1[x][y] || polelode1[x][y + 1] || polelode1[x][y + 2] || polelode1[x][y + 3])!= true) {// kontroluje jestli zde neni zadna lod
            polelode1[x][y] = true;
            polelode1[x][y + 1] = true;
            polelode1[x][y + 2] = true;
            polelode1[x][y + 3] = true;
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
      } else {
         if (pocetletadlovych1 < 1) {
            if((polelode2[x][y] || polelode2[x][y + 1] || polelode2[x][y + 2] || polelode2[x][y + 3])!= true) {// kontroluje jestli zde neni zadna lod
            polelode2[x][y] = true;
            polelode2[x][y + 1] = true;
            polelode2[x][y + 2] = true;
            polelode2[x][y + 3] = true;
            pocetletadlovych1 = pocetletadlovych1 + 1;
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
   }

   public static void isTrefa(int x, int y) {
      if (hrac == false) {
         if (polelode1[x][y] == true) {
            System.out.println("Cil zasazen na koordinatech x:" + x + " a y:" + y);
            polelode1[x][y] = false;//"zniceni" jednoho bodu
            poletrefy1[x][y] = true;// oznaceni trefy
            hrac = !hrac; //prepnuti hrace
            isWin();
         } else {
            minutevystrely1[x][y] = true; //oznaceni vystrelu vedle
            System.out.println("Sama voda");
            hrac = !hrac;
            drawAim();
         }     
      } else {
         if (polelode2[x][y] == true) {
            System.out.println("Cil zasazen na koordinatech x:" + x + " a y:" + y);
            polelode2[x][y] = false;//"zniceni" jednoho bodu
            poletrefy2[x][y] = true;// oznaceni trefy
            hrac = !hrac; //prepnuti hrace
            isWin();
         } else {
            minutevystrely2[x][y] = true; //oznaceni vystrelu vedle
            System.out.println("Sama voda");
            hrac = !hrac;
            drawAim();
         }     
      }
   }
   public static void isWin(){
      int i = 0, j = 0;
         for (i = 0; i < 10; i++) {
            for (j = 0; j < 10; j++) {
               int t = j + i;
               if (polelode1 [i][j] || polelode2[i][j]) {
                  drawAim();
               }   
               else if (t == 18){   //dodelat
                  for (int n = 0; n < 51; n++){
                     System.out.println("");
                     }
                     System.out.println("you won!");   
                  } 
               }
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
    
