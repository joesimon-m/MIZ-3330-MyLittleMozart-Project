package main;

import java.util.List;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

import factories.abstractmidi.MidiEventFactory;
import factories.abstractmidi.MidiEventFactoryAbstract;
import factories.abstractmidi.StandardMidiEventFactoryAbstract;

import instrument.ElectricBassGuitarStrategy;
import instrument.TrumpetStrategy;
import instrument.InstrumentStrategy;
import pitch.PitchStrategy;
import pitch.HigherPitchStrategy;
import parser.MidiCsvParser;
import parser.MidiEventData;


/*
 * Main class that integrates CSV parsing, MIDI event creation via an Abstract factory,
 * pitch modifications, instrument assignments, and play back.
 */
public class Main {

	public static void main(String[] args) {
		try {
			// Parse the CSV file to obtain a list of MidiEventData objects.
			List<MidiEventData> midiEvents = MidiCsvParser.parseCsv("src/files/mystery_song.csv"); // changed the filename from given as it wasn't working for me
			
			//Create a new MIDI sequence
			Sequence sequence = new Sequence(Sequence.PPQ, 384);
			Track track = sequence.createTrack();
			
			//---------------------------------------------------------------------------------
			//Step 1: Uncomment on of the following lines to select the factory you want to use
			//---------------------------------------------------------------------------------
			
			//Standard factory has no note duration modification.
			MidiEventFactoryAbstract factoryAbstract = new StandardMidiEventFactoryAbstract();
			
			//Legato factory increases not duration by 80 ticks
			// MidiEventFactoryAbstract factoryAbstract = new LegatoMidiEventFactoryAbstract();
			
			//Staccato factory decreases note duration by 120 ticks
			// MidiEventFactoryAbstract factoryAbstract = new StaccatoMidiEventFactoryAbstract();
			
			//Create the factory
			MidiEventFactory factory = factoryAbstract.createFactory();
			
			//---------------------------------------------------------------------------------
			// Step 2: Choose an instrument strategy (e.g., Trumpet, Bass Guitar, Piano)
			//---------------------------------------------------------------------------------
			
			//Setting the instrument for channel 0 to Electric Bass Guitar
			InstrumentStrategy instrumentStrategy = new ElectricBassGuitarStrategy();
			instrumentStrategy.applyInstrument(track, 0);
			
			//Setting the instrument for channel 1 to Trumpet
			instrumentStrategy = new TrumpetStrategy();
			instrumentStrategy.applyInstrument(track, 1);
			
			//---------------------------------------------------------------------------------
			// Step 3: Choose a pitch strategy (e.g., HigherPitch, LowerPitch)
			//---------------------------------------------------------------------------------
			
			//HigherPitchStrategy to rasies each note by 2 semitones
			PitchStrategy pitchStrategy = new HigherPitchStrategy();
			
			//LowerPitchStrategy lowers each note by 2 semitones
//			PitchStrategy pitchStrategy = new LowerPitchStrategy();
			
			//---------------------------------------------------------------------------------
			// Step 4:  Generate MIDI events from CSV data
			//---------------------------------------------------------------------------------

			for(MidiEventData event : midiEvents) {
				//Modify the note using the chosen pitch strategy
				int modifiedNote = pitchStrategy.modifyPitch(event.getNote());

				// call this as much as you want if you want to get a higher pitch
//				modifiedNote = pitchStrategy.modifyPitch(modifiedNote);
				
				//Create and add the appropriate MIDI event based on the note
				if(event.getNoteOnOff() == ShortMessage.NOTE_ON) {
					track.add(factory.createNoteOn(event.getStartEndTick(), modifiedNote, event.getVelocity(), event.getChannel()));
					
				}else {
					MidiEvent noteOffEvent = factory.createNoteOff(
	                        event.getStartEndTick(), modifiedNote, event.getChannel()
	                    );
	                    track.add(noteOffEvent);
				}
			}
			
			//---------------------------------------------------------------------------------
			// Step 5: Playing the sequence
			//---------------------------------------------------------------------------------

			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.setSequence(sequence);
			sequencer.start();
			
			//Keep the program running until the sequence has finished playing
			while(sequencer.isRunning() | sequencer.isOpen()) {
				Thread.sleep(100);
			}
			//Extra pause to make sure we get complete playback
			Thread.sleep(500);
			sequencer.close();
			
		} catch (Exception e) {
			//Print any errors that occur during execution.
			e.printStackTrace();
		}
	}

}
