package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class UnitTest {

	@Test(expected = IndexOutOfBoundsException.class)
	public void Exception() {
		List ls = new ArrayList<>();

		ls.get(1);
	}

}
