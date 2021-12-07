package test;

import javax.swing.*;

public class Runner {
    public static void main(String[] args) {

        Integer num = null;
        int num1 = 0;
        int num2 = 0;
        boolean exit = true;
        do{
            try {
                num1 = Integer.parseInt(JOptionPane.showInputDialog("Numero Uno"));
                num2 = Integer.parseInt(JOptionPane.showInputDialog("Numero Dos"));
                exit = true;
            } catch ( NumberFormatException e) {
                exit = false;
            }
        }while( !exit );

        OperationsNums on = new OperationsNums(num1,num2);
        try {
            System.out.println( on.div());
        } catch (ExceptionNumber e) {
            System.out.println( e.getMessage());
        }

        System.out.println("************FINN************");
    }

    private int div(int num1, int num2) throws ArithmeticException {

        return num1 > num2 ? num1 / num2 : num2 / num1;

    }

}

class OperationsNums {
    private int numOne;
    private int numTwo;

    public OperationsNums(int numOne, int numTwo) {
        this.numOne = numOne;
        this.numTwo = numTwo;
    }

    public int div() throws ExceptionNumber {
        if ( numOne == 0 || numTwo == 0 ){
            throw new ExceptionNumber("Division por Cero");
        }
        return numOne> numTwo ? numOne / numTwo : numTwo / numOne;
    }
}
