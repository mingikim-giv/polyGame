package polyGame;

import java.util.Random;
import java.util.Vector;

public class UnitManager {
	private Random ran = new Random();
	
	public Vector<Player> play_List = new Vector<>();
	public Vector<Unit> unit_List = new Vector<>();
	
	private String path = "polyGame";
	private String unit[] = {"UnitWolf", "UnitOrc", "UnitBat", "UnitDragon"};
	
	public UnitManager() {
		play_List.add(new Player("팔라딘", 1000, 50));
		play_List.add(new Player("나이트로드", 400, 100));
		play_List.add(new Player("비숍", 700, 40));
	}
	
	public void unitRanSet(int size) {
		for(int i = 0; i < size; i ++) {
			int num = ran.nextInt(unit.length);
			try {
				Class<?> clazz = Class.forName(path + unit[num]);
				Object obj = clazz.getDeclaredConstructor().newInstance();
				
				Unit temp = (Unit) obj;
				int hp = ran.nextInt(100) + 100;
				int power = ran.nextInt(30) + 10;
				
				temp.init(hp, power);
				unit_List.add(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
