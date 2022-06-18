package com.hl.hw26.Server.src.test.java;
import com.hl.hw26.Server.src.main.java.ClientHandler;
import com.hl.hw26.Server.src.main.java.Server;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.Socket;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ServerTest {
    @Test
    public void shouldTrueIfClientNotNull() throws IOException {
        Server server = new Server();
        ClientHandler clientHandler = new ClientHandler(new Socket("localhost", 3443), server);
        assertThat(server.getClients()).isNotNull();
    }
}
