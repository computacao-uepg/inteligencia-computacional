/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aima.core.environment.fivecoins;

import java.util.List;

import aima.core.search.adversarial.Game;

/**
 *
 * @author rafam
 */
public class FiveCoinsGame implements Game<FiveCoinsState, FiveCoinsAction, Integer>{
    
    FiveCoinsState initialState = new FiveCoinsState();
    
    @Override
    public FiveCoinsState getInitialState() {
        return initialState;
    }

    @Override
    public Integer[] getPlayers() {
        return new Integer[] {FiveCoinsState.player1, FiveCoinsState.player2};
    }

    @Override
    public Integer getPlayer(FiveCoinsState state) {
        return state.escolheJogador1();
    }

    
    @Override
    public boolean isTerminal(FiveCoinsState state) {
        return state.estadoDeJogo != -1;
    }
    
    @Override
    public double getUtility(FiveCoinsState state, Integer player) {
        double resultado = state.estadoDeJogo;
        int tamanhoListaJogadas = state.times.size();
        
        if(state.getStackSize() == 0) {
            if(state.times.get(tamanhoListaJogadas).equals(player)) {
                resultado = player;                
            } else {
                throw new IllegalArgumentException("O jogo ainda não acabou.");
            }
        }
        
        return resultado;
    }

    @Override
    public FiveCoinsState getResult(FiveCoinsState state, FiveCoinsAction action) {
        state.remove(1);
        return state;
    }

    @Override
    public List<FiveCoinsAction> getActions(FiveCoinsState state) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
