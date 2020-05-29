# Java 8

Aulas do curso Java 8: Tire proveito dos novos recursos da Linguagem, minustrado no Alura Cursos EAD.

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
