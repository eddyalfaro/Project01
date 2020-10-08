import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class DateTimeOne{
		
	private LocalDateTime showDateTime;
	
	public void dateTimeNow() 
	{
		//Date/time object for date/time
		DateTimeFormatter formattedDateTime = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
		this.showDateTime = LocalDateTime.now();
		String formattedDateTimeFinal = showDateTime.format(formattedDateTime);
	    System.out.println("Current Date/Time: " + formattedDateTimeFinal);	    
	} 

	public void sleepForThreeSec(){
		try {
			TimeUnit.MILLISECONDS.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int getValueOfSecond() {
		//DateTimeFormatter valueOfSecond = DateTimeFormatter.ofPattern("ss");
		this.showDateTime = LocalDateTime.now();	
		int secondNow = showDateTime.getSecond();

		if (secondNow == 58) {
			System.out.println("The value of Second now: 58");
		}
		
		return secondNow;
	}
}