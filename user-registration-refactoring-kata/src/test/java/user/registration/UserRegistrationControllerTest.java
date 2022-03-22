package user.registration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserRegistrationController.class)
public class UserRegistrationControllerTest {
    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        UserRegistrationController.orm = new UserOrmRepository();
    }

    @Test
    public void should_success_when_everything_is_valid() throws Exception {
        String url = "/users?name=Codium&email=my@email.com&password=myPass_123123";

        mockMvc.perform(post(url))
                .andExpect(status().isOk());
    }

    @Test
    public void should_returns_a_user_with_the_email_when_everything_is_valid() throws Exception {
        String url = "/users?name=Codium&email=my@email.com&password=myPass_123123";

        mockMvc.perform(post(url))
                .andExpect(jsonPath("$.email").value("my@email.com"));
    }

    @Test
    public void should_returns_a_user_with_the_name_when_everything_is_valid() throws Exception {
        String url = "/users?name=Codium&email=my@email.com&password=myPass_123123";

        mockMvc.perform(post(url))
                .andExpect(jsonPath("$.name").value("Codium"));
    }

    @Test
    public void should_fail_when_password_is_short() throws Exception {
        String url = "/users?name=Codium&email=my@email.com&password=myPass_";

        mockMvc.perform(post(url))
                .andExpect(content().string("The password is not valid"));
    }

    @Test
    public void should_fail_when_email_is_used() throws Exception {
        String url = "/users?name=Codium&email=same@email.com&password=myPass_123123";
        mockMvc.perform(post(url));

        mockMvc.perform(post(url))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("The email is already in use"));
    }


    @Test
    public void should_generate_a_random_id_when_everything_is_valid() throws Exception {
        String url = "/users?name=Codium&email=my@email.com&password=myPass_123123";

        mockMvc.perform(post(url))
                .andExpect(jsonPath("$.id").isNotEmpty());
    }

}