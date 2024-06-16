package dataStructure;  // Declara que o código está no pacote dataStructure

public class LinkedList {  // Declara uma classe chamada LinkedList (Lista Encadeada)
    private Node head;  // Declara uma variável head (cabeça) para armazenar o primeiro nó da lista
    private Node tail;  // Declara uma variável tail (cauda) para armazenar o último nó da lista
    private int length;  // Declara uma variável length (comprimento) para armazenar o número de elementos na lista

    class Node {  // Declara uma classe interna chamada Node (Nó) que representa cada elemento da lista
        String data;  // Declara uma variável data para armazenar os dados do nó
        Node next;  // Declara uma variável next para armazenar a referência ao próximo nó na lista

        Node(String data){  // Construtor para inicializar um nó com os dados fornecidos
            this.data  = data;  // Define os dados do nó
        }
    }

    public LinkedList(String data){  // Construtor para inicializar a lista com um elemento
        length = 1;  // Define o comprimento da lista como 1
        Node newNode = new Node(data);  // Cria um novo nó com os dados fornecidos
        head = newNode;  // Define o novo nó como a cabeça da lista
        tail = newNode;  // Define o novo nó como a cauda da lista
    }

    public void getHead(){  // Método para imprimir os dados da cabeça da lista
        if(this.head == null){  // Verifica se a lista está vazia
            System.out.println("Lista vazia");  // Imprime uma mensagem se a lista estiver vazia
        } else {
            System.out.println("Head: " + head.data);  // Imprime os dados da cabeça da lista
        }
    }

    public void getTail(){  // Método para imprimir os dados da cauda da lista
        if(this.tail == null){  // Verifica se a lista está vazia
            System.out.println("Lista vazia");  // Imprime uma mensagem se a lista estiver vazia
        }  else {
            System.out.println("Tail: " + tail.data);  // Imprime os dados da cauda da lista
        }
    }

    public void getLength(){  // Método para imprimir o comprimento da lista
        System.out.println("Length: " + this.length);  // Imprime o comprimento da lista
    }

    public void makeEmpty(){  // Método para esvaziar a lista
        head = null;  // Define a cabeça como nula
        tail = null;  // Define a cauda como nula
        length = 0;  // Define o comprimento como 0
    }

    public void print(){  // Método para imprimir todos os elementos da lista
        System.out.println("#################");
        Node temp = this.head;  // Começa pela cabeça da lista
        while (temp != null){  // Percorre a lista até o fim
            System.out.println(temp.data);  // Imprime os dados de cada nó
            temp = temp.next;  // Passa para o próximo nó
        }
        System.out.println("#################");
    }

    public void append(String data){  // Método para adicionar um elemento no final da lista
        Node newNode = new Node(data);  // Cria um novo nó com os dados fornecidos
        if(length == 0){  // Se a lista estiver vazia
            head = newNode;  // Define o novo nó como a cabeça
            tail = newNode;  // Define o novo nó como a cauda
        } else {
            tail.next = newNode;  // Liga a cauda atual ao novo nó
            tail = newNode;  // Define o novo nó como a nova cauda
        }
        length++;  // Incrementa o comprimento da lista
    }

    public Node removeLast(){  // Método para remover o último elemento da lista
        if(length == 0) return null;  // Se a lista estiver vazia, retorna nulo
        if(length == 1) {  // Se a lista tiver apenas um elemento
            Node temp = head;  // Salva a referência ao único nó
            head = null;  // Define a cabeça como nula
            tail = null;  // Define a cauda como nula
            length--;  // Decrementa o comprimento da lista
            return temp;  // Retorna o nó removido
        }
        Node pre = head;  // Começa pela cabeça da lista
        while (pre.next != tail) {  // Percorre a lista até o penúltimo nó
            pre = pre.next;
        }
        Node temp = tail;  // Salva a referência à cauda atual
        tail = pre;  // Define o penúltimo nó como a nova cauda
        tail.next = null;  // Remove a referência ao antigo último nó
        length--;  // Decrementa o comprimento da lista
        return temp;  // Retorna o nó removido
    }

    public void prepend(String data){  // Método para adicionar um elemento no início da lista
        Node newNode = new Node(data);  // Cria um novo nó com os dados fornecidos
        if(length == 0){  // Se a lista estiver vazia
            head = newNode;  // Define o novo nó como a cabeça
            tail = newNode;  // Define o novo nó como a cauda
        } else {
            newNode.next = head;  // Liga o novo nó à antiga cabeça
            head = newNode;  // Define o novo nó como a nova cabeça
        }
        length++;  // Incrementa o comprimento da lista
    }

    public Node removeFirst(){  // Método para remover o primeiro elemento da lista
        if (length == 0) return null;  // Se a lista estiver vazia, retorna nulo
        Node temp = head;  // Salva a referência à cabeça atual
        head = head.next;  // Define a nova cabeça como o segundo nó
        temp.next = null;  // Remove a referência ao próximo nó do antigo primeiro nó
        length--;  // Decrementa o comprimento da lista
        if (length == 0){  // Se a lista ficou vazia
            head = null;  // Define a cabeça como nula
            tail = null;  // Define a cauda como nula
        }
        return temp;  // Retorna o nó removido
    }

