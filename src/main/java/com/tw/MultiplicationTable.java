package com.tw;

public class MultiplicationTable {
    public String create(int startNumber, int endNumber) {
        boolean isValid = isValid(startNumber, endNumber);
        String multiplicationTable = createMultiplicationTable(startNumber, endNumber);
        return isValid ? multiplicationTable : null;
    }

    private String createMultiplicationTable(int startNumber, int endNumber) {
        String[] multiplcationLines = new String[(endNumber-startNumber) + 1];
        for (int i = 0; i < multiplcationLines.length; i++){
            multiplcationLines[i] = generateMultiplicationLine(startNumber, startNumber + i);
        }
        return String.join("\r\n", multiplcationLines);
    }

    private String generateMultiplicationLine(int num1, int num2) {
        String[] multiplicationExpressions = new String[(num2-num1) + 1];
        for (int i = 0; i < multiplicationExpressions.length; i++){
            multiplicationExpressions[i] = generateMultiplicationExpression(num1 + i, num2);
        }
        return String.join("  ", multiplicationExpressions);
    }

    private String generateMultiplicationExpression(int multiplicand, int multiplier) {
        return multiplicand + "*" + multiplier + "=" + (multiplicand*multiplier);
    }


    private boolean isValid(int startNum, int endNum) {
        boolean isSmallerOrEqual = isSmallerOrEqual(startNum, endNum);
        boolean isStartNumberInRange = isWithinRange(startNum);
        boolean isEndNumberInRange = isWithinRange(endNum);

        return isSmallerOrEqual && isStartNumberInRange && isEndNumberInRange;
    }

    private boolean isWithinRange(int number) {
        return (number >= 1 && number <= 1000);
    }

    private boolean isSmallerOrEqual(int startNum, int endNum) {
        return startNum <= endNum;
    }
}
