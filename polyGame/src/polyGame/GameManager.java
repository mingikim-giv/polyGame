package polyGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GameManager {
	public static Random ran = new Random();
	public static Scanner scan = new Scanner(System.in);
	public static String nextStage = "";
	
	public String curStage = "";
	
	private Map<String, Stage> list = new HashMap<String, Stage>();
	private boolean run = true;
	
	
	public GameManager() {
		list.put("TITLE", new StageTitle());
		list.put("BATTLE", new StageBattle());
		list.put("LOBBY", new StageLobby());
		
		nextStage = "TITLE";
	}
	
	// changeStage
	private boolean changeStage() {
		System.out.printf("curStage: %s\n", curStage);
		System.out.printf("nextStage: %s\n", nextStage);
		
		if(curStage.equals(nextStage)) {
			return true;
		}
		
		curStage = nextStage;
		Stage stage = list.get(curStage);
		stage.init();
		
		while(true) {
			run = stage.update();
			if(run == false) {
				break;
			}
		}
		
		if(nextStage.equals("")) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void run() {
		while(true) {
			run = changeStage();
			if(run == false) {
				break;
			}
		}
		System.out.println("GAME OVER");
	}
}