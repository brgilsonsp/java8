package br.com.gilson.estudo.java8.service;

public class UseDoFoo {
	
	public DoFoo doFoo(final Integer param) {
		return (s1) -> System.out.println(Integer.sum(s1.getFoo(), param));
	}

}
