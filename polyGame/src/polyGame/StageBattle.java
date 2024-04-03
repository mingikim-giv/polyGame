package polyGame;

import java.util.Random;
import java.util.Vector;

public class StageBattle extends Stage {
	private Random ran = new Random();
	
	private final int ATTACK = 1;
	private final int SKILL = 2;

	private UnitManager unitManager = UnitManager.getInstance();
	private Vector<Play> playList;
	private Vector<Unit> unitList;
	
	private int unitDie;
	private int playerDie;
	
	private boolean isRun = true;
	private boolean isTurn = true;
	
	public StageBattle() {
		playList = null;
		unitList = null;
		unitDie = 0;
		playerDie = 0;
	}
	
	// init
	public void init() {
		unitManager.unit_List.clear();
		unitManager.unitRanSet(3);
		
		playList = null;
		playList = unitManager.getPlayers();
		
		unitList = null;
		unitList = unitManager.unit_List;
		
		unitDie = unitList.size();
		playerDie = playList.size();
	}
	
	// print
	public void print() {
		System.out.println("=======[BATTLE]=======");
		System.out.println("=======[PLAYER]=======");
		
		for(int i = 0; i < playList.size(); i ++) {
			playList.get(i).printData();
		}
		
		System.out.println("======[MONSTER]======");
		
		for(int i = 0; i < unitList.size(); i ++) {
			unitList.get(i).printData();
		}
	}
	
	// playAttack
	public void playAttack(int index) {
		Play play = playList.get(index);
		
		if(play.getHp() <= 0) {
			return;
		}
		
		System.out.println("========[MENU]========");
		System.out.printf("[%s]|[1]공격|[2]스킬\n", play.getName());
		
		int sel = GameManager.scan.nextInt();
		if(sel == ATTACK) {
			while(true) {
				int idx = ran.nextInt(unitList.size());
				
				Unit unit = unitList.get(idx);
				if(unit.getHp() > 0) {
					play.attack(unit);
					break;
				}
			}
		}
		else if(sel == SKILL) {
			while(true) {
				int idx = ran.nextInt(unitList.size());
				Unit unit = unitList.get(idx);
				if(unit.getHp() > 0) {
					play.skill(unit);
					break;
				}
			}
		}
	}
	
	// unitAttack
	public void unitAttack(int index) {
		Unit unit = unitList.get(index);
		
		if(unit.getStun()) {
			return;
		}
		
		if(unit.getHp() <= 0) {
			return;
		}
		
		while(true) {
			int idx = ran.nextInt(playList.size());
			int ranAttack = ran.nextInt(3);
			Play play = playList.get(idx);
			
			if(ranAttack != 0) {
				if(play.getHp() > 0) {
					unit.attack(play);
					break;
				}
			}
			else {
				if(unit instanceof UnitLucid) {
					UnitLucid lucid = (UnitLucid)unit;
					lucid.skill(play);
					break;
				}
				else if(unit instanceof UnitDragon) {
					UnitDragon dragon = (UnitDragon)unit;
					dragon.skill(play);
					break;
				}
				else if(unit instanceof UnitSeren) {
					UnitSeren seren = (UnitSeren)unit;
					seren.skill(play);
					break;
				}
			}
		}
	}
	
	// check
	public void check() {
		int num = 0;
		for(int i = 0; i < playList.size(); i ++) {
			if(playList.get(i).getHp() <= 0) {
				num ++;
			}
		}
		playerDie = playList.size() - num;
		
		num = 0;
		for(int i = 0; i < unitList.size(); i ++) {
			if(unitList.get(i).getHp() <= 0) {
				num ++;
			}
		}
		unitDie = unitList.size() - num;
	}
	
	@Override
	public boolean update() {
		int playerIdx = 0;
		int unitIdx = 0;
		
		while(isRun) {
			if(isTurn) {
				print();
				if(playerIdx < playList.size()) {
					playAttack(playerIdx);
					playerIdx ++;
				}
				else {
					isTurn = !isTurn;
					playerIdx = 0;
				}
			}
			else if(!isTurn) {
				if(unitIdx < unitList.size()) {
					unitAttack(unitIdx);
					unitIdx ++;
				}
				else {
					isTurn = !isTurn;
					unitIdx = 0;
				}
			}
			check();
			if(playerDie <= 0 || unitDie <= 0) {
				System.out.println("🎉STAGE CLEAR🎉");
				break;
			}
		}
		GameManager.nextStage = "LOBBY";
		return false;
	}
}