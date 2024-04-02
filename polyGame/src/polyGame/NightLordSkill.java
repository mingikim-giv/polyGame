package polyGame;

public class NightLordSkill extends Skill {

	@Override
	public void skill(Unit unit) {
		String name = "생사여탈";
		System.out.printf("%s님 %s시전\n", NightLord.instance.name, name);
		System.out.printf("%s으로 공격 시 %s의 3배 공격\n", name, NightLord.instance.name);
		
		unit.hp -= NightLord.instance.power*3;
		if(unit.hp <= 0) {
			System.out.printf("%s 사망\n", unit.name);
			unit.live = false;
		}
		
		System.out.printf("%s님 %s시전 %s[HP:%d]\n", NightLord.instance.name, name, unit.name);
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
