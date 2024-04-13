package org.chaoticsomeone.chaosjfx;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NodeCJFX {
	public static Scene getSceneOfNode(Node node) {
		return node.getScene();
	}

	public static Stage getStageOfNode(Node node) {
		return (Stage) node.getScene().getWindow();
	}
}
