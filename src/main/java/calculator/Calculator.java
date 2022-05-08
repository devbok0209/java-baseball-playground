package calculator;


public class Calculator {

    public int calculate(String message) {

        String[] values = message.split(" ");
        int calculatedValue = Integer.parseInt(values[0]);

        for (int i = 0; i < values.length; i++) {

            if (i % 2 != 0) {
                String sign = values[i];
                int calculatingValue = Integer.parseInt(values[i+1]);
                if (sign.equals("+")) {
                    calculatedValue = plus(calculatedValue, calculatingValue);
                }

                if (sign.equals("-")) {
                    calculatedValue = minus(calculatedValue, calculatingValue);
                }

                if (sign.equals("/")) {
                    calculatedValue = divide(calculatedValue, calculatingValue);
                }

                if (sign.equals("*")) {
                    calculatedValue = multiply(calculatedValue, calculatingValue);
                }
            }
        }
        return calculatedValue;
    }

    public int plus(int calculatedValue, int plusValue) {
        return calculatedValue + plusValue;
    }

    public int minus(int calculatedValue, int minusValue) {
        return calculatedValue - minusValue;
    }

    public int divide(int calculatedValue, int divideValue) {
        return calculatedValue / divideValue;
    }

    public int multiply(int calculatedValue, int multiplyValue) {
        return calculatedValue * multiplyValue;
    }
}


