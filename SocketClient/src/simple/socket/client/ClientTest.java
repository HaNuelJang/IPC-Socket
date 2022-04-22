package simple.socket.client;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/* TODO
 * 1. Client Class ���� ����(extends Socket)
 * 2. Client Class ���� ����
 * 3. get_set_UserId() 
 */

class ClientTest {
	private static ServerSocket server;

	@BeforeEach
	void makeTempServer() {
		try {
			server = new ServerSocket(8888);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterEach
	void destoryTempServer() {
		server = null;
	}

	@Nested
	class Client_������ {
		@Nested
		class �ν��Ͻ�_���� {
			@Test
			@DisplayName("����")
			void Construct_Client() throws IOException {
				try (Client client = new Client();) {
					server.accept();
					assertNotNull(client);
					client.close();
					server.close();
				}
			}

			@Test
			@DisplayName("���Ȯ�� [Socket <- Client]")
			void instaceOfSocket_Client() throws IOException {
				try (Client client = new Client();) {
					server.accept();
					server.close();
					assertThat(client, instanceOf(Socket.class));
				}
			}
		}

		@Nested
		class �ν��Ͻ�_���� {

		}
	}

	@Nested
	class ����ID {
		
		@Test
		@DisplayName("get_set_userId()")
		void getset_userId() throws IOException {
			String userId = "testUser";
			try (Client client = new Client();) {
				server.accept();
				client.setUserId(userId);
				server.close();
				assertEquals(userId, client.getUserId());
			}
		}
	}

}
