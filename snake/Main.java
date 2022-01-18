package snake;

import javafx.application.Application;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;


public class Main extends Application {
	
		private static final int WIDTH = 600;
	    private static final int HEIGHT = 200;
	    
	    private GameLoop loop;
	    private GameField grid;
	    private GraphicsContext context;
	    
	    @Override
		public void start(Stage primaryStage) throws Exception {
	    	
	    	Stage s = new Stage();
	    	Parent root2 = FXMLLoader.load(getClass().getResource("Start.fxml"));
	        Scene scene2 = new Scene(root2);
	        scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	        s.setResizable(false);
	        s.setTitle("Snake");
	        s.setOnCloseRequest(e -> System.exit(0));
	        s.setScene(scene2);
	        s.show();
	    	
	    	
//	        StackPane root = new StackPane();
//	        Canvas canvas = new Canvas(WIDTH, HEIGHT);
//	        context = canvas.getGraphicsContext2D();

//	        canvas.setFocusTraversable(true);
//	        canvas.setOnKeyPressed(e -> {
//	            Snake snake = grid.getSnake();
//	            if (loop.isKeyPressed()) {
//	                return;
//	            }
//	            loop.setKeyPressed();
//	            switch (e.getCode()) {
//	                case UP:
//	                    snake.setUp();
//	                    break;
//	                case DOWN:
//	                    snake.setDown();
//	                    break;
//	                case LEFT:
//	                    snake.setLeft();
//	                    break;
//	                case RIGHT:
//	                    snake.setRight();
//	                    break;
//	                case ENTER:
//	                    if (loop.isPaused()) {
//	                        reset();
//	                        (new Thread(loop)).start();
//	                    }
//	            }
//	        });

//	        reset();

//	        root.getChildren().add(canvas);

//	        Scene scene = new Scene(root);
//
//	        primaryStage.setResizable(false);
//	        primaryStage.setTitle("Snake");
//	        primaryStage.setOnCloseRequest(e -> System.exit(0));
//	        primaryStage.setScene(scene);
//	        primaryStage.show();
//
//	        (new Thread(loop)).start();
	    }
		
//		private void reset() {
//	        grid = new GameField(WIDTH, HEIGHT);
//	        loop = new GameLoop(grid, context);
//	        Painter.paint(grid, context);
//	    }
		
		public static void main(String[] args) {
			launch(args);
		}
	    
	    

//    @Override
//    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));
//        Scene scene = new Scene(root);
//        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
}
