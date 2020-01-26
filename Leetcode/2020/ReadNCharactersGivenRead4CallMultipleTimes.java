package LeetCode;

public class ReadNCharactersGivenRead4CallMultipleTimes {

    /*

    Given a file and assume that you can only read the file using a given method read4,
    implement a method read to read n characters. Your method read may be called multiple times.

    Example -
    File = "abc"
    Multiple calls with n = [1,2,1]

    Expected output in each call = ["a","bc",""]

     */


    int prevIndex = 0;  // to store till what index in prevBuf data was copied for previous call to read() method
    int prevSize = 0;  // to store how many characters were read in previous call to parent read method read4()
    char[] prevBuf = new char[4];  // local buffer to keep data read in between 2 calls to read() method.
    // prevIndex will make sure we are reading from next index i.e. all characters before prevIndex are read in previous call
    public int read(char[] buf, int n) {
        int count = 0;
        while(count < n) {
            if (prevIndex == 0) {
                prevSize = read4(prevBuf);
            }
            if (prevSize == 0) break;
            while(count < n && prevIndex < prevSize) {
                buf[count++] = prevBuf[prevIndex++];
            }
            if (prevIndex == prevSize) {
                prevIndex = 0;
            }
        }
        return count;
    }


    private int read4(char[] buf) {
        return 0;
    }
}
