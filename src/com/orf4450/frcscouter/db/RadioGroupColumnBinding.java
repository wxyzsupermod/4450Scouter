package com.orf4450.frcscouter.db;

import android.widget.RadioGroup;

/**
 * @author ShortCircuit908
 *         Created on 2/4/2016
 */
public class RadioGroupColumnBinding extends AbstractColumnBinding<RadioGroup, Integer> {
	private final int[][] id_to_value_bindings;

	public RadioGroupColumnBinding(RadioGroup view, String column_name, int[][] id_to_value_bindings) {
		super(view, column_name, Integer.class, "INT", (view.getChildCount() + "").length(), false, -1);
		this.id_to_value_bindings = id_to_value_bindings;
	}

	public int getValueFromId(int id) {
		for (int[] binding : id_to_value_bindings) {
			if (binding[0] == id) {
				return binding[1];
			}
		}
		return -1;
	}

	public int getIdFromValue(int value) {
		for (int[] binding : id_to_value_bindings) {
			if (binding[1] == value) {
				return binding[0];
			}
		}
		return -1;
	}

	@Override
	public Integer getValue() {
		return getValueFromId(view.getCheckedRadioButtonId());
	}

	@Override
	public void setValue(Integer value) {
		int id = getIdFromValue(value);
		if (id > -1) {
			view.check(id);
		}
		else {
			view.clearCheck();
		}
	}
}
