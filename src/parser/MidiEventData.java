package parser;

public class MidiEventData {
	private int startEndTick, velocity, note, channel, noteOnOff;
	private int instrument;
	
	/**
	 * Constructor for the MidiEventData class 
	 * 
	 * @param startEndTick		int value indicating the starting tick
	 * @param velocity			int value indicating the velocity 
	 * @param note				int value indicating which note is being used
	 * @param channel			int value indicating the channel of the data
	 * @param instrument		int value determining which instrument is used
	 * @param noteOnOff			int value indicating whether the note is on or off
	 */
	public MidiEventData(int startEndTick, int velocity, int note,
			int channel, int instrument, int noteOnOff) {
		this.startEndTick = startEndTick;
		this.velocity = velocity;
		this.note = note;
		this.channel = channel;
		this.noteOnOff = noteOnOff;
		this.instrument = instrument;
	}

	/**
	 * getStartEndTick getter method
	 * 
	 * @return 		the startEndTick of this object
	 */
	public int getStartEndTick() {
		return startEndTick;
	}

	/**
	 * setStartEndTick setter method
	 * 
	 * @param startEndTick		tick to be set to this object's startEndTick
	 */
	public void setStartEndTick(int startEndTick) {
		this.startEndTick = startEndTick;
	}

	/**
	 * getVelocity getter method
	 * 
	 * @return		returns the velocity of this object
	 */
	public int getVelocity() {
		return velocity;
	}

	/**
	 * setVelocity setter method
	 * 
	 * @param velocity		int value velocity to be assigned to this object's velocity variable
	 */
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	/**
	 * getNote getter method
	 * 
	 * @return	returns this object's int value note
	 */
	public int getNote() {
		return note;
	}

	/**
	 * setNote setter method
	 * 
	 * @param note		int value note to be assigned to this object's note variable
	 */
	public void setNote(int note) {
		this.note = note;
	}

	/**
	 * getChannel getter method
	 * 
	 * @return		returns this object's int channel variable
	 */
	public int getChannel() {
		return channel;
	}

	/**
	 * setChannel setter method
	 * 
	 * @param channel 		int channel value to be assigned to this object's channel value
	 */
	public void setChannel(int channel) {
		this.channel = channel;
	}

	/**
	 * getNoteOnOff getter method
	 * 
	 * @return		returns this object's noteOnOff integer value
	 */
	public int getNoteOnOff() {
		return noteOnOff;
	}

	/**
	 * setNoteOnOff setter method
	 * 
	 * @param noteOnOff			int value note to be stored inside of this object's noteOnOff variable
	 */
	public void setNoteOnOff(int noteOnOff) {
		this.noteOnOff = noteOnOff;
	}

	/**
	 * getInstrument getter method
	 * 
	 * @return		returns the int value instrument for this object
	 */
	public int getInstrument() {
		return instrument;
	}

	/**
	 * setInstrument setter method
	 * 
	 * @param instrument		int value instrument to be stored inside of this object's instrument variable
	 */
	public void setInstrument(int instrument) {
		this.instrument = instrument;
	}
	
	
}
