package services;

import java.util.Iterator;

import domain.User;

public class UserService extends GenericService<User> implements IUserService {

	@Override
	public User getUserByLogin(String login)  throws Exception{
		for(Iterator<User> i = map.values().iterator(); i.hasNext();){
			if (i.next().getLogin() == login){
				return i.next();
			}
		}
		throw new Exception("Not found");
	}

	@Override
	public boolean isUserExists(String login) {
		for(Iterator<User> i = map.values().iterator(); i.hasNext();){
			if (i.next().getLogin() == login){
				return true;
			}
		}
		return false;
	}

}
