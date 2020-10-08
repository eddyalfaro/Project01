/**
 * @author Mohammad Mukhtaruzzaman
 * @version 2020-09-01
*/
import java.io.IOException;

public class Driver 
{
	public static void main(String[] args) throws IOException 
	{
		int stopIfSecond = 30;
		DateTimeOne dateTimeOne = new DateTimeOne();
	    dateTimeOne.dateTimeNow();	
		/**
		 * You have to retrieve the value of "Second" of the current time.
		 * If 'Second' is greater than 30, you have to sleep your program for 3 seconds. 
		 * Current value of Second is stored in vlaueOfSecondNow. 
		 * If second is 58, the resulted string will be, "The value of Second now: 58"
		 */
		int vlaueOfSecondNow = dateTimeOne.getValueOfSecond();
		/**
		 * If vlaueOfSecondNow>30, program will sleep for 3 seconds.
		 */		
		if(vlaueOfSecondNow > stopIfSecond)	{
			dateTimeOne.sleepForThreeSec();
		}
		
	    dateTimeOne.dateTimeNow();	
		
		System.out.print("\n");
		
		String[] cityOfOk = {"NEWK", "WEBR", "BROK", "FREE"};
		HammingDist hammDist1 = new HammingDist(cityOfOk[0], cityOfOk[1]);
		HammingDist hammDist2 = new HammingDist(cityOfOk[2], cityOfOk[3]);
		
		System.out.println(hammDist1);
		System.out.print("\n");
		System.out.println(hammDist2);
	}
}