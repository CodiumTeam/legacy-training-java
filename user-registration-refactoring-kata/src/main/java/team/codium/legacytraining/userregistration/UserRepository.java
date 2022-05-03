package team.codium.legacytraining.userregistration;

public interface UserRepository {
    void save(User user);

    User findByEmail(String email);
}
