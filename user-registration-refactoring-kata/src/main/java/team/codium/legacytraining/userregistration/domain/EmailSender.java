package team.codium.legacytraining.userregistration.domain;
public interface EmailSender {
    void send(Email email) throws EmailException;
}
