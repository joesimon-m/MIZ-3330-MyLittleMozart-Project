package factories.abstractmidi;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.InvalidMidiDataException;

public interface MidiEventFactory {
	/**
	 * createNoteOn is declared for other factory classes to be implemented for NOTE_ON
	 * 
	 * @param tick							position at which note should occur	from MIDI class
	 * @param note							note number apart of MIDI class
	 * @param velocity						velocity of the note from MIDI class
	 * @param channel						MIDI channel for which the note is displayed
	 * @return								a MidiEvent
	 * @throws InvalidMidiDataException		throws an exception when data is invalid
	 */
	MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException;
	
	/**
	 * createNoteoff is declared for other factory classes to be implemented for NOTE_OFF
	 * 
	 * @param tick							position at which note should occur from MIDI class
	 * @param note							note number apart of MIDI class
	 * @param channel						MIDI channel for which the note is displayed
	 * @return								a MidiEvent
	 * @throws InvalidMidiDataException		throws an exception when data is invalid
	 */
	MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException;
}
