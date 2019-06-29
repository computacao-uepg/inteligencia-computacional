/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aima.core.environment.MinimumPath;
import aima.core.search.framework.HeuristicFunction;
/**
 *
 * @author pedro
 */
public class GridHeuristic implements HeuristicFunction{

       
    //algoritmo de distância em linha reta para ser utilizada como heuristica

    
   
    @Override
    public double h(Object state) {
       float dist = (float) 0.0;          //distância em linha reta
       
       GridState s = (GridState)state;
      
       //pego a distância em linha reta da posição atual até a posição final
       dist = s.dist[s.current_position[0]][s.current_position[1]];
       

       //e a retorno
       return dist; 
        
    }
  
    
}
