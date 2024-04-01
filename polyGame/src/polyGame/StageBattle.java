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
	
	private final int ATTACK = 1;
	private final int SKILL = 2;
	
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
	
	// playAttack
	public void playAttack(int index) {
		Player play = playList.get(index);
		
		if(play.hp <= 0) {
			return;
		}
		
		System.out.println("=== [MENU] ===");
		System.out.printf("[%s] [1]공격 [2]스킬\n", play.name);
		
		int sel = GameManager.scan.nextInt();
		if(sel == ATTACK) {
			while(true) {
				int idx = ran.nextInt(unitList.size());
				
				Unit unit = unitList.get(idx);
				if(unit.hp > 0) {
					play.attack(unit);
					break;
				}
			}
		}
		else if(sel == SKILL) {
			
		}
	}
	
	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		return false;
	}
}
