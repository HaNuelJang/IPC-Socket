package simple.socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class Server extends ServerSocket {
	private static final int PORT = 8888;
	private String userId;

	public Server() throws IOException {
		super(PORT);
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String receiveMessage(Socket client) {
		String message = null;
		try (InputStream in = client.getInputStream();
				InputStreamReader insr = new InputStreamReader(in, StandardCharsets.UTF_8);) {
			message = new BufferedReader(insr).lines().collect(Collectors.joining("\n"));
		} catch (IOException ioe) {
			System.out.println("클라이언트의 메세지 수신 실패");
		}
		return message;
	}
}
