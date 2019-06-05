package in.amal.rpg.gameofstones.controller.util;

import java.util.List;

public class MyListUtils {
	public static int[] indexesToArray(List<?> list) {
		int[] indexes = null;
		if (list != null) {
			indexes = new int[list.size()];
			for (int i = 0; i < list.size(); i++) {
				indexes[i] = i;
			}
		}
		return indexes;
	}
}
