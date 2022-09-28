public class Produto{
    private String codigo;
    private String descricao;
    private double preco;
    private int estoque;
    
    public Produto (String c){
        this.codigo = c;
    }
    public Produto (String c,String d){
        this.codigo = c;
        this.descricao = d;
    }
    public Produto (String c,String d, double p,int e){
        this.codigo = c;
        this.descricao = d;
        this.preco = p;
        this.estoque = e;
    }
    
    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return this.estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
    
    public Produto copiarProduto(){
        Produto aux = null;
        aux = new Produto (this.codigo,this.descricao);
        aux.setEstoque(this.estoque);
        aux.setPreco(this.preco);
        
        return aux;
    }
    
    @Override
    public String toString (){
        return "O codigo: " + this.codigo + " descricao: " + this.descricao + " preco" + this.preco + " estoque: " + this.estoque ;
    }
    
    public int compareTo (Produto p){
        int result;
        result = this.getCodigo().compareTo(p.getCodigo());
        return result;
    }
}