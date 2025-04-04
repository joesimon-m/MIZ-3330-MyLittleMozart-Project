package factories.abstractmidi;

public class LegatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract{

	/**
	 * createFactory method that returns a new LegatoMidiEventFactory
	 * 
	 * @return		a new LegatoMidiEventFactory() object
	 */
	@Override
	public MidiEventFactory createFactory() {
		return new LegatoMidiEventFactory();
	}

}
