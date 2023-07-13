public class InvalidArithmeticOperatorException extends Exception {
    public InvalidArithmeticOperatorException() {
        super("Отсутствует или неверно указана арифметическая операция. Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами");
    }
}