package LeetCode;

public class ReadNCharactersGivenRead4 {


    public int read(char[] buf, int n) {
        int k = 0;
        while(k < n) {
            char[] tempBuf = new char[4];
            int count = read4(tempBuf);
            if (count == 0) {
                break;
            }
            for (int i = 0; i < count && k < n; i++) {
                buf[k++] = tempBuf[i];
            }
        }
        return k;
    }

    private int read4(char[] buf) {
        return 0;
    }
}
