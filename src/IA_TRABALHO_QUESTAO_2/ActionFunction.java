package IA_TRABALHO_QUESTAO_2;

import java.util.ArrayList;
import java.util.List;
import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

/**
 * @author Mateus Junges
 * <contato@mateusjunges.com>
 */
public class ActionFunction implements SuccessorFunction{
    @Override
    public List getSuccessors(Object aState){
        ArrayList retVal = new ArrayList();
        Position board   = (Position) aState;
        if (board.canGoLeft()){
            Position newBoard = new Position(board.getX(),board.getY(),board.getPlan());
            newBoard._left();
            retVal.add(new Successor(Actions._LEFT_,newBoard));
        }
        if(board.canGoUp()){
            Position newBoard = new Position(board.getX(),board.getY(),board.getPlan());
            newBoard._up();
            retVal.add(new Successor(Actions._UP_,newBoard));
        }
        if(board.canGoDown()){
            Position newBoard = new Position(board.getX(),board.getY(),board.getPlan());
            newBoard._down();
            retVal.add(new Successor(Actions._DOWN_,newBoard));
        }
        if(board.canGoRight()){
            Position newBoard = new Position(board.getX(),board.getY(),board.getPlan());
            newBoard.direita();
            retVal.add(new Successor(Actions._RIGHT_,newBoard));
        }
        return retVal;
    }
}