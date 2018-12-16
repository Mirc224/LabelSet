/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package novylabelset;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author mino
 */
public class Algoritmus {
    private int hrany[][];
    private int vrcholyTi[];
    private int vrcholyXi[];
    public Algoritmus() throws IOException{
        java.io.File subor = new File("graf.txt");
        Scanner citac = new Scanner(subor);
        int temp = citac.nextInt() + 1;
        this.hrany = new int[temp][temp];
        this.vrcholyTi = new int[temp];
        this.vrcholyXi = new int[temp];
        while (citac.hasNextLine()) {
            citac.nextLine();
            this.hrany[citac.nextInt()][citac.nextInt()] = citac.nextInt();
        }
        citac.close();
    }
    public void najdiNajkratsiuCestu() {
        ArrayList<Integer> zasobnik = new ArrayList<Integer>();
        System.out.println("Zadajte zaciatocny vrchol");
        int zaciatocnyVrchol;
        int koncovyVrchol;
        try (Scanner citac = new Scanner(System.in)) {
            boolean test = true;
            do {
            zaciatocnyVrchol = citac.nextInt();
            if(!(zaciatocnyVrchol > 0 && zaciatocnyVrchol < this.hrany.length)) {
                System.out.println("Zadali ste nespravny zaciatocny vrchol, skuste to znovu.");
            } else {
                test = false;
            }
            }while(test);
            System.out.println("Zadajte koncovy vrchol");
            test = true;
            do {
            koncovyVrchol = citac.nextInt();
            if(!(koncovyVrchol > 0 && koncovyVrchol < this.hrany.length)) {
                System.out.println("Zadali ste nespravny koncovy vrchol, skuste to znovu.");
            } else {
                test = false;
            }
            }while(test);
            zasobnik.add(zaciatocnyVrchol);
        }
        if(koncovyVrchol == zaciatocnyVrchol) {
            System.out.println("Koncovy a zaciatocny su rovnake vrcholy, takze najkratsia cesta meria 0 ");
            return;
        }
        for(int i = 1; i < hrany.length; i++) {
            vrcholyTi[i] = Integer.MAX_VALUE/2;
            vrcholyXi[i] = 0;
            if( i == zaciatocnyVrchol)
                vrcholyTi[i] = 0;
        }
        while(!zasobnik.isEmpty()) {
            int vrchol = zasobnik.get(0);
            for (Integer integer : zasobnik) {
                if(vrcholyTi[integer] < vrcholyTi[vrchol]) {
                    vrchol = integer;
                }
            }
            for(int i = 1; i < hrany.length; i++) {
                if(hrany[vrchol][i] !=0 ) {
                    if(vrcholyTi[i] > vrcholyTi[vrchol] + hrany[vrchol][i]) {
                        vrcholyTi[i] = vrcholyTi[vrchol] + hrany[vrchol][i];
                        vrcholyXi[i] = vrchol;
                        zasobnik.add(i);
                    }
                }
            }
            Integer temp = vrchol;
            zasobnik.remove(temp);
        }
        int vrchol = koncovyVrchol;
        
        if(vrcholyTi[koncovyVrchol] != Integer.MAX_VALUE/2 ) {
        System.out.print("Najkratsia cesta z " + zaciatocnyVrchol + " do " + koncovyVrchol + " je " + vrcholyTi[koncovyVrchol] + " a ma tvar : ");
        System.out.print(koncovyVrchol + " ");
        do {
            System.out.print(vrcholyXi[vrchol] + " ");
            vrchol = vrcholyXi[vrchol];
            
        }while(vrchol != zaciatocnyVrchol);
        } else {
            System.out.println("Neexistuje cesta medzi vrcholom " + zaciatocnyVrchol + " a " + koncovyVrchol + " !");
        }
    }
}
