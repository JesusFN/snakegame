package snake;

import static snake.GameField.SIZE;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Painter {
	
	final static Color BASECOLOR =  Color.valueOf("141E25");
	final static Color FOODCOLOR =  Color.valueOf("f26419");
	final static Color SNAKECOLOR =  Color.valueOf("7eb827");
	final static Color DEADCOLOR =  Color.RED;
	final static Color SCORECOLOR =  Color.CYAN;

    public static void paint(GameField grid, GraphicsContext gc) {
        gc.setFill(BASECOLOR);
        gc.fillRect(0, 0, grid.getWidth(), grid.getHeight());
        Snake snake = grid.getSnake();
        food(gc);
        snake(snake, gc);
        score(snake, gc);
    }

    private static void paintPoint(Point point, GraphicsContext gc) {
        gc.fillRect(point.getX() * SIZE, point.getY() * SIZE, SIZE, SIZE);
    }

    public static void paintResetMessage(GraphicsContext gc) {
        gc.setFill(Color.AQUAMARINE);
        gc.fillText("Hit RETURN to reset.", 10, 10);
    }
    private static void food(GraphicsContext gc) {
    	gc.setFill(FOODCOLOR);
        paintPoint(GameField.getFood(), gc);
    }
    private static void snake(Snake snake, GraphicsContext gc) {
    	
        gc.setFill(SNAKECOLOR);
        snake.getPoints().forEach(point -> paintPoint(point, gc));
        if (!snake.isSafe()) {
            gc.setFill(DEADCOLOR);
            paintPoint(snake.getHead(), gc);
        }
    }
    private static void score(Snake snake, GraphicsContext gc) {
    	gc.setFill(SCORECOLOR);
        gc.fillText("Score : " + 100 * snake.getPoints().size(), 10, 490);
    }
}