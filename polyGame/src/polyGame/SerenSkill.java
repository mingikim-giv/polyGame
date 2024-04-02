package polyGame;

public class SerenSkill extends Skill {

	@Override
	public void skill(Unit unit) {
		String name = "미트라의 권능☀️";
		System.out.printf("%s님 %s시전\n", UnitSeren.instance.name, name);
		System.out.printf("%s으로 공격 시 %s의 2배 공격\n", name, UnitSeren.instance.name);
		
		unit.hp -= UnitSeren.instance.power*3;
		if(unit.hp <= 0) {
			System.out.printf("%s 사망\n", unit.name);
			unit.live = false;
		}
		
		System.out.printf("%s님 %s시전 %s[HP:%d]\n", UnitSeren.instance.name, name, unit.name);
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
