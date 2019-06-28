/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aima.core.environment.MinimumPath;

import aima.core.agent.Action;
import aima.core.search.framework.ActionsFunction;
import aima.core.search.framework.ResultFunction;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author pedro
 */
public class GridFunctions {
    
    private static ActionsFunction _actionsFunction = null;
    private static ResultFunction _resultFunction = null;
    
    
    	public static ActionsFunction getActionsFunction() {
		if (null == _actionsFunction) {
			_actionsFunction = new GridActions();
		}
		return _actionsFunction;
	}

	public static ResultFunction getResultFunction() {
		if (null == _resultFunction) {
			_resultFunction = new GridResultActions();
		}
		return _resultFunction;
	}
    
    private static class GridActions implements ActionsFunction{

        @Override
        public Set<Action> actions(Object s) {
            
            GridState gs = (GridState) s;
            
            Set<Action> actions = new LinkedHashSet<Action>();
                
            
            if(gs.canMoveDown(GridState.DOWN))
                actions.add(GridState.DOWN);
            
            if(gs.canMoveUp(GridState.UP))
                actions.add(GridState.UP);
            
            if(gs.canMoveLeft(GridState.LEFT))
                actions.add(GridState.LEFT);
            
            if(gs.canMoveRight(GridState.RIGHT))
                actions.add(GridState.RIGHT);
           
                
         
            
            return actions;
        }
    }
    
    
    private static class GridResultActions implements ResultFunction{
            
        
        @Override
        public Object result(Object s, Action a) {
            GridState gs = (GridState) s;
            GridState newGrid = new GridState(gs);
                
            
            if(a.equals(GridState.UP) && gs.canMoveUp(GridState.UP)){
                newGrid.MoveUp();
                
            }
        
                    
            if(a.equals(GridState.DOWN) && gs.canMoveDown(GridState.DOWN)){
                
                newGrid.MoveDown();
            }
            
                
            if(a.equals(GridState.LEFT) && gs.canMoveLeft(GridState.LEFT)){
                
                newGrid.MoveLeft();
            }
            
                
            if(a.equals(GridState.RIGHT) && gs.canMoveRight(GridState.RIGHT)){
                
                newGrid.MoveRight();
            }
     
            return newGrid;
    }
}
    
    
}