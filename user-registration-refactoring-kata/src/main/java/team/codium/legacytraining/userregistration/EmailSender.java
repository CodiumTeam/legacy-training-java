package team.codium.legacytraining.userregistration;
public interface EmailSender {
    void send(Email email) throws EmailException;
}
