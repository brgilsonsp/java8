package br.com.gilson.estudo.java8;

import java.util.Comparator;

import br.com.gilson.estudo.java8.service.DefaulMethodService;

public class DeaultMethods {

	public static void main(String[] args) {
		DefaulMethodService defaultMethods = new DefaulMethodServiceImpl();
		defaultMethods.printWords(new WordsSize());
	}
}

class WordsSize implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {
		if(s1.length() < s2.length())
			return -1;
		
		if(s1.length() > s2.length())
			return 1;
		
		return 0;
	}
	
}

class DefaulMethodServiceImpl implements DefaulMethodService{
	@Override
	public void foo() {
	}
	@Override
	public Object getFoo() {
		return new Object();
	}
}
