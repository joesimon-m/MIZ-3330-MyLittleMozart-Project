package parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MidiCsvParser {
	
	/**
	 * parseCsv method goes through the csv file, and stores each variable inside of a 
	 * MidiEventData object (for the whole line). A list is created for each line, and is returned
	 * 
	 * @param filename			string name of the location for the csv file
	 * @return					returns the lines list of MidiEventData
	 * @throws IOException		throws an IOException when an error is caught
	 */
	public static List<MidiEventData> parseCsv(String filename) throws IOException{
		BufferedReader reader = null;
		List<MidiEventData> lines = new ArrayList<MidiEventData>();
		
		try {
			reader = new BufferedReader(new FileReader(filename));
			String line;
			
			// reading through each line inside of the csv file
			while((line = reader.readLine()) != null) {
				// separates each value by a comma
				String[] values = line.split(",");
				
				int noteOnOff;
				int startEndTick = Integer.parseInt(values[0]);
				int channel = Integer.parseInt(values[2]);
				int note = Integer.parseInt(values[3]);
				int velocity = Integer.parseInt(values[4]);
				int instrument = Integer.parseInt(values[5]);
				
				if(values[1].equals(" Note_on_c")) {
					noteOnOff = 1;
				} else if (values[1].equals(" Note_off_c")) {
					noteOnOff = 0;
				} else {
					// throws an exception if noteOnOff is invalid (problem inside of csv file)
					throw new IllegalArgumentException("Unrecognized noteOnOff value: " + values[1]);
				}
				
				MidiEventData midiLine = new MidiEventData(startEndTick, 
						velocity, note, channel, instrument, noteOnOff);
				
				lines.add(midiLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// tries to close the reader BufferedReader, and if it fails, and error is thrown
			try { 
	            reader.close();
	        } catch (IOException e) {
	            e.printStackTrace(); 
	        }
		}
		
		return lines;
	}

}
