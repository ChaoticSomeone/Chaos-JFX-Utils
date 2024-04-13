package org.chaoticsomeone.chaosjfx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StageCJFX {
	public static void initStage(Stage stage, FXMLLoader fxmlLoader, String title) throws IOException {
		Scene scene = new Scene(fxmlLoader.load());
		stage.setTitle(title);
		stage.setScene(scene);
	}

	public static void initStage(Stage stage, FXMLLoader fxmlLoader, String title, int width, int height) throws IOException {
		Scene scene = new Scene(fxmlLoader.load(), width, height);
		stage.setTitle(title);
		stage.setScene(scene);
	}

	public static void changeSceneOfStage(Stage stage, FXMLLoader fxmlLoader) throws IOException {
		stage.setScene(new Scene(fxmlLoader.load()));
		stage.show();
	}

	public static void changeSceneOfStage(Stage stage, FXMLLoader fxmlLoader, int width, int height) throws IOException {
		stage.setScene(new Scene(fxmlLoader.load(), width, height));
		stage.show();
	}

	public static Stage newStageWindow(FXMLLoader fxmlLoader, String title) throws IOException {
		Parent root = fxmlLoader.load();
		Stage stage = new Stage();
		stage.setTitle(title);
		stage.setScene(new Scene(root));
		return stage;
	}

	public static Stage newStageWindow(FXMLLoader fxmlLoader, String title, int width, int height) throws IOException {
		Parent root = fxmlLoader.load();
		Stage stage = new Stage();
		stage.setTitle(title);
		stage.setScene(new Scene(root, width, height));
		return stage;
	}
}
