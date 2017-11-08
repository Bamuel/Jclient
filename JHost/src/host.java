import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class host {

    public static void main(String args[]) throws IOException {
        final int portNumber = 81;
        System.out.println("Creating server socket on port " + portNumber);
        ServerSocket serverSocket = new ServerSocket(portNumber);
        while (true) {
            Socket socket = serverSocket.accept();
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os, true);
            pw.println("SEND MSG?");

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str = br.readLine();

            if (Objects.equals(str, "INT")){
                Random rand = new Random();
                pw.println(rand.nextInt(50));
                pw.close();
                socket.close();
                System.out.println("Just send a RND number");
            }
            else if (Objects.equals(str, "MESSAGE")){
                pw.println(readfile());
                pw.close();
                socket.close();
                System.out.println("Just send a secret message");
            }
            else {
                pw.println("Secret Message Set!");
                writefile(str);
                pw.close();
                socket.close();
            }
        }
    }
    private static String readfile() throws IOException {
        File file = new File("../JHost/src/message.txt");
        Scanner sc = new Scanner(file);
        String string = "";
        while(sc.hasNextLine()){
            string += sc.nextLine();
        }
        return string;
    }
    private static void writefile(String string) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("../JHost/src/message.txt", "UTF-8");
        writer.println(string);
        writer.close();
    }
}