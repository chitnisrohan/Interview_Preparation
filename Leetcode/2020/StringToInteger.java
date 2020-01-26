package LeetCode;

public class StringToInteger {

    public static void main(String[] args) {
        int i = '4' - '0';
        System.out.println(i);
        System.out.println(new StringToInteger().myAtoi("    42"));
        System.out.println(new StringToInteger().myAtoi("    -42  "));
        System.out.println(new StringToInteger().myAtoi("876 abc"));
        System.out.println(new StringToInteger().myAtoi("word 876"));
        System.out.println(new StringToInteger().myAtoi(" +-876"));
    }

    /*
    1. ignore all leading spaces.
    2. check for sign, if -, sign = -1 else sign = 1;
    3. now start checking for only digits in while loop
        i. check for overflow.
        ii. multiply by 10 and add current char at units place.
    4. return base * sign
     */
    public int myAtoi(String str) {
        if (str.isEmpty()) return 0;
        int sign = 1, base = 0, i = 0;
        while (i < str.length() && str.charAt(i) == ' ')
            i++;
        if (i < str.length() && (str.charAt(i) == '-' || str.charAt(i) == '+'))
            sign = str.charAt(i++) == '-' ? -1 : 1;
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            base = 10 * base + (str.charAt(i++) - '0');
        }
        return base * sign;
    }

}
