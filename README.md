# Chaos JFX Utils
A collection of utilities for JavaFX because I am lazy.

**Disclaimer:** Do NOT expect regular updates on this library, it's most likely that I will only make changes or additions
when I find some annoying tasks in JavaFX that I want to simplify into a single method.

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


### ProgressBarCJFX
This class's purpose is it to mainly handle and create smoothly moving progress bars


### ProgressBarCJFX.ProgressBarTask
Signature: `public interface ProgressBarTask`

You should NOT let your classes implement this interface. Instead, this is used for passing lambdas
to the various 'play' methods of the `ProgressBarCJFX.SmoothProgressBar` subclass.


### ProgressBarCJFX.SmoothProgressBar
Signature: `public static class SmoothProgressBar`

Handles smooth movement of progress bars.


#### Methods

- `public SmoothProgressBar(ProgressBar progressBar)`

	Creates a basic instance of `SmoothProgressBar` (step size is set to 1/1000 (0.001) and speed factor to 1)


- `public SmoothProgressBar(ProgressBar progressBar, double stepSize)`

	Allows you to create an instance of the class, but also allows you to set a custom step size (speed factor defaults to 1)


- `public SmoothProgressBar(ProgressBar progressBar, double stepSize, double speedFactor)`

	Variation of the constructor with full control over both the step size and speed factor


- `public void playUntil(double targetProgress, ProgressBarTask onFinished)`

	Advances the progress bar by `stepSize * speedFactor`, until the `targetProcess` threshold is reached.
	Among completion, `onFinished` is executed, this is expected to be a lambda expression, method reference or similar with 0 parameters.

	**Avoid consecutive calls!**

	**Do NOT pass `null` to `onFinished`, the NullPointerException will NOT be handled!**


- `public void play(ProgressBarTask onFinished)`

	Exactly like `playUntil`, but the `targetProgress` will always be 1 (100%).

  **Avoid consecutive calls!**

  **Do NOT pass `null` to `onFinished`, the NullPointerException will NOT be handled!**


- `public void playChain(double targetProgress, ProgressBarTask onFinished, ProgressBarTask next)`

	Similar to `playUntil`, but this method is meant for chained / nested calls.
	When the target progress is reached, `onFinished` is executed, followed by a call to `next`,
	`next` should contain another call to `playChain`.

  **Do NOT pass `null` to `onFinished` or `next`, the NullPointerException will NOT be handled!**


- `public void setDelays(double minDelay, double maxDelay)`

	Sets the min and max delay (in seconds) between frames, in which the progress bar may advance.
  	The various 'play' methods will choose a random delay between those 2 thresholds.


- `public void setDelay(double delay)`

	Sets the min and max delay (in seconds) to a constant time.


- `public get/set stepSize`

	(Note: No, I will not cover the getter and setter separately)

	Gets / Sets the `stepSize` attribute, with reasonable restrictions:

		- Getter: No restrictions
		- Setter: new stepSize must be > 0 and <= 1


- `public get/set speedFactor`

	(Note: No, I will not cover the getter and setter separately)

	Gets / Sets the `speedFactor` attribute, with reasonable restrictions:

		- Getter: No restrictions
		- Setter: new speedFactor must be > 0



### UtilsCJFX
Contains stuff which I didn't fit in anywhere else

#### Methods

- `public static void doNothing()`

	Do I really need to tell you about this one?
	In case you can't tell from the name, this function does nothing, like nothing at all.

	Use this instead of `null` when working with `ProgressBarCJFX.ProgressBarTask` parameters
