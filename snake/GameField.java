package snake;

import java.util.Random;

public class GameField {
	
	public static final int SIZE = 10;
	private final int width;
	private final int height;
	private Snake snake;
    private static Point food;
	
	public GameField(final double width,final double height) {
		this.width = (int) width / SIZE;
		this.height = (int) height / SIZE;
        snake = new Snake(this, new Point(this.width/2,this.height/2));
        food = getRandomPoint();
	}
	
	public Point wrap(Point point) {
		int x = point.getX();
        int y = point.getY();
        if (x >= width) x = 0;
        if (y >= height) y = 0;
        if (x < 0) x = width - 1;
        if (y < 0) y = height - 1;
        return new Point(x, y);
	}
	
	private Point getRandomPoint() {
        Random random = new Random();
        Point point;
        do {
            point = new Point(random.nextInt(width), random.nextInt(height));
        } while (point.equals(snake.getHead()));
        return point;
    }
	
    public void update() {
        if (food.equals(snake.getHead())) {
            snake.extend();
            food = getRandomPoint();
        } else {
            snake.move();
        }
    }
	public int getWidth() {
		return width * SIZE;
	}
	public int getHeight() {
		return height * SIZE;
	}
	public Snake getSnake() {
		return snake;
	}

	public static Point getFood() {
		return food;
	}
}