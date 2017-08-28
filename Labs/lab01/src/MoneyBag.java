import java.util.LinkedList;
import java.util.List;

public class MoneyBag {
	public MoneyBag() {
		_monies = new LinkedList<Money>( );
	}
	public int size() {
		return _monies.size();
	}
	
	public void add(Money money) {
		_monies.add(money);
	}
	
	public boolean contains(Money money) {
		return _monies.contains(money);
	}
	
	List<Money> getMonies() {
		return _monies;
	}
	
	private List<Money> _monies;
}