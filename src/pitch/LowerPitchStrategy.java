package pitch;

/**
 * Implementation of PitchStrategy that lowers the pitch by 2 semitones.
 */
public class LowerPitchStrategy implements PitchStrategy {

    /**
     * Decreases the note by 2 semitones.
     * 
     * @param note the original note value
     * @return the note value decreased by 2
     */
    @Override
    public int modifyPitch(int note) {
        return note - 2;
    }
}
