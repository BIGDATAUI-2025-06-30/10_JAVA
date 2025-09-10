package Ch21.building;

import Ch21.unit.Marine;
import Ch21.unit.Unit;

public class MarineGenerator implements UnitGenerator{

	@Override
	public Unit gen() {
		return new Marine();
	}

}
