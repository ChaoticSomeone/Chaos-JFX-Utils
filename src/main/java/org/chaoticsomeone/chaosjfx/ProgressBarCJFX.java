package org.chaoticsomeone.chaosjfx;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;

import java.util.Random;

public class ProgressBarCJFX {

	public interface ProgressBarTask {
		public void handle();
	}

	public static class SmoothProgressBar {
		private Timeline timeline;
		private ProgressBar progressBar;
		private Random rng;

		private double stepSize;
		private double speedFactor;

		private double minDelay = 0d;
		private double maxDelay = 0d;

		private double progress;

		public SmoothProgressBar(ProgressBar progressBar) {
			this(progressBar, 0.001d);
		}

		public SmoothProgressBar(ProgressBar progressBar, double stepSize) {
			this(progressBar, stepSize, 1d);
		}

		public SmoothProgressBar(ProgressBar progressBar, double stepSize, double speedFactor) {
			this.progressBar = progressBar;
			this.stepSize = stepSize;
			this.speedFactor = speedFactor;

			this.progress = 0d;

			this.rng = new Random();

			this.timeline = null;
		}

		public void playUntil(double targetProgress, ProgressBarTask onFinished) {
			if (targetProgress > progress && targetProgress >= 0d && targetProgress <= 1d) {
				timeline = new Timeline(new KeyFrame(Duration.seconds(maxDelay == minDelay ? minDelay : rng.nextDouble(minDelay, maxDelay)), new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						progress = Math.min(progress + stepSize * speedFactor, targetProgress);

						progressBar.setProgress(progress);

						if (progress == targetProgress) {
							timeline.stop();
							onFinished.handle();
						}
					}
				}));
				timeline.setCycleCount(Timeline.INDEFINITE);
				timeline.play();
			}
		}

		public void play(ProgressBarTask onFinished) {
			playUntil(1d, onFinished);
		}

		public void playChain(double targetProgress, ProgressBarTask onFinished, ProgressBarTask next) {
			playUntil(targetProgress, () -> {
				onFinished.handle();
				next.handle();
			});
		}


		public void setDelays(double minDelay, double maxDelay) {
			this.minDelay = minDelay;
			this.maxDelay = maxDelay;
		}

		public void setDelay(double delay) {
			this.minDelay = delay;
			this.maxDelay = delay;
		}

		public double getStepSize() {
			return stepSize;
		}

		public void setStepSize(double stepSize) {
			if (stepSize > 0 && stepSize <= 1) {
				this.stepSize = stepSize;
			}
		}

		public double getSpeedFactor() {
			return speedFactor;
		}

		public void setSpeedFactor(double speedFactor) {
			if (speedFactor > 0) {
				this.speedFactor = speedFactor;
			}
		}
	}
}
