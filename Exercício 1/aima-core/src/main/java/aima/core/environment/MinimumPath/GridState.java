/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aima.core.environment.MinimumPath;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;

;

/**
 *
 * @author pedro    
 */

public class GridState {
    
    
    public static Action LEFT = new DynamicAction("Left");

    public static Action RIGHT = new DynamicAction("Right");

    public static Action UP = new DynamicAction("Up");

    public static Action DOWN = new DynamicAction("Down");
    
    
    public int[][] grid = new int[11][8];       //matriz com caminhos
    
       
    public static float[][] dist = new float[11][8];   //distância em linha reta
    
    static int f[] =new int[]{1,4};        //posição final
    
    public static int i[] = new int[]{8,3};       //posição inicial
    
    public int current_position[] = new int[]{8,3};
    
    
    public GridState(){
        grid = new int[][]{  {0,0,0,0,0,0,0,0},
                             {0,0,0,0,0,1,0,0},
                             {0,1,0,0,0,0,0,0},
                             {0,0,1,1,1,1,1,0},
                             {0,1,0,0,0,0,1,0},
                             {0,1,0,0,1,0,0,0},
                             {0,0,0,0,1,0,1,0},
                             {0,0,1,0,1,0,0,0},
                             {0,0,1,0,0,0,0,0},
                             {0,0,1,0,0,0,0,0},
                             {0,0,0,0,0,0,0,0}};
     
       StraightLineHeuristic();
    }

   
  

    public int[] getState(){
        return current_position;
    }
    
    public GridState(GridState gs){ 
      this.current_position[0] = gs.current_position[0];
      this.current_position[1] = gs.current_position[1];
      
        grid = new int[][]{  {0,0,0,0,0,0,0,0},
                             {0,0,0,0,0,1,0,0},
                             {0,1,0,0,0,0,0,0},
                             {0,0,1,1,1,1,1,0},
                             {0,1,0,0,0,0,1,0},
                             {0,1,0,0,1,0,0,0},
                             {0,0,0,0,1,0,1,0},
                             {0,0,1,0,1,0,0,0},
                             {0,0,1,0,0,0,0,0},
                             {0,0,1,0,0,0,0,0},
                             {0,0,0,0,0,0,0,0}};
     
       StraightLineHeuristic();
      
    }
    
      private void StraightLineHeuristic(){
        
        
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 8; j++) {
                float x = this.f[0]-i;
                float y = this.f[1]-j;
                this.dist[i][j] =(float) x+y;
                  
            }   
        }   
    }
    
    public boolean canMoveUp(Action where){
        boolean op = false;
        
              
       //só é possível ir para cima  se a linha que é desejada tiver um zero e
        if((current_position[0] - 1) >= 0 && grid[current_position[0] - 1][current_position[1]] == 0  ){            //não extrapolar o tamanho da matriz
            op = true;
        }
       
        
        
        return op;
    }
    
    //para testar se é possivel ir para baixo
    public boolean canMoveDown(Action where){
        boolean op = false;
        
       //só é possível ir para baixo se a linha que é desejada tiver um zero e
        if((current_position[0] + 1) <= 10 && grid[current_position[0]+1][current_position[1]] == 0){            //não extrapolar o tamanho da matriz
            op = true;
        }
       
        return op;
    }
    
    
     public boolean canMoveLeft(Action where){
        boolean op = false;
        
               
       //só é possível ir para esquerda se a linha que é desejada tiver um zero e
        if((current_position[1] - 1) >= 0 && grid[current_position[0]][current_position[1] - 1] == 0){            //não extrapolar o tamanho da matriz
            op = true;
        }
       
       
        return op;
    }
    
      public boolean canMoveRight(Action where){
        boolean op = false;
        
        //só é possível ir para direita se a linha que é desejada tiver um zero e
        if((current_position[1] + 1) <= 7 && grid[current_position[0]][current_position[1] + 1] == 0){            //não extrapolar o tamanho da matriz
            op = true;
       
       
    }
         return op;
      }
    
    
      
      //trafegar para horizontal ou vertical é incrementar/decrementar a linha ou a coluna
      public void MoveUp(){
          current_position[0]--;
          
      }
      
      public void MoveDown(){
            current_position[0]++;
          
      }
      
      public void MoveRight(){
          
            current_position[1]++;
      }
      
      public void MoveLeft(){
          
            current_position[1]--;
          
      }
            
}