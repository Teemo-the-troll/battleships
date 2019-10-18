package app;

import app.UI;

/**
 * logic
 */
public class logic {

   public static void checkCount(char Id) { // faze testovani
      if ((Id == ('l')) || (Id == ('k')) || (Id == ('p'))) {

      } else {

      }

   }

   public static void isTrefa(int x, int y) {
      if (UI.hrac == true) {
         vars.pole = vars.polelode2;
         vars.trefa = vars.poletrefy1;
         vars.minuty = vars.minutevystrely1;
      } else {
         vars.pole = vars.polelode1;
         vars.trefa = vars.poletrefy2;
         vars.minuty = vars.minutevystrely2;
      }
      if (vars.pole[x][y] == true) {
         System.out.println("Cil zasazen na koordinatech x:" + x + " a y:" + y);
         vars.pole[x][y] = false;// "zniceni" jednoho bodu
         vars.trefa[x][y] = true;// oznaceni trefy
         UI.hrac = !UI.hrac; // prepnuti hrace
         isWin();
      } else {
         vars.minuty[x][y] = true; // oznaceni vystrelu vedle
         System.out.println("Sama voda");
         UI.hrac = !UI.hrac;
         UI.main(null);
      }
   }

   public static void isWin() {
      int i = 0, j = 0;
      for (i = 0; i < 10; i++) {
         for (j = 0; j < 10; j++) {
            int t = j + i;
            if (vars.polelode1[i][j] || vars.polelode2[i][j]) {
               UI.main(null);
            } else if (t == 18) { // dodelat
               for (int n = 0; n < 51; n++) {
                  System.out.println("");
               }
               System.out.println("you won!");
            }
         }
      }
   }
}