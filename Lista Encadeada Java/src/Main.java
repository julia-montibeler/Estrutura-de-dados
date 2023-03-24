public class Main {
    public static void main(String[] args) {
        Lista lista1 = new Lista();
        Lista lista2 = new Lista();

        for (int i = 1; i < 6; i++) {
            lista1.insereFim(i);
        }

        for (int i = 1; i < 6; i++) {
            lista2.insereFim(i);
        }

        lista1.imprimeRecursivo();
        lista2.imprimeRecursivo();

        lista2.retirarRecursivo(5);
        lista2.retirar(1);
        lista1.imprimeRecursivo();
        lista2.imprimeRecursivo();

        if (lista1.igualRecursivo(lista2)) {
            System.out.println("As listas são iguais");
        } else {
            System.out.println("AS listas são diferentes");
        }

        lista2.insere(1);
        lista2.insereFim(5);
        lista1.imprimeRecursivo();
        lista2.imprimeRecursivo();


        if (lista1.igual(lista2)) {
            System.out.println("As listas são iguais");
        } else {
            System.out.println("AS listas são diferentes");
        }

        lista1.libera();
        if (lista1.vazia()) {
            System.out.println("A lista está vazia");
        } else {
            System.out.println("A lista possui elementos");
        }

    }
}