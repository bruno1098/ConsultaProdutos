package br.com.fiap;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1521);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            Scanner scanner = new Scanner(System.in);
            System.out.println("***********************************************************************");
            System.out.println("[Bem vindo(a) a consulta de produtos!]");
            System.out.print("\nPara receber as informações sobre o produto digite o seu ID (De 1 a 7):");
            int idDoProduto = scanner.nextInt();
            System.out.println("***********************************************************************");
            outputStream.writeInt(idDoProduto);
            outputStream.flush();
            Produto produto = (Produto) inputStream.readObject();
            System.out.println(produto);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}