package polyGame;

public class PaladinSkill extends Skill {

	@Override
	public void skill(Unit unit) {
		String name = "세이크리드 바스티온!";
		System.out.printf("%s님 %s시전\n", Paladin.instance.name, name);
		System.out.printf("%s으로 공격 시 %s의 2배로 공격하고 50%확률로 기절\n", name, Paladin.instance.name);
		
		unit.hp -= Paladin.instance.power*2;
		if(unit.hp <= 0) {
			System.out.printf("%s 사망\n", unit.name);
			unit.live = false;
		}
		
		int stun = GameManager.ran.nextInt(10)+1;
		if(stun > 5) {
			System.out.printf("%s님의 %s명중! %s💤\n", Paladin.instance.name, name, unit.name);
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
