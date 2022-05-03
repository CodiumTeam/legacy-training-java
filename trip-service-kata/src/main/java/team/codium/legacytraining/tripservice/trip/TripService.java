package team.codium.legacytraining.tripservice.trip;

import team.codium.legacytraining.tripservice.user.User;
import team.codium.legacytraining.tripservice.user.UserSession;
import team.codium.legacytraining.tripservice.exception.UserNotLoggedInException;

import java.util.ArrayList;
import java.util.List;

public class TripService {

	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
		List<Trip> tripList = new ArrayList<Trip>();
		User loggedUser = UserSession.getInstance().getLoggedUser();
		boolean isFriend = false;
		if (loggedUser != null) {
			for (User friend : user.getFriends()) {
				if (friend.equals(loggedUser)) {
					isFriend = true;
					break;
				}
			}
			if (isFriend) {
				TripDAO tripDAO = new TripDAO();
				tripList = tripDAO.findTripsByUser(user);
			}
			return tripList;
		} else {
			throw new UserNotLoggedInException();
		}
	}
	
}