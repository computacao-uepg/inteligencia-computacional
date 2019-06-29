/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aima.core.environment.blocks;

import aima.core.agent.Action;
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

            // DEFINE A AÇÃO DE CADA BLOCO DEPENDENDO DO ESTADO ATUAL
            // VERIFICA SE O BLOCO A SER MOVIDO ESTA NO TOPO DA COLUNA
            // VERIFICA SE A POSIÇÃO PARA MOVER O BLOCO ESTA LIVRE
            
            public Set<Action> actions(Object estado) {
            BlocksState board = (BlocksState) estado;
            Set<Action> actions = new LinkedHashSet<Action>();
            
            
            // MOVIMENTANDO O BLOCO A
            
            
            if ((isFree('a',0, board)) && colunaLivre(1, board) ) {
                actions.add(board.MOVE_a_0_1);
            }            
            if ((isFree('a',0, board)) && colunaLivre(2, board) ) {
                actions.add(board.MOVE_a_0_2);
            }            
            if ((isFree('a',1, board)) && colunaLivre(0, board) ) {
                actions.add(board.MOVE_a_1_0);
            }            
            if ((isFree('a',1, board)) && colunaLivre(2, board) ) {
                actions.add(board.MOVE_a_1_2);
            }
            if ((isFree('a',2, board)) && colunaLivre(0, board) ) {
                actions.add(board.MOVE_a_2_0);
            }
            if ((isFree('a',2, board)) && colunaLivre(1, board) ) {
                actions.add(board.MOVE_a_2_1);
            }
            
            // MOVIMENTANDO O BLOCO B
            
            if ((isFree('b',0, board)) && colunaLivre(1, board) ) {
                actions.add(board.MOVE_b_0_1);
            }            
            if ((isFree('b',0, board)) && colunaLivre(2, board) ) {
                actions.add(board.MOVE_b_0_2);
            }            
            if ((isFree('b',1, board)) && colunaLivre(0, board) ) {
                actions.add(board.MOVE_b_1_0);
            }            
            if ((isFree('b',1, board)) && colunaLivre(2, board) ) {
                actions.add(board.MOVE_b_1_2);
            }
            if ((isFree('b',2, board)) && colunaLivre(0, board) ) {
                actions.add(board.MOVE_b_2_0);
            }
            if ((isFree('b',2, board)) && colunaLivre(1, board) ) {
                actions.add(board.MOVE_b_2_1);
            }
            
            // MOVIMENTANDO O BLOCO C
            
            if ((isFree('c',0, board))&& colunaLivre(1, board) ) {
                actions.add(board.MOVE_c_0_1);
            }            
            if ((isFree('c',0, board)) && colunaLivre(2, board) ) {
                actions.add(board.MOVE_c_0_2);
            }            
            if ((isFree('c',1, board)) && colunaLivre(0, board) ) {
                actions.add(board.MOVE_c_1_0);
            }            
            if ((isFree('c',1, board)) && colunaLivre(2, board) ) {
                actions.add(board.MOVE_c_1_2);
            }
            if ((isFree('c',2, board)) && colunaLivre(0, board) ) {
                actions.add(board.MOVE_c_2_0);
            }
            if ((isFree('c',2, board)) && colunaLivre(1, board) ) {
                actions.add(board.MOVE_c_2_1);
            }
            
           
             
            return actions;
        }

       
          
       
        private boolean isAt(char blocoA, char blocoB, BlocksState board) { //FUNÇÃO RETORNA TRUE SE blocoA estiver em cima de blocoB
            for (int linha = 1; linha < 3; linha++) {
                for (int coluna = 0; coluna < 3; coluna++) {
                    if (board.stacks[linha][coluna] == blocoA && board.stacks[linha-1][coluna] == blocoB) {
                        System.out.println("O BLOCO " + blocoA +" ESTA EM CIMA DO BLOCO " + blocoB);
                        return true;
                    }
                }
            }
            return false;
        }
        
        private boolean colunaLivre(int coluna, BlocksState board){ //FUNÇÃO RETORNA TRUE SE A COLUNA DESTINO DO BLOCO ESTIVER LIVRE
            for (int i = 2; i>=0;i--){
                if(board.stacks[i][coluna]=='\u0000'){
                    return true;
                }
            }
            return false;
            
        }
        
        
        private boolean isAtPos(char bloco, int coluna, BlocksState board){ //FUNÇÃO RETORNA TRUE SE O bloco ESTIVER NA coluna
            for (int linha = 0; linha < 3; linha++) {
                if(board.stacks[linha][coluna] == bloco){
                    System.out.println("O BLOCO " + bloco + " ESTA NA POSICAO " + board.stacks[linha][coluna]);
                    return true;
                }
            }
            return false;
        }
        
        
      
        private boolean isFreePos(int coluna, BlocksState board) { //FUNÇÃO RETORNA TRUE SE A COLUNA ESTIVER LIVRE NO NIVEL 0

            if (board.stacks[0][coluna] == '\u0000') {    // se for igual a null
                System.out.println("A POSICAO NO NIVEL 0" + coluna + " É LIVRE");
                return true;
            }

            return false;
        }

       
        private boolean isFree(char bloco, int colunaatual, BlocksState board) { //FUNÇÃO RETORNA TRUE SE O BLOCO ESTA NO TOPO DA COLUNA
            
            for (int linha = 2; linha >0; linha--) {
                    if (board.stacks[linha][colunaatual] != '\u0000') {
                        if (board.stacks[linha][colunaatual] == bloco) {
                            
                            return true;
                            
                        } else{
                            return false;
                        }
                    }
            }

            return false;
        }

        private int[] blockPosition(char bloco, BlocksState board){//FUNÇÃO RETORNA UM VETOR 0 A POS i
            int[] aux = new int[2];
            
            for(int linha = 0; linha < 3; linha++){
                for(int coluna = 0; coluna < 3; coluna++){
                    
                    if(board.stacks[linha][coluna] == bloco) {
                        aux[0]=linha;
                        aux[1]=coluna;
                        return aux;    
                    }
                    
                }
            }
            aux[0]=-1;
            aux[1]=-1;
            return aux;
        }

       
        private int freeNivel(int coluna, BlocksState board){//FUNÇÃO RETORNA O NIVEL SE A POSIÇÃO ESTIVER VAZIA, SENÃO RETORNA -1
            for(int nivel = 0 ; nivel<3; nivel++){
                if (board.stacks[nivel][coluna]== '\u0000'){
                    return nivel;
                }
            }
          return -1;  
        }
    } 

   private static class BlocksResultFunction implements ResultFunction {
        // metodo q verifica se a ação é valida, se TRUE atualiza o board e prossegue, se FALSE usa o board anterior 

        public Object result(Object estado, Action acao) {
            
            System.out.println(" RESULT ");
            BlocksActionsFunction blocksAF = new BlocksActionsFunction();
            BlocksState board = (BlocksState) estado;
            BlocksState board_novo = new BlocksState();
            board_novo = board;
            
            int[] antiga_posicao;
            char bloco;
            int coluna;
            
            // bloco A
            if (board.MOVE_a_0_1.equals(acao)) {
                System.out.println("MOVE A 0 1");
                antiga_posicao = blocksAF.blockPosition('a', board);
                bloco= 'a';
                coluna = 1;
                
            }else if (board.MOVE_a_0_2.equals(acao)) {
                System.out.println("MOVE A 0 2");
                antiga_posicao = blocksAF.blockPosition('a', board);
                bloco = 'a';
                coluna = 2;
                
            }else if (board.MOVE_a_1_0.equals(acao)) {
                System.out.println("MOVE A 1 0");
                antiga_posicao = blocksAF.blockPosition('a', board);
                bloco = 'a';
                coluna = 0;
                
            }else if (board.MOVE_a_1_2.equals(acao)) {
                System.out.println("MOVE A 1 2");
                antiga_posicao = blocksAF.blockPosition('a', board);
                bloco = 'a';
                coluna = 2;
            }else if (board.MOVE_a_2_0.equals(acao)) {
                System.out.println("MOVE A 2 0");
                antiga_posicao = blocksAF.blockPosition('a', board);
                bloco = 'a';
                coluna = 0;
            }else if (board.MOVE_a_2_1.equals(acao)) {
                System.out.println("MOVE A 2 1");
                antiga_posicao = blocksAF.blockPosition('a', board);
                bloco = 'a';
                coluna = 1;
            }
            
            // bloco B
            else if (board.MOVE_b_0_1.equals(acao)) {
                System.out.println("MOVE b 0 1");
                antiga_posicao = blocksAF.blockPosition('b', board);
                bloco = 'b';
                coluna = 1;
                
            }else if (board.MOVE_b_0_2.equals(acao)) {
                System.out.println("MOVE b 0 2");
                antiga_posicao = blocksAF.blockPosition('b', board);
                bloco = 'b';
                coluna = 2;
                
            }else if (board.MOVE_b_1_0.equals(acao)) {
                System.out.println("MOVE b 1 0");
                antiga_posicao = blocksAF.blockPosition('b', board);
                bloco = 'b';
                coluna = 0;
                
            }else if (board.MOVE_b_1_2.equals(acao)) {
                System.out.println("MOVE A 1 2");
                antiga_posicao = blocksAF.blockPosition('b', board);
                bloco = 'b';
                coluna = 2;
            }else if (board.MOVE_b_2_0.equals(acao)) {
                System.out.println("MOVE b 2 0");
                antiga_posicao = blocksAF.blockPosition('b', board);
                bloco = 'b';
                coluna = 0;
            }else if (board.MOVE_b_2_1.equals(acao)) {
                System.out.println("MOVE b 2 1");
                antiga_posicao = blocksAF.blockPosition('b', board);
                bloco = 'b';
                coluna = 1;
            }
            
            // bloco C
            else if (board.MOVE_c_0_1.equals(acao)) {
                System.out.println("MOVE b 0 1");
                antiga_posicao = blocksAF.blockPosition('c', board);
                bloco = 'c';
                coluna = 1;
                
            }else if (board.MOVE_c_0_2.equals(acao)) {
                System.out.println("MOVE b 0 2");
                antiga_posicao = blocksAF.blockPosition('c', board);
                bloco = 'c';
                coluna = 2;
                
            }else if (board.MOVE_c_1_0.equals(acao)) {
                System.out.println("MOVE b 1 0");
                antiga_posicao = blocksAF.blockPosition('c', board);
                bloco = 'c';
                coluna = 0;
                
            }else if (board.MOVE_c_1_2.equals(acao)) {
                System.out.println("MOVE A 1 2");
                antiga_posicao = blocksAF.blockPosition('c', board);
                bloco = 'c';
                coluna = 2;
            }else if (board.MOVE_c_2_0.equals(acao)) {
                System.out.println("MOVE b 2 0");
                antiga_posicao = blocksAF.blockPosition('c', board);
                bloco = 'c';
                coluna = 0;
            }else if (board.MOVE_c_2_1.equals(acao)) {
                System.out.println("MOVE b 2 1");
                antiga_posicao = blocksAF.blockPosition('c', board);
                bloco = 'c';
                coluna = 1;
            }
            
            
            else {
                antiga_posicao = null;
		board_novo = null;
                bloco = 'e';
                coluna = -1;
 
            }
            if(board_novo != null){
                board_novo.stacks[antiga_posicao[0]][antiga_posicao[1]] = '\u0000';
                board_novo.stacks[blocksAF.freeNivel(coluna, board)][coluna] = bloco;
            }
           
            for(int linha = 2; linha>-1; linha--){
                for(coluna = 0; coluna<3; coluna++){
                    if(board_novo.stacks[linha][coluna]=='\u0000'){
                        System.out.print("vazio");
                    }else{
                        System.out.print(board_novo.stacks[linha][coluna]);
                    }
                }
                
            }

            if (board_novo != null) {
                return board_novo;
            } else {
                return estado;
            }
        }
    }
}
