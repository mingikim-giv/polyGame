package polyGame;

import java.util.Random;
import java.util.Vector;

public class UnitManager {
	public Random ran = new Random();
	public static UnitManager instance = new UnitManager();
	
	public Vector<Unit> play_List = new Vector<>();
	public Vector<Unit> unit_List = new Vector<>();
	
	private String path = "polyGame.";
	private String unit[] = {"UnitLucid", "UnitSeren", "UnitDragon"};
	
	public UnitManager() {
		play_List.add(new Play("팔라딘", 700, 40));
		play_List.add(new Play("나이트로드", 300, 100));
		play_List.add(new Play("비숍", 500, 30));
	}
	
	public void unitRanSet(int size) {
		for(int i = 0; i < size; i ++) {
			int num = ran.nextInt(unit.length);
			try {
				Class<?> clazz = Class.forName(path + unit[num]);
				Object obj = clazz.getDeclaredConstructor().newInstance();
				
				Unit temp = (Unit) obj;
				int hp = ran.nextInt(100) + 100;
				int pow = ran.nextInt(10) + 10;
				
				temp.init(hp, pow);
				unit_List.add(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}