/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package aima.core.environment.MinimumPath;
import aima.core.search.framework.GoalTest;
/**
 *
 * @author pedro
 */
public class GridGoalState implements GoalTest{
 

    //função para testar se o estado desejado foi alcançado
 public boolean isGoalState(Object state){
      //System.out.println("aaa"+(String)state);
      GridState estado = (GridState) state;
      GridState estado2 = (GridState) state;
      System.out.print("Posicao X: ");
      System.out.println(estado.current_position[0]);
      System.out.print("Posicao Y: ");
      System.out.println(estado.current_position[1]);
      System.out.println(" ");
     //se a linha e a coluna atual são iguais a desejada, retorna true
        if (estado.current_position[0] == estado.f[0] && estado.current_position[1]== estado.f[1]){
            return true;
            
        }else{
            return false;
        }
        
    }
    

    public boolean test(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
