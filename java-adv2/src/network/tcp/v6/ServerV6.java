package network.tcp.v6;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static util.MyLogger.log;

public class ServerV6 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {

        log("서버 시작");
        SessionMangerV6 sessionManger = new SessionMangerV6();
        ServerSocket serverSocket = new ServerSocket(PORT);
        log("서버 포트 시작 - 리스닝 포트: " + PORT);

        ShutDownHook shutDownHook = new ShutDownHook(serverSocket, sessionManger);
        Runtime.getRuntime().addShutdownHook(new Thread(shutDownHook, "shutdownHook"));

        try {
            while (true) {
                Socket socket = serverSocket.accept();
                log("소켓 연결: " + socket);

                SessionV6 session = new SessionV6(socket, sessionManger);
                new Thread(session).start();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    static class ShutDownHook implements Runnable {

        private final ServerSocket serverSocket;
        private final SessionMangerV6 sessionManger;

        public ShutDownHook(ServerSocket serverSocket, SessionMangerV6 sessionManger) {
            this.serverSocket = serverSocket;
            this.sessionManger = sessionManger;
        }

        @Override
        public void run() {

            log("shutDownHook 실행");
            try {
                sessionManger.closeAll();
                serverSocket.close();

                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
