import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class ClientTest {
    @Test
    public void shouldTrueIfClientNotNull(){
        Client client=new Client();
        assertThat(client).isNotNull();
    }



}
