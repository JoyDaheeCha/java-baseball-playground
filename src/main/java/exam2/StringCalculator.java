package exam2;

import java.util.List;
import java.util.Scanner;

public class StringCalculator {
    private static final String REQUIRED_SEPARATOR = " ";
    private static final int MIN_ELEMENT_SIZE = 3;

    public double execute(String inputString) {
        List<String> expressionElementList = createExpressionElementList(inputString);

        double result = Double.parseDouble(expressionElementList.get(0));
        for (int i = 1; i < expressionElementList.size(); i += 2) {
            result = calculate(
                    result,
                    expressionElementList.get(i),
                    Double.parseDouble(expressionElementList.get(i + 1))
            );
        }

        return result;
    }

    private List<String> createExpressionElementList(String inputString) {
        if (!inputString.contains(REQUIRED_SEPARATOR)) {
            throw new IncompleteStringExpressionException("식에는 '" + REQUIRED_SEPARATOR + "' 가 포함되어 있어야 합니다.");
        }

        List<String> expressionElementList = List.of(inputString.split(REQUIRED_SEPARATOR));

        checkValidation(expressionElementList);

        return expressionElementList;
    }

    private void checkValidation(List<String> expressionElementList) {
        int expressionElementSize = expressionElementList.size();
        if (expressionElementSize < MIN_ELEMENT_SIZE) {
            throw new IncompleteStringExpressionException("최소 " + MIN_ELEMENT_SIZE + "개 이상의 요소가 필요합니다.");
        }

        if (expressionElementSize % 2 == 0) {
            throw new IncompleteStringExpressionException("요소의 개수가 홀수만 가능합니다. 요소 수: " + expressionElementSize);
        }
    }

    private double calculate(double number1, String operator, double number2) throws NotSupportedOperatorException {
        return switch (operator) {
            case "+" -> number1 + number2;
            case "-" -> number1 - number2;
            case "/" -> number1 / number2;
            case "*" -> number1 * number2;
            default -> throw new NotSupportedOperatorException("사칙연산 외에는 계산할 수 없습니다. 연산자: " + operator);
        };
    }

    public static void main(String[] args) {
        while (true) {
            System.out.print("계산식을 입력하세요: ");

            Scanner scanner = new Scanner(System.in);
            String inputString = scanner.nextLine();
            if (inputString.toLowerCase().charAt(1) == 'q') {
                System.out.println("계산기를 종료합니다.");
                break;
            }

            try {
                double result = (new StringCalculator()).execute(inputString);
                System.out.println("계산된 결과: " + result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
