package domain;

import java.util.ArrayList;
import java.util.Collection;

public class Section extends Text{
	
	Collection<Theme> themes;

	public Section(String title, User user) {
		super(title, user);
		themes = new ArrayList<Theme>();
	}
	
	public void addTheme(Theme theme){
		themes.add(theme);
	};

	public void deleteTheme(Theme theme){
		themes.remove(theme);
	};
	public int getNumberofThemes(){
		return themes.size();
	}
	public Collection<Theme> getThemes() {
		return themes;
	}
	public void setTitle(String title){
		setText(title);
	}
}
