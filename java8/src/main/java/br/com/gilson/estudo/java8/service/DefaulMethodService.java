package br.com.gilson.estudo.java8.service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public interface DefaulMethodService {
	
	void foo();
	
	Object getFoo();
	
	default void printWords(Comparator<String> comparator) {
		List<String> words = Arrays.asList("Martinho Lutero", "Paulo", "Jeremias", "Jhon Hans");
		words.sort(comparator);
		
		words.forEach(System.out::println);
	}

}
