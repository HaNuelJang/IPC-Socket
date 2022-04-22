package simple.socket.client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends Socket {
	private static final String IP = "127.0.0.1";
	private static final int PORT = 8888;
	private String userId;

	public Client() throws UnknownHostException, IOException {
		super(IP, PORT);
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void sendMessage(String message) {
		try (PrintStream p = new PrintStream(this.getOutputStream());) {
			p.println(message);
			p.flush();
		} catch (IOException ioe) {
			System.out.println("서버에 메세지 전달 실패");
		}
	}
}
