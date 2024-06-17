package dataStructure;

// Definição da classe Queue (Fila)
public class Queue {
    // Campos da classe Queue para manter o primeiro e o último nó, além do comprimento da fila
    private Node first;
    private Node last;
    private int length;

    // Definição da classe interna Node, que representa cada elemento da fila
    public class Node {
        int value; // Valor armazenado no nó
        Node next; // Referência para o próximo nó na fila

        // Construtor da classe Node
        Node(int value) {
            this.value = value;
        }

        // Método para obter o valor do nó
        public int getValue() {
            return this.value;
        }
    }

    // Construtor da classe Queue, inicializa a fila com um valor inicial
    public Queue(int value) {
        Node newNode = new Node(value); // Cria um novo nó com o valor dado
        first = newNode; // Define o primeiro nó da fila
        last = newNode; // Define o último nó da fila
        length++; // Incrementa o comprimento da fila
    }

    // Método para obter o primeiro elemento da fila
    public void getFirst() {
        if (first != null) { // Verifica se a fila não está vazia
            System.out.println("First: " + first.value); // Imprime o valor do primeiro nó
        } else {
            System.out.println("Fila está vazia"); // Imprime uma mensagem se a fila estiver vazia
        }
    }

    // Método para obter o último elemento da fila
    public void getLast() {
        if (last != null) { // Verifica se a fila não está vazia
            System.out.println("Last: " + last.value); // Imprime o valor do último nó
        } else {
            System.out.println("Fila está vazia"); // Imprime uma mensagem se a fila estiver vazia
        }
    }

    // Método para obter o comprimento da fila
    public void getLength() {
        System.out.println("Length: " + length); // Imprime o comprimento da fila
    }

    // Método para imprimir todos os elementos da fila
    public void print() {
        System.out.println("######################");
        Node temp = first; // Começa do primeiro nó
        while (temp != null) { // Percorre todos os nós até o final da fila
            System.out.println(temp.value); // Imprime o valor do nó atual
            temp = temp.next; // Avança para o próximo nó
        }
        System.out.println("######################");
    }

    // Método para adicionar um elemento ao final da fila
    public void enqueue(int value) {
        Node newNode = new Node(value); // Cria um novo nó com o valor dado

        if (length == 0) { // Verifica se a fila está vazia
            first = newNode; // Define o novo nó como o primeiro
            last = newNode; // Define o novo nó como o último
        } else {
            last.next = newNode; // Adiciona o novo nó após o último nó atual
            last = newNode; // Atualiza o último nó para o novo nó
        }
        length++; // Incrementa o comprimento da fila
    }

    // Método para remover o primeiro elemento da fila
    public Node dequeue() {
        if (length == 0) return null; // Retorna null se a fila estiver vazia

        Node temp = first; // Armazena o primeiro nó
        if (length == 1) { // Verifica se a fila tem apenas um elemento
            first = null; // Define o primeiro nó como null
            last = null; // Define o último nó como null
        } else {
            first = first.next; // Avança para o próximo nó
            temp.next = null; // Desconecta o nó removido
        }
        length--; // Decrementa o comprimento da fila
        return temp; // Retorna o nó removido
    }

    public static void main(String[] args) {
        System.out.println("Criação da fila:");
        Queue myQueue = new Queue(1); // Cria uma nova fila com o valor inicial 1
        myQueue.print(); // Imprime a fila atual

        System.out.println("Adiciona elementos à fila:");
        myQueue.enqueue(2); // Adiciona o valor 2 à fila
        myQueue.enqueue(3); // Adiciona o valor 3 à fila
        myQueue.print(); // Imprime a fila atual

        System.out.println("Obtendo elementos:");
        myQueue.getFirst(); // Obtém o primeiro elemento da fila
        myQueue.getLast(); // Obtém o último elemento da fila
        myQueue.getLength(); // Obtém o comprimento da fila

        System.out.println("Removendo elementos da fila:");
        // Remove e imprime o primeiro elemento da fila (esperado: 1)
        System.out.println("Elemento removido: " + myQueue.dequeue().value);
        myQueue.print(); // Imprime a fila atual

        // Remove e imprime o próximo elemento da fila (esperado: 2)
        System.out.println("Elemento removido: " + myQueue.dequeue().value);
        myQueue.print(); // Imprime a fila atual

        // Remove e imprime o próximo elemento da fila (esperado: 3)
        System.out.println("Elemento removido: " + myQueue.dequeue().value);
        myQueue.print(); // Imprime a fila atual

        System.out.println("Obtendo elementos após remoções:");
        myQueue.getFirst(); // Obtém o primeiro elemento da fila
        myQueue.getLast(); // Obtém o último elemento da fila
        myQueue.getLength(); // Obtém o comprimento da fila
    }
}
