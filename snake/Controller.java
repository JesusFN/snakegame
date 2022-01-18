package snake;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Controller {
	
	@FXML
	private AnchorPane StartAnchorPane;

	public void startGame(ActionEvent e) throws IOException {
		StackPane root = FXMLLoader.load(getClass().getResource("Game.fxml"));
		StartAnchorPane.getChildren().setAll(root);
		System.out.println("START GAME");
	
	}
}
