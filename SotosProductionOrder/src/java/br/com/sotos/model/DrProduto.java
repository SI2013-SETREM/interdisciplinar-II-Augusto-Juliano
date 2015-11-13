package br.com.sotos.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Augusto
 */
@Entity
@Table(name = "dr_produto")
public class DrProduto implements Serializable {

    @Id
    @SequenceGenerator(name = "pro_codigo", sequenceName = "pro_codigo")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "pro_codigo")
    private int pro_codigo;
    private String pro_descricao;
    private double pro_valorvenda;
    private int pro_codigopro;

    @ManyToOne
    @JoinColumn(name = "col_codigo", referencedColumnName = "col_codigo")
    private DrColecao drColecao;

    public int getPro_codigo() {
        return pro_codigo;
    }

    public void setPro_codigo(int pro_codigo) {
        this.pro_codigo = pro_codigo;
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

    public DrColecao getDrColecao() {
        return drColecao;
    }

    public void setDrColecao(DrColecao drColecao) {
        this.drColecao = drColecao;
    }
    
        public int getPro_codigopro() {
        return pro_codigopro;
    }

    public void setPro_codigopro(int pro_codigopro) {
        this.pro_codigopro = pro_codigopro;
    }

}
