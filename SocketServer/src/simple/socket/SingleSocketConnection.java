package simple.socket;

import java.io.IOException;
import java.net.Socket;

import simple.socket.server.Server;

public class SingleSocketConnection {
	public static void main(String[] args) throws IOException {

		// ���� ���� ����
		try (Server server = new Server()) {
			System.out.println("���� Ȱ��ȭ");
			while (true) {
				// Ŭ���̾�Ʈ ���� ��û ����
				Socket client = server.accept();
				// Ŭ���̾�Ʈ �޼��� ����
				String userId = server.receiveMessage(client);
				// ������ Ŭ���̾�ũ ����ID ����
				server.setUserId(userId);
				
				System.out.println("�����[" + server.getUserId() + "]�� �����߽��ϴ�. ");
				// Ŭ���̾�Ʈ ���� ����
				client.close();
			}
		} catch (IOException ioe) {
			System.out.println("Server ���� ���� ����");
		}
	}

	public static String initUserId(Socket client) {
		String userId = null;

		return userId;
	}
}
