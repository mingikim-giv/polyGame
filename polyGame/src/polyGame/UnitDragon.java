package polyGame;

public class UnitDragon extends Unit {
	
	public UnitDragon() {
		name = "혼테일";
	}
	
	public void skill(Unit unit) {
		String name = "브레스🔥";
		System.out.printf("%s님 %s시전\n", this.name, name);
		System.out.printf("%s는 몬스터가 일반 공격 후 50%확률로 1턴 기절\n", name);
		
		unit.setHp(this.power);
		
		if(unit.getHp() <= 0) {
			unit.setHp(0);
			System.out.printf("%s 사망\n", unit.getName());
		}
		
		int stun = GameManager.ran.nextInt(2);
		if(stun == 1) {
			System.out.printf("브레스🔥 명중! %s💤\n", unit.getName());
			unit.stun = true;
		}
		else {
			System.out.println("아무런 효과가 없었다🛡️");
		}
		
		System.out.printf("%s가 %s공격으로 %s[HP:%d]\n", this.name, name, unit.getName(), unit.getHp());
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}