package br.com.gilson.estudo.java8;

import br.com.gilson.estudo.java8.service.UseDoFoo;
import br.com.gilson.estudo.java8.service.UseReturnFoo;

public class LambdasTest {

	public static void main(String[] args) {
		
		System.out.println("<--- Interface Funcional  que retorna Integer e não recebe parâmetros --->");
		UseReturnFoo useReturnFoo = new UseReturnFoo();
		useReturnFoo.implementaInterfaceDentroDaChamadaDoMetodo();
		useReturnFoo.implementaInterfaceCompletoEPassaObjetoParaMetodo();
		useReturnFoo.implementaInterfaceSimplificadoEEnviarObjetoParaMetodo();
		
		
		System.out.println("<--- Interface Funcional  recebe parâmetro e faz alguma coisa --->");
		new UseDoFoo().doFoo(5).doSomething(() -> 8);
	}

}
