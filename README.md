# Java 8

Aulas do curso Java 8: Tire proveito dos novos recursos da Linguagem, ministrado no Alura Cursos EAD.

## **Default Methods**

O `Default Method` � um recurso que permite a evolu��o de uma `interface` sem quebrar as classes que j� implementam essa interface.

Esse recurso foi incorporado no Java a partir do Java 8 e j� existe em outras linguagens como Scala e C#, por exemplo.

Para implementar um `default method` na sua interface, voc� deve inserir um m�todo com o modificador **dafault** e obrigat�riamente um corpo. Agora as interefaces podem ter comportamentos implementados.

Na vers�o 8 do Java, as APIs de lista receberam v�rios `default methods` em suas estruturas como, por exemplo, o m�todo `foreach()` da API List, o m�todo `stream()` entre outros. A evolu��o dessas interfaces s� foram poss�veis com a adi��o do default methods, caso contr�rio todas as classes que implementam essas APIs quebrariam.

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

Lambda permite o uso de uma [Functional Interface](https://docs.oracle.com/javase/8/docs/api/index.html?java/lang/FunctionalInterface.html) sem a necessidade de criar classe an�nima ou implementar a interface.

Ao invocar um m�todo que aguarda no seu par�metro um tipo de uma determinada interface funcional utilizando o lambda, o compilador consegue inferir o tipo, em tempo de compila��o.

Para implementar uma interface funcional utilizando um lambda devemos utilizar a seguinte sintaxe: `(param1, param2, paramN) -> { implementa��o }`. Voc� n�o precisa informar os tipos dos par�metros, pois o compilador consegue inferi-los conhecendo a interface funcional, os par�nteses s�o opcionais se o m�todo recebe apenas um par�metros caso contr�rio deve inserir os par�nteses e caso n�o receba nenhum par�metro deve colocar os par�nteses vazios. Deve separar os par�metros do bloco da implementa��o com o s�mbolo do lambda `->`. Se o corpo possui apenas um statement, ent�o n�o ser� necess�rio os colchetes `{}` nem `;` no final do statement, por�m se possui mais de um stetament ent�o os colchetes e o `;` ser�o obrigat�rios para delimitar o corpo da sua implementa��o e cada stetament, respectivamente. Se o m�todo retornar algum valor e possui apenas um statment, n�o � necess�rio a palavra reservada `return`, pois o compilador inferir� o retorno em tempo de execu��o, por�m caso tenha mais de um stetament deve inserir a palavra reservada `return`.
 

Exemplo de uma Interface Funcional que retorna um Integer e n�o recebe par�metros.

```
@FunctionalInterface
public interface ReturnFoo {

	Integer getFoo();
}
```

Aqui temos um m�todo que espera um tipo da interface funcional `ReturnFoo`. Note que a implementa��o � normal, recebe o objeto e consome o m�todo, sem nenhuma altera��o como j� conhecemos

```
private void printValueInterface(final ReturnFoo returnFoo) {
	
	System.out.println(returnFoo.getFoo());
}
```

Agora para invocar o m�todo acima passando um objeto do tipo `FooWithReturnAndNoParam` utilizaremos o lambda. Vamos definir o tipo que esperamos, por�m ao inv�s de utilizar a palavrada reserva `new` para criar uma classe an�nima iremos usufruir do benef�cio do lambda. Note que o m�todo da interface n�o espera nenhum par�metro, ent�o inserimos os par�nteses vazio. Depois iremos utilizar o s�mbolo do lambda `->`, aonde o compilador saber� interpretar a nossa implementa��o. Na sequ�ncia iremos implementar a nossa interface. Note que � semelhante a implementa��o de uma classe an�nima, um pouco mais simples pois n�o foi necess�rio inserir o nome do m�todo, po exemplo. 


```
public void implementaInterfaceCompletoEPassaObjetoParaMetodo() {
	
	ReturnFoo returnFoo = () -> {
		return 1;
	};
	
	this.printValueInterface(returnFoo);
}
```

Agora podemos deixar ainda mais simples essa implementa��o pois iremos apenas retornar o valor **1**, ent�o podemos fazer tudo isso em apenas um statement. Com isso n�o ser� necess�rio os colchetes, o ponto e v�rgula nem a palavra reservada `return`. muito mais simples:

```
public void implementaInterfaceSimplificadoEEnviarObjetoParaMetodo() {
	
	ReturnFoo returnFoo = () -> 1;
	this.printValueInterface(returnFoo);
}
```

J� nesse exemplo utilizando o lambda direto ao invocar o m�todo, utilizando a forma simplificado, por�m poder�amos utilizar a forma "completa" tamb�m, sem nenhum problema:

```
public void implementaInterfaceDentroDaChamadaDoMetodo() {
	
	this.printValueInterface(() -> 1);
}
```

Agora vamos criar uma Functional Interface que recebe um Functiona Interface como par�metro

```
@FunctionalInterface
public interface DoFoo {

	void doSomething(ReturnFoo param);
}
```

Para implementar a nossa Functional Interface **DoFoo** iremos aguardar um objeto do tipo `ReturnFoo` e fazer alguma coisa com esse retorno, no nosso exemplo iremos somar com o valor do par�metro e imprimir no console:

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
		
		System.out.println("<--- Interface Funcional  que retorna Integer e n�o recebe par�metros --->");
		UseReturnFoo useReturnFoo = new UseReturnFoo();
		useReturnFoo.implementaInterfaceDentroDaChamadaDoMetodo();
		useReturnFoo.implementaInterfaceCompletoEPassaObjetoParaMetodo();
		useReturnFoo.implementaInterfaceSimplificadoEEnviarObjetoParaMetodo();
		
		
		System.out.println("<--- Interface Funcional  recebe par�metro e faz alguma coisa --->");
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
