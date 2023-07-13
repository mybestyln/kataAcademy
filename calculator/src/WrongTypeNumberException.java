public class WrongTypeNumberException extends Exception {
    public WrongTypeNumberException() {
        super("Калькулятор умеет работать только с арабскими или римскими цифрами");
    }
}