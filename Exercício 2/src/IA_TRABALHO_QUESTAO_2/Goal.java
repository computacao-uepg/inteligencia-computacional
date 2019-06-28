package IA_TRABALHO_QUESTAO_2;

import aima.search.framework.GoalTest;

/**
* @author Mateus Junges
  <contato@mateusjunges.com>
 */
public class Goal implements GoalTest{
    @Override
    public boolean isGoalState(Object aState){
        Position board = (Position)aState;
        return(board.isGoalState());
  }

}
