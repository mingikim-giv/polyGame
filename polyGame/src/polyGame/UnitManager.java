package polyGame;

import java.util.Random;
import java.util.Vector;

public class UnitManager {
	private Random ran = new Random();
	
	private Vector<Player> playList = new Vector<>();
	private Vector<Unit> unitList = new Vector<>();
	
	private String path = "polyGame";
	private String unit[] = {"UnitWolf", "UnitOrc", "UnitBat", "UnitDragon"};
	
	public UnitManager() {
		playList.add(new Player("팔라딘", 1000, 50));
		playList.add(new Player("나이트로드", 400, 100));
		playList.add(new Player("비숍", 700, 40));
	}
	
	private void unitRanSet(int size) {
		for(int i = 0; i < size; i ++) {
			int num = ran.nextInt(unit.length);
			try {
				Class<?> clazz = Class.forName(path + unit[num]);
				Object obj = clazz.getDeclaredConstructor().newInstance();
				
				Unit temp = (Unit) obj;
				int hp = ran.nextInt(100) + 100;
				int power = ran.nextInt(30) + 10;
				
				temp.init(hp, power);
				unitList.add(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
