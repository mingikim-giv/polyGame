package polyGame;

public class UnitSeren extends Unit {
	
	public UnitSeren() {
		name = "세렌";
	}
	
	public void skill(Play unit) {
		String name = "미트라의 권능☀️";
		System.out.printf("[스킬]%s님 %s시전\n", this.name, name);
		System.out.printf("[스킬 정보]%s으로 공격 시 %s의 2배 공격\n", name, this.power);
		
		unit.setHp(unit.getHp() - this.power*2);
		if(unit.getHp() <= 0) {
			unit.setHp(0);
			System.out.printf("%s 사망\n", unit.getName());
		}
		
		System.out.printf("%s님 %s시전 %s[HP:%d]\n", this.name, name, unit.getName(), unit.getHp());
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}