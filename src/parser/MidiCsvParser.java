package parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MidiCsvParser {
	
	public static List<MidiEventData> parseCsv(String filename) throws IOException{
		BufferedReader reader = null;
		List<MidiEventData> lines = new ArrayList<MidiEventData>();
		
		try {
			reader = new BufferedReader(new FileReader(filename));
			String line;
			
			while((line = reader.readLine()) != null) {
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
					throw new IllegalArgumentException("Unrecognized noteOnOff value: " + values[1]);
				}
				
				MidiEventData midiLine = new MidiEventData(startEndTick, 
						velocity, note, channel, instrument, noteOnOff);
				
				lines.add(midiLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// probably unnecessary, but eclipse won't throw any errors when I do it this way
			try { 
	            reader.close();
	        } catch (IOException e) {
	            e.printStackTrace(); 
	        }
		}
		
		return lines;
	}

}
