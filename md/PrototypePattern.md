# Prototype Pattern
  객체생성을 위한 디자인패턴중 하나인 *프로토타입 패턴(Prototype Pattern)*에 대해서 설명하도록 하겠다. 객체생성시 비용을 줄이기 위한 패턴들이니 이점에 유의에서 읽어보도록 하자.  
  
[TOC]

### 1. 개요
 프로토타입 패턴은 동일한 객체를 여러번 생성해야 하는 비용을 줄이기 위한 고안된 패턴이다. 예를 들어 수만건의 데이터를 읽어들인 분석을 위한 기초자료를 가지는 객체가 있다고 하자. 이를 분석할때마다 로딩한다면 그 비용은 엄청 날것이다. 이런 경우에 한번만 로딩후 이객체를 계속 복제해서 사용한다면 비용을 상당히 줄일 수 있을것이다. 
 
### 2. 클래스 다이어 그램
![프로토타입 패턴(Prototype Patern)](http://upload.wikimedia.org/wikipedia/commons/a/af/Prototype_design_pattern.png)
- **Client** 복제된 객체를 이용하는 클래스
- **Prototype** clone 메소드를 가지고 있는 인터페이스
- **ConcretePrototype** 실제 Clone() 메소드를 구현하는 클래스이며 이 메소드에서 자신의 객체를 복제하게 된다.

### 3. Java 예제
  예제로서는 게임을 만든다고 했을때, 동일한 아이템을 많은 사용자에게 제공을 해주는 상황이라고 가정을 하겠다.
  ##### 1) 클래스다이어 그램
  
  ##### 2) 소스
```
package ProtoType;

public interface Item extends Cloneable {

	public Item clone();
	
	public int getHealth();
}
```
```
package ProtoType;

public class ItemShotGun implements Item {

	private int health = 100;
	
	public ItemShotGun() {
		// 실제로 여기는 아이템 이미지나 비용이 많이 드는 초기화 작업이 존재하게됨
	}
	
	public Item clone() {
		return this.clone();
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public void setHealth( int health ) {
		this.health = health;
	}
}
```
```
package ProtoType;

public class ItemKnife implements Item {
	
	private int health = 100;

	public ItemKnife() {
		// 실제로 여기는 아이템 이미지나 비용이 많이 드는 초기화 작업이 존재하게됨
	}
	
	public Item clone() {
		return this;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public void setHealth( int health ) {
		this.health = health;
	}
}

```
```
package ProtoType;

import java.util.HashMap;

public class ItemManager {

	public final static int ITEM_SHOTGUN = 0;
	public final static int ITEM_KNIFE   = 1;
	
	private HashMap<Integer, Item> itemList = new HashMap<Integer, Item>();
	
	// 생성자
	// Item을 초기화 한다.
	public ItemManager() {
		itemList.put( ItemManager.ITEM_SHOTGUN, new ItemShotGun() );
		itemList.put( ItemManager.ITEM_KNIFE  , new ItemKnife()   );
	}
	
	
	// 
	/**
	 * 원하는 item 을 복제해서 제공함.
	 * @param itemCd 아이템코드
	 * @return Item 객체를 반환한다.
	 */
	public Item getItem( int itemCd ) {
		return itemList.get( itemCd ).clone();
	}
	
	
	public static void main(String[] args) {

		ItemManager itemManager = new ItemManager();
		Item shotgun = itemManager.getItem( ItemManager.ITEM_SHOTGUN );
		Item knife   = itemManager.getItem( ItemManager.ITEM_KNIFE   );
	}

}

```
  ##### 3) 소스 설명
  - `Item` : Prototype 에 해당하는 인터페이스
  - `ItemShotGun, ItemKnife` : ConcretePrototype 에 해당함. 
  - `ItemManager` :  실제 client 부분인데 HashMap을 이용하여 Item 들을 관리하고 있다. client(main함수)가 필요한 객체를 복제(cline)해서 반환한다.
  
### 4. 고려사항
- 다수의 프로토타입 패턴을 이용한 객체를 관리를 해야 할때, HashMap을 이용해서 관리하는게 편리하다. 
- 복제를 위한함수 clone 을 설계할때, 얕은복제를 해야할지 깊은 복제를 해야할지 잘 고려해야한다. 값을 복제해주어야 하는 것과 복제하지 않고 서로 참조해야 하는 경우를 잘고려해서 설계해야 할 것이다.
- 복제후 멤버변수를 적절하게 초기화 해주어야 한다. 

### 5. 마치며
Prototype Pattern 상대적으로 다른종류의 객체생성 패턴보다는 쉬울거라 예상이 된다. 필자 또한 쉽게 이해하고 이글을 포스팅 하고 있으니 말이다. 하나하나 공부할때마다 앞서 공부했던 패턴들의 이해가 안되었던 부분들이 이해가 되는 경우도 있다. 그러니 꾸준함이 필요할때!
