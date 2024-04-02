package polyGame;

public class NightLord extends Unit {
	public static NightLord instance = new NightLord();
	
	  public Unit add() {
		  this.name = "나이트로드";
		  this.maxHp = 300;
		  this.power = 150;
		  Unit temp = new Unit(name, maxHp, power, new NightLordSkill());
		  return temp;
	  }
}
