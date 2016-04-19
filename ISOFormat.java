package codeFoo6.ign.www;

import java.util.TimeZone;
/**
 * Translate different date and time format strings into 
 * ISO format
 * @author Giovanni
 *
 */
public class ISOFormat {
	
	/**
	 * 2016.03.20 
	 * @param input 
	 * YYYY.MM.DD
	 * @return 
	 * YYYY-MM-DD
	 */
	public String dateFormatOne(String input){
		String[] splitString = input.split("\\.");
		if(Integer.parseInt(splitString[1]) < 10)
			return splitString[0] + "-0" + Integer.parseInt(splitString[1]) + "-" + splitString[2];
		return splitString[0] + "-" + splitString[1] + "-" + splitString[2];
	}
	
	/**
	 * Sunday, March 20, 2016; Sunday, MAR 20, 2016<br>
	 * Sunday, March 20, 2016 4:05 PM<br>
	 * Sunday, March 20, 2016 4:05:07 PM
	 * @param input
	 * Day, MM DD, YYYY<br>
	 * Day, MM DD, YYYY HH:MM PM/AM<br>
	 * Day, MM DD, YYYY HH:MM:SS PM/AM
	 * @return
	 * YYYY-MM-DD<br>
	 * YY-MM-DDTHH:MM(+/- zone offset)<br>
	 * YY-MM-DDTHH:MM:SS(+/- zone offset)
	 */
	public String dateFormatTwo(String input){
		
		String[] splitFormat = input.split(" ");
		String[] dayString = splitFormat[2].split(",");
		
		splitFormat[2] = dayString[0];
		if(Integer.parseInt(dayString[0]) < 10)
			splitFormat[2] = "0" + Integer.parseInt(dayString[0]);
		
		//Day, MM DD, YYYY
		if(splitFormat.length == 4){
			return splitFormat[3] + "-" + monthToInt(splitFormat[1]) + "-" + splitFormat[2];
		}
		
		//Day, MM DD, YYYY HH:MM PM/AM
		//Day, MM DD, YYYY HH:MM:SS PM/AM
		else if(splitFormat.length == 6){
			String[] time = {splitFormat[4], splitFormat[5]};
			return splitFormat[3] + "-" + monthToInt(splitFormat[1]) + "-" + splitFormat[2] + timeSplitter(time);
		}
		
		return "";
	}
	
	
	/**
	 * 3/20/2016<br>
	 * 3/20/2016 4:05 PM<br>
	 * 3/20/2016 4:05:07 PM
	 * @param input
	 * MM/DD/YYYY<br>
	 * MM/DD/YYYY HH:MM AM/PM<br>
	 * MM/DD/YYYY HH:MM:SS AM/PM
	 * @return
	 * YYYY-MM-DD
	 * YYYY-MM-DDTHH:MM(+/- zone offset)
	 * YYYY-MM-DDTHH:MM:SS(+/- zone offset)
	 */
	public String dateFormatThree(String input){
		
		String[] split = input.split(" ");
		String[] secondSplit = split[0].split("/");
		

		if(Integer.parseInt(secondSplit[0]) < 10)
			secondSplit[0] = "0" + Integer.parseInt(secondSplit[0]);
		if(Integer.parseInt(secondSplit[1]) < 10)
			secondSplit[1] = "0" + Integer.parseInt(secondSplit[1]);
		
		//MM/DD/YYYY
		if(split.length == 1)
			return secondSplit[2] + "-" + secondSplit[0] + "-" + secondSplit[1];
		
		
		//MM/DD/YYYY HH:MM:SS AM/PM
		else if(split.length == 3){
			String[] time = {split[1], split[2]};
			return secondSplit[2] + "-" + secondSplit[0] + "-" + secondSplit[1] + timeSplitter(time);
		}
		return "";
	}
	
