package team.codium.legacytraining.userregistration.infrastructure;

import team.codium.legacytraining.userregistration.domain.User;
import team.codium.legacytraining.userregistration.domain.UserRepository;

import java.util.HashMap;

public class UserOrmRepository implements UserRepository {
    public HashMap<String, User> users = new HashMap<>();

    @Override
    public void save(User user) {
        users.put(user.getEmail(), user);
    }

    @Override
    public User findByEmail(String email) {
        return users.getOrDefault(email, null);
    }
}
