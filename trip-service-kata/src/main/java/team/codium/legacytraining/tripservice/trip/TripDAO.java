package team.codium.legacytraining.tripservice.trip;

import team.codium.legacytraining.tripservice.exception.CollaboratorCallException;
import team.codium.legacytraining.tripservice.user.User;

import java.util.List;

public class TripDAO {


	public List<Trip> findTripsByUser(User user) {
		throw new CollaboratorCallException(
				"TripDAO should not be invoked on an unit test.");
	}

}