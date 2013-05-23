package org.Sort;

import static org.junit.Assert.*;

import org.junit.Test;

import org.Sort.MergeSort;
import java.util.*;

public class SortTest {

	@Test
	public void testSort() {
		List<Integer> nums = Arrays.asList(40, 10, 20);
		List<Integer> sortedNums = Arrays.asList(10, 20, 40);
		MergeSort m = new MergeSort(nums);
		List<Integer> results = m.sortNumbers();
		System.out.println(results);
		System.out.println(m.numbers);
		assertEquals(results, (List<Integer>)sortedNums);
	}

}
