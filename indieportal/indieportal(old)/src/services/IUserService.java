package services;

import domain.User;

public interface IUserService extends IGenericService<User>{
	
	public User getUserByLogin(String login) throws Exception;
	public boolean isUserExists(String login);
	
}
