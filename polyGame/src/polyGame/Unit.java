package polyGame;

public class Unit {
	private int hp;
	private int maxHp;
	private int power;
	private String name;
	
	public Unit() {
		
	}
	
	public Unit(String name, int maxHp, int power) {
		this.name = name;
		this.maxHp = maxHp;
		this.hp = maxHp;
		this.power = power;
	}
	
	private void init(int maxHp, int power) {
		this.maxHp = maxHp;
		this.hp = maxHp;
		this.power = power;
	}
	
	private void init(String name, int maxHp, int power) {
		this.name = name;
		this.maxHp = maxHp;
		this.hp = maxHp;
		this.power = power;
	}
	
	private void attack(Unit target) {
		target.hp -= power;
		System.out.printf("[%s]가 [%s]에게 %d만큼 공격!\n", name, target.name, power);
		
		if(target.hp <= 0) {
			System.out.printf("[%s]를 처치했다!\n", target.name);
			target.hp = 0;
		}
	}
	
	private void printData() {
		System.out.printf("[%s][%d/%d][%d]\n", name, hp, maxHp, power);
	}
}
