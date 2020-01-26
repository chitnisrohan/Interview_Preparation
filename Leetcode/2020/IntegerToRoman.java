package LeetCode;

public class IntegerToRoman {

    public String intToRoman(int num) {
        String[] M = new String[]{"", "M", "MM", "MMM"};
        String[] C = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM", "M"};
        String[] L = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};
        String[] I = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        return M[num/1000] + C[num%1000/100] + L[num%100/10] + I[num%10];
    }

}
