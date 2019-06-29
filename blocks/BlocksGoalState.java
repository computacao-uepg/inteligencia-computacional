/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aima.core.environment.blocks;

import aima.core.search.framework.GoalTest;

/**
 *
 * @author jcarlos
 */
public class BlocksGoalState implements GoalTest {

    char[][] obj = new char[3][3];//3 Blocos e 3 posições na mesa

    // todos na mesa
    public boolean isGoalState(Object estado) {
        
        BlocksState currentState = (BlocksState) estado;
        if ((currentState.stacks[0][0] == 'a') && (currentState.stacks[0][1] == 'b') && (currentState.stacks[0][2] == 'c')) {
            return true;
        }
        return false;
    }
    
    private void matriz(){
        for(int linha = 0; linha<3; linha++){
            for(int coluna = 0; coluna<3; coluna++){
                obj[linha][coluna] = '\u0000';
            }
        }
    }
    
    public void setGoal(char bloco1, int linha1, int coluna1, char bloco2, int linha2, int coluna2, char bloco3, int linha3, int coluna3){
        matriz();
        obj[linha1][coluna1] = bloco1;  
        obj[linha2][coluna2] = bloco2;
        obj[linha3][coluna3] = bloco3;        
    }

}
