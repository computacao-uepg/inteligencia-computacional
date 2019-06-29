/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aima.core.environment.exercicio1;

import aima.core.search.framework.GoalTest;

/**
 *
 * @author pedro
 */
public class MSGoalState implements GoalTest {
    //  a soma de cada linha e das duas diagonais seja igual a k;
    int k = 17;
    int[] sumLinha = new int[4];
    int[] sumD = new int[2];
    @Override
    public boolean isGoalState(Object state) {
        System.out.println("oi");
        MSState board = (MSState) state;
        soma(board);
        somaD(board);
        if (    sumD[0]==sumD[1]
                &&sumD[0]==sumLinha[0] 
                &&sumD[0]==sumLinha[1] 
                &&sumD[0]==sumLinha[2]
                &&sumD[0]==sumLinha[3]
                ){
                System.out.println("ENCONTRADO");
                board.getStateAsString();
                return true;
        
        }
        System.out.println(" NAO ENCONTRADO");
        return false;
    }
    private void soma(MSState board ){
        for (int i = 0; i < 4; i++) {
            sumLinha[i]= 0;
            for (int j = 0; j < 4; j++) {
                sumLinha[i]+=board.grid[i][j];
            }
            
        }
    }
    private void somaD(MSState board){
        sumD[0] =board.grid[0][0]+board.grid[1][1]
            +board.grid[2][2]+board.grid[3][3];
        
           sumD[1]=(board.grid[0][3]+board.grid[1][2]
            +board.grid[2][1]+board.grid[3][0]);
    }
    
    
    
}
