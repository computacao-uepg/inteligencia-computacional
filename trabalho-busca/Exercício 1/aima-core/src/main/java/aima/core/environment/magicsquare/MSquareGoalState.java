package aima.core.environment.magicsquare;

import aima.core.search.framework.GoalTest;

public class MSquareGoalState implements GoalTest {

    int sumCol[] = new int[4], sumLin[] = new int[4], sumDia[] = new int[4];

    @Override
    public boolean isGoalState(Object state) {
        MSquareState currentState = (MSquareState) state;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(currentState.board[i][j]+"\t");
            }System.out.print("\n");
        }
        System.out.println("---------------");
        //aloca a soma de cada coluna nas posições de um vetor
        for (int col = 0; col < 4; col++) {
            sumCol[0] += currentState.board[col][0];
            sumCol[1] += currentState.board[col][1];
            sumCol[2] += currentState.board[col][2];
            sumCol[3] += currentState.board[col][3];
        }
        //testa se os valores da soma das colunas são iguais, senão já descarta o estado atual
        if (sumCol[0] != sumCol[1] || sumCol[0] != sumCol[2] || sumCol[0] != sumCol[3]) {
            System.out.println("Erro Colunas");
            return false;
        }
        System.out.println("Colunas OK");
        //aloca a soma de cada linha nas posições de um vetor
        for (int lin = 0; lin < 4; lin++) {
            sumLin[0] += currentState.board[0][lin];
            sumLin[1] += currentState.board[1][lin];
            sumLin[2] += currentState.board[2][lin];
            sumLin[3] += currentState.board[3][lin];
        }
        //testa se os valores da soma das linhas são iguais, senão descarta o estado atual
        if (sumLin[0] != sumLin[1] || sumLin[0] != sumLin[2] || sumLin[0] != sumLin[3]) {
            System.out.println("Erro Linhas");
            return false;
        }
        System.out.println("Linhas OK");
        //aloca a soma das diagonais nas posições de um vetor
        sumDia[0] = currentState.board[0][0]
                + currentState.board[1][1]
                + currentState.board[2][2]
                + currentState.board[3][3];
        sumDia[1] = currentState.board[0][3]
                + currentState.board[1][2]
                + currentState.board[2][1]
                + currentState.board[3][0];
        //testa se os valores da soma das diagonais são iguais, senão descarta o estado atual
        if (sumDia[0] != sumDia[1]) {
            System.out.println("Erro Diagonais");
            return false;
        }
        System.out.println("Diagonais OK");
        //se o programa chegou até aqui, então as somas das colunas, linhas e diagonais são, separadamente, iguais
        //então é necessário testar se a constante das somas das colunas, linhas e diagonais é igual
        //para isso comparamos os primeiros elemento de cada vetor, já que nesse ponto todos os elementos de cada vetor são iguais
        if (sumCol[0] != sumLin[0]) {
            return false;
        }
        System.out.println("Coluna com Linha OK");
        //se a constante k é igual nas colunas e linhas, como foi testado na condição acima
        //basta testar se k também é igual nas diagonais
        if (sumCol[0] == sumDia[0]) {
            //o modelo é um quadrado mágico!
            //mostra os valores do quadrado mágico
            System.out.println("Quadrado Mágico:");
            for (int i = 0; i < 4; i++) {
                System.out.println("");
                for (int j = 0; j < 4; j++) {

                    System.out.print(currentState.board[i][j] + " ");
                }
            }
            System.out.println("");
            return true;
        }
        //as constantes não são iguais
        System.out.println("Não achei solução!");
        return false;
    }

}
