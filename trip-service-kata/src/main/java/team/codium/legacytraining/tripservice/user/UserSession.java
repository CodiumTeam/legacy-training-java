package team.codium.legacytraining.tripservice.user;

import team.codium.legacytraining.tripservice.exception.CollaboratorCallException;

public class UserSession {

	private static final UserSession userSession;

	static {
		userSession = new UserSession(new User()){
			public User getLoggedUser() {
				throw new CollaboratorCallException(
						"UserSession.getInstance() we dont know how to retrieve the current user in an unit test");
			}
		};
	}

	private final User user;

	public UserSession(User loggedUser) {
		this.user = loggedUser;
	}
	
	public static UserSession getInstance() {
		return userSession;
	}

	public User getLoggedUser() {
		return user;
	}
}