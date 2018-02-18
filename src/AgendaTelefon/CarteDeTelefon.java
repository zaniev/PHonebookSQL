/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AgendaTelefon;

import AgendaTelefon.Abonat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CarteDeTelefon extends AbstractListModel {

    final List ct = new ArrayList();

    @Override
    public int getSize() {
        return ct.size();
    }

    @Override
    public Object getElementAt(int i) {
        return ct.get(i);
    }
    
// METODE DE VERIFICARE PRE-ADD
    public boolean verifNume(String nume) {
        if (!nume.matches("[a-zA-z]+")) {
            JOptionPane.showMessageDialog(
                    new JFrame(),
                    "Nume Invalid!",
                    "Atentie",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        return true;
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
        // VERIFICARE ULTIMA CIFRA 
        String[] res = cnp.split("");
        int rst = (Integer.parseInt(res[0]) * 2) + (Integer.parseInt(res[1]) * 7) + (Integer.parseInt(res[2]) * 9) + (Integer.parseInt(res[3]) * 1) + (Integer.parseInt(res[4]) * 4) + (Integer.parseInt(res[5]) * 6) + (Integer.parseInt(res[6]) * 3) + (Integer.parseInt(res[7]) * 5) + (Integer.parseInt(res[8]) * 8) + (Integer.parseInt(res[9]) * 2) + (Integer.parseInt(res[10]) * 7) + (Integer.parseInt(res[11]) * 9);
        int j = rst % 11;
        if (j != Integer.parseInt(res[12])) {
            JOptionPane.showMessageDialog(new JFrame(),
                    "CNP-ul nu este valid",
                    "Atentie! ",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        //ULTIMA CIFRA CNP
        //System.out.println(j);
        return true;
    }

    public boolean verificaTel(String tel) {
        if (tel == null) {
             System.out.println("e Gol");
            return false;
        }
        if (tel.length() != 10) {
             System.out.println("Lungimea nu e buna");
            return false;
        }
        if (!tel.substring(0, 2).equals("07") && !tel.substring(0, 3).equals("021")) {
            System.out.println("Nu e numar de pe Terra!");
            return false;
        }
        if (tel.matches("[a-zA-z]+")) {
            System.out.println("Nu contine doar cifre!");
            return false;
        }
        return true;
    }

    public void adauga(Abonat a) {

        ct.add(a);
        fireContentsChanged(this, -1, -1);

    }

    /* public void veriff(String s){
        
       for (int i=0; i< ct.size(); i++){
            if(ct.indexOf(i).getName().equals(s)){
                
            }
        }
    }*/
    public void adauga(String n, String p, nrTel t, String cnp) {
        adauga(new Abonat(n, p, t, cnp));
    }
    Comparator dupaNume = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Abonat a1 = (Abonat) o1,
                    a2 = (Abonat) o2;

            return a1.getNume().compareTo(a2.getNume());
        }

    };
    Comparator dupaPrenume = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Abonat a1 = (Abonat) o1,
                    a2 = (Abonat) o2;

            return a1.getPrenume().compareTo(a2.getPrenume());
        }

    };
    Comparator dupaCnp = new Comparator() {

        @Override
        public int compare(Object o1, Object o2) {
            Abonat a1 = (Abonat) o1, a2 = (Abonat) o2;
            return a1.getCnp().compareTo(a2.getCnp());
        }
    };
    Comparator dupaNrTel = new Comparator() {

        @Override
        public int compare(Object o1, Object o2) {
            Abonat a1 = (Abonat) o1, a2 = (Abonat) o2;
            return a1.getTell().compareTo(a2.getTell());

        }
    };

    public void sterge(int pozitie) {
        ct.remove(pozitie);
        fireContentsChanged(this, -1, -1);
    }
    private int srt = 1;

    public int getSrt() {
        return srt;
    }

    public void setSrt(int i) {
        srt = i;
    }

    public void ordoneaza() {
        switch (srt) {
            case 1:
                Collections.sort(ct, dupaNume);
                fireContentsChanged(this, -1, -1);
                break;
            case 2:
                Collections.sort(ct, dupaPrenume);
                fireContentsChanged(this, -1, -1);
                break;
            case 3:
                Collections.sort(ct, dupaCnp);
                fireContentsChanged(this, -1, -1);
                break;
            case 4:
                Collections.sort(ct, dupaNrTel);
                fireContentsChanged(this, -1, -1);
                break;
        }

    }

    public void cautare(String s) {

    }

}
