package br.com.fiap;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    private static void initEntityManager() {
        entityManagerFactory = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
        entityManager = entityManagerFactory.createEntityManager();
    }

    private static void closeEntityManager() {
        entityManager.close();
        entityManagerFactory.close();
    }

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1521);
            System.out.println("******************");
            System.out.print("SERVIDOR RODANDO");
            System.out.println("\n******************");
            while (true) {
                Socket socket = serverSocket.accept();
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

                int idDoProduto = inputStream.readInt();
                Produto produto = buscarProdutoPorId(idDoProduto);

                outputStream.writeObject(produto);
                outputStream.flush();
                socket.close();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static Produto buscarProdutoPorId(int idDoProduto) {

        initEntityManager();
        Produto produto = null;

        try {
            entityManager.getTransaction().begin();
            //select
            Query query = entityManager.createQuery("SELECT p FROM Produto p WHERE p.id = :id");
            query.setParameter("id", idDoProduto);
            produto = (Produto) query.getSingleResult();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            closeEntityManager();
        }
        return produto;
    }
}