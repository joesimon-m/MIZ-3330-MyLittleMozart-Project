package factories.abstractmidi;

public class StaccatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract{

	/**
	 * createFactory creates a new StaccatoMidiEventFactory
	 * 
	 * @return		a new StaccatoMidiEventFactory object
	 */
	@Override
	public MidiEventFactory createFactory() {
		return new StaccatoMidiEventFactory();
	}

}
