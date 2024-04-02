package polyGame;

public class LucidSkill extends Skill {

	@Override
	public void skill(Unit unit) {
		String name = "루시드의 축복🎆";
		System.out.printf("%s가 %s공격 시전\n", UnitLucid.instance.name, name);
		System.out.printf("%s는 루시드의 공격력만큼 한 몬스터 회복💉\n", name);
		
		if(unit.hp == unit.maxHp) {
			System.out.println("이미 최대 체력입니다");
			return;
		}
		else {
			unit.hp += UnitLucid.instance.power;
		}
		
		if((unit.hp + UnitLucid.instance.power) >= unit.maxHp) {
			System.out.println("최대 체력만큼 회복합니다");
			unit.hp = unit.maxHp;
		}
		System.out.printf("%s님이 %s시전하여 %s님[HP:%s]", UnitLucid.instance.name, unit.name, unit.hp);
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
