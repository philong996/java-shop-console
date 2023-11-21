package entities;

public class User implements IUser {
    private static int nextId = 0;
    
    private int id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;

    {
        this.id = nextId++;
    }

	public User() {
	}

	public User(String firstName, String lastName, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getEmail() {
		return email;
	}
	
	@Override
	public String toString() {
		return "User: {id: " + id + ", " +
                "firstName: " + firstName + ", " +
                "lastname: " + lastName + ", " +
                "email: " + email + "}";
	}

	@Override
	public void setPassword(String password) {
        if (password.length() > 0 && !password.isBlank()) {
            this.password = password;
        }
	}

	@Override
	public void setEmail(String newEmail) {
        if (newEmail.length() > 0 && !newEmail.isBlank()) {
            this.email = newEmail;
        }
    }

	@Override
	public int getId() {
		return id;
	}
	
	void clearState() {
        User.nextId = 0;
	}
}
