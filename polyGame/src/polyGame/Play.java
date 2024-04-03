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
			
		}
		else if(this.getName().equals("비숍")) {
			
		}
	}
	
	private void paladinSkill(Unit unit) {
		String name = "세이크리드 바스티온✝️";
		System.out.printf("%s님 %s시전\n", this.name, name);
		System.out.printf("%s으로 공격 시 %s의 2배로 공격하고 50%확률로 기절\n", name, this.name);
		
		unit.setHp(unit.getHp()- this.getPower()*2);
		if(unit.hp <= 0) {
			unit.setHp(0);
			System.out.printf("%s 사망\n", unit.name);
		}
		
		int stun = GameManager.ran.nextInt(10)+1;
		if(stun > 5) {
			System.out.printf("%s님의 %s명중! %s💤\n", this.name, name, unit.name);
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
}
