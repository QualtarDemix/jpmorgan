package test.jp.morgan.enums;

public enum Operator {
	add, subtract, multiply;

	public Integer calculate(Integer num1, Integer num2) {
		if (this.equals(Operator.add)) {
			return num1 + num2;
		} else if (this.equals(Operator.subtract)) {
			return num1 - num2;
		} else if (this.equals(Operator.multiply)) {
			return num1 * num2;
		}
		return null;
	}
}
