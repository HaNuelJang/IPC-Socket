package simple.socket;

import java.io.IOException;

import simple.socket.client.Client;

public class SingleSocketConnection {
	public static void main(String[] args) throws IOException {
		
		// 클라이언트 소켓 생성
		try (Client client = new Client();) {
			// 유저ID 셋팅
			client.setUserId("TestUser");
			// 서버에 메세지 송신
			client.sendMessage(client.getUserId());
		} catch (IOException ioe) {
			System.out.println("Client 소켓 생성 실패");
		}
	}
	
}
