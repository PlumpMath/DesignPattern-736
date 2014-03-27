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
