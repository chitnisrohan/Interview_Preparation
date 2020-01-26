package LeetCode;

public class AddStrings {

    public String addStrings(String num1, String num2) {
        String small, big;
        int smallLength, bigLength;
        if (num1.length() > num2.length()) {
            small = num2;
            big = num1;
            smallLength = num2.length();
            bigLength = num1.length();
        } else {
            small = num1;
            big = num2;
            smallLength = num1.length();
            bigLength = num2.length();
        }
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int zero = 48;
        while(smallLength >= 1) {
            int n1 = small.charAt(--smallLength) - zero;
            int n2 = big.charAt(--bigLength) - zero;
            int n3 = n1+n2+carry;
            if (n3 > 9) {
                carry = 1;
                result.append(n3%10);
            } else {
                result.append(n3);
                carry = 0;
            }
        }
        while(bigLength >= 1) {
            int n2 = big.charAt(--bigLength) - zero;
            int n3 = n2+carry;
            if (n3 > 9) {
                carry = 1;
                result.append(n3%10);
            } else {
                result.append(n3);
                carry = 0;
            }
        }
        if (carry == 1) {result.append("1");}
        result.reverse();
        return result.toString();
    }
}
