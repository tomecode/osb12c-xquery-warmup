package com.tomecode.oracle.osb12c.warmup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.xmlbeans.XmlObject;

import com.bea.wli.config.Ref;

/**
 * Utilities
 * 
 * @author Tome
 *
 */
public final class Utils {
	/**
	 * dummy empty message
	 */
	public static final XmlObject DUMMY_MESSAGE = dummyMessage();

	private static final XmlObject dummyMessage() {
		try {
			return XmlObject.Factory.parse("<soap:Body xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope/\"><AnyElement/></soap:Body>");
		} catch (Exception e) {
			throw new RuntimeException("Failed to unitialize dummmy body!, reason: " + e.getMessage(), e);
		}
	}

	/**
	 * format delta time
	 * 
	 * @param td
	 * @return
	 */
	public static final String formatDeltaTime(long td) {
		td = td / 1000;
		int h = (int) (td / (3600));
		int m = (int) ((td - (h * 3600)) / 60);
		int s = (int) (td - (h * 3600) - m * 60);
		return String.format("%02d:%02d:%02d", h, m, s);
	}

	/**
	 * split array of refs to sub-arrays
	 * 
	 * @param originalArray
	 * @param chunkSize
	 * @return
	 */
	public static final List<Ref[]> splitRefs(Ref[] originalArray, int chunkSize) {
		List<Ref[]> listOfArrays = new ArrayList<Ref[]>();
		int totalSize = originalArray.length;
		if (totalSize < chunkSize) {
			chunkSize = totalSize;
		}
		int from = 0;
		int to = chunkSize;

		while (from < totalSize) {
			Ref[] partArray = Arrays.copyOfRange(originalArray, from, to);
			listOfArrays.add(partArray);

			from += chunkSize;
			to = from + chunkSize;
			if (to > totalSize) {
				to = totalSize;
			}
		}
		return listOfArrays;
	}

}
