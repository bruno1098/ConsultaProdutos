package br.com.fiap;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TDS_TB_PRODUTOCS")
//name: nome igual ao generator, sequenceName: nome no Banco, allocationSize: incremento
@SequenceGenerator(name="produto", sequenceName = "", allocationSize = 1)
public class Produto implements Serializable{

    @Id
    @Column(name="ID")
    private int id;

    @Column(name="NOME", nullable = false, length = 155)
    private String nome;

    @Column(name="PRECO")
    private int valor;

    @Temporal(TemporalType.DATE)
    @Column(name="VALIDADE")
    private Date validade;

    @Column(name="TAMANHO")
    private int tamanho;

    @Column(name="DESCRICAO", length = 155)
    private String descricao;

    public Produto() {}

    public Produto(Integer id, String nome, int valor, Date validade, int tamanho, String descricao) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.validade = validade;
        this.tamanho = tamanho;
        this.descricao = descricao;
    }

    @PostPersist //Executa o metodo apos o persist
    private void executar() {
    System.out.println("Fique tranquilo que está executando...!");
    }

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public float getValor() {return valor;}
    public void setValor(int valor) {this.valor = valor;}

    public Date getValidade() {return validade;}
    public void setValidade(Date validade) {this.validade = validade;}

    public float getTamanho() {return tamanho;}
    public void setTamanho(int tamanho) {this.tamanho = tamanho;}

    public String getDescricao() {return descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}


    @Override
    public String toString() {
        return "[ Detalhes do Produto: ]" + "\n\r" +
                "Id do produto: " + id + "\n\r" +
                "Nome: " + nome + "\n\r" +
                "Valor: R$" + valor + "\n\r" +
                "Validade: " + validade + "\n\r" +
                "Tamanho: " + tamanho + " cm" + "\n\r" +
                "Descrição: " + descricao + "\n\r" ;

    }
}