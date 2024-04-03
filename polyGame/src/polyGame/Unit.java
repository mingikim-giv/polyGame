package polyGame;

public class Unit {
	private int hp;
	private int maxHp;
	private int power;
	private String name;
	private boolean stun;
	
	public Unit() {
		
	}
	
	public Unit(String name, int hp, int power) {
		this.name = name;
		this.maxHp = hp;
		this.hp = hp;
		this.power = power;
		this.stun = false;
	}
	
	public void init(int hp, int power) {
		this.maxHp = hp;
		this.hp = hp;
		this.power = power;
	}
	
	public void init(String name, int hp, int power) {
		this.name = name;
		this.maxHp = hp;
		this.hp = hp;
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
	
	public void setName(String name) {
		this.name = name;
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