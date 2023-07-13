public class Sentense {

    String x;
    String y;
    String operator;
    String typeofX;
    String typeofY;

    public Sentense(String str) throws InvalidArithmeticOperatorException {
        String[] symbols = new String[]{"+", "-", "*", "/"};
        for(int i = 0; i < symbols.length; ++i) {
            if (str.contains(symbols[i])) {
                String op = symbols[i];
                this.operator = op;
                this.x = str.substring(0, str.indexOf(op)).trim();
                this.y = str.substring(str.indexOf(op) + 1).trim();
                break;
            }
        }

        if (this.operator == null) {
            throw new InvalidArithmeticOperatorException();
        } else {
            if (this.x.matches("\\d+")) {
                this.typeofX = "isArabic";
            } else if (this.x.matches("^(C{0,1})|(L?X{0,3}|X[LC])(V?I{0,3}|I[VX])$")) {
                this.typeofX = "isRoman";
            }

            if (this.y.matches("\\d+")) {
                this.typeofY = "isArabic";
            } else if (this.y.matches("^(C{0,1})|(L?X{0,3}|X[LC])(V?I{0,3}|I[VX])$")) {
                this.typeofY = "isRoman";
            }
        }
    }
    void check() throws WrongTypeNumberException, DifferentTypesOfNumbersException {
        if (this.typeofX != null && this.typeofY != null) {
            if (!this.typeofX.equals(this.typeofY)) {
                throw new DifferentTypesOfNumbersException();
            }
        } else {
            throw new WrongTypeNumberException();
        }
    }
    int calculate() throws NumberOutOfRangeException {
        int x = Integer.parseInt(this.x);
        int y = Integer.parseInt(this.y);
        if (x > 10 || x < 1 || y > 10 || y < 1) {
            throw new NumberOutOfRangeException();
        }
        else {
            switch (this.operator) {
                case "+":
                    return x + y;
                case "-":
                    return x - y;
                case "*":
                    return x * y;
                default:
                    return x / y;
            }
        }
    }
    void getResult() throws NumberOutOfRangeException, DifferentTypesOfNumbersException, WrongTypeNumberException {
        this.check();
        if(this.typeofX.equals("isRoman")){
            System.out.println(
                    ConvertSentense.convert(
                            ConvertSentense.convert(this)
                                    .calculate()));
        }
        else {
            System.out.println(this.calculate());
        }
    }
}
