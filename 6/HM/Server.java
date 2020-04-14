package HM;
import java.io.*;
import java.net.*;

public class Server {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public static void main(String[] args) {
        new Server();
    }

    Server(){
        inputFromClient();
    }

    public void  inputFromClient(){
        try(ServerSocket serverSocket = new ServerSocket(8189)){
            System.out.println("Сервер запустился!");
            System.out.println("Для закрытия соединения с клиетом и завершение программы введите '/End'");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                try {
                    out.writeUTF("Соединение установлено");
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

            new Thread(() -> {
                try {
                    String str;
                    while (true){
                        str = in.readUTF();
                        if(str.equals("/End")){
                            System.out.println("Клиент закрыл соединение");
                            close(in, out, socket);
                            System.exit(0);
                        } else {
                            System.out.println("Client: " + str);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
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
}
