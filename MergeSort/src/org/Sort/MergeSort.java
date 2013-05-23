package org.Sort;

import java.util.*;

public class MergeSort {
	List<Integer> numbers;
	
	public MergeSort(List<Integer> numbers) {
		this.numbers = numbers;
	}
	
	public List<Integer> sortNumbers() {
		return mergeSort(this.numbers);
	}
	
	private List<Integer> mergeSort(List<Integer> numbers) {
		if (numbers.size() < 2) {
			return numbers;
		}
		int mid = numbers.size()/2;
		List<Integer> left = mergeSort(numbers.subList(0, mid));
		List<Integer> right = mergeSort(numbers.subList(mid, numbers.size()));
		return mergeArrays(left, right);
	}
	
	private List<Integer> mergeArrays(List<Integer> left, List<Integer> right){
		int i=0;
		int j=0;
		ArrayList<Integer> result = new ArrayList<Integer>();
		while ((i < left.size()) && (j < right.size())){
			if (left.get(i) < right.get(j)){
				result.add(left.get(i));
				i++;
			} 
			else {
				result.add(right.get(j));
				j++;
			}
		}
		result.addAll(left.subList(i, left.size()));
		result.addAll(right.subList(j, right.size()));

		return result;
	}
}
