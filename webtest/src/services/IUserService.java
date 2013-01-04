package services;

import domain.User;

public interface IUserService extends IGenericService<User>{
	
	public User getUserByLogin(String login);
	public boolean isUserExists(String login);
	
}
