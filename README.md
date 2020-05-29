# Java 8

Aulas do curso Java 8: Tire proveito dos novos recursos da Linguagem, minustrado no Alura Cursos EAD.

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
