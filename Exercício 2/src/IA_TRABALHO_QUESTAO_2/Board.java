package IA_TRABALHO_QUESTAO_2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/**
 * @author Mateus Junges
 * <contato@mateusjunges.com>
 */
public class Board extends JPanel{
    boolean init = false;
    int[][] plan;
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D) g;
        Color _BLACK_   = new Color(0f, 0f, 0f, 1.0f);
        Color _WHITE_  = new Color(0.95f, 0.95f, 0.95f, 1.0f);
        
        if (init){
            for(int i = 0; i < 11; i++){
                for (int j = 0; j < 8; j++){
                    switch (plan[i][j]){
                        case 1: g2.setPaint(_BLACK_);
                            break;
                        case 0: g2.setPaint(_WHITE_);
                            break;
                        case 2: g2.setPaint(Color.blue);
                            break;
                        case 3: g2.setPaint(Color.RED);
                            break;
                        case 4: g2.setPaint(Color.GREEN);
                            break;
                    }
                    Rectangle2D rect = new Rectangle2D.Double(j * 45, i * 45, 45, 45);
                    g2.fill(rect);
                }
            }
            for(int i = 0; i < 11; i++){
                for(int j = 0; j < 8; j++){
                    g2.setPaint(_BLACK_);
                    Line2D line2 = new Line2D.Double((j * 45) + 45, 0, (j * 45) + 45, 600);
                    g2.draw(line2);
                }
                g2.setPaint(_BLACK_);
                Line2D line1 = new Line2D.Double(0, (i * 45) + 45, 360, (i * 45) + 45);
                g2.draw(line1);
            }
        }
    }
    public void updatePlan(int x, int y) {
        plan[x][y] = 4;
        repaint();
    }
    public void setPlan(int[][] p) {
        init = true;
        plan = new int[11][8];
        for (int i = 0; i < 11; i++) {
            System.arraycopy(p[i], 0, plan[i], 0, 8);
        }
        repaint();
    }
}