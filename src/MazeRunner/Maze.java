package MazeRunner;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Maze extends JFrame {

    private int [][] maze =
            { {1,1,1,1,1,1,1,1,1,1,1,1,1},
                    {1,0,1,0,1,0,1,0,0,0,0,0,1},
                    {1,0,1,0,0,0,1,0,1,1,1,0,1},
                    {1,0,0,0,1,1,1,0,0,0,0,0,1},
                    {1,0,1,0,0,0,0,0,1,1,1,0,1},
                    {1,0,1,0,1,1,1,0,1,0,0,0,1},
                    {1,0,1,0,1,0,0,0,1,1,1,0,1},
                    {1,0,1,0,1,1,1,0,1,0,1,0,1},
                    {1,0,0,0,0,0,0,0,0,0,1,9,1},
                    {1,1,1,1,1,1,1,1,1,1,1,1,1}

            };
    public List<Integer> path = new ArrayList<>();

    public Maze() {
        setTitle("Maze Solver");
        setSize(640, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DFS.searchPath(maze, 1, 1, path);
    }
    public void paint(Graphics g) {
        g.translate(50, 50);
        for (int i = 0; i < maze.length; i++) {
            for(int j = 0; j < maze[0].length; j++) {
                Color color;
                if(maze[i][j] == 1) color = Color.black;
                else if(maze[i][j] == 9) color = Color.red;
                else color = Color.white;
                g.setColor(color);
                g.fillRect(30 * j, 30 * i, 30, 30);
                g.setColor(Color.red);
                g.drawRect(30 * j, 30 * i, 30, 30);
            }
        }
        for(int i = 0; i < path.size(); i+= 2) {
            int px = path.get(i);
            int py = path.get(i + 1);
            g.setColor(Color.green);
            g.fillOval(30 * px, 30 * py, 20, 20);
        }
    }

    public static void main(String[] args) {
        Maze view = new Maze();
        view.setVisible(true);
    }
}