	/**
	 * 20/03/2016
	 * @param input
	 * DD/MM/YYYY
	 * @return
	 * YYYY-MM-DD
	 */
	public String dateFormatFour(String input){
		String[] split = input.split("/");
		
		if(Integer.parseInt(split[0]) < 10)
			split[0] = "0" + Integer.parseInt(split[0]);
		if(Integer.parseInt(split[1]) < 10)
			split[1] = "0" + Integer.parseInt(split[1]);
		
		return split[2] + "-" + split[1] + "-" + split[0];
	}
	
	/**
	 * March 20, 2016<br>
	 * March 20<br>
	 * March, 2016
	 * @param input
	 * Month DD, YYYY<br>
	 * Month DD<br>
	 * Month, YYYY
	 * @return
	 * YYYY-MM-DD<br>
	 * MM-DD<br>
	 * YYYY-MM
	 */
	public String dateFormatFive(String input){
		
		String[] split  = input.split(" ");
		
		//Month DD, YYYY
		if(split.length == 3){
			
			String[] commaSplit = split[1].split(",");
			
			if(Integer.parseInt(commaSplit[0]) < 10)
				commaSplit[0] = "0" + commaSplit[0];
			
			return split[2] + "-" + monthToInt(split[0]) + "-" + commaSplit[0];

		}
		else if(split.length == 2 ){
			
			//Month DD
			if(split[1].length() == 2){
				
				if(Integer.parseInt(split[1]) < 10)
					split[1] = "0" + Integer.parseInt(split[1]);
				return monthToInt(split[0]) + "-" + split[1];
			}
			//Month, YYYY
			else if(split[1].length() == 4){
				String[] commaSplit = split[0].split(",");
				return split[1] + "-" + monthToInt(commaSplit[0]);
			}
		}
		return "";
	}
	
	/**
	 * 20 March 2016
	 * @param input
	 * DD Month YYYY<br>
	 * DD Month YYYY HH:MM:SS AM/PM
	 * @return
	 * YYYY-MM-DD<br>
	 * YYYY-MM-DDTHH:MM:SS(+/- zone offset)
	 */
	public String dateFormatSix(String input){
		String[] split = input.split(" ");
		
		if(Integer.parseInt(split[0]) < 10)
			split[0] = "0" + Integer.parseInt(split[0]);
		
		if(split.length == 3){
			return split[2] + "-" + monthToInt(split[1]) + "-" + split[0];
		}
		else if(split.length == 5){
			String[] time = {split[3], split[4]};
			return split[2] + "-" + monthToInt(split[1]) + "-" + split[0] + timeSplitter(time);
		}
		return "";
	}
	
	/**
	 * 4:05:07 PM
	 * @param input 
	 * HH:MM:SS AM/PM
	 * @return 
	 * THH:MM:SS(+/- zone offset)
	 */
	public String dateFormatSeven(String input){
		
		String[] split = input.split(" ");
		return timeSplitter(split);

	}
	

	/**
	 * 20160320 <br>
	 * 20160320 16:05:07
	 * @param input
	 * YYYYMMDD<br>
	 * YYYYMMDD HH:MM:SS
	 * @return
	 * YYYY-MM-DD<br>
	 * YYYY-MM-DDTHH:MM:SS(+/- zone offset)
	 */
	public String dateFormatEight(String input){
		
		char[] compDate = input.toCharArray();
		String date = "" + compDate[0] + compDate[1] + compDate[2] + compDate[3] + "-" + compDate[4] + compDate[5] + "-" + compDate[6] +
				compDate[7];
		
		if(compDate.length == 8)
			return date;
		
		else{
			String[] splitString = input.split(" ");
			String[] time = {splitString[1]};
			return date + timeSplitter(time);
		}
	}
	
