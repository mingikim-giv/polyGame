package polyGame;

import java.util.Random;
import java.util.Vector;

public class StageBattle extends Stage {
	private Random ran = new Random();
	private UnitManager unitManager;
	private Vector<Player> playList;
	private Vector<Unit> unitList;
	
	private int unitDie;
	private int playerDie;
	
	public StageBattle() {
		unitManager = new UnitManager();
		playList = null;
		unitList = null;
		unitDie = 0;
		playerDie = 0;
	}
	
	// init
	public void init() {
		unitManager.unit_List.clear();
		unitManager.unitRanSet(4);
		
		playList = null;
		playList = unitManager.play_List;
		
		unitList = null;
		unitList = unitManager.unit_List;
		
		unitDie = unitList.size();
		playerDie = playList.size();
	}
	
	// print
	public void print() {
		System.out.println("=== [BATTLE] ===");
		System.out.println("=== [PLAYER] ===");
		
		for(int i = 0; i < playList.size(); i ++) {
			playList.get(i).printData();
		}
		
		System.out.println("=== [MONSTER] ===");
		
		for(int i = 0; i < unitList.size(); i ++) {
			unitList.get(i).printData();
		}
	}
	
	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		return false;
	}
}
