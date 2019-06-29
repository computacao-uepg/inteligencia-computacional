package aima.core.environment.magicsquare;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MSquareState {

    public int[][] board = new int[4][4];

    public MSquareState() {
		//System.out.println("Cala Boca Bruno");
        List<Integer> lista = new ArrayList<>();
        List<Integer> lista2 = new ArrayList<>();
        //cria uma lista com número de 1 a 16
        for(int i = 1; i < 17; i++){
            lista.add(i);
        }
        
        //embaralha aleatóriamente a lista
        Collections.shuffle(lista);
        
        lista2.add(1);
        lista2.add(14);
        lista2.add(15);
        lista2.add(4);
        lista2.add(12);
        lista2.add(7);
        lista2.add(6);
        lista2.add(9);
        lista2.add(8);
        lista2.add(11);
        lista2.add(10);
        lista2.add(5);
        lista2.add(13);
        lista2.add(2);
        lista2.add(16);
        lista2.add(3);
        //aloca os elemento da lista na matriz para facilitar futuras operações
        for (int i = 0; i < 4; i++) {
            //System.out.println("");
            for (int j = 0; j < 4; j++) {
                board[i][j] = lista.get(0);
                lista.remove(0);
                //System.out.print(board[i][j] + " ");
            }
        }
        //System.out.println("");
    }
    
    public Action CHANGE_00_01 = new DynamicAction("CHANGE_00_01");
    public Action CHANGE_00_02 = new DynamicAction("CHANGE_00_02");
    public Action CHANGE_00_03 = new DynamicAction("CHANGE_00_03");
    public Action CHANGE_00_10 = new DynamicAction("CHANGE_00_10");
    public Action CHANGE_00_20 = new DynamicAction("CHANGE_00_20");
    public Action CHANGE_00_30 = new DynamicAction("CHANGE_00_30");
    
    public Action CHANGE_01_00 = new DynamicAction("CHANGE_01_00");
    public Action CHANGE_01_02 = new DynamicAction("CHANGE_01_02");
    public Action CHANGE_01_03 = new DynamicAction("CHANGE_01_03");
    public Action CHANGE_01_11 = new DynamicAction("CHANGE_01_11");
    public Action CHANGE_01_21 = new DynamicAction("CHANGE_01_21");
    public Action CHANGE_01_31 = new DynamicAction("CHANGE_01_31");
    
    public Action CHANGE_02_00 = new DynamicAction("CHANGE_02_00");
    public Action CHANGE_02_01 = new DynamicAction("CHANGE_02_01");
    public Action CHANGE_02_03 = new DynamicAction("CHANGE_02_03");
    public Action CHANGE_02_12 = new DynamicAction("CHANGE_02_12");
    public Action CHANGE_02_22 = new DynamicAction("CHANGE_02_22");
    public Action CHANGE_02_32 = new DynamicAction("CHANGE_02_32");
    
    public Action CHANGE_03_00 = new DynamicAction("CHANGE_03_00");
    public Action CHANGE_03_01 = new DynamicAction("CHANGE_03_01");
    public Action CHANGE_03_02 = new DynamicAction("CHANGE_03_02");
    public Action CHANGE_03_13 = new DynamicAction("CHANGE_03_13");
    public Action CHANGE_03_23 = new DynamicAction("CHANGE_03_23");
    public Action CHANGE_03_33 = new DynamicAction("CHANGE_03_33");
    
    public Action CHANGE_10_11 = new DynamicAction("CHANGE_10_11");
    public Action CHANGE_10_12 = new DynamicAction("CHANGE_10_12");
    public Action CHANGE_10_13 = new DynamicAction("CHANGE_10_13");
    public Action CHANGE_10_00 = new DynamicAction("CHANGE_10_00");
    public Action CHANGE_10_20 = new DynamicAction("CHANGE_10_20");
    public Action CHANGE_10_30 = new DynamicAction("CHANGE_10_30");
    
    public Action CHANGE_11_10 = new DynamicAction("CHANGE_11_10");
    public Action CHANGE_11_12 = new DynamicAction("CHANGE_11_12");
    public Action CHANGE_11_13 = new DynamicAction("CHANGE_11_13");
    public Action CHANGE_11_01 = new DynamicAction("CHANGE_11_01");
    public Action CHANGE_11_21 = new DynamicAction("CHANGE_11_21");
    public Action CHANGE_11_31 = new DynamicAction("CHANGE_11_31");
    
    public Action CHANGE_12_10 = new DynamicAction("CHANGE_12_10");
    public Action CHANGE_12_11 = new DynamicAction("CHANGE_12_11");
    public Action CHANGE_12_13 = new DynamicAction("CHANGE_12_13");
    public Action CHANGE_12_02 = new DynamicAction("CHANGE_12_02");
    public Action CHANGE_12_22 = new DynamicAction("CHANGE_12_22");
    public Action CHANGE_12_32 = new DynamicAction("CHANGE_12_32");
    
    public Action CHANGE_13_10 = new DynamicAction("CHANGE_13_10");
    public Action CHANGE_13_11 = new DynamicAction("CHANGE_13_11");
    public Action CHANGE_13_12 = new DynamicAction("CHANGE_13_12");
    public Action CHANGE_13_03 = new DynamicAction("CHANGE_13_03");
    public Action CHANGE_13_23 = new DynamicAction("CHANGE_13_23");
    public Action CHANGE_13_33 = new DynamicAction("CHANGE_13_33");
    
    public Action CHANGE_20_21 = new DynamicAction("CHANGE_20_21");
    public Action CHANGE_20_22 = new DynamicAction("CHANGE_20_22");
    public Action CHANGE_20_23 = new DynamicAction("CHANGE_20_23");
    public Action CHANGE_20_00 = new DynamicAction("CHANGE_20_00");
    public Action CHANGE_20_10 = new DynamicAction("CHANGE_20_10");
    public Action CHANGE_20_30 = new DynamicAction("CHANGE_20_30");
    
    public Action CHANGE_21_20 = new DynamicAction("CHANGE_21_20");
    public Action CHANGE_21_22 = new DynamicAction("CHANGE_21_22");
    public Action CHANGE_21_23 = new DynamicAction("CHANGE_21_23");
    public Action CHANGE_21_01 = new DynamicAction("CHANGE_21_01");
    public Action CHANGE_21_11 = new DynamicAction("CHANGE_21_11");
    public Action CHANGE_21_31 = new DynamicAction("CHANGE_21_31");
    
    public Action CHANGE_22_20 = new DynamicAction("CHANGE_22_20");
    public Action CHANGE_22_21 = new DynamicAction("CHANGE_22_21");
    public Action CHANGE_22_23 = new DynamicAction("CHANGE_22_23");
    public Action CHANGE_22_02 = new DynamicAction("CHANGE_22_02");
    public Action CHANGE_22_12 = new DynamicAction("CHANGE_22_12");
    public Action CHANGE_22_32 = new DynamicAction("CHANGE_22_32");
    
    public Action CHANGE_23_20 = new DynamicAction("CHANGE_23_20");
    public Action CHANGE_23_21 = new DynamicAction("CHANGE_23_21");
    public Action CHANGE_23_22 = new DynamicAction("CHANGE_23_22");
    public Action CHANGE_23_03 = new DynamicAction("CHANGE_23_03");
    public Action CHANGE_23_13 = new DynamicAction("CHANGE_23_13");
    public Action CHANGE_23_33 = new DynamicAction("CHANGE_23_33");
    
    public Action CHANGE_30_31 = new DynamicAction("CHANGE_30_31");
    public Action CHANGE_30_32 = new DynamicAction("CHANGE_30_32");
    public Action CHANGE_30_33 = new DynamicAction("CHANGE_30_33");
    public Action CHANGE_30_00 = new DynamicAction("CHANGE_30_00");
    public Action CHANGE_30_10 = new DynamicAction("CHANGE_30_10");
    public Action CHANGE_30_20 = new DynamicAction("CHANGE_30_20");
    
    public Action CHANGE_31_30 = new DynamicAction("CHANGE_31_30");
    public Action CHANGE_31_32 = new DynamicAction("CHANGE_31_32");
    public Action CHANGE_31_33 = new DynamicAction("CHANGE_31_33");
    public Action CHANGE_31_01 = new DynamicAction("CHANGE_31_01");
    public Action CHANGE_31_11 = new DynamicAction("CHANGE_31_11");
    public Action CHANGE_31_21 = new DynamicAction("CHANGE_31_21");
    
    public Action CHANGE_32_30 = new DynamicAction("CHANGE_32_30");
    public Action CHANGE_32_31 = new DynamicAction("CHANGE_32_31");
    public Action CHANGE_32_33 = new DynamicAction("CHANGE_32_33");
    public Action CHANGE_32_02 = new DynamicAction("CHANGE_32_02");
    public Action CHANGE_32_12 = new DynamicAction("CHANGE_32_12");
    public Action CHANGE_32_22 = new DynamicAction("CHANGE_32_22");
    
    public Action CHANGE_33_30 = new DynamicAction("CHANGE_33_30");
    public Action CHANGE_33_31 = new DynamicAction("CHANGE_33_31");
    public Action CHANGE_33_32 = new DynamicAction("CHANGE_33_32");
    public Action CHANGE_33_03 = new DynamicAction("CHANGE_33_03");
    public Action CHANGE_33_13 = new DynamicAction("CHANGE_33_13");
    public Action CHANGE_33_23 = new DynamicAction("CHANGE_33_23");

}
