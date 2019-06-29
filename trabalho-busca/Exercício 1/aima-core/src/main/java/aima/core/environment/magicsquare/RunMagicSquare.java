package aima.core.environment.magicsquare;

import aima.core.agent.Action;
import aima.core.search.framework.GraphSearch;
import aima.core.search.framework.Problem;
import aima.core.search.framework.Search;
import aima.core.search.framework.SearchAgent;
import aima.core.search.uninformed.DepthFirstSearch;
import aima.core.search.uninformed.DepthLimitedSearch;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author caio
 */
public class RunMagicSquare {

    public static void main(String[] args) {
        //System.out.println("Vai se fuder Bruno");
		RunMagicSquare test = new RunMagicSquare();
        try {
            test.MSquareDepthSearch();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void MSquareDepthSearch() throws Exception {
        Problem problem = new Problem(new MSquareState(),
                MSquareFunctionFactory.getActionsFunction(),
                MSquareFunctionFactory.getResultFunction(),
                new MSquareGoalState());
        Search search = new DepthLimitedSearch(10);

        //Search search = new DepthFirstSearch(new GraphSearch());
        SearchAgent agent = new SearchAgent(problem, search);
        List<Action> actions = agent.getActions();
        System.out.println(actions);
    }

}
