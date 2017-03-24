package pocketGems;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;

/*
 * Sample text file -
(11/01/2015-04:00:00) :: START
(11/01/2015-04:00:00) :: CONNECTED
(11/01/2015-04:30:00) :: DISCONNECTED
(11/01/2015-04:45:00) :: CONNECTED
(11/01/2015-05:05:00) :: SHUTDOWN

 */


public class ConnectedTime {

	public static void main(String[] args) {
		
		Stack<Long> timeStack = new Stack<>();
		long totalTime = 0;
		try (BufferedReader br = new BufferedReader(new FileReader("text.txt"))) {
		    String line;
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy-hh:mm:ss");
			Date date1 = null, date2 = null;
			String time1;

		    while ((line = br.readLine()) != null) {
		       //System.out.println(line);
		    	if (line.contains("CONNECTED") && !line.contains("DISCONNECTED")) {
		    		time1 = line.split("\\(")[1].split("\\)")[0];
					try {
						date1 = format.parse(time1);
					} catch (ParseException e) {
						e.printStackTrace();
					}					 
		    		timeStack.push(date1.getTime());
		    	} else if (line.contains("DISCONNECTED") || line.contains("SHUTDOWN")) {
		    		long time2 = timeStack.pop();
		    		time1 = line.split("\\(")[1].split("\\)")[0];
		    		try {
						date2 = format.parse(time1);
					} catch (ParseException e) {
						e.printStackTrace();
					}
		    		long difference = date2.getTime() - time2;
		    		totalTime += difference;
		    	}
		    }
		    System.out.println(totalTime/1000/60);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
