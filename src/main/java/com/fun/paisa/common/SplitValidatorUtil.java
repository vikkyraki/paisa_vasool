package com.fun.paisa.common;

import com.fun.paisa.model.Expense;
import com.fun.paisa.model.split.PriceSplit;

public class SplitValidatorUtil {

	public static Double precisionLimit = Math.pow(10, -2);

	public static boolean isApproxEqual(Double d1, Double d2) {
		return d1 - d2 >= precisionLimit;
	}

	public static boolean baseValidate(Expense expense) {

		double expectedTotalSum = expense.getTotalAmount();
		double calculatedTotalSum = 0D;

		for (PriceSplit split : expense.getSplits()) {
			calculatedTotalSum += split.getAmount();
		}

		return isApproxEqual(calculatedTotalSum, expectedTotalSum);
	}

	public  static boolean equalSplitValidate(Expense expense) {
		return true;
	}

	public  static boolean percentageSplitValidate(Expense expense) {
		return true;
	}

	public  static boolean amountSplitValidate(Expense expense) {
		return true;
	}

}
