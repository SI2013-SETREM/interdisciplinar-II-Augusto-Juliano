package br.com.sotos.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Augusto
 */
@Entity
@Table(name = "dr_produtofinal")
public class DrProdutoFinal implements Serializable {

    @Id
    private String pro_codigoref;

    @ManyToOne
    @JoinColumn(name = "pro_codigo", referencedColumnName = "pro_codigo")
    private DrProduto drProduto;

    @ManyToOne
    @JoinColumn(name = "cor_codigo", referencedColumnName = "cor_codigo")
    private DrCor drCor;

    @ManyToOne
    @JoinColumn(name = "tam_codigo", referencedColumnName = "tam_codigo")
    private DrTamanho drTamanho;

    private String pro_descricao;
    private double pro_valorvenda;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date pro_datacadastro;

    public String getPro_codigoref() {
        return pro_codigoref;
    }

    public void setPro_codigoref(String pro_codigoref) {
        this.pro_codigoref = pro_codigoref;
    }

    public DrProduto getDrProduto() {
        return drProduto;
    }

    public void setDrProduto(DrProduto drProduto) {
        this.drProduto = drProduto;
    }

    public DrCor getDrCor() {
        return drCor;
    }

    public void setDrCor(DrCor drCor) {
        this.drCor = drCor;
    }

    public DrTamanho getDrTamanho() {
        return drTamanho;
    }

    public void setDrTamanho(DrTamanho drTamanho) {
        this.drTamanho = drTamanho;
    }

    public String getPro_descricao() {
        return pro_descricao;
    }

    public void setPro_descricao(String pro_descricao) {
        this.pro_descricao = pro_descricao;
    }

    public double getPro_valorvenda() {
        return pro_valorvenda;
    }

    public void setPro_valorvenda(double pro_valorvenda) {
        this.pro_valorvenda = pro_valorvenda;
    }

    public Date getPro_datacadastro() {
        return pro_datacadastro;
    }

    public void setPro_datacadastro(Date pro_datacadastro) {
        this.pro_datacadastro = pro_datacadastro;
    }

}
