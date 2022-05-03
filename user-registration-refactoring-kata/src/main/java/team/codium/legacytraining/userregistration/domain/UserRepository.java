package team.codium.legacytraining.userregistration.domain;


public interface UserRepository {
    void save(User user);

    User findByEmail(String email);
}
