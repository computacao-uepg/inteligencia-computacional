/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aima.core.environment.blocks;

import aima.core.agent.Action;
import aima.core.environment.blocks.BlocksState;
import aima.core.search.framework.ActionsFunction;
import aima.core.search.framework.ResultFunction;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author jcarlos
 */
public class BlocksFunctionFactory {

    private static ActionsFunction _actionsFunction = null;
    private static ResultFunction _resultFunction = null;

    public static ActionsFunction getActionsFunction() {
        if (null == _actionsFunction) {
            _actionsFunction = new BlocksActionsFunction();
        }
        return _actionsFunction;
    }

    public static ResultFunction getResultFunction() {
        if (null == _resultFunction) {
            _resultFunction = new BlocksResultFunction();
        }
        return _resultFunction;
    }

    private static class BlocksActionsFunction implements ActionsFunction {

        // DEFININDO A AÇÃO DE CADA BLOCO DEPENDO DO ESTADO DE CADA UM
        // NESSE CASO ELE VERIFICA SE UM BLOCO ESTA EM CIMA DE OUTRO && SE O BLOCO QUE SERÁ MOVIDO ESTÁ NO TOPO
        // && SE A POSIÇÃO QUE ELE DESEJA COLOCAR ESTÁ LIVRE
        public Set<Action> actions(Object state) {
            BlocksState board = (BlocksState) state;
            Set<Action> actions = new LinkedHashSet<Action>();

            /*
            if ((isAt('c', 'b', board)) && (isFree('c', board)) && (isFreePos(0, board))) {
                actions.add(board.DESEMP_cFrom_bto_0);
            }
            if ((isAt('c', 'a', board)) && (isFree('c', board)) && (isFreePos(0, board))) {
                actions.add(board.DESEMP_cFrom_ato_0);
            }
            if ((isAt('b', 'a', board)) && (isFree('b', board)) && (isFreePos(0, board))) {
                actions.add(board.DESEMP_bFrom_ato_0);
            }
            if ((isAt('b', 'c', board)) && (isFree('b', board)) && (isFreePos(0, board))) {
                actions.add(board.DESEMP_bFrom_cto_0);
            }
            if ((isAt('a', 'b', board)) && (isFree('a', board)) && (isFreePos(0, board))) {
                actions.add(board.DESEMP_aFrom_bto_0);
            }
            if ((isAt('a', 'c', board)) && (isFree('a', board)) && (isFreePos(0, board))) {
                actions.add(board.DESEMP_aFrom_cto_0);
            }

            //*******************************************************************************
            
             if ((isAt('c', 'b', board)) && (isFree('c', board)) && (isFreePos(1, board))) {
                actions.add(board.DESEMP_cFrom_bto_1);
            }
            if ((isAt('c', 'a', board)) && (isFree('c', board)) && (isFreePos(1, board))) {
                actions.add(board.DESEMP_cFrom_ato_1);
            }
            if ((isAt('b', 'a', board)) && (isFree('b', board)) && (isFreePos(1, board))) {
                actions.add(board.DESEMP_bFrom_ato_1);
            }
            if ((isAt('b', 'c', board)) && (isFree('b', board)) && (isFreePos(1, board))) {
                actions.add(board.DESEMP_bFrom_cto_1);
            }
            if ((isAt('a', 'b', board)) && (isFree('a', board)) && (isFreePos(1, board))) {
                actions.add(board.DESEMP_aFrom_bto_1);
            }
            if ((isAt('a', 'c', board)) && (isFree('a', board)) && (isFreePos(1, board))) {
                actions.add(board.DESEMP_aFrom_cto_1);
            }
            
            //******************************************************************************
            
             if ((isAt('c', 'b', board)) && (isFree('c', board)) && (isFreePos(2, board))) {
                actions.add(board.DESEMP_cFrom_bto_2);
            }
            if ((isAt('c', 'a', board)) && (isFree('c', board)) && (isFreePos(2, board))) {
                actions.add(board.DESEMP_cFrom_ato_2);
            }
            if ((isAt('b', 'a', board)) && (isFree('b', board)) && (isFreePos(2, board))) {
                actions.add(board.DESEMP_bFrom_ato_2);
            }
            if ((isAt('b', 'c', board)) && (isFree('b', board)) && (isFreePos(2, board))) {
                actions.add(board.DESEMP_bFrom_cto_2);
            }
            if ((isAt('a', 'b', board)) && (isFree('a', board)) && (isFreePos(2, board))) {
                actions.add(board.DESEMP_aFrom_bto_2);
            }
            if ((isAt('a', 'c', board)) && (isFree('a', board)) && (isFreePos(2, board))) {
                actions.add(board.DESEMP_aFrom_cto_2);
            }
            
            //*********************************EMPILHAR***************************************
            
            //Testa se os 2 são topo e o 1° esta na posição certa
            
             if ((isFree('b', board)) && (isFree('a', board)) && (isAtPos('a', 0, board) )) {  
                actions.add(board.EMP_aFrom_0to_b);
            }
            if ((isFree('a', board)) && (isFree('c', board)) && (isAtPos('a', 0, board))) {
                actions.add(board.EMP_aFrom_0to_c);
            }
            if ((isFree('b', board)) && (isFree('a', board)) && (isAtPos('b', 0, board))) {
                actions.add(board.EMP_bFrom_0to_a);
            }
            if ((isFree('b', board)) && (isFree('c', board)) && (isAtPos('b', 0, board))) {
                actions.add(board.EMP_bFrom_0to_c);
            }
            if ((isFree('c', board)) && (isFree('a', board)) && (isAtPos('c', 0, board))) {
                actions.add(board.EMP_cFrom_0to_a);
            }
            if ((isFree('c', board)) && (isFree('b', board)) && (isAtPos('c', 0, board))) {
                actions.add(board.EMP_cFrom_0to_b);
            }
            
            //****************************************************************************8
            
             if ((isFree('b', board)) && (isFree('a', board)) && (isAtPos('a', 1, board))) {  
                actions.add(board.EMP_aFrom_1to_b);
            }
            if ((isFree('a', board)) && (isFree('c', board)) && (isAtPos('a', 1, board))) {
                actions.add(board.EMP_aFrom_1to_c);
            }
            if ((isFree('b', board)) && (isFree('a', board)) && (isAtPos('b', 1, board))) {
                actions.add(board.EMP_bFrom_1to_a);
            }
            if ((isFree('b', board)) && (isFree('c', board)) && (isAtPos('b', 1, board))) {
                actions.add(board.EMP_bFrom_1to_c);
            }
            if ((isFree('c', board)) && (isFree('a', board)) && (isAtPos('c', 1, board))) {
                actions.add(board.EMP_cFrom_1to_a);
            }
            if ((isFree('c', board)) && (isFree('b', board)) && (isAtPos('c', 1, board))) {
                actions.add(board.EMP_cFrom_1to_b);
            }
            
            //*************************************************************************
            
           if ((isFree('b', board)) && (isFree('a', board)) && (isAtPos('a', 2, board))) {  
                actions.add(board.EMP_aFrom_2to_b);
            }
            if ((isFree('a', board)) && (isFree('c', board)) && (isAtPos('a', 2, board))) {
                actions.add(board.EMP_aFrom_2to_c);
            }
            if ((isFree('b', board)) && (isFree('a', board)) && (isAtPos('b', 2, board))) {
                actions.add(board.EMP_bFrom_2to_a);
            }
            if ((isFree('b', board)) && (isFree('c', board)) && (isAtPos('b', 2, board))) {
                actions.add(board.EMP_bFrom_2to_c);
            }
            if ((isFree('c', board)) && (isFree('a', board)) && (isAtPos('c', 2, board))) {
                actions.add(board.EMP_cFrom_2to_a);
            }
            if ((isFree('c', board)) && (isFree('b', board)) && (isAtPos('c', 2, board))) {
                actions.add(board.EMP_cFrom_2to_b);
            }*/
            
            if ((isAt('a', 'c', board)) && (isFree('a', board)) && (isFreePos(2, board))) {
                actions.add(board.DESEMP_aFrom_cto_2);
            }
            
            if ((isFree('c', board)) && (isFree('b', board)) && (isAtPos('c', 2, board))) {
                actions.add(board.EMP_cFrom_2to_b);
            }
            
            //****************************************************************************
            
            return actions;
        }

