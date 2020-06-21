package br.com.gilson.estudo.java8.service;

public class UseReturnFoo {
	
	/**
	 * Invoca um método que aguarda um parâmetro do tipo da interface funcional {@link ReturnFoo}. Ao invocar o método 
	 * é inferido um tipo da interface funcional aguardada através do lambda
	 */
	public void implementaInterfaceDentroDaChamadaDoMetodo() {
		
		this.printValueInterface(() -> 1);
	}

	/**
	 * Implementa a interface funcional {@link ReturnFoo} utilizando lambda e invoca um método que aguarda um parâmetro do 
	 * tipo da interface funcional
	 */
	public void implementaInterfaceCompletoEPassaObjetoParaMetodo() {
		
		ReturnFoo fooWithReturnAndNoParam = () -> {
			return 1;
		};
		
		this.printValueInterface(fooWithReturnAndNoParam);
	}
	
	/**
	 * Implementa a interface funcional {@link ReturnFoo} utilizando lambda e invoca um método que aguarda um parâmetro do 
	 * tipo da interface funcional
	 */
	public void implementaInterfaceSimplificadoEEnviarObjetoParaMetodo() {
		
		ReturnFoo foo = () -> 1;
		this.printValueInterface(foo);
	}
	
	/**
	 * Recebendo uma interface functional no parâmetro e imprime o valor
	 * 
	 * @param foo FooWithReturnAndNoParam
	 */
	private void printValueInterface(final ReturnFoo foo) {
		
		System.out.println(String.format("ReturnFoo foi criado com o valor de %d", foo.getFoo()));
	}
	
}
