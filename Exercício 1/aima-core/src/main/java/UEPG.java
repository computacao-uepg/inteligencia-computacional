
import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;
import aima.core.environment.MinimumPath.GridFunctions;
import aima.core.environment.MinimumPath.GridGoalState;
import aima.core.environment.MinimumPath.GridHeuristic;
import aima.core.environment.MinimumPath.GridState;
import aima.core.environment.blocks.BlocksFunctionFactory;
import aima.core.environment.blocks.BlocksGoalState;
import aima.core.environment.blocks.BlocksState;
import aima.core.environment.exercicio1.MSFunctionFactory;
import aima.core.environment.exercicio1.MSFunctionFactory.GridActionsFunction;
import aima.core.environment.exercicio1.MSFunctionFactory.GridResultFunction;
import aima.core.environment.exercicio1.MSGoalState;
import aima.core.environment.jugs.JugsFunctionFactory;
import aima.core.environment.jugs.JugsGoalTest;
import aima.core.environment.jugs.JugsState;
import aima.core.environment.exercicio1.MSState;
import static aima.core.environment.jugs.JugsFunctionFactory.getResultFunction;

import aima.core.logic.propositional.parsing.ast.Sentence;
import aima.core.search.framework.Problem;
import aima.core.search.framework.Search;
import aima.core.search.framework.SearchAgent;
import aima.core.search.uninformed.DepthLimitedSearch;
import java.util.List;

import aima.core.logic.propositional.inference.PLResolution;
import aima.core.logic.propositional.kb.KnowledgeBase;
import aima.core.logic.propositional.parsing.PLParser;
import aima.core.search.framework.GraphSearch;
import aima.core.search.informed.AStarSearch;
import aima.core.search.informed.BestFirstSearch;
import aima.core.search.uninformed.DepthFirstSearch;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pedro
 */
public class UEPG {

    List<Action> actions;

    public static void main(String[] args) throws Exception {
        UEPG vUEPG = new UEPG();

        try {

            vUEPG.Exercicio1();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Exercicio1() {
        System.out.println("problema");
        Problem problem = new Problem(new MSState(),
                MSFunctionFactory.getActionsFunction(),
                MSFunctionFactory.getResultFunction(),
                new MSGoalState());
        System.out.println("busca");
        Search search = new DepthLimitedSearch(20);

        SearchAgent agent;
        try {
            System.out.println("rodar");
            agent = new SearchAgent(problem, search);
            actions = agent.getActions();

        } catch (Exception ex) {
            Logger.getLogger(UEPG.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Exercicio2() {
        System.out.println("problema");
        Problem problem = new Problem(new GridState(),
                GridFunctions.getActionsFunction(),
                GridFunctions.getResultFunction(),
                new GridGoalState());
        System.out.println("busca");
        Search search = new AStarSearch(new GraphSearch(), new GridHeuristic());
        SearchAgent agent;
        try {
            System.out.println("rodar");
            agent = new SearchAgent(problem, search);
            actions = agent.getActions();
//		assertCorrectPlacement(actio
        } catch (Exception ex) {
            Logger.getLogger(UEPG.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
