public class Lista {
    private NoLista prim;

    public Lista() {
        this.prim = null;
    }

    public void insere(int v) {
        NoLista novo = new NoLista();
        novo.setInfo(v);
        novo.setProx(this.prim);
        this.prim = novo;
    }

    public void imprime() {
        NoLista p = this.prim;
        while (p != null) {
            System.out.println(p.getInfo());
            p = p.getProx();
        }
    }

    public String toString() {
        String lista = "";
        NoLista p = this.prim;
        while (p != null) {
            lista += p + " ";
            p = p.getProx();
        }
        return lista;
    }

    public boolean vazia() {
        if (this.prim == null) {
            return true;
        }
        return false;
    }

    public NoLista busca(int v) {
        NoLista p = this.prim;
        while (p != null) {
            if (p.getInfo() == v) {
                return p;
            }
            p = p.getProx();
        }
        return null;
    }

    public int comprimento(){
        int cont = 0;
        NoLista p = this.prim;
        while (p != null) {
            cont++;
            p = p.getProx();
        }
        return cont;
    }

    public NoLista ultimo() {
        NoLista p = this.prim;
        while (p != null) {
            if (p.getProx() == null) {
                return p;
            }
            p = p.getProx();
        }
        return null;
    }

    public void retirar(int v) {
        NoLista p = this.prim;
        NoLista ant = null;
        while(p != null && p.getInfo() != v) {
            ant = p;
            p = p.getProx();
        }
        if (p != null) {
            if (ant == null) {
                this.prim = p.getProx();
            } else {
                ant.setProx(p.getProx());
            }
        }
    }

    public void libera() {
        this.prim = null;
    }

    public void insereFim(int v) {
        NoLista novo = new NoLista();
        novo.setInfo(v);
        novo.setProx(null);
        if (this.vazia()) {
            prim = novo;
        } else {
            NoLista ultimo = this.ultimo();
            ultimo.setProx(novo);
        }
    }

    public boolean igual(Lista l) {
        if (this.comprimento() == l.comprimento()) {
            NoLista p1 = this.prim;
            NoLista p2 = l.prim;
            while (p1 != null) {
                if (p1.getInfo() != p2.getInfo()) {
                    return false;
                }
                p1 = p1.getProx();
                p2 = p2.getProx();
            }
            return true;
        }
        return false;
    }

    public void imprimeRecursivo() {
        imprimeRecursivoAux(prim);
    }

    private void imprimeRecursivoAux(NoLista l) {
        if(l == null) {
            System.out.println("");
        } else {
            System.out.print(l + " ");
            imprimeRecursivoAux(l.getProx());
        }
    }

    public void retirarRecursivo(int v) {
        retirarRecursivoAux(this.prim, v);
    }

    private NoLista retirarRecursivoAux(NoLista l, int v) {
        if (l != null) {
            if (l.getInfo() == v) {
                l = l.getProx();
            } else {
                l.setProx(retirarRecursivoAux(l.getProx(), v));
            }
        }
        return l;
    }

    public boolean igualRecursivo(Lista l) {
        return igualRecursivoAux(this.prim, l.prim);
    }

    private boolean igualRecursivoAux(NoLista l1, NoLista l2) {
        if (l1 == null && l2 == null) {
            return true;
        }
        if (l1 == null || l2 == null) {
            return false;
        }
        return (l1.getInfo() == l2.getInfo() && igualRecursivoAux(l1.getProx(), l2.getProx()));
    }
}

