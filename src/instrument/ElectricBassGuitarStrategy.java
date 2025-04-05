package instrument;

import javax.sound.midi.Track;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

/**
 * Instrument strategy that sets the instrument to Electric Bass Guitar (MIDI instrument 33).
 */
public class ElectricBassGuitarStrategy implements InstrumentStrategy{
	/*
	 * Applies the electric bass guitar instrument (33) to the specified channel.
	 * PROGRAM_CHANGE used to change the instrument on the given channel.
	 * 
	 * @param track the MIDI track to apply the instrument change
	 * @param channel the MIDI channel to set the instrument on 
	 * @throws InvalidMidiDataException if the MIDI data is invalid
	 */
	
	@Override
	public void applyInstrument(Track track, int channel) throws InvalidMidiDataException{
		ShortMessage message = new ShortMessage();
		//Set PROGRAM_CHANGE message: command, channel, instrument, and unused data
		message.setMessage(ShortMessage.PROGRAM_CHANGE, channel, 33, 0);
		MidiEvent event = new MidiEvent(message,0);
		track.add(event);
	}
}