        /**
         * 
         * @param blocoA
         * @param blocoB
         * @param board
         * @return true se o blocoA estiver em cima do blocoB
         */
        private boolean isAt(char blocoA, char blocoB, BlocksState board) {
            for (int i = 1; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board.stacks[i][j] == blocoA && board.stacks[i-1][j] == blocoB) {
                        System.out.println(blocoA+" ESTA EM CIMA DE "+blocoB);
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean isAtPos(char a, int i, BlocksState board){
            for (int j = 0; j <3; j++) {
                if(board.stacks[i][j] == a){
                    System.out.println(a+" ESTA NA POSICAO "+board.stacks[i][j]);
                    return true;
                }
            }
            return false;
        }
        
        
        /**
         * 
         * @param i
         * @param board
         * @return true se a posição escolhida estiver vazia
         */
        private boolean isFreePos(int i, BlocksState board) {

            if (board.stacks[0][i] == '\u0000') {    // se for igual a null
                System.out.println("A POSICAO NO NIVEL 0" + i + " É LIVRE");
                return true;
            }

            return false;
        }

        /**
         * 
         * @param bloco
         * @param board
         * @return true se não tiver ninguém acima do bloco escolhido e nao for o ultimo
         *  
         */
        private boolean isFree(char bloco, BlocksState board) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {

                    if (board.stacks[i][j] == bloco) {
                        if (board.stacks[i+1][j] == '\u0000' && j < 2) {
                            System.out.println(bloco + "TA LIVRE ");
                            return true;
                        }
                    }
                }
            }

            return false;
        }


