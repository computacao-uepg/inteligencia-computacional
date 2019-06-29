/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aima.core.environment.exercicio1;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author pedro
 */
public class MSState {
    
    public int[][] grid = new int[4][4];
    Random gen = new Random();
    
    public MSState(){
        
        List<Integer> lista2 = new ArrayList<>();
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
                grid[i][j] = lista2.get(0);
                lista2.remove(0);
                //System.out.print(board[i][j] + " ");
            }
        }
        
        
        
     
        Set<Integer> used = new HashSet<Integer>();  
        used.add(0);
        for (int i = 0; i < 4; i++) {  
            for (int j = 0; j < 4; j++) {

            int newRandom;  
            do {  
                newRandom = gen.nextInt(17);  
            } while (used.contains(newRandom));  
            grid[i][j] = newRandom;
            //System.out.print(grid[i][j]+"\t");
            used.add(newRandom);  
            }//System.out.print("\n");
        } //System.out.println("-----");
    }
    
    /*
    Ações
    */
    
    
    public Action mv_baixo = new DynamicAction("mv_baixo");
    public Action mv_dir = new DynamicAction("mv_dir");
    public Action mv_esq = new DynamicAction("mv_esq");
    public Action mv_cima = new DynamicAction("mv_cima");
    
    
    public  void troca(int x1, int y1, int x2,int y2, MSState g){
        int aux;
        aux = g.grid[x1][y1];
        g.grid[x1][y1] = g.grid[x2][y2];
        g.grid[x2][y2]= aux;                
        
    }
    
    public void trocaCima(int i, int j, MSState g){
        troca(i, j, i-1, j, g);        
    }
    
    public void trocaBaixo(int i, int j, MSState g){
        troca(i, j, i+1, j, g);        
    }
    
    public void trocaDir(int i, int j, MSState g){
        troca(i, j, i, j+1, g);        
    }
    
    public void trocaEsq(int i, int j, MSState g){
        troca(i, j, i, j-1, g);        
    }
    public boolean podeTrocaCima(int[] posi){
        if (posi[0]==0){
            return false;
        }
        return true;
    }
    public boolean podeTrocaBaixo(int[] posi){
        if (posi[0]==15){
            return false;
        }
        return true;
    }
    public boolean podeTrocaDir(int[] posi){
        if (posi[1]==15){
            return false;
        }
        return true;
    }
    public boolean podeTrocaEsq(int[] posi){
        if (posi[1]==0){
            return false;
        }
        return true;
    }

    public void getStateAsString() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(grid[i][j]+"\t");
            }
            System.out.print("\n");
        }
    }
    
    
    
    
    
    
}
