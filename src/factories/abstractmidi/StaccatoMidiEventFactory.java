package factories.abstractmidi;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

public class StaccatoMidiEventFactory implements MidiEventFactory{

	/**
	 * Creates and returns a MidiEvent with NOTE_ON
	 * 
	 * @param tick							position at which note should occur	from MIDI class
	 * @param note							note number apart of MIDI class
	 * @param velocity						velocity of the note from MIDI class
	 * @param channel						MIDI channel for which the note is displayed
	 * @return								a MidiEvent
	 * @throws InvalidMidiDataException		throws an exception when data is invalid
	 */
	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();
		message.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
		return new MidiEvent(message, tick-120);
	}

	/**
	 * Creates and returns a MidiEvent for NOTE_OFF
	 * 
	 * @param tick							position at which note should occur from MIDI class
	 * @param note							note number apart of MIDI class
	 * @param channel						MIDI channel for which the note is displayed
	 * @return								a MidiEvent
	 * @throws InvalidMidiDataException		throws an exception when data is invalid
	 */
	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();
		message.setMessage(ShortMessage.NOTE_OFF, channel, note);
		return new MidiEvent(message, tick-120);
	}

}
