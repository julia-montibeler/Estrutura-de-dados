#include"lista_simples.h"
#include<stdio.h>
#include<stdlib.h>

NoLista *sllCria(void) {
    Lista lista;
    lista.prim = NULL;
    return lista.prim;
};

NoLista *sllInsere(NoLista *head, int v) {
    NoLista *novo = (NoLista*)malloc(sizeof(NoLista));
    novo->info = v;
    novo->prox = head;
    return novo;
};

void sllImprime(NoLista *head) {
    NoLista *p = head;
    while (p != NULL)
    {
        printf("%d ",p->info);
        p = p->prox;
    }
    printf("\n");
};

int sllVazia(NoLista *head)
{
    if (head == NULL)
    {
        return 1;
    }
    return 0;
}


NoLista *sllBusca(NoLista *head, int v) 
{
    NoLista *p = head;
    while (p != NULL)
    {
        if (p->info == v)
        {
            return p;
        }
        p = p->prox;
    }
    return NULL;
}

int sllComprimento(NoLista *head)
{
    int cont = 0;
    NoLista *p = head;
    while (p != NULL)
    {
        cont++;
        p = p->prox;
    }
    return cont;
}

NoLista *sllUltimo(NoLista *head)
{
    NoLista *p = head;
    while (p != NULL)
    {
        if (p->prox == NULL)
        {
            break;
        }
        p = p->prox;
    }
    return p;
}