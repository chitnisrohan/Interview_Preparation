package leetcode;

/*
 * Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.

IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;

Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.

IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. The groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one. Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the address to upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).

However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.

Besides, extra leading zeros in the IPv6 is also invalid. For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.

Note: You may assume there is no extra space or special characters in the input string.
 */
public class ValidateIPAddress_468 {

	public static void main(String[] args) {
		System.out.println("1.1.1.1.".split("\\.").length);
		System.out.println(new ValidateIPAddress_468().validIPAddress("192.0.0.1"));
	}
	
	public String validIPAddress(String IP) {
        if (IP.indexOf(':') > -1) {
        	if (IP.split(":").length > 8)
        		return "Neither";
        	return validateIPv6(IP);
        } else if (IP.indexOf('.') > -1) {
        	if (IP.split("\\.").length > 4 || IP.split("\\.").length < 4)
        		return "Neither";
        	return validateIPv4(IP);
        } else 
        	return "Neither";

    }
	
	public String validateIPv6(String IP) {
		int start = 0;
		boolean result = true;
		for (int i = 0; i < IP.length() ; i++) {
			if (IP.charAt(i) == ':') {
				result = result && validateIPv6Part(IP, start, i-1);
				if (!result)
					break;
				start = i+1;
			}
		}
		result = result && validateIPv6Part(IP, start, IP.length()-1);
		return result ? "IPv6" : "Neither";
	}
	
	public boolean validateIPv6Part(String IP,int start,int i) {
		boolean result = true;
		if (i - start >= 4 || i - start < 0)
			return false;
		for (int j = start; j <= i ; j++) {
			if ((IP.toUpperCase().charAt(j) >= 65 && IP.toUpperCase().charAt(j) <= 70) 
	                || (IP.toUpperCase().charAt(j) >= 48 && IP.toUpperCase().charAt(j) <= 57)) {
					result = result && true;
				} else {
	                result = result && false;
	            }
			}
		
		return result;
	}
	
	public String validateIPv4(String IP) {
		boolean result = true;
		int start = 0;
		for (int i = 0 ; i < IP.length() ; i++) {
			if (IP.charAt(i) == '.') {
				result = result && validateIPv4Part(IP, start, i-1);
				if (!result)
					break;
				start = i+1;
			}

		}
		result = result && validateIPv4Part(IP, start, IP.length() - 1);
		return result ? "IPv4" : "Neither";
	}
	
	public boolean validateIPv4Part(String IP,int start,int i) {
		
        if (i - start >= 3 || i - start < 0)
			return false;
        if (IP.charAt(start) == '0'  && IP.substring(start, i+1).length() > 1)
			return false;
		try {
            if (IP.substring(start, i+1).contains("-"))
                return false;
			int num = Integer.parseInt(IP.substring(start, i+1));
			if (num <= 255 && num >= 0)
				return true;
			else 
				return false;
		} catch (Exception e) {
			return false;
		}

	}

	
}


