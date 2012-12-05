package services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import domain.Section;
import domain.Theme;

public class SectionService extends GenericService<Section> implements ISectionService {


	
	@Override
	public void calculatePositions(Section s) {
		
		for (Iterator<Theme> i = s.getThemes().iterator(); i.hasNext(); ) {
			i.next().calculateSummary();
		}
		
		ArrayList<Theme> list = new ArrayList<Theme>();
		list.addAll(s.getThemes());
		Collections.sort(list, new Comparator<Theme>() {
			@Override
			public int compare(Theme o1, Theme o2) {
				if (o1.getSummary() < o2.getSummary()) return -1;

				if (o1.getSummary() > o2.getSummary()) return 1;
				return 0;
			}
		}
		);
		int pos = 0;
		for (Iterator<Theme> i = list.iterator(); i.hasNext();){
			i.next().setPosition(pos++);
		}
		
	}

}