	/**
	 * Sunday 20th of March 2016 04:05:07 PM
	 * @param input
	 * Day DDth of Month YYYY HH:MM:SS AM/PM
	 * @return
	 * YYYY-MM-DDTHH:MM:SS(+/- zone offset)
	 */
	public String dateFormatNine(String input){
		String[] split = input.split(" ");
		String[] time = {split[5],split[6]};
		char[] day = split[1].toCharArray();
		if(day.length == 3)
			return split[4] + "-" + monthToInt(split[3]) + "-0" + day[0] + timeSplitter(time); 
		else if(day.length == 4)
			return split[4] + "-" + monthToInt(split[3]) + "-" + day[0] + "" + day[1] + timeSplitter(time);
		return "";
	}

	/**
	 * 2016-20-03T16:05:07-08:00
	 * @param input
	 * YYYY-DD-MMTHH:MM:SS(+/- zone offset)
	 * @return
	 * YYYY-MM-DDTHH:MM:SS(+/- zone offset)
	 */
	public String dateFormatTen(String input){
		String[] split = input.split("T");
		String[] secondSplit = split[0].split("-");
		return secondSplit[0] + "-" + secondSplit[2] + "-" + secondSplit[1] + "T" + split[1];
	}
	
	/**
	 * eg. Sun, 20 Mar 2016 16:05:07 GMT
	 * @param input
	 * Day, DD Month YYYY HH:MM:SS Zone
	 * @return
	 * YYYY-MM-DDTHH:MM:SS(+/- zone offset)
	 */
	public String dateFormatEleven(String input){
		String[] split = input.split(" ");
		String[] time = {split[4], split[5]};
		
		return split[3] + "-" + monthToInt(split[2]) + "-" + split[1] + timeSplitter(time);
	}

	
	/**
	 * eg. Sun, 20 Mar 2016 16:05:07 -0800
	 * @param input
	 * Day, DD Month YYYY HH:MM:SS offset
	 * @return
	 * YYYY-MM-DDTHH:MM:SS(+/- zone offset)
	 */
	public String dateFormatTwelve(String input){
		String[] split = input.split(" ");
		String[] time = {split[4],split[5]};
		return split[3] + "-" + monthToInt(split[2]) + "-" + split[1] + timeSplitter(time);
	}
	
	
	/**
	 * Return a String containing an offset into 
	 * the appropriate format
	 * @param input 
	 * An offset without a colon <br>
	 * eg. -0800
	 * @return
	 * String in appropriate format<br>
	 * eg. -08:00
	 */
	private String timeZone(String input){
		char[] split = input.toCharArray();
        return split[0] + "" + split[1] + "" + split[2] + ":" + split[3] + "" + split[4];
	}
	
	/**
	 * Changes a String containing a month in English 
	 * to its equivalent numerical value
	 * @param month String representing a month eg. January
	 * @return An integer which represents the month eg. January = 1..December = 12
	 */
	private String monthToInt(String month){

		String[] months = {"JANUARY","FEBRUARY","MARCH","APRIL","MAY",
				"JUNE","JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"};
		String[] shortMonths = {"JAN","FEB","MAR","APR","MAY","JUN","JUL",
									"AUG","SEP","OCT","NOV","DEC"};
		for(int i = 0; i < 12; i++){
			if(month.equalsIgnoreCase(months[i]) || month.equalsIgnoreCase(shortMonths[i]))
				if(i < 9)
					return "0" + (i + 1);
				else
					return (i+1) + "";
		}
		return "";
	}
	
