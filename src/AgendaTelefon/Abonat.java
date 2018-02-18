/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AgendaTelefon;

import AgendaTelefon.nrTel;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.lang.Exception;
import java.util.Comparator;

public class Abonat {

    private String nume;
    private String prenume;
    private nrTel tel;
    private String cnp;

    public Abonat(String nume, String prenume, nrTel tel, String cnp) {
        this.nume = nume;
        this.prenume = prenume;
        this.tel = tel;
        this.cnp = cnp;
    }

    public boolean verifCnp(String cnp) {

        if (cnp.length() != 13) {

            System.out.println("Lungimea este gresita!");
            return false;
        }
        if (!cnp.matches("[0-9]+")) {
            System.out.println("Nu contine cifre!");
            return false;
        }
        if (!cnp.substring(0, 1).contains("1") && !cnp.substring(0, 1).contains("2")) {
            System.out.println("Poate esti extraterestru!");
            return false;
        }
        String[] res = cnp.split("");
        int rst = (Integer.parseInt(res[0]) * 2) + (Integer.parseInt(res[1]) * 7) + (Integer.parseInt(res[2]) * 9) + (Integer.parseInt(res[3]) * 1) + (Integer.parseInt(res[4]) * 4) + (Integer.parseInt(res[5]) * 6) + (Integer.parseInt(res[6]) * 3) + (Integer.parseInt(res[7]) * 5) + (Integer.parseInt(res[8]) * 8) + (Integer.parseInt(res[9]) * 2) + (Integer.parseInt(res[10]) * 7) + (Integer.parseInt(res[11]) * 9);
        int j = rst % 11;
        if (j != Integer.parseInt(res[12])) {

            return false;
        }

        return true;

    }

    public boolean verifNume(String nume) {
        if (!nume.matches("[a-zA-z]+")) {
            //throw new RuntimeException("Nu e bine!");
            System.out.println("Nu contine litere!");
            return false;
        }
        return true;
    }

    public String toString() {
        return nume + " " + prenume + " " + tel.getTel() + " " + cnp;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getTell() {
        return tel.getTel();
    }

    public String getCnp() {
        return cnp;
    }

   
}
