public class ConvertSentense {
    static String[][] letters = new String[][]{{"IX", "V", "IV", "I"}, {"XC", "L", "XL", "X"}};
    static int[] units = new int[]{9, 5, 4, 1};
    public static String convert(int number){
        int[] numbers = new int[2];
        StringBuilder sb = new StringBuilder();
        if (number == 100) {
            sb.append("C");
        } else {
            for(int i = 0; number > 0; ++i) {
                numbers[i] = number % 10;
                number /= 10;
            }

            int dec = 0;

            for(int j = 0; j < numbers.length; ++j) {
                if (numbers[j] != 0) {
                    for(int k = 0; k < units.length; ++k) {
                        StringBuilder sb2 = new StringBuilder();
                        if (numbers[j] >= units[k]) {
                            sb2.append(letters[dec][k]);
                            for(int l = 0; l < numbers[j] - units[k]; ++l) {
                                sb2.append(letters[dec][3]);
                            }

                            sb.insert(0,sb2);
                            break;
                        }
                    }
                }
                ++dec;
            }
        }
        return sb.toString();
    }
    public static Sentense convert(Sentense sentense){
        sentense.x = fromRomanToArabic(sentense.x);
        sentense.y = fromRomanToArabic(sentense.y);
        return sentense;
    }
    static String fromRomanToArabic(String s){
        int result = 0;
        for(int i = letters.length - 1; i > -1; --i) {
            for(int j = 0; j < letters[i].length; ++j) {
                String s2 = String.valueOf(letters[i][j]);
                if (s.startsWith(s2)) {
                    result = (int)((double)result + (double)units[j] * Math.pow(10.0, (double)i));
                    int index = s.indexOf(s2) + s2.length();
                    if (j == 3) {
                        --j;
                    }
                    s = s.substring(index);
                }
            }
        }
        return String.valueOf(result);
    }
}
