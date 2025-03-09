package network.exception.connect;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

public class ConnectMain {
    public static void main(String[] args) throws IOException {
        unKnownHostEx1();
        unKnownHostEx2();
        connectionRefused();
    }

    private static void connectionRefused() throws IOException {
        try {
            new Socket("localhost", 45678);
        } catch (ConnectException e) {
            e.printStackTrace();
        }
    }

    private static void unKnownHostEx2() {
        try {
            Socket socket = new Socket("google.gogo", 80);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void unKnownHostEx1() {
        try {
            Socket socket = new Socket("999.999.9.9", 80);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
