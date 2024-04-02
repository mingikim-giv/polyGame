package polyGame;

public class Bishop extends Unit {
	public static Bishop instance = new Bishop();
	
	  public Unit add() {
		  this.name = "비숍";
		  this.maxHp = 400;
		  this.power = 40;
		  Unit temp = new Unit(name, maxHp, power, new BishopSkill());
		  return temp;
	  }
}
