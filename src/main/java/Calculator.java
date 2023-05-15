import java.util.ArrayDeque;

public class Calculator {
    private String str;
    private ArrayDeque<Integer> numbers = new ArrayDeque<>();
    private ArrayDeque<String> operation = new ArrayDeque<>();
    private int result = 0;

    public Calculator(String str) {
        this.str = str;
    }

    public int calculate() {
        String[] arrays = str.split(" ");
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].matches("[\\+\\-\\*\\/]")) operation.add(arrays[i]);
            else if (arrays[i].matches("^-?[0-9]\\d*(\\.\\d+)?$")) {
                try {
                    int n = Integer.parseInt(arrays[i]);
                    if (n < 0 && n < -10) {
                        throw new RuntimeException("Number wast be between -1 to -10:" + n);
                    } else if (n == 0 || n > 10) {
                        throw new RuntimeException("Number wast be between 1 to 10:" + n);
                    }
                    numbers.add(n);
                } catch (NumberFormatException e) {
                    throw new RuntimeException("Number wast be Integer");
                }

            } else throw new RuntimeException("Wrong operation: " + arrays[i]);
        }
        String operation1 = operation.pollFirst();
        String operation2 = operation.pollFirst();
        if (operation2 == null) {
            if (operation1.equals("*")) result += numbers.pollFirst() * numbers.pollFirst();
            else if (operation1.equals("/")) result += numbers.pollFirst() / numbers.pollFirst();
            else if (operation1.equals("+")) result += numbers.pollFirst() + numbers.pollFirst();
            else if (operation1.equals("-")) result += numbers.pollFirst() - numbers.pollFirst();
        } else {
            if (operation1.equals("*") && operation2.equals("*"))
                result += numbers.pollFirst() * numbers.pollFirst() * numbers.pollFirst();
            else if (operation1.equals("*") && operation2.equals("/"))
                result += numbers.pollFirst() * numbers.pollFirst() / numbers.pollFirst();
            else if (operation1.equals("*") && operation2.equals("+"))
                result += numbers.pollFirst() * numbers.pollFirst() + numbers.pollFirst();
            else if (operation1.equals("*") && operation2.equals("-"))
                result += numbers.pollFirst() * numbers.pollFirst() - numbers.pollFirst();
            else if (operation1.equals("/") && operation2.equals("/"))
                result += numbers.pollFirst() / numbers.pollFirst() / numbers.pollFirst();
            else if (operation1.equals("/") && operation2.equals("*"))
                result += numbers.pollFirst() / numbers.pollFirst() * numbers.pollFirst();
            else if (operation1.equals("/") && operation2.equals("+"))
                result += numbers.pollFirst() / numbers.pollFirst() + numbers.pollFirst();
            else if (operation1.equals("/") && operation2.equals("-"))
                result += numbers.pollFirst() / numbers.pollFirst() - numbers.pollFirst();
            else if (operation1.equals("+") && operation2.equals("*"))
                result += numbers.pollFirst() + numbers.pollFirst() * numbers.pollFirst();
            else if (operation1.equals("+") && operation2.equals("/"))
                result += numbers.pollFirst() + numbers.pollFirst() / numbers.pollFirst();
            else if (operation1.equals("+") && operation2.equals("+"))
                result += numbers.pollFirst() + numbers.pollFirst() + numbers.pollFirst();
            else if (operation1.equals("+") && operation2.equals("-"))
                result += numbers.pollFirst() + numbers.pollFirst() - numbers.pollFirst();
            else if (operation1.equals("-") && operation2.equals("*"))
                result += numbers.pollFirst() - numbers.pollFirst() * numbers.pollFirst();
            else if (operation1.equals("-") && operation2.equals("/"))
                result += numbers.pollFirst() - numbers.pollFirst() / numbers.pollFirst();
            else if (operation1.equals("-") && operation2.equals("+"))
                result += numbers.pollFirst() - numbers.pollFirst() + numbers.pollFirst();
            else if (operation1.equals("-") && operation2.equals("-"))
                result += numbers.pollFirst() - numbers.pollFirst() - numbers.pollFirst();
        }
        return result;
    }
}
