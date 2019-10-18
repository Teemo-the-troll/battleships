package app;

import app.creators;

import java.util.Scanner;

public class UI {
   static boolean showpole = true; // prepinac mezi viditelnosti lodi
   static boolean hrac = true; // dva hraci: true a false

   public static void main(String[] args) {
      boolean bool = true; // prepinac on/off while loopu
      Scanner scan = new Scanner(System.in);
      int x = 0, y = 0, w = 10, h = 10, i = 0;
      while (bool) {
         if (hrac == true) {
            System.out.println("hraje hrac cislo 1");
            vars.p = vars.polelode1;
            vars.trefa = vars.poletrefy1;
            vars.minuty = vars.minutevystrely1;
         } else {
            System.out.println("hraje hrac cislo 2");
            vars.p = vars.polelode2;
            vars.trefa = vars.poletrefy2;
            vars.minuty = vars.minutevystrely2;
         }
         for (i = 0; i < 10; i++) {
            // 10x
            for (int j = 0; j < 10; j++) {
               // 10
               if (vars.trefa[i][j] == true) { // print zasahu
                  System.out.print("@ ");
               } else if (vars.minuty[i][j] == true) {// print vystrelu vedle
                  System.out.print("W ");
               } else if (vars.p[i][j] == true && showpole == true) { // zobrazeni lodi pokud je showpole pravda
                  System.out.print("O ");
                  // kontrola boolean pole pro lodě
               } else if (i != x || j != y) {
                  // kontrola pozice X
                  System.out.print("* ");
               } else
                  System.out.print("X ");
            }
            System.out.println("");
         }
         System.out.println(
               "Enter direction (w,a,s,d); q - shoot, c - create new boat, e - exit, n - start the game, p - switch player");
         char c = scan.next().charAt(0);
         switch (c) { // hlavni input UI
         case 'w': // nahoru
            x = Math.max(0, x - 1);
            break;
         case 's': // dolu
            x = Math.min(w - 1, x + 1);
            break;
         case 'a': // doleva
            y = Math.max(0, y - 1);
            break;
         case 'd': // doprava
            y = Math.min(h - 1, y + 1);
            break;
         case 'e': // konec
            System.out.println("Exiting...");
            System.exit(0);
         case 'q': // vystrel
            logic.isTrefa(x, y);
            bool = false;
            break;
         case 'c': // zavolani stvoritele lodi
            creators.boatCreation(x, y);
            bool = false;
            break;
         case 'n': // nova hra
            System.out.println("Hra zacina");
            showpole = false;
            hrac = !hrac;
            break;
         case 'p': // prepnuti hrace
            System.out.println("hrac prepnut");
            hrac = !hrac;
         }
      }
   }
}
