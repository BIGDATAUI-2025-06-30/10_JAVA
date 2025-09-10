package Ch21.building;

import Ch21.unit.Medic;
import Ch21.unit.Unit;

public class MedicGenerator implements UnitGenerator{

	@Override
	public Unit gen() {
		return new Medic();
	}

}
