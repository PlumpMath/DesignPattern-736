#Builder Pattern#
---
[TOC]

####1. 개요
  복잡한 응용프로그램을 개발하다 보면 특정 기능을 위한 객체들의 관계가 복잡해질 수가 있다. 객체를 생성하기 위한 프로세스나 패턴이 동일할 경우 새로운 타입의 객체를 쉽게 추가 할수 있도록 할 수 있는 패턴이 Builder Pattern 이라고 할 수 있겠다.    
  자동차를 만들기 위해 동일한 공정으로 여러가지 유형의 자동차를 만들 수 있겠다. 빌더패턴을 이용하면 여러디자인의 자동차를 동일한 공정으로 만들수 있다.
  
####2. 클래스 다이어그램

* Director   
  빌더 인터페이스를 이용하여 복잡한 객체를 만드는 역할을 한다.
* Builder   
  대상객체의 일부를 만들기 위한 추상 인터페이스 들을 지정한다.
* ConcreteBuilder   
  Builder Interface를 구현하며 대상객체 생성에 필요한 객체들을 구현합니다.
* Product   
  빌더에 의해 생성되는 객체입니다.
  
###3. Java로 구현한 패턴
![Alt Text](http://www.oodesign.com/images/creational/builder-pattern-example.png "")
출처-http://www.oodesign.com/builder-pattern.html

```[Java]
//Abstract Builder
class abstract class TextConverter{
	abstract void convertCharacter(char c);
	abstract void convertParagraph();
}

// Product
class ASCIIText{
	public void append(char c){ //Implement the code here }
}

//Concrete Builder
class ASCIIConverter extends TextConverter{
	ASCIIText asciiTextObj;//resulting product

	/*converts a character to target representation and appends to the resulting*/
	object void convertCharacter(char c){
		char asciiChar = new Character(c).charValue();
			//gets the ascii character
		asciiTextObj.append(asciiChar);
	}
	void convertParagraph(){}
	ASCIIText getResult(){
		return asciiTextObj;
	}
}

//This class abstracts the document object
class Document{
	static int value;
	char token;
	public char getNextToken(){
		//Get the next token
		return token;
	}
}

//Director
class RTFReader{
	private static final char EOF='0'; //Delimitor for End of File
	final char CHAR='c';
	final char PARA='p';
	char t;
	TextConverter builder;
	RTFReader(TextConverter obj){
		builder=obj;
	}
	void parseRTF(Document doc){
		while ((t=doc.getNextToken())!= EOF){
			switch (t){
				case CHAR: builder.convertCharacter(t);
				case PARA: builder.convertParagraph();
			}
		}
	}
}

//Client
public class Client{
	void createASCIIText(Document doc){
		ASCIIConverter asciiBuilder = new ASCIIConverter();
		RTFReader rtfReader = new RTFReader(asciiBuilder);
		rtfReader.parseRTF(doc);
		ASCIIText asciiText = asciiBuilder.getResult();
	}
	public static void main(String args[]){
		Client client=new Client();
		Document doc=new Document();
		client.createASCIIText(doc);
		system.out.println("This is an example of Builder Pattern");
	}
}
```
###4. 활용범위와 예제
 복잡한 객체의 생성알고리즘이 실제로 구성되는 객체들과 의존관계를 느슨할 필요가 있을때    
 특정한 객체에 대해 여러가지의 표현방식을 원할때   

1. 자동차 공장   
  자동차 공장(Director)에서 K3, K5, K7(product)등의 자동차를 생산하기 위한 공정(Builder)을 가지고 있다. 이 생산공정(Builder)을 이용하여 각 하청업체에서 부품들을 생산(ConcreteBuilder)하여 자동차공장 쪽으로 납품하게 됩니다. 그렇게 생산된 자동차(Product)들을 소비자(client)들이 이용하게 됩니다.
  
2. 학교시험결과 조회
  학교 시험결과조회를 위해 웹서비스를 만든다고 가정한다면, 각 사용자의 유형에 따라 다양한 화면을 보여주어야 할것이다. 학생에게는 단순조회만 가능하게 하고 담임선생님에게는 성적을 수정하고 확정할 수 있게도 할수 있어야 한다. 따라서 로그인계정에 따러 각가의 빌더를 이용하여 권한에 맞는 웹화면을 생성할 수 있을 것이다.

3. Java 에서 Comparator 와 Runnable 인터페이스

###5. Factory Pattern 과 Builder Pattern 의 차이
  둘다 다형성을 기반으로 하고 사용하는 객체와의 읜존성을 낮추는 목적에는 동일합니다. 객체를 생성하는 로직을 캡슐화하여 결합도를 최소화하고 있습니다.   
  즉, Builder Pattern은 자바에서 Comparator와 Runnable 인터페이스를 생각하시면 될것입니다. 해당 인터페이스를 구현한 개체를 생성하여 메소드에 전달하여서 구동되는 방식입니다.   
  반면 Factory Pattern은 자바에서 Runtime클래스의 getRuntime()에 적용되어 있는데요. 메소드에서 해당객체를 생성해서 반환하고 있습니다.

###6. 마치며
  Builder Pattern은 객체생성을 위한 패턴중 하나이다. 목적은 복잡한 객체생성을 내부로 캡슐화하여 사용하는 쪽에서는 간결한 사용 및 결합도를 낮추는데 주 목적이 있겠다. Factory 패턴과의 Builder패턴이 약간 중복이 될수 있지만 둘의 용법이 다르니 상황에 맞는 패턴을 이용하도록 하자.

[참고 사이트] http://www.oodesign.com/builder-pattern.html

