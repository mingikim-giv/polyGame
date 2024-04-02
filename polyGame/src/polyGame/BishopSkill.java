package polyGame;

public class BishopSkill extends Skill {

	@Override
	public void skill(Unit unit) {
		String name = "홀리 어드밴트💉";
		System.out.printf("%s님 %s시전\n", Bishop.instance.name, name);
		System.out.printf("%s으로 공격 시 %s의 공격력으로 전체 팀원 힐🚑\n", name, Bishop.instance.name);
		
		if(unit.hp == unit.maxHp) {
			System.out.println("이미 최대 체력입니다");
			return;
		}
		else {
			unit.hp += Bishop.instance.power;
		}
		
		if((unit.hp + Bishop.instance.power) >= unit.maxHp) {
			System.out.println("최대 체력만큼 회복합니다");
			unit.hp = unit.maxHp;
		}
		System.out.printf("%s님이 %s시전하여 %s님[HP:%s]", Bishop.instance.name, unit.name, unit.hp);
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
