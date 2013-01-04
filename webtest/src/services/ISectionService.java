package services;

import domain.Section;

public interface ISectionService extends IGenericService<Section> {


	void calculatePositions(Section s);
}
