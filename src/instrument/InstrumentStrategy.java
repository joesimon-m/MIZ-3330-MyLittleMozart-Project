package instrument;


import javax.sound.midi.Track;
import javax.sound.midi.InvalidMidiDataException;

/**
 * Interface for applying an instrument change to a MIDI track.
 */
public interface InstrumentStrategy {
	/*
	 * Applies an instrument change to the specified track and channel.
	 * 
	 * @param track the MIDI track to which instrument change is applied
	 * @param channel the MIDI channel to set the instrument
	 * @throws InvalidMidiDataException if the MIDI data is invalid
	 */
	void applyInstrument(Track track, int channel) throws InvalidMidiDataException;

}
