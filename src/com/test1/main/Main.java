package com.test1.main;
import java.net.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        int port = 3567;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.out.println("Port Error");
            System.exit(-1);
        }
        while (serverSocket != null) {
            new Proxy(serverSocket.accept()).start();
        }
        serverSocket.close();
    }
}

class Proxy extends Thread {

    private final Socket client;

    public Proxy(Socket socket) {
        this.client = socket;
    }

    public void run() {
        try {

            InputStream incommingRequest = client.getInputStream();
            byte[] b = new byte[8196];
            int len = incommingRequest.read(b);

            if (len > 0) {
                String request =new String(b, 0, len);

                System.out.println("REQUEST");
                System.out.println("-------------");
                System.out.println(request);

                URL u = new URL(request.split(" ")[1]);
                if (!(u.getProtocol().equalsIgnoreCase("http"))) {
                    System.err.println("Solo proceso html!");
                }

                Socket newSocket = new Socket(u.getHost(), 80);
                OutputStream responseOS = newSocket.getOutputStream();
                responseOS.write(b, 0, len);

                OutputStream incommingOS = client.getOutputStream();
                InputStream outgoingIS = newSocket.getInputStream();

                System.out.println("RESPONSE");

                System.out.println("-------------");
                for (int length; (length = outgoingIS.read(b)) != -1;) {
                    incommingOS.write(b, 0, length);
                    System.out.println(new String(b,0,length));
                }

                incommingOS.flush();
                incommingOS.close();
                outgoingIS.close();
                responseOS.close();
                incommingRequest.close();
                newSocket.close();
            } else {
                incommingRequest.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}