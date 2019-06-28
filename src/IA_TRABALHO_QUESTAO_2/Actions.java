package IA_TRABALHO_QUESTAO_2;

import aima.core.agent.Action;
/**
 * @author Mateus Junges
 * <contato@mateusjunges.com>
 */
public class Actions implements Action{
    
    public static final String _LEFT_ = "LEFT";
    public static final String _UP_  = "UP";
    public static final String _DOWN_ = "DOWN";
    public static final String _RIGHT_  = "RIGHT";
            
    @Override
    public boolean isNoOp() {
        throw new UnsupportedOperationException("The selected action is currently not supported!");
    }
}