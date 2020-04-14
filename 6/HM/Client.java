package HM;

import java.io.*;
import java.net.Socket;

public class Client {
    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8189;

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public Client() {
        try {
            openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openConnection() throws IOException {
        socket = new Socket(SERVER_ADDR, SERVER_PORT);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        System.out.println("Для закрытия соединения с сервером и завершение программы введите '/End'");

        new Thread(() -> {
            try {
                String str;
                while(true){
                    str = in.readUTF();
                    if(str.equals("/End")){
                        System.out.println("Сервер закрыл соединение");
                        close(in, out, socket);
                        System.exit(0);
                    } else {
                        System.out.println("Server: " + str);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                String str;
                while (true){
                    str = inputFromKeyboard();
                    if(!str.equals("")){out.writeUTF(str); }
                    if(str.equals("/End")){
                        System.out.println("Вы закрыли соединение");
                        close(in, out, socket);
                        System.exit(0);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

    }

    public String inputFromKeyboard(){
        String str = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            str = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    private void close(Closeable... objects){
        for(Closeable o : objects){
            try {
                if (o != null) {
                    o.close();
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Client();
    }

}
