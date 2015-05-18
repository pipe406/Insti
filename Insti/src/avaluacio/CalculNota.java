package avaluacio;

import java.text.DecimalFormat;

public class CalculNota {
    
    
    
    
    
    

    public static int calculaNota(String modul, String uf, int notes[]) {
        double lanota = 0.0;
        int lanotaint = 0;
        DecimalFormat df = new DecimalFormat("##");

        
        
        if (modul == "M05") {
            for (int i = 0; i < notes.length; i++) {
                if (notes[i] < 3) {
                    lanotaint = -3; //alguna nota és menor que 3
                }
            }
            if (lanotaint == 0) {

                if (uf == "UF1") {
                    lanotaint = calculauf1(notes, df);
                } 
                
                else if (uf == "UF2") {
                    if (notes.length < 6) {
                        lanotaint = -4; //falten notes
                    } else {
                        lanota = notes[0] * 0.1 + notes[1] * 0.05 + notes[2] * 0.05 + notes[3] * 0.2 + notes[4] * 0.2 + notes[5] * 0.4;
                        lanotaint = Integer.parseInt(df.format(lanota));
                    }
                } else if (uf == "UF3") {
                    if (notes.length < 5) {
                        lanotaint = -4; //falten notes
                    } else {
                        lanota = notes[0] * 0.1 + notes[1] * 0.1 + notes[2] * 0.2 + notes[3] * 0.2 + notes[4] * 0.4;
                        lanotaint = Integer.parseInt(df.format(lanota));
                    }
                } else {
                    lanotaint = -2; //uf diferent de UF1, UF2 o UF3
                }
            }
        } else {
            lanotaint = -1; //mòdul no és M5
        }
        return lanotaint;
    }

    public static int calculauf1(int[] notes, DecimalFormat df) throws NumberFormatException {
        int lanotaint;
        double lanota;
        if (notes.length < 6) {
            lanotaint = -4; //falten notes
        } else {
            lanota = notes[0] * 0.05 + notes[1] * 0.05 + notes[2] * 0.05 + notes[3] * 0.05 + notes[4] * 0.3 + notes[5] * 0.5;
            lanotaint = Integer.parseInt(df.format(lanota));
        }
        return lanotaint;
    }

}


