package polyGame;

public class DragonSkill extends Skill {

	@Override
	public void skill(Unit unit) {
		String name = "브레스🔥";
		System.out.printf("%s님 %s시전\n", UnitDragon.instance.name, name);
		System.out.printf("%s는 몬스터가 일반 공격 후 50%확률로 1턴 기절\n", name);
		
		unit.hp -= UnitDragon.instance.power;
		
		if(unit.hp <= 0) {
			System.out.printf("%s 사망\n", unit.name);
			unit.live = false;
		}
		
		int stun = GameManager.ran.nextInt(2);
		
		if(stun == 1) {
			System.out.printf("브레스🔥 명중! %s💤\n", unit.name);
			unit.stun = true;
		}
		else {
			System.out.println("아무런 효과가 없었다🛡️");
		}
		
		System.out.printf("%s가 %s공격으로 %s[HP:%d]\n", UnitDragon.instance.name, name, unit.name, unit.hp);
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
