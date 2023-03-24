#include"lista_simples.h"
#include<stdio.h>

int main() {
    NoLista *head = sllCria();
    head = sllInsere(head,0);
    head = sllInsere(head,8);
    head = sllInsere(head,7);
    sllImprime(head);
    printf("A lista está vazia: %d \n",sllVazia(head));
    printf("%d ", sllUltimo(head)->info);
}

