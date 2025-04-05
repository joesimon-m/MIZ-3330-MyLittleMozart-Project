package pitch;

/**
 * Implementation of PitchStrategy that raises the pitch by 2 semitones.
 */
public class HigherPitchStrategy implements PitchStrategy {

    /**
     * Increases the note by 2 semitones.
     * 
     * @param note the original note value
     * @return the note value increased by 2
     */
    @Override
    public int modifyPitch(int note) {
        return note + 2;
    }
}
