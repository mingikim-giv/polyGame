package polyGame;

public class Unit {
	public int hp;
	public int maxHp;
	public int power;
	public String name;
	
	public Unit() {
		
	}
	
	public Unit(String name, int maxHp, int power) {
		this.name = name;
		this.maxHp = maxHp;
		this.hp = maxHp;
		this.power = power;
	}
	
	public void init(int maxHp, int power) {
		this.maxHp = maxHp;
		this.hp = maxHp;
		this.power = power;
	}
	
	public void init(String name, int maxHp, int power) {
		this.name = name;
		this.maxHp = maxHp;
		this.hp = maxHp;
		this.power = power;
	}
	
	public void attack(Unit target) {
		target.hp -= power;
		System.out.printf("[%s]가 [%s]에게 %d만큼 공격!\n", name, target.name, power);
		
		if(target.hp <= 0) {
			System.out.printf("[%s]를 처치했다!\n", target.name);
			target.hp = 0;
		}
	}
	
	public void printData() {
		System.out.printf("[%s][%d/%d][%d]\n", name, hp, maxHp, power);
	}
}