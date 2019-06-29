/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aima.core.environment.fivecoins;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author rafam
 */
public class FiveCoinsState {

    public static final int player1 = 1;
    public static final int player2 = 2;
    public double estadoDeJogo = -1;   // 1 -> player1, 2 -> player2
    
    List<Integer> times = new ArrayList<>();
   
    public int escolheJogador1() {
        return player1;
    }
    
    public int escolheJogador2() {
        return player2;
    }
    
    public int getStackSize() {
        FiveCoinsAction size = new FiveCoinsAction();
        return size.stackSize;
    }
    
    public int removeUmaMoeda() {
        return FiveCoinsAction.RemoveUmaMoeda;
    }
    
    public int removeDuasMoedas() {
        return FiveCoinsAction.RemoveDuasMoedas;
    }
    
    public void remove(int quantidade) {
        FiveCoinsAction action = new FiveCoinsAction();
        action.escolheQuantidadeMoedas(quantidade);
    }

    List<Integer> possiveisJogadas() {
        List<Integer> jogadas = new ArrayList<>();
        FiveCoinsAction action = new FiveCoinsAction();
        
        if(action.stackSize <= 5 && action.stackSize >= 2){
            jogadas.add(FiveCoinsAction.RemoveUmaMoeda);
            jogadas.add(FiveCoinsAction.RemoveDuasMoedas);
        }
        if(action.stackSize < 2) {
            jogadas.add(FiveCoinsAction.RemoveUmaMoeda);
        }
        return jogadas;
    }
    
}
