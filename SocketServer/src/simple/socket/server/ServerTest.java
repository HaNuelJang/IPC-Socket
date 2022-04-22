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
 * 1.Server Class 생성 성공(extends Socket)
 * 2.Server Class 생성 실패
 * 3.get_set_UserId()
 */

class ServerTest {

	@Nested
	class Server_생성자 {

		@Nested
		class 인스턴스_성공 {

			@Test
			@DisplayName("성공")
			void SuccessConstructor_Server() throws IOException {
				try (Server server = new Server()) {
					assertNotNull(server);
				}
			}

			@Test
			@DisplayName("상속확인 [ServerSocket <- Server]")
			void instaceOfServerSocket_Server() throws IOException {
				try (Server server = new Server()) {
					assertThat(server, instanceOf(ServerSocket.class));
				}
			}
		}

		@Nested
		class 인스턴스_실패 {
			@Test
			@DisplayName("실패")
			void FailConstructor_Server() {
				Assertions.assertThrows(BindException.class, () -> {
					try (Server server = new Server(); Server server2 = new Server();) {
					}
				});
			}
		}

		@Nested
		class 유저ID {

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
