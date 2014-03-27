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