        private int blockPosition(char bloco, BlocksState board){
            for(int i = 0; i<3; i++){
                for(int j=0;j<3;j++){
                    if(board.stacks[i][j]==bloco)
                        return (i*10+j);    //retorna um numero, a dezena é i e a unidade é j
                }
            }
            return -1;
        }


        private int freePosition(int col, BlocksState board){
            for(int i = 0 ; i<3; i++){
                if (board.stacks[col][i]== '\u0000'){
                    return i;
                }
            }

          return -1;  
        }
    } 

    private static class BlocksResultFunction implements ResultFunction {

        // AQUI HÁ UMA VERIFICAÇÃO PARA VER SE A AÇÃO DO BLOCO É VALIDA,
        //COM ISSO ELE ATUALIZA O BOARD PARA PROSSEGUIR 
        // CASO CONTRÁRIO ELE MANTÉM A INSTANCIA DE BOARD JÁ USADA ANTERIORMENTE
        public Object result(Object state, Action action) {
            
            BlocksState board = (BlocksState) state;
            BlocksState newBoard = new BlocksState();
            newBoard = board;
            BlocksActionsFunction baf = new BlocksActionsFunction();
            
            if (board.DESEMP_aFrom_bto_0.equals(action)) {
                System.out.println("Criar o novo objeto do tipo BlocksState");
                int posiOld= baf.blockPosition('a', board);
                System.out.println(posiOld);
                newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
                newBoard.stacks[0][baf.freePosition(0, board)]= 'a';
                
            } else if (board.DESEMP_aFrom_cto_0.equals(action)) {
                System.out.println("Criar o novo objeto do tipo BlocksState");
                int posiOld= baf.blockPosition('a', board);
                System.out.println(posiOld);
                newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
                newBoard.stacks[0][baf.freePosition(0, board)]= 'a';
                
            } else if (board.DESEMP_bFrom_ato_0.equals(action)) {
                System.out.println("Criar o novo objeto do tipo BlocksState");
                int posiOld= baf.blockPosition('b', board);
                System.out.println(posiOld);
                newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
                newBoard.stacks[0][baf.freePosition(0, board)]= 'b';
                
            } else if (board.DESEMP_bFrom_cto_0.equals(action)) {
                //System.out.println("Criar o novo objeto do tipo BlocksState");
                int posiOld= baf.blockPosition('b', board);
                System.out.println(posiOld);
                newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
                newBoard.stacks[0][baf.freePosition(0, board)]= 'b';
                
            } else if (board.DESEMP_cFrom_bto_0.equals(action)) {
                //System.out.println("Criar o novo objeto do tipo BlocksState");
                int posiOld= baf.blockPosition('c', board);
                System.out.println(posiOld);
                newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
                newBoard.stacks[0][baf.freePosition(0, board)]= 'c';
                
            } else if (board.DESEMP_cFrom_ato_0.equals(action)) {
                //System.out.println("Criar o novo objeto do tipo BlocksState");
                int posiOld= baf.blockPosition('c', board);
                System.out.println(posiOld);
                newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
                newBoard.stacks[0][baf.freePosition(0, board)]= 'c';
            }
            
            //++++++++++++++++++
            // pilha 1
            //------------------
            
            else if (board.DESEMP_aFrom_bto_1.equals(action)) {
                System.out.println("Criar o novo objeto do tipo BlocksState");
                int posiOld= baf.blockPosition('a', board);
                System.out.println(posiOld);
                newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
                newBoard.stacks[1][baf.freePosition(1, board)]= 'a';
                
            } else  if (board.DESEMP_aFrom_cto_1.equals(action)) {
                System.out.println("Criar o novo objeto do tipo BlocksState");
                int posiOld= baf.blockPosition('a', board);
                System.out.println(posiOld);
                newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
                newBoard.stacks[1][baf.freePosition(1, board)]= 'a';
                
            } else  if (board.DESEMP_bFrom_ato_1.equals(action)) {
                System.out.println("Criar o novo objeto do tipo BlocksState");
                int posiOld= baf.blockPosition('b', board);
                System.out.println(posiOld);
                newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
                newBoard.stacks[1][baf.freePosition(1, board)]= 'b';
                
            } else if (board.DESEMP_bFrom_cto_1.equals(action)) {
                int posiOld= baf.blockPosition('b', board);
                System.out.println(posiOld);
                newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
                newBoard.stacks[1][baf.freePosition(1, board)]= 'b';
                
            } else if (board.DESEMP_cFrom_bto_1.equals(action)) {
                int posiOld= baf.blockPosition('c', board);
                System.out.println(posiOld);
                newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
                newBoard.stacks[1][baf.freePosition(1, board)]= 'c';
                
            } else if (board.DESEMP_cFrom_ato_1.equals(action)) {
                int posiOld= baf.blockPosition('c', board);
                System.out.println(posiOld);
                newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
                newBoard.stacks[1][baf.freePosition(1, board)]= 'c';
            }            
            
            
            //++++++++++++++++++
            // pilha 2
            //------------------
            
            else if (board.DESEMP_aFrom_bto_2.equals(action)) {
                System.out.println("DESEMP_aFrom_bto_2");
                int posiOld= baf.blockPosition('a', board);
                System.out.println(posiOld);
                newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
                newBoard.stacks[2][baf.freePosition(2, board)]= 'a';
                
            } else  if (board.DESEMP_aFrom_cto_2.equals(action)) {
                System.out.println("DESEMP_aFrom_cto_2");
                int posiOld= baf.blockPosition('a', board);
                System.out.println(posiOld);
                newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
                newBoard.stacks[2][baf.freePosition(2, board)]= 'a';
                
            } else  if (board.DESEMP_bFrom_ato_2.equals(action)) {
                System.out.println("DESEMP_bFrom_ato_2");
                int posiOld= baf.blockPosition('b', board);
                System.out.println(posiOld);
                newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
                newBoard.stacks[2][baf.freePosition(2, board)]= 'b';
                
            } else   if (board.DESEMP_bFrom_cto_2.equals(action)) {
                System.out.println("DESEMP_bFrom_cto_2");
                int posiOld= baf.blockPosition('b', board);
                System.out.println(posiOld);
                newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
                newBoard.stacks[2][baf.freePosition(2, board)]= 'b';
                
            } else    if (board.DESEMP_cFrom_bto_2.equals(action)) {
                System.out.println("DESEMP_cFrom_bto_2");
                int posiOld= baf.blockPosition('c', board);
                System.out.println(posiOld);
                newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
                newBoard.stacks[2][baf.freePosition(2, board)]= 'c';
                
            } else    if (board.DESEMP_cFrom_ato_2.equals(action)) {
                System.out.println("DESEMP_cFrom_ato_2");
                int posiOld= baf.blockPosition('c', board);
                System.out.println(posiOld);
                newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
                newBoard.stacks[2][baf.freePosition(2, board)]= 'c';
            } else 
            
            
            //**********************empilhar**************************
            
            if (board.EMP_aFrom_0to_b.equals(action)) {
                System.out.println("EMP_aFrom_0to_b");
                int posiOld= baf.blockPosition('a', board);
                System.out.println(posiOld);
                newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
                posiOld = baf.blockPosition('b', board);
                System.out.println(posiOld);
                newBoard.stacks[(posiOld%100 - posiOld%10)/10][ (posiOld%10) +1]= 'a';
                
            } else  if (board.EMP_aFrom_0to_c.equals(action)) {
                System.out.println("EMP_aFrom_0to_c");
                int posiOld= baf.blockPosition('a', board);
                System.out.println(posiOld);
                newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
                posiOld = baf.blockPosition('c', board);
                System.out.println(posiOld);
                newBoard.stacks[(posiOld%100 - posiOld%10)/10][ (posiOld%10) +1]= 'a';
                
            } else if (board.EMP_bFrom_0to_a.equals(action)) {
                System.out.println("EMP_bFrom_0to_a");
                int posiOld= baf.blockPosition('b', board);
                System.out.println(posiOld);
                newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
                posiOld = baf.blockPosition('a', board);
                System.out.println(posiOld);
                newBoard.stacks[(posiOld%100 - posiOld%10)/10][ (posiOld%10) +1]= 'b';
                
            } else if (board.EMP_bFrom_0to_c.equals(action)) {
                System.out.println("EMP_bFrom_0to_c");
                int posiOld= baf.blockPosition('b', board);
                System.out.println(posiOld);
                newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
                posiOld = baf.blockPosition('c', board);
                System.out.println(posiOld);
                newBoard.stacks[(posiOld%100 - posiOld%10)/10][ (posiOld%10) +1]= 'b';
                
            } else  if (board.EMP_cFrom_0to_a.equals(action)) {
                System.out.println("EMP_cFrom_0to_a");
                int posiOld= baf.blockPosition('c', board);
                System.out.println(posiOld);
                newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
                posiOld = baf.blockPosition('a', board);
                System.out.println(posiOld);
                newBoard.stacks[(posiOld%100 - posiOld%10)/10][ (posiOld%10) +1]= 'c';
                
            } else if (board.EMP_cFrom_0to_b.equals(action)) {
                System.out.println("EMP_cFrom_0to_b");
                int posiOld= baf.blockPosition('c', board);
                System.out.println(posiOld);
                newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
                posiOld = baf.blockPosition('b', board);
                System.out.println(posiOld);
                newBoard.stacks[(posiOld%100 - posiOld%10)/10][ (posiOld%10) +1]= 'c';
                
            } else if (board.EMP_aFrom_1to_b.equals(action)) {
                System.out.println("EMP_aFrom_1to_b");
                int posiOld= baf.blockPosition('a', board);
                System.out.println(posiOld);
                newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
                posiOld = baf.blockPosition('b', board);
                System.out.println(posiOld);
                newBoard.stacks[(posiOld%100 - posiOld%10)/10][ (posiOld%10) +1]= 'a';
                
            } else if (board.EMP_aFrom_1to_c.equals(action)) {
                System.out.println("EMP_aFrom_1to_c");
                int posiOld= baf.blockPosition('a', board);
                System.out.println(posiOld);
                newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
                posiOld = baf.blockPosition('c', board);
                System.out.println(posiOld);
                newBoard.stacks[(posiOld%100 - posiOld%10)/10][ (posiOld%10) +1]= 'a';
                
            } else if (board.EMP_bFrom_1to_a.equals(action)) {
                System.out.println("EMP_bFrom_1to_a");
                int posiOld= baf.blockPosition('b', board);
                System.out.println(posiOld);
                newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
                posiOld = baf.blockPosition('a', board);
                System.out.println(posiOld);
                newBoard.stacks[(posiOld%100 - posiOld%10)/10][ (posiOld%10) +1]= 'b';
                
            } else if (board.EMP_bFrom_1to_c.equals(action)) {
                System.out.println("EMP_bFrom_1to_c");
                int posiOld= baf.blockPosition('b', board);
                System.out.println(posiOld);
                newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
                posiOld = baf.blockPosition('c', board);
                System.out.println(posiOld);
                newBoard.stacks[(posiOld%100 - posiOld%10)/10][ (posiOld%10) +1]= 'b';
                
            } else if (board.EMP_cFrom_1to_a.equals(action)) {
                System.out.println("EMP_cFrom_1to_a");
                int posiOld= baf.blockPosition('c', board);
                System.out.println(posiOld);
                newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
                posiOld = baf.blockPosition('a', board);
                System.out.println(posiOld);
                newBoard.stacks[(posiOld%100 - posiOld%10)/10][ (posiOld%10) +1]= 'c';
                
            } else if (board.EMP_cFrom_1to_b.equals(action)) {
                System.out.println("EMP_cFrom_1to_b");
                int posiOld= baf.blockPosition('c', board);
                System.out.println(posiOld);
                newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
                posiOld = baf.blockPosition('b', board);
                System.out.println(posiOld);
                newBoard.stacks[(posiOld%100 - posiOld%10)/10][ (posiOld%10) +1]= 'c';
                
            } else  if (board.EMP_aFrom_2to_b.equals(action)) {
                System.out.println("EMP_aFrom_2to_b");
                int posiOld= baf.blockPosition('a', board);
                System.out.println(posiOld);
                newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
                posiOld = baf.blockPosition('b', board);
                System.out.println(posiOld);
                newBoard.stacks[(posiOld%100 - posiOld%10)/10][ (posiOld%10) +1]= 'a';
                
            } else  if (board.EMP_aFrom_2to_c.equals(action)) {
                System.out.println("EMP_aFrom_2to_c");
                int posiOld= baf.blockPosition('a', board);
                System.out.println(posiOld);
                newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
                posiOld = baf.blockPosition('c', board);
                System.out.println(posiOld);
                newBoard.stacks[(posiOld%100 - posiOld%10)/10][ (posiOld%10) +1]= 'a';
                
            } else  if (board.EMP_bFrom_2to_a.equals(action)) {
                System.out.println("EMP_bFrom_2to_a");
                int posiOld= baf.blockPosition('b', board);
                System.out.println(posiOld);
                newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
                posiOld = baf.blockPosition('a', board);
                System.out.println(posiOld);
                newBoard.stacks[(posiOld%100 - posiOld%10)/10][ (posiOld%10) +1]= 'b';
                
            } else  if (board.EMP_bFrom_2to_c.equals(action)) {
                System.out.println("EMP_bFrom_2to_c");
                int posiOld= baf.blockPosition('b', board);
                System.out.println(posiOld);
                newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
                posiOld = baf.blockPosition('c', board);
                System.out.println(posiOld);
                newBoard.stacks[(posiOld%100 - posiOld%10)/10][ (posiOld%10) +1]= 'b';
                
            } else   if (board.EMP_cFrom_2to_a.equals(action)) {
                System.out.println("EMP_cFrom_2to_a");
                int posiOld= baf.blockPosition('c', board);
                System.out.println(posiOld);
                newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
                posiOld = baf.blockPosition('a', board);
                System.out.println(posiOld);
                newBoard.stacks[(posiOld%100 - posiOld%10)/10][ (posiOld%10) +1]= 'c';
                
            } else   if (board.EMP_cFrom_2to_b.equals(action)) {
                System.out.println("EMP_cFrom_2to_b");
                int posiOld= baf.blockPosition('c', board);
                System.out.println(posiOld);
                newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
                posiOld = baf.blockPosition('b', board);
                System.out.println(posiOld);
                newBoard.stacks[(posiOld%100 - posiOld%10)/10][ (posiOld%10) +1]= 'c';
                
            } else {
                 newBoard = null; //oras, n da pra colocar = null na matriz em vez de '\u0000'?
            }
            System.out.println("============");
            for(int i=2; i>-1;i--){
                for(int j=0;j<3;j++){
                    if(newBoard.stacks[i][j]=='\u0000'){
                        System.out.print("0");
                    }else{
                        System.out.print(newBoard.stacks[i][j]);
                    }
                }
                System.out.print("\n");
            }
            System.out.println("============");

              
            // The Action is not understood or is a NoOp
            // the result will be the current state.
            if (newBoard != null) {
                return newBoard;
            } else {
                return state;
            }
        }
    }
}
