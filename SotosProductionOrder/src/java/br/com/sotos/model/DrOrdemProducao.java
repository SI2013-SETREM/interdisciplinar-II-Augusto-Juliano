package br.com.sotos.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Augusto
 */
@Entity
@Table(name = "dr_ordemproducao")
public class DrOrdemProducao implements Serializable {

    @Id
    @SequenceGenerator(name = "ord_codigo", sequenceName = "ord_codigo")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ord_codigo")
    private int ord_codigo;

    @ManyToOne
    @JoinColumn(name = "pro_codigo", referencedColumnName = "pro_codigo")
    private DrProduto drProduto;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ord_dataproducao;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ord_dataentrega;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ord_datacadastro;

    public int getOrd_codigo() {
        return ord_codigo;
    }

    public void setOrd_codigo(int ord_codigo) {
        this.ord_codigo = ord_codigo;
    }

    public DrProduto getDrProduto() {
        return drProduto;
    }

    public void setDrProduto(DrProduto drProduto) {
        this.drProduto = drProduto;
    }

    public Date getOrd_dataproducao() {
        return ord_dataproducao;
    }

    public void setOrd_dataproducao(Date ord_dataproducao) {
        this.ord_dataproducao = ord_dataproducao;
    }

    public Date getOrd_dataentrega() {
        return ord_dataentrega;
    }

    public void setOrd_dataentrega(Date ord_dataentrega) {
        this.ord_dataentrega = ord_dataentrega;
    }

    public Date getOrd_datacadastro() {
        return ord_datacadastro;
    }

    public void setOrd_datacadastro(Date ord_datacadastro) {
        this.ord_datacadastro = ord_datacadastro;
    }

}
