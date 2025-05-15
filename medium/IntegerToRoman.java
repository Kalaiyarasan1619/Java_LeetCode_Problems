package medium;

public class IntegerToRoman {
    public static void main(String[] args) {

        IntegerToRoman solution = new IntegerToRoman();
        int num = 1994;
        String result = solution.intToRoman(num);
        System.out.println("Roman numeral: " + result);

    }

    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();

        String[] thousands = { "", "M", "MM", "MMM" };
        String[] hundreds = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
        String[] tens = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
        String[] ones = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };

        roman.append(thousands[num / 1000]);
        num %= 1000;
        roman.append(hundreds[num / 100]);
        num %= 100;
        roman.append(tens[num / 10]);
        num %= 10;
        roman.append(ones[num]);

        return roman.toString();
    }
}
