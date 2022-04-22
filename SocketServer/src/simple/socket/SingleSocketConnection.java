package simple.socket;

import java.io.IOException;
import java.net.Socket;

import simple.socket.server.Server;

public class SingleSocketConnection {
	public static void main(String[] args) throws IOException {

		// 서버 소켓 생성
		try (Server server = new Server()) {
			System.out.println("서버 활성화");
			while (true) {
				// 클라이언트 소켓 요청 수락
				Socket client = server.accept();
				// 클라이언트 메세지 수신
				String userId = server.receiveMessage(client);
				// 서버에 클라이언크 유저ID 저장
				server.setUserId(userId);
				
				System.out.println("사용자[" + server.getUserId() + "]가 접속했습니다. ");
				// 클라이언트 소켓 종료
				client.close();
			}
		} catch (IOException ioe) {
			System.out.println("Server 소켓 생성 실패");
		}
	}

	public static String initUserId(Socket client) {
		String userId = null;

		return userId;
	}
}
