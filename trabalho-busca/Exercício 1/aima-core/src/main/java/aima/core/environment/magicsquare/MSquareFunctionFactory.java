/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aima.core.environment.magicsquare;

import aima.core.environment.magicsquare.*;
import aima.core.agent.Action;
import aima.core.search.framework.ActionsFunction;
import aima.core.search.framework.ResultFunction;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class MSquareFunctionFactory {

    private static ActionsFunction _actionsFunction = null;
    private static ResultFunction _resultFunction = null;

    public static ActionsFunction getActionsFunction() {
        if (null == _actionsFunction) {
            _actionsFunction = new MSquareActionsFunction();
        }
        return _actionsFunction;
    }

    public static ResultFunction getResultFunction() {
        if (null == _resultFunction) {
            _resultFunction = new MSquareResultFunction();
        }
        return _resultFunction;
    }

    private static class MSquareActionsFunction implements ActionsFunction {

        public Set<Action> actions(Object state) {
            MSquareState board = (MSquareState) state;
            Set<Action> actions = new LinkedHashSet<Action>();

            Random gerador = new Random();
            String n1 = Integer.toString(gerador.nextInt(4));
            String n2 = Integer.toString(gerador.nextInt(4));
            String aleatorio = n1 + n2;

            switch (aleatorio) {
                case "00":
                    actions.add(board.CHANGE_00_01);
                    actions.add(board.CHANGE_00_02);
                    actions.add(board.CHANGE_00_03);
                    actions.add(board.CHANGE_00_10);
                    actions.add(board.CHANGE_00_20);
                    actions.add(board.CHANGE_00_30);
                    break;

                case "01":
                    actions.add(board.CHANGE_01_00);
                    actions.add(board.CHANGE_01_02);
                    actions.add(board.CHANGE_01_03);
                    actions.add(board.CHANGE_01_11);
                    actions.add(board.CHANGE_01_21);
                    actions.add(board.CHANGE_01_31);
                    break;

                case "02":
                    actions.add(board.CHANGE_02_00);
                    actions.add(board.CHANGE_02_01);
                    actions.add(board.CHANGE_02_03);
                    actions.add(board.CHANGE_02_12);
                    actions.add(board.CHANGE_02_22);
                    actions.add(board.CHANGE_02_32);
                    break;
                case "03":
                    actions.add(board.CHANGE_03_00);
                    actions.add(board.CHANGE_03_01);
                    actions.add(board.CHANGE_03_02);
                    actions.add(board.CHANGE_03_13);
                    actions.add(board.CHANGE_03_23);
                    actions.add(board.CHANGE_03_33);
                    break;

                case "10":
                    actions.add(board.CHANGE_10_11);
                    actions.add(board.CHANGE_10_12);
                    actions.add(board.CHANGE_10_13);
                    actions.add(board.CHANGE_10_00);
                    actions.add(board.CHANGE_10_20);
                    actions.add(board.CHANGE_10_30);
                    break;

                case "11":
                    actions.add(board.CHANGE_11_10);
                    actions.add(board.CHANGE_11_12);
                    actions.add(board.CHANGE_11_13);
                    actions.add(board.CHANGE_11_01);
                    actions.add(board.CHANGE_11_21);
                    actions.add(board.CHANGE_11_31);
                    break;

                case "12":
                    actions.add(board.CHANGE_12_10);
                    actions.add(board.CHANGE_12_11);
                    actions.add(board.CHANGE_12_13);
                    actions.add(board.CHANGE_12_02);
                    actions.add(board.CHANGE_12_22);
                    actions.add(board.CHANGE_12_32);
                    break;

                case "13":
                    actions.add(board.CHANGE_13_10);
                    actions.add(board.CHANGE_13_11);
                    actions.add(board.CHANGE_13_12);
                    actions.add(board.CHANGE_13_03);
                    actions.add(board.CHANGE_13_23);
                    actions.add(board.CHANGE_13_33);
                    break;

                case "20":
                    actions.add(board.CHANGE_20_21);
                    actions.add(board.CHANGE_20_22);
                    actions.add(board.CHANGE_20_23);
                    actions.add(board.CHANGE_20_00);
                    actions.add(board.CHANGE_20_10);
                    actions.add(board.CHANGE_20_30);
                    break;

                case "21":
                    actions.add(board.CHANGE_21_20);
                    actions.add(board.CHANGE_21_22);
                    actions.add(board.CHANGE_21_23);
                    actions.add(board.CHANGE_21_01);
                    actions.add(board.CHANGE_21_11);
                    actions.add(board.CHANGE_21_31);
                    break;

                case "22":
                    actions.add(board.CHANGE_22_20);
                    actions.add(board.CHANGE_22_21);
                    actions.add(board.CHANGE_22_23);
                    actions.add(board.CHANGE_22_02);
                    actions.add(board.CHANGE_22_12);
                    actions.add(board.CHANGE_22_32);
                    break;

                case "23":
                    actions.add(board.CHANGE_23_20);
                    actions.add(board.CHANGE_23_21);
                    actions.add(board.CHANGE_23_22);
                    actions.add(board.CHANGE_23_03);
                    actions.add(board.CHANGE_23_13);
                    actions.add(board.CHANGE_23_33);
                    break;

                case "30":
                    actions.add(board.CHANGE_30_31);
                    actions.add(board.CHANGE_30_32);
                    actions.add(board.CHANGE_30_33);
                    actions.add(board.CHANGE_30_00);
                    actions.add(board.CHANGE_30_10);
                    actions.add(board.CHANGE_30_20);
                    break;

                case "31":
                    actions.add(board.CHANGE_31_30);
                    actions.add(board.CHANGE_31_32);
                    actions.add(board.CHANGE_31_33);
                    actions.add(board.CHANGE_31_01);
                    actions.add(board.CHANGE_31_11);
                    actions.add(board.CHANGE_31_21);
                    break;

                case "32":
                    actions.add(board.CHANGE_32_30);
                    actions.add(board.CHANGE_32_31);
                    actions.add(board.CHANGE_32_33);
                    actions.add(board.CHANGE_32_02);
                    actions.add(board.CHANGE_32_12);
                    actions.add(board.CHANGE_32_22);
                    break;

                case "33":
                    actions.add(board.CHANGE_33_30);
                    actions.add(board.CHANGE_33_31);
                    actions.add(board.CHANGE_33_32);
                    actions.add(board.CHANGE_33_03);
                    actions.add(board.CHANGE_33_13);
                    actions.add(board.CHANGE_33_23);
                    break;

                default:
                    actions.add(board.CHANGE_00_01);
                    break;
            }

            return actions;
        }
    }

    private static class MSquareResultFunction implements ResultFunction {

        public Object result(Object s, Action a) {
            MSquareState board = (MSquareState) s;
            MSquareState newBoard = new MSquareState();

            if (board.CHANGE_00_01
                    .equals(a)) {
                newBoard.board[0][1] = board.board[0][0];
                newBoard.board[0][0] = board.board[0][1];
            } else if (board.CHANGE_00_02
                    .equals(a)) {
                newBoard.board[0][2] = board.board[0][0];
                newBoard.board[0][0] = board.board[0][2];
            } else if (board.CHANGE_00_03
                    .equals(a)) {
                newBoard.board[0][3] = board.board[0][0];
                newBoard.board[0][0] = board.board[0][3];
            } else if (board.CHANGE_00_10
                    .equals(a)) {
                newBoard.board[1][0] = board.board[0][0];
                newBoard.board[0][0] = board.board[1][0];
            } else if (board.CHANGE_00_20
                    .equals(a)) {
                newBoard.board[2][0] = board.board[0][0];
                newBoard.board[0][0] = board.board[2][0];
            } else if (board.CHANGE_00_30
                    .equals(a)) {
                newBoard.board[3][0] = board.board[0][0];
                newBoard.board[0][0] = board.board[3][0];
            } else if (board.CHANGE_01_00
                    .equals(a)) {
                newBoard.board[0][0] = board.board[0][1];
                newBoard.board[0][1] = board.board[0][0];
            } else if (board.CHANGE_01_02
                    .equals(a)) {
                newBoard.board[0][2] = board.board[0][1];
                newBoard.board[0][1] = board.board[0][2];
            } else if (board.CHANGE_01_03
                    .equals(a)) {
                newBoard.board[0][3] = board.board[0][1];
                newBoard.board[0][1] = board.board[0][3];
            } else if (board.CHANGE_01_11
                    .equals(a)) {
                newBoard.board[1][1] = board.board[0][1];
                newBoard.board[0][1] = board.board[1][1];
            } else if (board.CHANGE_01_21
                    .equals(a)) {
                newBoard.board[2][1] = board.board[0][1];
                newBoard.board[0][1] = board.board[2][1];
            } else if (board.CHANGE_01_31
                    .equals(a)) {
                newBoard.board[3][1] = board.board[0][1];
                newBoard.board[0][1] = board.board[3][1];
            } else if (board.CHANGE_02_00
                    .equals(a)) {
                newBoard.board[0][0] = board.board[0][2];
                newBoard.board[0][2] = board.board[0][0];
            } else if (board.CHANGE_02_01
                    .equals(a)) {
                newBoard.board[0][1] = board.board[0][2];
                newBoard.board[0][2] = board.board[0][1];
            } else if (board.CHANGE_02_03
                    .equals(a)) {
                newBoard.board[0][3] = board.board[0][2];
                newBoard.board[0][2] = board.board[0][3];
            } else if (board.CHANGE_02_12
                    .equals(a)) {
                newBoard.board[1][2] = board.board[0][2];
                newBoard.board[0][2] = board.board[1][2];
            } else if (board.CHANGE_02_22
                    .equals(a)) {
                newBoard.board[2][2] = board.board[0][2];
                newBoard.board[0][2] = board.board[2][2];
            } else if (board.CHANGE_02_32
                    .equals(a)) {
                newBoard.board[3][2] = board.board[0][2];
                newBoard.board[0][2] = board.board[3][2];
            } else if (board.CHANGE_03_00
                    .equals(a)) {
                newBoard.board[0][0] = board.board[0][3];
                newBoard.board[0][3] = board.board[0][0];
            } else if (board.CHANGE_03_01
                    .equals(a)) {
                newBoard.board[0][1] = board.board[0][3];
                newBoard.board[0][3] = board.board[0][1];
            } else if (board.CHANGE_03_02
                    .equals(a)) {
                newBoard.board[0][2] = board.board[0][3];
                newBoard.board[0][3] = board.board[0][2];
            } else if (board.CHANGE_03_13
                    .equals(a)) {
                newBoard.board[1][3] = board.board[0][3];
                newBoard.board[0][3] = board.board[1][3];
            } else if (board.CHANGE_03_23
                    .equals(a)) {
                newBoard.board[2][3] = board.board[0][3];
                newBoard.board[0][3] = board.board[2][3];
            } else if (board.CHANGE_03_33
                    .equals(a)) {
                newBoard.board[3][3] = board.board[0][3];
                newBoard.board[0][3] = board.board[3][3];
            } else if (board.CHANGE_10_11
                    .equals(a)) {
                newBoard.board[1][1] = board.board[1][0];
                newBoard.board[1][0] = board.board[1][1];
            } else if (board.CHANGE_10_12
                    .equals(a)) {
                newBoard.board[1][2] = board.board[1][0];
                newBoard.board[1][0] = board.board[1][2];
            } else if (board.CHANGE_10_13
                    .equals(a)) {
                newBoard.board[1][3] = board.board[1][0];
                newBoard.board[1][0] = board.board[1][3];
            } else if (board.CHANGE_10_00
                    .equals(a)) {
                newBoard.board[0][0] = board.board[1][0];
                newBoard.board[1][0] = board.board[0][0];
            } else if (board.CHANGE_10_20
                    .equals(a)) {
                newBoard.board[2][0] = board.board[1][0];
                newBoard.board[1][0] = board.board[2][0];
            } else if (board.CHANGE_10_30
                    .equals(a)) {
                newBoard.board[3][0] = board.board[1][0];
                newBoard.board[1][0] = board.board[3][0];
            } else if (board.CHANGE_11_10
                    .equals(a)) {
                newBoard.board[1][0] = board.board[1][1];
                newBoard.board[1][1] = board.board[1][0];
            } else if (board.CHANGE_11_12
                    .equals(a)) {
                newBoard.board[1][2] = board.board[1][1];
                newBoard.board[1][1] = board.board[1][2];
            } else if (board.CHANGE_11_13
                    .equals(a)) {
                newBoard.board[1][3] = board.board[1][1];
                newBoard.board[1][1] = board.board[1][3];
            } else if (board.CHANGE_11_01
                    .equals(a)) {
                newBoard.board[0][1] = board.board[1][1];
                newBoard.board[1][1] = board.board[0][1];
            } else if (board.CHANGE_11_21
                    .equals(a)) {
                newBoard.board[2][1] = board.board[1][1];
                newBoard.board[1][1] = board.board[2][1];
            } else if (board.CHANGE_11_31
                    .equals(a)) {
                newBoard.board[3][1] = board.board[1][1];
                newBoard.board[1][1] = board.board[3][1];
            } else if (board.CHANGE_12_10
                    .equals(a)) {
                newBoard.board[1][0] = board.board[1][2];
                newBoard.board[1][2] = board.board[1][0];
            } else if (board.CHANGE_12_11
                    .equals(a)) {
                newBoard.board[1][1] = board.board[1][2];
                newBoard.board[1][2] = board.board[1][1];
            } else if (board.CHANGE_12_13
                    .equals(a)) {
                newBoard.board[1][3] = board.board[1][2];
                newBoard.board[1][2] = board.board[1][3];
            } else if (board.CHANGE_12_02
                    .equals(a)) {
                newBoard.board[0][2] = board.board[1][2];
                newBoard.board[1][2] = board.board[0][2];
            } else if (board.CHANGE_12_22
                    .equals(a)) {
                newBoard.board[2][2] = board.board[1][2];
                newBoard.board[1][2] = board.board[2][2];
            } else if (board.CHANGE_12_32
                    .equals(a)) {
                newBoard.board[3][2] = board.board[1][2];
                newBoard.board[1][2] = board.board[3][2];
            } else if (board.CHANGE_13_10
                    .equals(a)) {
                newBoard.board[1][0] = board.board[1][3];
                newBoard.board[1][3] = board.board[1][0];
            } else if (board.CHANGE_13_11
                    .equals(a)) {
                newBoard.board[1][1] = board.board[1][3];
                newBoard.board[1][3] = board.board[1][1];
            } else if (board.CHANGE_13_12
                    .equals(a)) {
                newBoard.board[1][2] = board.board[1][3];
                newBoard.board[1][3] = board.board[1][2];
            } else if (board.CHANGE_13_03
                    .equals(a)) {
                newBoard.board[0][3] = board.board[1][3];
                newBoard.board[1][3] = board.board[0][3];
            } else if (board.CHANGE_13_23
                    .equals(a)) {
                newBoard.board[2][3] = board.board[1][3];
                newBoard.board[1][3] = board.board[2][3];
            } else if (board.CHANGE_13_33
                    .equals(a)) {
                newBoard.board[3][3] = board.board[1][3];
                newBoard.board[1][3] = board.board[3][3];
            } else if (board.CHANGE_20_21
                    .equals(a)) {
                newBoard.board[2][1] = board.board[2][0];
                newBoard.board[2][0] = board.board[2][1];
            } else if (board.CHANGE_20_22
                    .equals(a)) {
                newBoard.board[2][2] = board.board[2][0];
                newBoard.board[2][0] = board.board[2][2];
            } else if (board.CHANGE_20_23
                    .equals(a)) {
                newBoard.board[2][3] = board.board[2][0];
                newBoard.board[2][0] = board.board[2][3];
            } else if (board.CHANGE_20_00
                    .equals(a)) {
                newBoard.board[0][0] = board.board[2][0];
                newBoard.board[2][0] = board.board[0][0];
            } else if (board.CHANGE_20_10
                    .equals(a)) {
                newBoard.board[1][0] = board.board[2][0];
                newBoard.board[2][0] = board.board[1][0];
            } else if (board.CHANGE_20_30
                    .equals(a)) {
                newBoard.board[3][0] = board.board[2][0];
                newBoard.board[2][0] = board.board[3][0];
            } else if (board.CHANGE_21_20
                    .equals(a)) {
                newBoard.board[2][0] = board.board[2][1];
                newBoard.board[2][1] = board.board[2][0];
            } else if (board.CHANGE_21_22
                    .equals(a)) {
                newBoard.board[2][2] = board.board[2][1];
                newBoard.board[2][1] = board.board[2][2];
            } else if (board.CHANGE_21_23
                    .equals(a)) {
                newBoard.board[2][3] = board.board[2][1];
                newBoard.board[2][1] = board.board[2][3];
            } else if (board.CHANGE_21_01
                    .equals(a)) {
                newBoard.board[0][1] = board.board[2][1];
                newBoard.board[2][1] = board.board[0][1];
            } else if (board.CHANGE_21_11
                    .equals(a)) {
                newBoard.board[1][1] = board.board[2][1];
                newBoard.board[2][1] = board.board[1][1];
            } else if (board.CHANGE_21_31
                    .equals(a)) {
                newBoard.board[3][1] = board.board[2][1];
                newBoard.board[2][1] = board.board[3][1];
            } else if (board.CHANGE_22_20
                    .equals(a)) {
                newBoard.board[2][0] = board.board[2][2];
                newBoard.board[2][2] = board.board[2][0];
            } else if (board.CHANGE_22_21
                    .equals(a)) {
                newBoard.board[2][1] = board.board[2][2];
                newBoard.board[2][2] = board.board[2][1];
            } else if (board.CHANGE_22_23
                    .equals(a)) {
                newBoard.board[2][3] = board.board[2][2];
                newBoard.board[2][2] = board.board[2][3];
            } else if (board.CHANGE_22_02
                    .equals(a)) {
                newBoard.board[0][2] = board.board[2][2];
                newBoard.board[2][2] = board.board[0][2];
            } else if (board.CHANGE_22_12
                    .equals(a)) {
                newBoard.board[1][2] = board.board[2][2];
                newBoard.board[2][2] = board.board[1][2];
            } else if (board.CHANGE_22_32
                    .equals(a)) {
                newBoard.board[3][2] = board.board[2][2];
                newBoard.board[2][2] = board.board[3][2];
            } else if (board.CHANGE_23_20
                    .equals(a)) {
                newBoard.board[2][0] = board.board[2][3];
                newBoard.board[2][3] = board.board[2][0];
            } else if (board.CHANGE_23_21
                    .equals(a)) {
                newBoard.board[2][1] = board.board[2][3];
                newBoard.board[2][3] = board.board[2][1];
            } else if (board.CHANGE_23_22
                    .equals(a)) {
                newBoard.board[2][2] = board.board[2][3];
                newBoard.board[2][3] = board.board[2][2];
            } else if (board.CHANGE_23_03
                    .equals(a)) {
                newBoard.board[0][3] = board.board[2][3];
                newBoard.board[2][3] = board.board[0][3];
            } else if (board.CHANGE_23_13
                    .equals(a)) {
                newBoard.board[1][3] = board.board[2][3];
                newBoard.board[2][3] = board.board[1][3];
            } else if (board.CHANGE_23_33
                    .equals(a)) {
                newBoard.board[3][3] = board.board[2][3];
                newBoard.board[2][3] = board.board[3][3];
            } else if (board.CHANGE_30_31
                    .equals(a)) {
                newBoard.board[3][1] = board.board[3][0];
                newBoard.board[3][0] = board.board[3][1];
            } else if (board.CHANGE_30_32
                    .equals(a)) {
                newBoard.board[3][2] = board.board[3][0];
                newBoard.board[3][0] = board.board[3][2];
            } else if (board.CHANGE_30_33
                    .equals(a)) {
                newBoard.board[3][3] = board.board[3][0];
                newBoard.board[3][0] = board.board[3][3];
            } else if (board.CHANGE_30_00
                    .equals(a)) {
                newBoard.board[0][0] = board.board[3][0];
                newBoard.board[3][0] = board.board[0][0];
            } else if (board.CHANGE_30_10
                    .equals(a)) {
                newBoard.board[1][0] = board.board[3][0];
                newBoard.board[3][0] = board.board[1][0];
            } else if (board.CHANGE_30_20
                    .equals(a)) {
                newBoard.board[2][0] = board.board[3][0];
                newBoard.board[3][0] = board.board[2][0];
            } else if (board.CHANGE_31_30
                    .equals(a)) {
                newBoard.board[3][0] = board.board[3][1];
                newBoard.board[3][1] = board.board[3][0];
            } else if (board.CHANGE_31_32
                    .equals(a)) {
                newBoard.board[3][2] = board.board[3][1];
                newBoard.board[3][1] = board.board[3][2];
            } else if (board.CHANGE_31_33
                    .equals(a)) {
                newBoard.board[3][3] = board.board[3][1];
                newBoard.board[3][1] = board.board[3][3];
            } else if (board.CHANGE_31_01
                    .equals(a)) {
                newBoard.board[0][1] = board.board[3][1];
                newBoard.board[3][1] = board.board[0][1];
            } else if (board.CHANGE_31_11
                    .equals(a)) {
                newBoard.board[1][1] = board.board[3][1];
                newBoard.board[3][1] = board.board[1][1];
            } else if (board.CHANGE_31_21
                    .equals(a)) {
                newBoard.board[2][1] = board.board[3][1];
                newBoard.board[3][1] = board.board[2][1];
            } else if (board.CHANGE_32_30
                    .equals(a)) {
                newBoard.board[3][0] = board.board[3][2];
                newBoard.board[3][2] = board.board[3][0];
            } else if (board.CHANGE_32_31
                    .equals(a)) {
                newBoard.board[3][1] = board.board[3][2];
                newBoard.board[3][2] = board.board[3][1];
            } else if (board.CHANGE_32_33
                    .equals(a)) {
                newBoard.board[3][3] = board.board[3][2];
                newBoard.board[3][2] = board.board[3][3];
            } else if (board.CHANGE_32_02
                    .equals(a)) {
                newBoard.board[0][2] = board.board[3][2];
                newBoard.board[3][2] = board.board[0][2];
            } else if (board.CHANGE_32_12
                    .equals(a)) {
                newBoard.board[1][2] = board.board[3][2];
                newBoard.board[3][2] = board.board[1][2];
            } else if (board.CHANGE_32_22
                    .equals(a)) {
                newBoard.board[2][2] = board.board[3][2];
                newBoard.board[3][2] = board.board[2][2];
            } else if (board.CHANGE_33_30
                    .equals(a)) {
                newBoard.board[3][0] = board.board[3][3];
                newBoard.board[3][3] = board.board[3][0];
            } else if (board.CHANGE_33_31
                    .equals(a)) {
                newBoard.board[3][1] = board.board[3][3];
                newBoard.board[3][3] = board.board[3][1];
            } else if (board.CHANGE_33_32
                    .equals(a)) {
                newBoard.board[3][2] = board.board[3][3];
                newBoard.board[3][3] = board.board[3][2];
            } else if (board.CHANGE_33_03
                    .equals(a)) {
                newBoard.board[0][3] = board.board[3][3];
                newBoard.board[3][3] = board.board[0][3];
            } else if (board.CHANGE_33_13
                    .equals(a)) {
                newBoard.board[1][3] = board.board[3][3];
                newBoard.board[3][3] = board.board[1][3];
            } else if (board.CHANGE_33_23.equals(a)) {
                newBoard.board[2][3] = board.board[3][3];
                newBoard.board[3][3] = board.board[2][3];
            } else {
                newBoard = null;
            }
            // The Action is not understood or is a NoOp
            // the result will be the current state.
            if (newBoard != null) {
                return newBoard;
            } else {
                return s;
            }
        }
    }
}
