import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author EddyAlfaroCordoba
 *
 */

public class HammingDist{
	
	private static String[] stations = getStations();
	
	private static final String DEFAULT_STATION = "NRMN";
	private String cityOne;
	private String cityTwo;
	
	private static final int STARTING_LINE = 5;
	private int hdCityOne;
	private int hdCityTwo;
	private int[] hdStationsCityOne;
	private int[] hdStationsCityTwo;
	private int hdCityOneRepetition;
	private int hdCityTwoRepetition;
	
	public HammingDist(String word1, String word2){
		this.cityOne = word1;
		this.cityTwo = word2;
		
		hdCityOne = findHammingDistance(word1, DEFAULT_STATION);
		hdCityTwo = findHammingDistance(word2, DEFAULT_STATION);
		
		hdStationsCityOne = findHammingDistance(word1, stations);
		hdStationsCityTwo = findHammingDistance(word2, stations);
		
		hdCityOneRepetition = findRepetitionsWithinArray(hdCityOne, hdStationsCityOne);
		hdCityTwoRepetition = findRepetitionsWithinArray(hdCityTwo, hdStationsCityTwo);
	}
		
	public String toString() {		
		return "The Hamming distance between Norman and " + cityOne + " is " 
	+ hdCityOne + "; between Norman and " + cityTwo + " is " + hdCityTwo + "." + '\n' 
	+ "For " + cityOne + ": Number of stations with Hamming Distance " + hdCityOne + ": "
	+ hdCityOneRepetition + "." + '\n'
	+ "For " + cityTwo + ": Number of stations with Hamming Distance " + hdCityTwo + ": "
	+ hdCityTwoRepetition + ".";
	}
	
	private static String[] readFile(String fileName) {
		//System.out.println("File being read");
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader(fileName));//opens file
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Stream<String> lineStream = reader.lines(); //pushes the lines of the files into a stream of strings
		String[] linesReadInFile = lineStream.toArray(String[]::new); //turns the stream of strings into an array
		
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		lineStream.close();
		
	/*	System.out.println("file read:" + '\n');

		for(int i = 0; i < linesReadInFile.length; i++) {
			System.out.println(linesReadInFile[i]);
		}
	*/	
		
		//System.out.println('\n' + "obtaining first value of every line");
		
		return linesReadInFile;
	}
	
	private static String[] getStations() {
		String[] linesReadInFile = readFile("Mesonet.txt");//calls to read file and obtain he lines in the file
		
		for(int i = 0; i < linesReadInFile.length; i++) {
			linesReadInFile[i] = linesReadInFile[i].trim();//takes leading and ending blank spaces from each line
			linesReadInFile[i] = linesReadInFile[i].split(" ",2)[0];//splits into two the line using as a delimiter a blank space and assigns the first value of the line before a space
			linesReadInFile[i] = linesReadInFile[i].trim();//trims down the obtained value from the line
		}
		
		return Arrays.copyOfRange(linesReadInFile, STARTING_LINE, linesReadInFile.length);//returns a copy of the array trimming it to the start of the STIDs
	}
	
	public String getCityOne() {
		return cityOne;
	}

	public String getCityTwo() {
		return cityTwo;
	}

	public int getHdCityOne() {
		return hdCityOne;
	}

	public int getHdCityTwo() {
		return hdCityTwo;
	}

	public int[] getHdStationsCityOne() {
		return hdStationsCityOne;
	}

	public int[] getHdStationsCityTwo() {
		return hdStationsCityTwo;
	}

	public int getHdCityOneRepetition() {
		return hdCityOneRepetition;
	}

	public int getHdCityTwoRepetition() {
		return hdCityTwoRepetition;
	}

	public static int findHammingDistance(String word, String compareTo) {
		
		//spliting both String into a character array
		char[] compare = compareTo.toCharArray();
		char[] base = word.toCharArray();
		int hammingNumber = 0;
		
		if (compare.length != base.length) {//compares the length of the strings and returns -1 if 
			return -1;						//they have different sizes
		}
		
		//System.out.println("calculating hamming distance between " + word 
			//	+ " and " + compareTo);
		
		for (int i = 0; i < compare.length; i++) { //counts the differences of the character arrays			
			if (compare[i] != base[i]) {		   //the hamming number is incremented every time a difference is found	
				hammingNumber++;
			}
		}
		
		//System.out.println("hamming distance found. HammingNumber: " + hammingNumber + '\n');
		
		return hammingNumber;
	}
	
	public static int[] findHammingDistance(String word, String[] array) {
		
		int[] arrayOfHammingNumbers = new int[array.length];
		
		for (int index = 0; index < array.length; index++) {//uses the previous method to find hamming distance between a given
															//word and words within the array
			
			arrayOfHammingNumbers[index] = findHammingDistance(word, array[index]);
			
		}
		
		return arrayOfHammingNumbers;
	}

	public static int findRepetitionsWithinArray(int key, int[] array) {
		
		int repetition = 0;
		
		for (int index = 0; index < array.length; index++) {//loop to find number of times key is wihtin array
			
			if (key == array[index]) {
				repetition++;
			}
			
		}
		
		return repetition;
	}
}