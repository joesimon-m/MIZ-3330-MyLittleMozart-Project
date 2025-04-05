package parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.ShortMessage;

/**
 * Parses a CSV file and converts each line into MidiEventData object
 */
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
		
		
		List<MidiEventData> lines = new ArrayList<MidiEventData>();
		
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
			String line;
			
			// reading through each line inside of the csv file
			while((line = reader.readLine()) != null) {
				
				// Skipping any empty line
				if(line.trim().isEmpty()) {
					continue;
				}
				
				//Seperating each value by the comma
				String[] values = line.split(",");
				
				//Checking if the line has at least 6 values if not we skip it
				if(values.length < 6) {
					System.err.println("Skipping abnormal line (Not at least 6 values): " + line);
					continue;
				}
				
				//For each value we trim the whitespace and remove the surrounding quotes if they exsist
				for (int i=0; i < values.length; i++) {
					values[i] = values[i].trim();
					if (values[i].startsWith("\"") && values[i].endsWith("\"")) {
						values[i] = values[i].substring(1, values[i].length() - 1);
					}
				}
				
				int noteOnOff;
				int startEndTick = Integer.parseInt(values[0]);
				int channel = Integer.parseInt(values[2]);
				int note = Integer.parseInt(values[3]);
				int velocity = Integer.parseInt(values[4]);
				int instrument = Integer.parseInt(values[5]);
				
				// Comparing the event type against its expected values after trimming
				if(values[1].equals("Note_on_c")) {
					//noteOnOff = 1;
					noteOnOff = ShortMessage.NOTE_ON;
				} else if (values[1].equals("Note_off_c")) {
					//noteOnOff = 0;
					noteOnOff = ShortMessage.NOTE_OFF;

				} else {
					// throws an exception if noteOnOff is invalid (problem inside of csv file)
					throw new IllegalArgumentException("Unrecognized noteOnOff value: " + values[1]);
				}
				
				// Create a new MidiEventData object with the parsed values
				MidiEventData midiLine = new MidiEventData(startEndTick, 
						velocity, note, channel, instrument, noteOnOff);
				
				lines.add(midiLine);
			}
		}
		
		return lines;
	}

}
