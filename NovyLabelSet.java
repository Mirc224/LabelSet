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
public class NovyLabelSet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Algoritmus graf = new Algoritmus();
        graf.najdiNajkratsiuCestu();
    }
    
}
