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
@Table(name = "dr_produtotamanhos")
public class DrProdutoTamanho implements Serializable {

    @Id
    @SequenceGenerator(name = "prt_codigo", sequenceName = "prt_codigo")
    @GeneratedValue(generator = "prt_codigo", strategy = GenerationType.AUTO)
    private int prt_codigo;

    @ManyToOne
    @JoinColumn(name = "pro_codigo", referencedColumnName = "pro_codigo")
    private DrProduto drProduto;

    @ManyToOne
    @JoinColumn(name = "tam_codigo", referencedColumnName = "tam_codigo")
    private DrTamanho drTamanho;

    public int getPrt_codigo() {
        return prt_codigo;
    }

    public void setPrt_codigo(int prt_codigo) {
        this.prt_codigo = prt_codigo;
    }

    public DrProduto getDrProduto() {
        return drProduto;
    }

    public void setDrProduto(DrProduto drProduto) {
        this.drProduto = drProduto;
    }

    public DrTamanho getDrTamanho() {
        return drTamanho;
    }

    public void setDrTamanho(DrTamanho drTamanho) {
        this.drTamanho = drTamanho;
    }

}
