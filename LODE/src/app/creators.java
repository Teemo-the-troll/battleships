package app;

import java.util.Scanner;

/**
 * creators
 */
public class creators {
   public static void boatCreation(int x, int y) { // stvoritel lodi
      Scanner sc = new Scanner(System.in);
      System.out.println(
            "Which boat do you want to create? k for kriznik, l for letadlova, c for clun, p for parnik. There must be enough room for the ship!");
      char g = sc.next().charAt(0);
      switch (g) {
      case 'k':
         creators.createKriznik(x, y);
         System.out.println("Creating kriznik at x:" + x + " y:" + y);
         UI.main(null);
         break;
      case 'l':
         creators.createLetadlova(x, y);
         System.out.println("Creating letadlova at x:" + x + " y:" + y);
         UI.main(null);
         break;
      case 'c':
         creators.createClun(x, y);
         System.out.println("Creating clun at x:" + x + " y:" + y);
         UI.main(null);
         break;
      case 'p':
         creators.createParnik(x, y);
         System.out.println("Creating parnik at x:" + x + " y:" + y);
         UI.main(null);
         break;
      }
   }

   public static void createLetadlova(int x, int y) {
      logic.checkCount('l');
      if (UI.hrac == true) {

         vars.pole = vars.polelode1;
         vars.nletadlovych = vars.pocetletadlovych;
      } else {
         vars.pole = vars.polelode2;
         vars.nletadlovych = vars.pocetletadlovych1;
      }
      if ((vars.pole[x][y] || vars.pole[x][y + 1] || vars.pole[x][y + 2] || vars.pole[x][y + 3]) != true) {
         vars.pole[x][y] = true;
         vars.pole[x][y + 1] = true;
         vars.pole[x][y + 2] = true;
         vars.pole[x][y + 3] = true;
         vars.nletadlovych = vars.nletadlovych + 1; // <---- error?
      }
      UI.main(null);
   }

   public static void createParnik(int x, int y) {
      logic.checkCount('p');
      if (UI.hrac == true) {
         vars.pole = vars.polelode1;
         vars.nparniku = vars.pocetparniku;
      } else {
         vars.pole = vars.polelode2;
         vars.nparniku = vars.pocetparniku1;
      }
      if ((vars.pole[x][y] || vars.pole[x][y + 1] || vars.pole[x][y + 2] || vars.pole[x - 1][y + 1]
            || vars.pole[x - 1][y + 2] || vars.pole[x][y + 3]) != true) {
         vars.pole[x][y] = true;
         vars.pole[x][y + 1] = true;
         vars.pole[x][y + 2] = true;
         vars.pole[x - 1][y + 1] = true;
         vars.pole[x - 1][y + 2] = true;
         vars.pole[x][y + 3] = true;
         vars.nparniku = vars.nparniku + 1;
      }
      UI.main(null);
   }

   public static void createKriznik(int x, int y) {
      logic.checkCount('k');
      if (UI.hrac == true) {
         vars.pole = vars.polelode1;
         vars.nkrizniku = vars.pocetkrizniku;
      } else {
         vars.pole = vars.polelode2;
         vars.nkrizniku = vars.pocetkrizniku1;
      }
      if ((vars.pole[x][y] || vars.pole[x + 1][y] || vars.pole[x + 2][y] || vars.pole[x + 1][y + 1]) != true) {
         vars.pole[x][y] = true;
         vars.pole[x + 1][y] = true;
         vars.pole[x + 2][y] = true;
         vars.pole[x + 1][y + 1] = true;
         vars.nkrizniku = vars.nkrizniku + 1;
      }
      UI.main(null);
   }

   public static void createClun(int x, int y) {
      logic.checkCount('c');
      if (UI.hrac == true) {
         vars.pole = vars.polelode1;
         vars.nclunu = vars.pocetclunu;
      } else {
         vars.pole = vars.polelode2;
         vars.nclunu = vars.pocetclunu1;
      }
      if ((vars.pole[x][y] || vars.pole[x][y + 1]) != true) {
         vars.pole[x][y] = true;
         vars.pole[x][y + 1] = true;
         vars.nclunu = vars.nclunu + 1;
      }
      UI.main(null);
   }
}