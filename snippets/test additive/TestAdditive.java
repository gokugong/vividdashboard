import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import java.util.*;

public class TestAdditive {	
	@Before
	public void setUp() {
		setAllPrimes();
	}
	
	@After
	public void tearDown() {
		myPrimes = null;
	}

	@Test
	public void testSecret() {
		assertEquals("SomeSecret.secretFunc1 is additive", isAdditiveFunc1(), true);
		assertEquals("SomeSecret.secretFunc2 is not additive", isAdditiveFunc2(), false);
	}

	private int testWrap1(int x) {
		return SomeSecret.secretFunc1(x);
	}
	
	private int testWrap2(int x) {
		return SomeSecret.secretFunc2(x);
	}

	private static boolean isPrime(int n) {
		if (n < 2) return false;
		
		int aHalf = n / 2 + 1;
		for (int i = 2; i < aHalf; ++i) {
			if (n % i == 0) return false;
		}
		return true;
	}
	
	private static void setAllPrimes() {
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i = 2; i <= myLimit; ++ i) {
			if (isPrime(i)) list.add(Integer.valueOf(i));
		}
		
		Integer[] nums = list.toArray(new Integer[list.size()]);
		myPrimes = new int[nums.length];
		for (int i = 0; i < nums.length; ++i) {
			myPrimes[i] = nums[i].intValue();
		}
	}
	
	private boolean isAdditiveFunc1() {
		for (int i = 0; i < myPrimes.length; ++i) {
			int x = myPrimes[i];
			for (int j = 0; j <= i; ++j) {
				int y = myPrimes[j];
				if (testWrap1(x + y) != testWrap1(x) + testWrap1(y)) return false;
			}
		}
		return true;
	}
	
	private boolean isAdditiveFunc2() {
		for (int i = 0; i < myPrimes.length; ++i) {
			int x = myPrimes[i];
			for (int j = 0; j <= i; ++j) {
				int y = myPrimes[j];
				if (testWrap2(x + y) != testWrap2(x) + testWrap2(y)) return false;
			}
		}
		return true;
	}

	private static final int myLimit = 100;
	private static int[] myPrimes = null;
}
