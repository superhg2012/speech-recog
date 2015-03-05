package muster.unittests.preproc;

import muster.sound.*;
import junit.framework.TestCase;

public class ConverterTests extends TestCase implements ByteSource, DoubleSource {
	
	// convert 01110101 01011111
	byte[] bytes = { 95, 117};
	int counter = 0;
	double sample = 30047.0;
	
	public void testByteToDouble() {
		// convert 01110101 01011111 (dec: 30047) to double
		ByteConverter testConverter = new ByteConverter(this);
		assertEquals(30047.0, testConverter.getNextDouble(), Double.parseDouble("1.0E-9"));
	}
	
	public void testDoubleToByte() {
		DoubleConverter testConverter = new DoubleConverter(this);
		assertEquals(95, testConverter.getNextByte());
		assertEquals(117, testConverter.getNextByte());
	}

	@Override
	public byte getNextByte() {
		return bytes[counter++];
	}

	@Override
	public double getNextDouble() {
		return sample;
	}
	
	@Override
	public boolean isFinished() {
		return false;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

}
