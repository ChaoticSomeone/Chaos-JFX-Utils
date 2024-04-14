package org.chaoticsomeone.chaosjfx;

import javafx.collections.FXCollections;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

import java.util.List;

public class SpinnerCJFX {
	public static void initIntegerSpinner(Spinner<Integer> spinner, Integer min, Integer max, Integer step) {
		spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(min, max, step));
		spinner.getValueFactory().setValue(min);
	}

	public static void initIntegerSpinner(Spinner<Integer> spinner, Integer min, Integer max) {
		initIntegerSpinner(spinner, min, max, 1);
	}

	public static void initDoubleSpinner(Spinner<Double> spinner, Double min, Double max, Double step) {
		spinner.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(min, max, step));
		spinner.getValueFactory().setValue(min);
	}

	public static void initDoubleSpinner(Spinner<Double> spinner, Double min, Double max) {
		initDoubleSpinner(spinner, min, max, 1d);
	}

	public static void initStringSpinner(Spinner<String> spinner, String[] items) {
		if (items.length > 0) {
			spinner.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<>(FXCollections.observableArrayList(items)));
			spinner.getValueFactory().setValue(items[0]);
		}
	}

	public static void initStringSpinner(Spinner<String> spinner, List<String> items) {
		if (!items.isEmpty()) {
			spinner.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<>(FXCollections.observableArrayList(items)));
			spinner.getValueFactory().setValue(items.getFirst());
		}
	}
}
