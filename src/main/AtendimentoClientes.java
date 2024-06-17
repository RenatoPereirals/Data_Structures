package main;

import dataStructure.Queue;
import java.util.Random;

/**
 * Simula o atendimento de clientes em uma fila.
 * A classe cria uma fila de clientes com valores aleatórios e atende cada cliente na ordem de chegada.
 */
public class AtendimentoClientes {
    public static void main(String[] args) {
        int quantClientes = 5; // Define a quantidade de clientes a serem atendidos
        var random = new Random(); // Instancia a classe Random para gerar números aleatórios
        int cliente = random.nextInt(101); // Gera um número aleatório para o primeiro cliente (0-100)

        Queue queue = new Queue(cliente); // Cria uma fila e adiciona o primeiro cliente
        System.out.println("------------------------");
        System.out.println("Chegou o cliente: " + cliente);

        // Simula a chegada dos clientes
        for (int i = 2; i <= quantClientes; i++) {
            cliente = random.nextInt(101); // Gera um número aleatório para o próximo cliente (0-100)
            System.out.println("Chegou o cliente: " + cliente);
            queue.enqueue(cliente); // Adiciona o cliente à fila
        }

        System.out.println("------------------------");
        // Atendimento dos clientes
        var node = queue.dequeue(); // Remove o primeiro cliente da fila para atendimento
        while (node != null) {
            System.out.println("Atendendo o cliente: " + node.getValue()); // Atende o cliente e imprime o valor
            node = queue.dequeue(); // Remove o próximo cliente da fila para atendimento
        }
        System.out.println("------------------------");
    }
}
