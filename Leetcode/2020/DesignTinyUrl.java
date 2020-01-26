package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class DesignTinyUrl {

    List<String> urls = new ArrayList();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        urls.add(longUrl);
        return String.valueOf(urls.size() - 1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        Integer i = Integer.parseInt(shortUrl);
        return urls.get(i);
    }
}
