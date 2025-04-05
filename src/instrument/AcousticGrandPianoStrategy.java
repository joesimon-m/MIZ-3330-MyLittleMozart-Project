package instrument;

import javax.sound.midi.Track;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

/**
 * Instrument strategy that sets the instrument to Acoustic Grand Piano (MIDI instrument 0).
 */
public class AcousticGrandPianoStrategy implements InstrumentStrategy {

    /**
     * Applies the Acoustic Grand Piano instrument (0) to the specified channel.
     *
     * @param track   the MIDI track to apply the instrument change
     * @param channel the MIDI channel to set the instrument on
     * @throws InvalidMidiDataException if the MIDI data is invalid
     */
    @Override
    public void applyInstrument(Track track, int channel) throws InvalidMidiDataException {
        ShortMessage message = new ShortMessage();
        message.setMessage(ShortMessage.PROGRAM_CHANGE, channel, 0, 0);
        MidiEvent event = new MidiEvent(message, 0);
        track.add(event);
    }
}
