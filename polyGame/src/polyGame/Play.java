package polyGame;

public class Play extends Unit {
	public Play(String name, int maxHp, int power) {
		super(name, maxHp, power);
	}
	
	public void skill(Unit unit) {
		if(this.getName().equals("팔라딘")) {
			paladinSkill(unit);
		}
		else if(this.getName().equals("나이트로드")) {
			nightLordSkill(unit);
		}
		else if(this.getName().equals("비숍")) {
			bishopSkill(unit);
		}
	}
	
	// paladinSkill
	private void paladinSkill(Unit unit) {
		String name = "세이크리드 바스티온✝️";
		System.out.printf("%s님 %s시전\n", this.name, name);
		System.out.printf("%s으로 공격 시 %s의 2배로 공격하고 50%확률로 기절\n", name, this.name);
		
		unit.setHp(unit.getHp()- this.getPower()*2);
		if(unit.hp <= 0) {
			unit.setHp(0);
			System.out.printf("%s 사망\n", unit.getName());
		}
		
		int stun = GameManager.ran.nextInt(10)+1;
		if(stun > 5) {
			System.out.printf("%s님의 %s명중! %s💤\n", this.name, name, unit.getName());
			unit.stun = true;
		}
		else {
			System.out.println("스킬 빗나감😞");
		}
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// nightLordSkill
	private void nightLordSkill(Unit unit) {
		String name = "생사여탈";
		System.out.printf("%s님 %s시전\n", this.name, name);
		System.out.printf("%s으로 공격 시 %s의 3배 공격\n", name, this.name);
		
		unit.setHp(unit.getHp() - this.power*3);
		if(unit.hp <= 0) {
			unit.setHp(0);
			System.out.printf("%s 사망\n", unit.name);
		}
		
		System.out.printf("%s님 %s시전 %s[HP:%d]\n", this.name, name, unit.getName(), unit.getHp());
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// bishopSkill
	private void bishopSkill(Unit unit) {
		String name = "홀리 어드밴트💉";
		System.out.printf("%s님 %s시전\n", this.name, name);
		
		if(unit.getHp() == unit.getMaxHp()) {
			System.out.println("이미 최대 체력입니다");
			return;
		}
		else {
			unit.setHp(this.power);
		}
		
		if((unit.getHp() + this.power) >= unit.getMaxHp()) {
			System.out.println("최대 체력만큼 회복합니다");
			unit.setHp(unit.getMaxHp());
		}
		System.out.printf("%s님이 %s시전하여 %s님[HP:%s]", this.name, unit.getName(), unit.getHp());
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
