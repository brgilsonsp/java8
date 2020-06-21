# Java 8

Aulas do curso Java 8: Tire proveito dos novos recursos da Linguagem, ministrado no Alura Cursos EAD.

## **Default Methods**

O `Default Method` é um recurso que permite a evolução de uma `interface` sem quebrar as classes que já implementam essa interface.

Esse recurso foi incorporado no Java a partir do Java 8 e já existe em outras linguagens como Scala e C#, por exemplo.

Para implementar um `default method` na sua interface, você deve inserir um método com o modificador **dafault** e obrigatóriamente um corpo. Agora as interefaces podem ter comportamentos implementados.

Na versão 8 do Java, as APIs de lista receberam vários `default methods` em suas estruturas como, por exemplo, o método `foreach()` da API List, o método `stream()` entre outros. A evolução dessas interfaces só foram possíveis com a adição do default methods, caso contrário todas as classes que implementam essas APIs quebrariam.

Exemplo de um default method:
 

```
public interface DefaulMethodService {
	
	void foo();
	
	Object getFoo();
	
	default Object getDefaultFoo() {
		return new Object();
	}

}

```

Exemplos:
 
 * br.com.gilson.estudo.java8.DeaultMethods
 * br.com.gilson.estudo.java8.service.DefaulMethodService

---


## **Lambdas**

Lambda permite o uso de uma [Functional Interface](https://docs.oracle.com/javase/8/docs/api/index.html?java/lang/FunctionalInterface.html) sem a necessidade de criar classe anônima ou implementar a interface.

Ao invocar um método que aguarda no seu parâmetro um tipo de uma determinada interface funcional utilizando o lambda, o compilador consegue inferir o tipo, em tempo de compilação.

Para implementar uma interface funcional utilizando um lambda devemos utilizar a seguinte sintaxe: `(param1, param2, paramN) -> { implementação }`. Você não precisa informar os tipos dos parâmetros, pois o compilador consegue inferi-los conhecendo a interface funcional, os parênteses são opcionais se o método recebe apenas um parâmetros caso contrário deve inserir os parênteses e caso não receba nenhum parâmetro deve colocar os parênteses vazios. Deve separar os parâmetros do bloco da implementação com o símbolo do lambda `->`. Se o corpo possui apenas um statement, então não será necessário os colchetes `{}` nem `;` no final do statement, porém se possui mais de um stetament então os colchetes e o `;` serão obrigatórios para delimitar o corpo da sua implementação e cada stetament, respectivamente. Se o método retornar algum valor e possui apenas um statment, não é necessário a palavra reservada `return`, pois o compilador inferirá o retorno em tempo de execução, porém caso tenha mais de um stetament deve inserir a palavra reservada `return`.
 

Exemplo de uma Interface Funcional que retorna um Integer e não recebe parâmetros.

```
@FunctionalInterface
public interface ReturnFoo {

	Integer getFoo();
}
```

Aqui temos um método que espera um tipo da interface funcional `ReturnFoo`. Note que a implementação é normal, recebe o objeto e consome o método, sem nenhuma alteração como já conhecemos

```
private void printValueInterface(final ReturnFoo returnFoo) {
	
	System.out.println(returnFoo.getFoo());
}
```

Agora para invocar o método acima passando um objeto do tipo `FooWithReturnAndNoParam` utilizaremos o lambda. Vamos definir o tipo que esperamos, porém ao invés de utilizar a palavrada reserva `new` para criar uma classe anônima iremos usufruir do benefício do lambda. Note que o método da interface não espera nenhum parâmetro, então inserimos os parênteses vazio. Depois iremos utilizar o símbolo do lambda `->`, aonde o compilador saberá interpretar a nossa implementação. Na sequência iremos implementar a nossa interface. Note que é semelhante a implementação de uma classe anônima, um pouco mais simples pois não foi necessário inserir o nome do método, po exemplo. 


```
public void implementaInterfaceCompletoEPassaObjetoParaMetodo() {
	
	ReturnFoo returnFoo = () -> {
		return 1;
	};
	
	this.printValueInterface(returnFoo);
}
```

Agora podemos deixar ainda mais simples essa implementação pois iremos apenas retornar o valor **1**, então podemos fazer tudo isso em apenas um statement. Com isso não será necessário os colchetes, o ponto e vírgula nem a palavra reservada `return`. muito mais simples:

```
public void implementaInterfaceSimplificadoEEnviarObjetoParaMetodo() {
	
	ReturnFoo returnFoo = () -> 1;
	this.printValueInterface(returnFoo);
}
```

Já nesse exemplo utilizando o lambda direto ao invocar o método, utilizando a forma simplificado, porém poderíamos utilizar a forma "completa" também, sem nenhum problema:

```
public void implementaInterfaceDentroDaChamadaDoMetodo() {
	
	this.printValueInterface(() -> 1);
}
```

Agora vamos criar uma Functional Interface que recebe um Functiona Interface como parâmetro

```
@FunctionalInterface
public interface DoFoo {

	void doSomething(ReturnFoo param);
}
```

Para implementar a nossa Functional Interface **DoFoo** iremos aguardar um objeto do tipo `ReturnFoo` e fazer alguma coisa com esse retorno, no nosso exemplo iremos somar com o valor do parâmetro e imprimir no console:

```
package br.com.gilson.estudo.java8.service;

public class UseDoFoo {
	
	public DoFoo doFoo(final Integer param) {
		return (s1) -> System.out.println(Integer.sum(s1.getFoo(), param));
	}

}
```

Nossos testes
```
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
```


Fontes:
 * br.com.gilson.estudo.java8.LambdasTest
 * br.com.gilson.estudo.java8.service.ReturnFoo
 * br.com.gilson.estudo.java8.service.UseReturnFoo
 * br.com.gilson.estudo.java8.service.DoFoo
 * br.com.gilson.estudo.java8.service.UseDoFoo



---
