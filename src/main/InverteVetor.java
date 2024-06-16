package main;

import dataStructure.Stack;

/**
 * Este programa utiliza uma pilha para inverter os valores de um vetor de inteiros.
 */
public class InverteVetor {
    public static void main(String[] args){

        int[] numeros = {5, 4, 3, 2, 1};

        inverter(numeros);
    }

    /**
     * Inverte os valores de um vetor utilizando uma pilha.
     * @param numeros O vetor de inteiros a ser invertido.
     */
    private static void inverter(final int[] numeros){

        Stack stack = new Stack(numeros[0]);

        // Empilha os elementos restantes do vetor na pilha
        for (int i = 1; i < numeros.length; i++) {
            stack.push(numeros[i]);
        }

        // Desempilha e imprime os elementos da pilha, que agora estão invertidos
        var node = stack.pop();
        while(node != null) {
            System.out.println(node.getValue());
            node = stack.pop();
        }
    }
}
