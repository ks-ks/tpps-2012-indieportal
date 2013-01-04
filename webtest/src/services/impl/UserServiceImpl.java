package services.impl;

import java.util.Iterator;
import java.util.List;

import domain.User;
import services.IUserService;

public class UserServiceImpl extends GenericServiceImpl<User> implements
		IUserService {

	public UserServiceImpl() {
		super(User.class);
	}

	@Override
	public User getUserByLogin(String login) {
		List<User> list = executeQuery(String.format(QUERY_SELECT_ALL, persistentClass
				.getSimpleName()), false, false);
		if (list != null){
			for (Iterator<User> i = list.iterator(); i.hasNext();){
				if (i.next().getLogin() == login){
					return i.next();
				}
			}
		}
		return null;
	}

	@Override
	public boolean isUserExists(String login) {
		List<User> list = executeQuery(String.format(QUERY_SELECT_ALL, persistentClass
				.getSimpleName()), false, false);
		if (list != null){
			for (Iterator<User> i = list.iterator(); i.hasNext();){
				if (i.next().getLogin() == login){
					return true;
				}
			}
		}
		return false;
	}



}
