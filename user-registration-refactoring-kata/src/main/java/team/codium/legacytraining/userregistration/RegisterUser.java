package team.codium.legacytraining.userregistration;
import java.util.Random;

public class RegisterUser {
    private final EmailSender emailSender;
    private final UserRepository userRepository;

    public RegisterUser(EmailSender emailSender, UserRepository userRepository) {
        this.emailSender = emailSender;
        this.userRepository = userRepository;
    }

    User execute(String password, String emailAddress, String name) throws InvalidPasswordException, DuplicatedEmailException, EmailException {
        if (password.length() <= 8 || !password.contains("_")) {
            throw new InvalidPasswordException();

        }

        if (userRepository.findByEmail(emailAddress) != null) {
            throw new DuplicatedEmailException();
        }

        User user = new User(
                new Random().nextInt(),
                name,
                emailAddress,
                password
        );
        userRepository.save(user);

        Email email = new Email("noreply@codium.team", emailAddress, "Welcome to Codium", "This is the confirmation email");
        emailSender.send(email);

        return user;
    }
}