package model;
import java.util.ArrayList;
import java.util.List;

public class PersonMVC {
	public interface PersonListener{
		void onPersonNameChanged();
	}
	
	public PersonMVC()
	{
	
	}
	
	public PersonMVC(String name)
	{
		this.setName(name);
	}

	public String getName()
	{
		return _name;
	}
	
	public void setName(String name)
	{
		_name = name;
		fireOnNameChanged();
	}

	public void addListener(PersonListener l)
	{
		this.listeners.add(l);
	}
	
	public void removeListener(PersonListener l)
	{
		this.listeners.remove(l);
	}
	
	private void fireOnNameChanged() {
		for(PersonListener l:this.listeners)
		{
			l.onPersonNameChanged();
		}
	}
	
	private String _name;
	private List<PersonListener> listeners = new ArrayList<PersonListener>();
}
