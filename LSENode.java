public class LSENode {
    private Produto info;
    private LSENode prox;

    public LSENode(Produto info) {
        this.info = info;
    }

    public Produto getInfo() {
        return info;
    }

    public void setInfo(Produto info) {
        this.info = info;
    }

    public LSENode getProx() {
        return prox;
    }

    public void setProx(LSENode prox) {
        this.prox = prox;
    }
}