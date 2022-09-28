import java.util.Scanner;

public class LSEProduto {
    private LSENode primeiro;

    public boolean isEmpty() {
        if (this.primeiro == null) {
            return true;
        } else {
            return false;
        }
    }

    public LSENode busca(Produto p) {
        LSENode aux;

        if (this.isEmpty() == true) {
            return null;
        } else {
            aux = this.primeiro;
            while (aux != null) {
                if (aux.getInfo().compareTo(p) == 0) {
                    return aux;
                } else {
                    aux = aux.getProx();
                }

            }
        }
        return null;
    }

    public void inserirNoInicio(Produto p) {
        LSENode aux;
        LSENode result = this.busca(p);

        if (result != null) {
            System.out.println("aluno já cadastrado! ");
        } else {
            aux = new LSENode(p);
            if (this.isEmpty() == true) {
                System.out.println("Lista está vazia");
                this.primeiro = aux;
                System.out.println("Insercao realizada! ");
            } else {
                System.out.println("Lista nao vazia! ");
                aux.setProx(this.primeiro);
                this.primeiro = aux;
                System.out.println("Insrcao realizada ");
            }
        }
    }

    public void inserirNoFinal(Produto al) {
        LSENode novo, aux;
        LSENode result = this.busca(al);

        if (result != null) {
            System.out.println("Aluno já cadastrado");
        } else {
            novo = new LSENode(al);
            if (this.isEmpty() == true) {
                this.primeiro = novo;
            } else {
                aux = this.primeiro;
                while (aux != null) {
                    aux = aux.getProx();
                }
                aux.setProx(novo);
            }
            System.out.println("Insercao realizada! ");
        }
    }

    public void exibirTodos() {
        LSENode aux;
        if (this.isEmpty() == true) {
            System.out.println("Lista vazia!! ");
        } else {
            aux = this.primeiro;
            while (aux != null) {
                System.out.println(aux);
                aux = aux.getProx();
            }
        }
    }

    public void exibirProduto(String codigo) {
        Produto p = new Produto(codigo);
        LSENode result = this.busca(p);

        if (result == null) {
            System.out.println("Produto nao escontrado! ");
        } else {
            if (this.isEmpty() == true) {
                System.out.println("Lista está vazia! ");
            } else {
                System.out.println(result.getInfo());
            }
        }
    }

    public void removerNoInicio() {
        if (this.isEmpty() == true) {
            System.out.println("Lista vazia");
        } else {
            this.primeiro = this.primeiro.getProx();
        }
    }

    public void removerNoFinal() {
        LSENode aux, penultimo = null;
        if (this.isEmpty() == true) {
            System.out.println("Lista vazia! ");
        } else {
            aux = this.primeiro;
            while (aux != null) {
                penultimo = aux;
                aux = aux.getProx();
            }
            penultimo.setProx(null);
            System.out.println("Remocão efetuada");
        }
    }

    public LSEProduto criarCopia() {
        Produto auxP, novoProduto;
        LSEProduto outra = new LSEProduto();
        LSENode aux;

        if (this.isEmpty() == true) {
            return outra;
        } else {
            aux = this.primeiro;
            while (aux != null) {
                auxP = aux.getInfo();
                novoProduto = new Produto(auxP.getCodigo(), auxP.getDescricao());
                novoProduto.setEstoque(auxP.getEstoque());
                novoProduto.setPreco(auxP.getPreco());
                outra.inserirNoFinal(novoProduto);
                aux = aux.getProx();
            }
            return outra;
        }
    }

    public void alterarDados(String codigo) {
        Scanner in = new Scanner(System.in);
        Produto p = new Produto(codigo);
        LSENode result = this.busca(p);
        int op, novoEstoque;

        if (result == null) {
            System.out.println("Produto nao escontrado! ");
        } else {
            if (this.isEmpty() == true) {
                System.out.println("Lista está vazia! ");
            } else {
                System.out.println("Voce deseja alterar (preço e/ou estoque) do produto");
                System.out.println("Digite 1 - preço || 2 - estoque || 3 - preço e estoque || 0 - nenhum");
                op = in.nextInt();
                double novoPreco;

                do {
                    switch (op) {
                        case 1:
                            System.out.println("EScolheu modificar o preço: ");
                            System.out.println("Digite o novo preco");
                            novoPreco = in.nextDouble();
                            result.getInfo().setPreco(novoPreco);
                            break;
                        case 2:
                            System.out.println("Escolheu modificar o estoque: ");
                            System.out.println("Digite o novo estoque");
                            novoEstoque = in.nextInt();
                            result.getInfo().setEstoque(novoEstoque);
                            break;
                        case 3:
                            System.out.println("Escolheu modificar ambos (preço e estoque)");
                            System.out.println("Digite o novo preco");
                            novoPreco = in.nextDouble();
                            result.getInfo().setPreco(novoPreco);
                            System.out.println("Digite o novo estoque");
                            novoEstoque = in.nextInt();
                            result.getInfo().setEstoque(novoEstoque);
                            break;
                        case 0:
                            System.out.println("BYE BYE!!");
                            break;

                        default:
                            System.out.println(" digitou algo errado ");

                    }
                } while (op != 0);
            }
        }
    }

    public void removerSemBusca(String codigo) {
        Produto p = new Produto(codigo);
        LSENode aux = new LSENode(p);
        LSENode atual, anterior = null;

        if (this.isEmpty() == true) {
            System.out.println("Lista vazia!");
        } else {
            if (this.primeiro.getProx() == null) {//lista com apenas um nó
                atual = this.primeiro;
                if (atual.getInfo() == aux.getInfo()) {
                    this.primeiro = null;
                } else {
                    System.out.println("O produto nao existe na lista");
                }
            } else {
                atual = this.primeiro;
                while (atual.getInfo() != aux.getInfo()) {
                    anterior = atual;
                    atual = atual.getProx();
                }
                anterior.setProx(atual.getProx());
            }

        }
    }

    public void removerValorSelecionado(String codigo) {
        LSENode aux;
        int qtdRemovido = 0;
        
        if (this.isEmpty() == true){
            System.out.println("Lista vazia! ");
        }else{
            aux = this.primeiro;
            while (aux != null){
                if (aux.getInfo().getCodigo().compareTo(codigo) == 0){
                    this.removerSemBusca(aux.getInfo().getCodigo());
                    qtdRemovido++;
                }
                aux = aux.getProx();
            }
            System.out.println("Remocoes efetuadas total de: " + qtdRemovido + " de produtos removidos." );
        }
    }
    
    

}
