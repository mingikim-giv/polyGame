package polyGame;

import java.util.Vector;

public class Play extends Unit {
	public Play(String name, int maxHp, int power) {
		super(name, maxHp, power);
	}

	public void skill(Unit unit) {
		if (this.getName().equals("팔라딘")) {
			paladinSkill(unit);
		} else if (this.getName().equals("나이트로드")) {
			nightLordSkill(unit);
		} else if (this.getName().equals("비숍")) {
			bishopSkill();
		}
	}

	// paladinSkill
	private void paladinSkill(Unit unit) {
		String name = "세이크리드 바스티온✝️";
		System.out.printf("[스킬]%s님 %s시전\n", this.getName(), name);
		System.out.printf("[스킬 정보]%s으로 공격 시 %s의 2배 공격 2분의1 확률로 스턴\n", name, this.getPower());
		
		
		unit.setHp(this.getPower() * -2);
		if (unit.getHp() <= 0) {
			unit.setHp(0);
			System.out.printf("%s 사망\n", unit.getName());
		}
		
		int stun = GameManager.ran.nextInt(10) + 1;
		if (stun > 5) {
			System.out.printf("%s님의 %s명중! %s💤\n", this.getName(), name, unit.getName());
			unit.setStun(true);
		} else {
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
		String name = "생사 여탈";
		System.out.printf("[스킬]%s님 %s시전\n", this.getName(), name);
		System.out.printf("[스킬 정보]%s으로 공격 시 %s의 3배 공격\n", name, this.getPower());

		unit.setHp(this.getPower() * -3);
		if (unit.getHp() <= 0) {
			unit.setHp(0);
			System.out.printf("%s 사망\n", unit.getName());
		}

		System.out.printf("%s님 %s시전 %s[HP:%d]\n", this.getName(), name, unit.getName(), unit.getHp());

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// bishopSkill
	private void bishopSkill() {
		String name = "홀리 어드밴트💉";
		System.out.printf("[스킬]%s님 %s시전\n", this.getName(), name);
		Vector<Play> players = UnitManager.getInstance().getPlayers();
		for (int i = 0; i < players.size(); i++) {
			Play play = players.get(i);

			if (play.getHp() == 0) {
				return;
			}

			int heal = this.getPower();
			if (play.getHp() + heal > play.getMaxHp()) {
				heal = play.getMaxHp() - play.getHp();
			}

			play.setHp(heal);
			System.out.printf("%s(이)가 %d회복 중..❤️‍🩹\n", play.getName(), heal);

			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
