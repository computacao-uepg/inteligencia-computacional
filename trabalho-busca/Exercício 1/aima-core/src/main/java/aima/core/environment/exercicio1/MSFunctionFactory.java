/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aima.core.environment.exercicio1;

import aima.core.agent.Action;
import aima.core.search.framework.ActionsFunction;
import aima.core.search.framework.ResultFunction;
import java.util.*;

/**
 *
 * @author pedro
 */
public class MSFunctionFactory {
        
    
	private static ActionsFunction _actionsFunction = null;
	private static ResultFunction _resultFunction = null;

	public static ActionsFunction getActionsFunction() {
		if (null == _actionsFunction) {
			_actionsFunction = new GridActionsFunction();
		}
		return _actionsFunction;
	}

	public static ResultFunction getResultFunction() {
		if (null == _resultFunction) {
			_resultFunction = new GridResultFunction();
		}
		return _resultFunction;
	}

	public static class GridActionsFunction implements ActionsFunction {
                 int[] posi = new int[2];
      
                
                @Override
		public Set<Action> actions(Object state) {
                        posi[0]= 0;
                        posi[1]= 0;
                        
			MSState board = (MSState) state;
                        
			Set<Action> actions = new LinkedHashSet<Action>();
                        for (int i = 0; i < 4; i++) {
                            for (int j = 0; j < 4; j++) {
                                posi[0]= i;
                                posi[1]=j;
                                System.out.println("posi "+posi[0]+posi[1]);
                        
                                if(board.podeTrocaBaixo(posi)){
                                    actions.add(board.mv_baixo);
                                    System.out.println("mv_baixo");


                                }

                                if(board.podeTrocaCima(posi)){
                                    actions.add(board.mv_cima);
                                    System.out.println("mv_cima");



                                }

                                if(board.podeTrocaDir(posi)){
                                    actions.add(board.mv_dir);
                                    System.out.println("mv_dir");


                                }

                                if(board.podeTrocaEsq(posi)){
                                    actions.add(board.mv_esq);
                                    System.out.println("mv_esq");

                                }

                         }
                        }
			return actions;
		}
	}

	public static class GridResultFunction implements ResultFunction {
                 int[] posi = new int[2];
      
                public GridResultFunction(){
                        posi[0]= 0;
                        posi[1]= 0;
                }
            
                @Override
		public Object result(Object s, Action a) {
                    System.out.println("result");

			MSState board = (MSState) s;
                        MSState newBoard = new MSState();
                        for (int i = 0; i < 4; i++) {
                            for (int j = 0; j < 4; j++) {
                                posi[0]= i;
                                posi[1]=j;
                                System.out.println("posi "+posi[0]+posi[1]);

                                if (board.mv_baixo.equals(a)) {
                                    newBoard.podeTrocaBaixo(posi);

                                }
                                else if (board.mv_cima.equals(a)) {
                                    newBoard.podeTrocaCima(posi);

                                }
                                else if (board.mv_esq.equals(a)) {
                                    newBoard.podeTrocaEsq(posi);

                                }
                                else if (board.mv_dir.equals(a)) {
                                    newBoard.podeTrocaDir(posi);

                                }

                                else newBoard=null;

                            }
                        }
			// The Action is not understood or is a NoOp
			// the result will be the current state.
                        System.out.println("---------------------");
                        board.getStateAsString();
                        System.out.println(a.toString());
                        newBoard.getStateAsString();
                        if (newBoard!=null){
                            return newBoard;
                        }
                        else {return s;}
		}
	}
}
    
            
    

