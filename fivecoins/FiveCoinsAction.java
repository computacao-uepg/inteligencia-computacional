/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aima.core.environment.fivecoins;

/**
 *
 * @author rafam
 */
public class FiveCoinsAction {
    
    public static final int RemoveDuasMoedas = 2;
    public static final int RemoveUmaMoeda = 1;
    public int stackSize = 5;
    
    FiveCoinsState state = new FiveCoinsState();
    
    public void removeMoeda(int quantidade) {
        stackSize = stackSize - quantidade;
    }
    
    public void escolheQuantidadeMoedas(int quantidade) {
        if (quantidade == 1 || quantidade == 2) {
            removeMoeda(quantidade);
        } else {
            throw new IllegalArgumentException("Só pode remover 1 ou 2 moedas da pilha.");
        }
    }
    
}
