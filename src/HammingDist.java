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
			reader = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Stream<String> lineStream = reader.lines();
		String[] linesReadInFile = lineStream.toArray(String[]::new);
		
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
		String[] linesReadInFile = readFile("Mesonet.txt");
		
		for(int i = 0; i < linesReadInFile.length; i++) {
			linesReadInFile[i] = linesReadInFile[i].trim();
			linesReadInFile[i] = linesReadInFile[i].split(" ",2)[0];
			linesReadInFile[i] = linesReadInFile[i].trim();
		}
		
		return Arrays.copyOfRange(linesReadInFile, 5, linesReadInFile.length);
	}
	
	public String getWord1() {
		return cityOne;
	}

	public String getWord2() {
		return cityTwo;
	}

	public int getHammingDistWith1() {
		return hdCityOne;
	}

	public int getHammingDistWith2() {
		return hdCityTwo;
	}

	public int[] getHammingNumberWith1() {
		return hdStationsCityOne;
	}

	public int[] getHammingNumberWith2() {
		return hdStationsCityTwo;
	}

	public int getNumOfStationsFromOne() {
		return hdCityOneRepetition;
	}

	public int getNumOfStationsFromTwo() {
		return hdCityTwoRepetition;
	}

	public static int findHammingDistance(String word, String compareTo) {
		
		char[] compare = compareTo.toCharArray();
		char[] base = word.toCharArray();
		int hammingNumber = 0;
		
		if (compare.length != base.length) {
			return -1;
		}
		
		//System.out.println("calculating hamming distance between " + word 
			//	+ " and " + compareTo);
		
		for (int i = 0; i < compare.length; i++) {			
			if (compare[i] != base[i]) {
				hammingNumber++;
			}
		}
		
		//System.out.println("hamming distance found. HammingNumber: " + hammingNumber + '\n');
		
		return hammingNumber;
	}
	
	public static int[] findHammingDistance(String word, String[] array) {
		
		int[] arrayOfHammingNumbers = new int[array.length];
		
		for (int index = 0; index < array.length; index++) {
			
			arrayOfHammingNumbers[index] = findHammingDistance(word, array[index]);
			
		}
		
		return arrayOfHammingNumbers;
	}

	public static int findRepetitionsWithinArray(int key, int[] array) {
		
		int repetition = 0;
		
		for (int index = 0; index < array.length; index++) {
			
			if (key == array[index]) {
				repetition++;
			}
			
		}
		
		return repetition;
	}
}