    public Node get(int index){  // Método para obter o elemento em uma posição específica
        if(index < 0 || index >= length) return null;  // Se o índice for inválido, retorna nulo
        Node temp = head;  // Começa pela cabeça da lista
        for(int i = 0; i < index; i++){  // Percorre a lista até a posição desejada
            temp = temp.next;
        }
        return temp;  // Retorna o nó encontrado
    }

    public boolean insert(int index, String data){  // Método para inserir um elemento em uma posição específica
        if(index < 0 || index > length) return false;  // Se o índice for inválido, retorna falso

        if(index == 0){  // Se a posição for o início da lista
            prepend(data);  // Adiciona no início
            return true;
        }

        if (index == length){  // Se a posição for o fim da lista
            append(data);  // Adiciona no final
            return true;
        }

        Node newNode = new Node(data);  // Cria um novo nó com os dados fornecidos
        Node temp = get(index - 1);  // Obtém o nó anterior à posição desejada
        newNode.next = temp.next;  // Liga o novo nó ao nó seguinte
        temp.next = newNode;  // Liga o nó anterior ao novo nó
        length++;  // Incrementa o comprimento da lista
        return true;
    }

    public boolean set(int index, String data) {  // Método para atualizar os dados de um nó em uma posição específica
        Node temp = get(index);  // Obtém o nó na posição desejada
        if(temp !=null){  // Se o nó foi encontrado
            temp.data = data;  // Atualiza os dados do nó
            return true;  // Retorna verdadeiro
        }
        return false;  // Se o nó não foi encontrado, retorna falso
    }

    public Node remove(int index){  // Método para remover um nó em uma posição específica
        if(index < 0 || index >= length) return null;  // Se o índice for inválido, retorna nulo
        if (index == 0) return removeFirst();  // Se a posição for o início, remove o primeiro nó
        if (index == length - 1) return removeLast();  // Se a posição for o fim, remove o último nó

        Node prev = get(index - 1);  // Obtém o nó anterior à posição desejada
        Node temp = prev.next;  // Salva a referência ao nó que será removido

        prev.next = temp.next;  // Liga o nó anterior ao nó seguinte
        temp.next = null;  // Remove a referência ao próximo nó do nó removido
        length--;  // Decrementa o comprimento da lista

        return temp;  // Retorna o nó removido
    }

    public static void main(String[] args){
        // Cria uma lista com um elemento inicial e imprime a lista
        System.out.println("Lista com um elemento:");
        LinkedList list = new LinkedList("elemento 1");
        list.print();  // Imprime os elementos da lista

        // Adiciona elementos no final da lista e imprime a lista
        System.out.println("Adiciona elementos à Lista:");
        list.append("elemento 2");
        list.append("elemento 3");
        list.prepend("elemento 0");
        list.print();  // Imprime os elementos da lista

        // Remove o elemento na posição 2 (começando do índice 0) e imprime a lista
        System.out.println("Remove elementos da Lista (índice 2):");
        list.remove(2);
        list.print();  // Imprime os elementos da lista

        // Adiciona um elemento na posição 2 (começando do índice 0) e imprime a lista
        System.out.println("Adiciona elementos à Lista no índice 2:");
        list.insert(2, "elemento 2.5");
        list.print();  // Imprime os elementos da lista

        // Obtém e imprime a cabeça (primeiro elemento) da lista
        System.out.println("Obtém o primeiro elemento (head) da Lista:");
        list.getHead();

        // Obtém e imprime a cauda (último elemento) da lista
        System.out.println("Obtém o último elemento (tail) da Lista:");
        list.getTail();

        // Obtém e imprime o comprimento da lista
        System.out.println("Obtém o comprimento da Lista:");
        list.getLength();

        // Define um novo valor para o elemento na posição 1 (começando do índice 0) e imprime a lista
        System.out.println("Atualiza o elemento no índice 1:");
        list.set(1, "elemento atualizado");
        list.print();  // Imprime os elementos da lista

        // Remove o primeiro elemento da lista e imprime a lista
        System.out.println("Remove o primeiro elemento da Lista:");
        list.removeFirst();
        list.print();  // Imprime os elementos da lista

        // Remove o último elemento da lista e imprime a lista
        System.out.println("Remove o último elemento da Lista:");
        list.removeLast();
        list.print();  // Imprime os elementos da lista

        // Esvazia a lista e imprime o comprimento para confirmar
        System.out.println("Esvazia a Lista:");
        list.makeEmpty();
        list.print();  // Imprime os elementos da lista (deve estar vazia)
        list.getLength();  // Imprime o comprimento da lista (deve ser 0)
    }
}
