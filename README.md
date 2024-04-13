# Chaos JFX Utils
A collection of utilities for JavaFX because I am lazy.

## Classes

### StageCJFX
This class contains static methods to help manage your stages.

Need a new window? No problem.

Need to change the scene of your change? Easy.

#### Methods

- `public static void initStage(Stage stage, FXMLLoader fxmlLoader, String title) throws IOException`

	Initializes a new stage from the given FXML and sets the window's title.


- `public static void initStage(Stage stage, FXMLLoader fxmlLoader, String title, int width, int height) throws IOException`

	Like the above, this method initializes a new stage, this variant sets the width and height of the windows, too.


- `public static void changeSceneOfStage(Stage stage, FXMLLoader fxmlLoader) throws IOException`

	Loads a new scene, from the given FXML, into the stage (calls `stage.show()`).


- `public static void changeSceneOfStage(Stage stage, FXMLLoader fxmlLoader, int width, int height) throws IOException`

	Like the above, but also sets the width and height of the window (calls `stage.show()`).


- `public static Stage newStageWindow(FXMLLoader fxmlLoader, String title) throws IOException`

	Creates a new stage, a new windows if you will, from the given FXML. Also sets the title.


- `public static Stage newStageWindow(FXMLLoader fxmlLoader, String title, int width, int height) throws IOException`

	Creates a new stage, like the above, but also sets the width and height of the window.


### NodeCJFX
This class contains static methods to help with getting certain properties from Nodes (GUI objects).

#### Methods

- `public static Scene getSceneOfNode(Node node)`

	Returns the scene in which the given node is placed in.


- `public static Stage getStageOfNode(Node node)`

	Returns the stage in which the given node is loaded.
