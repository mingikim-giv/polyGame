package polyGame;

public class Unit {
	public int hp;
	public int maxHp;
	public int power;
	public String name;
	public Skill skill;
	public boolean stun;
	
	public Unit() {
		
	}
	
	public Unit(String name, int maxHp, int power) {
		this.name = name;
		this.maxHp = maxHp;
		this.hp = maxHp;
		this.power = power;
		this.stun = false;
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
	
	public String getName() {
		return this.name;
	}
	public int getMaxHp() {
		return this.maxHp;
	}
	public int getHp() {
		return this.hp;
	}
	public int getPower() {
		return this.power;
	}
	public boolean getStun() {
		return this.stun;
	}
	
	public void setStun(boolean stun) {
		this.stun = stun;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public void attack(Unit target) {
		target.hp -= power;
		System.out.printf("[%s](이)가[%s]에게 %d만큼 공격!\n", name, target.name, power);
		
		if(target.hp <= 0) {
			target.hp = 0;
			System.out.printf("[%s]를 처치했다!\n", target.name);
		}
	}
	
	public void printData() {
		System.out.printf("[%s][%d/%d][%d]\n", name, hp, maxHp, power);
	}
}