	/**
	 * Responsible for managing time inputs.<br>
	 * Takes the time section of a string along with an offset or time zone
	 * and transforms it into the appropriate format which will be 
	 * concatenated with the date.
	 * @param An array of Strings that holds the time.
	 * @return Time in THH:MM:SS+00:00 format
	 */
	private String timeSplitter(String[] time){
		String[] timeSplit = time[0].split(":"); 
		
		//Make sure single digit values have a 0 added in front
		if(Integer.parseInt(timeSplit[0]) < 10)
			timeSplit[0] = "0" + Integer.parseInt(timeSplit[0]);
//		if(Integer.parseInt(timeSplit[1]) < 10)
//			timeSplit[1] = "0" + Integer.parseInt(timeSplit[1]);
		
		//HH:MM:SS
		if(time.length == 1){
			
			if(timeSplit.length == 2)
				return "T" + timeSplit[0] + ":" + timeSplit[1]  + "-08:00";
			
			else if(timeSplit.length == 3){
				if(Integer.parseInt(timeSplit[2]) < 10)
					timeSplit[2] = "0" + Integer.parseInt(timeSplit[2]);
				return "T" + timeSplit[0] + ":" + timeSplit[1] + ":" + timeSplit[2] + "-08:00";
			}
		}
		
		//HH:MM:SS AM/PM OR Zone OR Offset
		else if(time.length == 2){
			//If the String ends in AM
			if(time[1].equalsIgnoreCase("AM")){
				
				if(Integer.parseInt(timeSplit[0]) == 12)
					timeSplit[0] = "00";
				
				if(timeSplit.length == 2)
					return "T" + timeSplit[0] + ":" + timeSplit[1] + "-08:00";
				
				else if(timeSplit.length ==3){
					if(Integer.parseInt(timeSplit[2]) < 10)
						timeSplit[2] = "0" + Integer.parseInt(timeSplit[2]);
					return "T" + timeSplit[0] + ":" + timeSplit[1] + ":" + timeSplit[2] + "-08:00";
				}
			}
			//If the String ends in PM
			else if(time[1].equalsIgnoreCase("PM")){
				
				if(Integer.parseInt(timeSplit[0]) < 12)
					timeSplit[0] = "" + (Integer.parseInt(timeSplit[0]) + 12);
				
				if(timeSplit.length == 2)
					return "T" + timeSplit[0] + ":" + timeSplit[1] + "-08:00";
				
				else if(timeSplit.length ==3){
					if(Integer.parseInt(timeSplit[2]) < 10)
						timeSplit[2] = "0" + Integer.parseInt(timeSplit[2]);
					return "T" + timeSplit[0] + ":" + timeSplit[1] + ":" + timeSplit[2] + "-08:00";
				}
			}
			//If the String contains the offset
			else if(time[1].charAt(0) == '+' || time[1].charAt(0) == '-'){
				if(Integer.parseInt(timeSplit[0]) < 12)
					timeSplit[0] = "" + (Integer.parseInt(timeSplit[0]) + 12);
				
				if(timeSplit.length == 2)
					return "T" + timeSplit[0] + ":" + timeSplit[1] + timeZone(time[1]);
				
				else if(timeSplit.length ==3){
					if(Integer.parseInt(timeSplit[2]) < 10)
						timeSplit[2] = "0" + Integer.parseInt(timeSplit[2]);
					return "T" + timeSplit[0] + ":" + timeSplit[1] + ":" + timeSplit[2] + timeZone(time[1]);
				}
			}
			//If the String contains a time zone
			else{

				double zone = (TimeZone.getTimeZone(time[1]).getRawOffset() *.001/3600);
				String zones;
				if(zone < 0){
					double zo = Math.abs(zone);
					zones = String.format("-%05.2f", zo).replace('.', ':');
				}
				else{
					double zo = Math.abs(zone);
					zones = String.format("+%05.2f", zo).replace('.', ':');
				}

				if(Integer.parseInt(timeSplit[0]) < 12)
					timeSplit[0] = "" + (Integer.parseInt(timeSplit[0]) + 12);
				
				if(timeSplit.length == 2)
						return "T" + timeSplit[0] + ":" + timeSplit[1] + zones;

				else if(timeSplit.length ==3){
					if(Integer.parseInt(timeSplit[2]) < 10)
						timeSplit[2] = "0" + Integer.parseInt(timeSplit[2]);
					return "T" + timeSplit[0] + ":" + timeSplit[1] + ":" + timeSplit[2] + zones;
				}
			}
		}
		return "";
	}
}
