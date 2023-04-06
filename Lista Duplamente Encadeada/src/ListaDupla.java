import java.sql.ClientInfoStatus;

public class ListaDupla {
    NoListaDupla prim;

    public ListaDupla() {
        this.prim = null;
    }

    public void insere(int v) {
        NoListaDupla novo = new NoListaDupla();
        novo.setInfo(v);
        novo.setProx(this.prim);
        novo.setAnt(null);
        if (this.prim != null) {
            prim.setAnt(novo);
        }
        this.prim = novo;
    }

    public void imprime() {
        NoListaDupla p = this.prim;
        while (p != null) {
            System.out.print(p.getInfo() + " ");
            p = p.getProx();
        }
        System.out.println("");
    }

    public boolean vazia() {
        if (this.prim == null) return true;
        return false;
    }

    public NoListaDupla busca(int v) {
        NoListaDupla p = this.prim;
        while (p != null) {
            if (p.getInfo() == v) {
                return p;
            }
            p = p.getProx();
        }
        return null;
    }

    public int comprimento() {
        int cont = 0;
        NoListaDupla p = this.prim;
        while (p != null) {
            cont++;
            p = p.getProx();
        }
        return cont;
    }

    public NoListaDupla ultimo() {
        NoListaDupla p = this.prim;
        while (p != null) {
            if (p.getProx() == null) {
                return p;
            }
            p = p.getProx();
        }
        return null;
    }

    public void retira(int v) {
        NoListaDupla p = busca(v);
        if (p == null) {
            return;
        }
        if (prim == p) {
            this.prim = p.prox;
        } else {
            p.ant.setProx(p.prox);
        }

        if (p.prox != null) {
            p.prox.setAnt(p.ant);
        }
    }

    public void libera() {
        this.prim = null;
    }

    public void insereFim(int v) {
        NoListaDupla novo = new NoListaDupla();
        novo.setInfo(v);
        novo.setProx(null);
        if (this.vazia()) {
            prim = novo;
        } else {
            NoListaDupla ultimo = this.ultimo();
            ultimo.setProx(novo);
        }
    }
    public boolean igual(ListaDupla l) {
        if (this.comprimento() == l.comprimento()) {
            NoListaDupla p1 = this.prim;
            NoListaDupla p2 = l.prim;
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
    public ListaDupla merge(ListaDupla l) {
        ListaDupla lista = new ListaDupla();
        NoListaDupla p1 = this.prim;
        NoListaDupla p2 = l.prim;

        while (p1 != null || p2 != null) {
            if (p1 == null) {
                lista.insereFim(p2.getInfo());
                p2 = p2.getProx();
            } else if (p2 == null) {
                lista.insereFim(p1.getInfo());
                p1 = p1.getProx();
            } else {
                lista.insereFim(p1.getInfo());
                lista.insereFim(p2.getInfo());
                p1 = p1.getProx();
                p2 = p2.getProx();
            }
        }
        return lista;
    }
}
