package polyGame;

public class UnitDragon extends Unit {
	public static UnitDragon instance = new UnitDragon();

	public Unit add() {
	  this.name = "혼테일";
	  this.maxHp = 300;
	  this.power = 20;
	  Unit temp = new Unit(name, maxHp, power, new DragonSkill());
	  return temp;
	}
}