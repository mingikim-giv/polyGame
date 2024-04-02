package polyGame;

public class StageLobby extends Stage {
	private final int BATTLE = 1;
	private final int END = 2;
	
	@Override
	public boolean update() {
		System.out.println("===[DUNGEON LOBBY]===");
		System.out.println("[1]전투 [2]종료");
		int sel = GameManager.scan.nextInt();
		
		if(sel == BATTLE) {
			GameManager.nextStage = "BATTLE";
		}
		else if(sel == END) {
			GameManager.nextStage = "";
		}
		return false;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}