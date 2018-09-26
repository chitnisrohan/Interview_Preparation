public static void main(String args[]){
        HelloWorld hw = new HelloWorld();
        System.out.println(hw.solution("ACCAABBC"));
        System.out.println(hw.solution("ABCBBCBA"));
        System.out.println(hw.solution("BABABA"));
    }

    public String solution(String str) {
        if (str.length() < 2) {
            return str;
        }
        while (isDuplicate(str)) {
            str = removeDuplicate(str);
        }
        return str;
    }

    private String removeDuplicate(String str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i+1)) {
                sb.append(str.charAt(i));
            } else {
                i++;
            }
        }
        if (sb.charAt(sb.length() - 1) != str.charAt(str.length() - 1)) {
            sb.append(str.charAt(str.length() - 1));
        }
        else {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }


    private boolean isDuplicate(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i+1)) {
                return true;
            }
        }
        return false;
    }
