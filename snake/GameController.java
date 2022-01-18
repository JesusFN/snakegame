package snake;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class GameController implements Initializable{
	
    private GameLoop loop;
    private GameField grid;
    private GraphicsContext context;
    
    @FXML
    private StackPane gamePane;
    @FXML
    private Canvas drawArea;
    @FXML
    private VBox pauseMenu;
    @FXML
    private Rectangle overlay;
    @FXML
    private Label startLabel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		context = drawArea.getGraphicsContext2D();
		drawArea.setFocusTraversable(true);
		drawArea.setOnKeyPressed(e -> {
			 
	            Snake snake = grid.getSnake();
	            if (loop.isKeyPressed()) {
	                return;
	            }
	            loop.setKeyPressed();
	            switch (e.getCode()) {
	                case UP: 
	                    snake.setUp();
	                    break;
	                case DOWN:
	                    snake.setDown();
	                    break;
	                case LEFT:
	                    snake.setLeft();
	                    break;
	                case RIGHT:
	                    snake.setRight();
	                    break;
	                case ESCAPE:
	                	pauseMenu.setVisible(true);
	                	overlay.setVisible(true);
	                	//loop.pause();
	                	break;
	                case ENTER:
	                    if (loop.isPaused()) {
	                        reset();
	                        (new Thread(loop)).start();
	                    }
	            }
	            startLabel.setVisible(false);
	        });
		 reset();
		 (new Thread(loop)).start();
		 
	}
	
	public void playAfterPause(ActionEvent e) {
			pauseMenu.setVisible(false);
			overlay.setVisible(false);
			if(loop.isPaused()) {
				loop.resume();
			}
	}
	
	public void restartGame(ActionEvent e) {
		closePauseMenu(); 
		loop.pause();
        reset();
            (new Thread(loop)).start();
        }
	
	public void openMenu(ActionEvent e) throws IOException {
		closePauseMenu();
		loop.pause();
        reset();
		AnchorPane root = FXMLLoader.load(getClass().getResource("Start.fxml"));
		gamePane.getChildren().setAll(root);
        }
	
	private void reset() {
        grid = new GameField(drawArea.getWidth(),drawArea.getHeight());
        loop = new GameLoop(grid, context);
        Painter.paint(grid, context);
    }
	
	private void closePauseMenu() {
		startLabel.setVisible(true);
		pauseMenu.setVisible(false);
		overlay.setVisible(false);
	}
	

}


