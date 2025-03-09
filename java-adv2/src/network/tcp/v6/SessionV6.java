package network.tcp.v6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static network.tcp.SocketCloseUtil.closeAll;
import static util.MyLogger.log;

public class SessionV6 implements Runnable {

    private final Socket socket;
    private final DataOutputStream output;
    private final DataInputStream input;
    private final SessionMangerV6 sessionManger;
    private boolean closed = false;

    public SessionV6(Socket socket, SessionMangerV6 sessionManger) throws IOException {
        this.socket = socket;
        input = new DataInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());
        this.sessionManger = sessionManger;
        this.sessionManger.add(this);
    }

    @Override
    public void run() {
        try {
            while (true) {
                String received = input.readUTF();
                log("server <- client: " + received);

                if (received.equals("exit")) {
                    break;
                }

                String toSend = received + " world!";
                output.writeUTF(toSend);
                log("server -> client: " + toSend);
            }

        } catch (IOException e) {
            log(e);
        } finally {
            sessionManger.remove(this);
            this.close();
        }

    }

    public synchronized void close() {
        if (closed) {
            return;
        }

        closeAll(socket, input, output);
        closed = true;
        log("연결 종료: " + socket);

    }
}
