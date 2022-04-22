package simple.socket.server;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/* TODO
 * 1.Server Class ���� ����(extends Socket)
 * 2.Server Class ���� ����
 * 3.get_set_UserId()
 */

class ServerTest {

	@Nested
	class Server_������ {

		@Nested
		class �ν��Ͻ�_���� {

			@Test
			@DisplayName("����")
			void SuccessConstructor_Server() throws IOException {
				try (Server server = new Server()) {
					assertNotNull(server);
				}
			}

			@Test
			@DisplayName("���Ȯ�� [ServerSocket <- Server]")
			void instaceOfServerSocket_Server() throws IOException {
				try (Server server = new Server()) {
					assertThat(server, instanceOf(ServerSocket.class));
				}
			}
		}

		@Nested
		class �ν��Ͻ�_���� {
			@Test
			@DisplayName("����")
			void FailConstructor_Server() {
				Assertions.assertThrows(BindException.class, () -> {
					try (Server server = new Server(); Server server2 = new Server();) {
					}
				});
			}
		}

		@Nested
		class ����ID {

			@Test
			@DisplayName("get_set_userId()")
			void getset_userId() throws IOException {
				String userId = "testUser";
				try (Server server = new Server();) {
					server.setUserId(userId);
					assertEquals(userId, server.getUserId());
				}
			}

		}
	}

}
