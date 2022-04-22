package simple.socket;

import java.io.IOException;

import simple.socket.client.Client;

public class SingleSocketConnection {
	public static void main(String[] args) throws IOException {
		
		// Ŭ���̾�Ʈ ���� ����
		try (Client client = new Client();) {
			// ����ID ����
			client.setUserId("TestUser");
			// ������ �޼��� �۽�
			client.sendMessage(client.getUserId());
		} catch (IOException ioe) {
			System.out.println("Client ���� ���� ����");
		}
	}
	
}
