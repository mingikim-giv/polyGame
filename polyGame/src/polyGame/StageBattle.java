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
	
	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
