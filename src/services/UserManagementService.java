package services;

import entities.IUser;

public class UserManagementService implements IUserManagementService {
	
	private static final String NOT_UNIQUE_EMAIL_ERROR_MESSAGE = "This email is already used by another user. Please, use another email";
	private static final String EMPTY_EMAIL_ERROR_MESSAGE = "You have to input email to register. Please, try one more time";
	private static final String NO_ERROR_MESSAGE = "";
	
	private static final int DEFAULT_USERS_CAPACITY = 10;
	
	private static UserManagementService instance;
	
    private IUser[] users;
    private int lastUserIndex;

    {
        users = new IUser[DEFAULT_USERS_CAPACITY];
        lastUserIndex = 0;
    }

	private UserManagementService() {
	}
	
	@Override
	public String registerUser(IUser user) {
        String userEmail = user.getEmail();
        if (userEmail.length() == 0 || userEmail.isBlank()) {
            return EMPTY_EMAIL_ERROR_MESSAGE;
        }
        
        if (getUserByEmail(userEmail) != null) {
            return NOT_UNIQUE_EMAIL_ERROR_MESSAGE;
        
        }
        
        users[lastUserIndex++] = user;
        return null;
	}

	public static UserManagementService getInstance() {
		if (instance == null) {
			instance = new UserManagementService();
		}
		return instance;
	}

	
	@Override
	public IUser[] getUsers() {
		return users;
	}

	@Override
	public IUser getUserByEmail(String userEmail) {
		for (IUser user : users) {
            if (user != null && user.getEmail() == userEmail) {
                return user;
            }
        }

		return null;
	}
	
	void clearServiceState() {
		// <write your code here>
	}
}
