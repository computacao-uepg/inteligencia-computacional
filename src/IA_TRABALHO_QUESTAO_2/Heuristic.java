package IA_TRABALHO_QUESTAO_2;

import aima.search.framework.HeuristicFunction;

/**
    * @author Mateus Junges
    <contato@mateusjunges.com>
 */
public class Heuristic implements HeuristicFunction{
    @Override
    public double getHeuristicValue(Object state){
        Position board = (Position)state;
        return (board.euclidean());
    }
}