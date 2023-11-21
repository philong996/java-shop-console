package services;
import entities.IUser;

public interface IUserManagementService {

	String registerUser(IUser user);
	
	IUser[] getUsers();

	IUser getUserByEmail(String userEmail);

}
