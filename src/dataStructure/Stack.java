package dataStructure;

// Define a classe Stack (Pilha)
public class Stack {
    private Node top;  // Armazena o nó no topo da pilha
    private int height;  // Armazena a altura (quantidade de elementos) da pilha

    // Define a classe interna Node (Nó) que representa cada elemento na pilha
    public class Node {
        int value;  // Armazena o valor do nó
        Node next;  // Aponta para o próximo nó na pilha

        // Construtor do nó que inicializa o valor
        Node(int value){
            this.value = value;
        }

        // Método que retorna o valor do nó
        public int getValue() {
            return value;
        }
    }

    // Construtor da pilha que inicializa a pilha com um nó
    public Stack(int value) {
        Node newNode = new Node(value);  // Cria um novo nó com o valor fornecido
        top = newNode;  // Define este nó como o topo da pilha
        height = 1;  // Define a altura da pilha como 1
    }

    // Método para imprimir o valor do topo da pilha
    public void getTop() {
        if (top == null) {  // Verifica se a pilha está vazia
            System.out.println("Pilha vazia");  // Imprime uma mensagem se a pilha estiver vazia
        } else {
            System.out.println("top: " + top.value);  // Imprime o valor do topo da pilha
        }
    }

    // Método para imprimir a altura da pilha
    public void getHeight() {
        System.out.println("Altura: " + height);  // Imprime a altura da pilha
    }

    // Método para imprimir todos os elementos da pilha
    public void print() {
        System.out.println("#########################");
        Node temp = top;  // Começa pelo topo da pilha
        while (temp != null) {  // Percorre a pilha até o fim
            System.out.println(temp.value);  // Imprime o valor de cada nó
            temp = temp.next;  // Passa para o próximo nó
        }
        System.out.println("#########################");
    }

    // Método para adicionar um elemento ao topo da pilha
    public void push(int value) {
        Node newNode = new Node(value);  // Cria um novo nó com o valor fornecido
        if (height == 0) {  // Se a pilha estiver vazia
            top = newNode;  // Define o novo nó como o topo da pilha
        } else {
            newNode.next = top;  // Liga o novo nó ao antigo topo
            top = newNode;  // Define o novo nó como o novo topo da pilha
        }
        height++;  // Incrementa a altura da pilha
    }

    // Método para remover o elemento do topo da pilha
    public Node pop() {
        if (height == 0) return null;  // Se a pilha estiver vazia, retorna nulo

        Node temp = top;  // Salva a referência ao topo atual
        top = top.next;  // Define o novo topo como o próximo nó
        temp.next = null;  // Remove a referência ao próximo nó do nó removido
        height--;  // Decrementa a altura da pilha

        return temp;  // Retorna o nó removido
    }

    // Método principal para testar a pilha
    public static void main(String[] args){
        // Cria uma nova pilha com um elemento inicial (valor 2)
        Stack myStack = new Stack(2);

        // Adiciona um elemento ao topo da pilha (valor 1)
        myStack.push(1);

        // Remove e imprime o elemento do topo da pilha (valor 1)
        Node poppedNode1 = myStack.pop();
        if (poppedNode1 != null) {
            System.out.println("Elemento removido do topo da pilha: " + poppedNode1.value);
        } else {
            System.out.println("A pilha está vazia.");
        }

        // Remove e imprime o próximo elemento do topo da pilha (valor 2)
        Node poppedNode2 = myStack.pop();
        if (poppedNode2 != null) {
            System.out.println("Elemento removido do topo da pilha: " + poppedNode2.value);
        } else {
            System.out.println("A pilha está vazia.");
        }

        // Imprime a pilha após as operações
        myStack.print();

        // Imprime o valor do topo da pilha e a altura da pilha
        myStack.getTop();
        myStack.getHeight();

        // Imprime a pilha novamente após as operações
        myStack.print();
    }

}
