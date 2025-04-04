package factories.abstractmidi;

public class StandardMidiEventFactoryAbstract implements MidiEventFactoryAbstract{

	/**
	 * createFactory creates a new StandardMidiEventFactory
	 * 
	 * @return		a new StandardMidiEventFactory object
	 */
	@Override
	public MidiEventFactory createFactory() {
		return new StandardMidiEventFactory();
	}

}
