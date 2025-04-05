package pitch;

/**
 * Interface for modifying the pitch of a note.
 */
public interface PitchStrategy {
    /**
     * Modifies the given note value.
     * 
     * @param note the original note value
     * @return the modified note value
     */
    int modifyPitch(int note);
}
