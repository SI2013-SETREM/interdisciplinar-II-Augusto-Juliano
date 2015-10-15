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
@Table(name = "dr_etapasproduto")
public class DrEtapasProduto implements Serializable {

    @Id
    @SequenceGenerator(name = "etp_codigo", sequenceName = "etp_codigo")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "etp_codigo")
    private int etp_codigo;

    @ManyToOne
    @JoinColumn(name = "set_codigo", referencedColumnName = "set_codigo")
    private DrSetor drSetor;

    @ManyToOne
    @JoinColumn(name = "pro_codigo", referencedColumnName = "pro_codigo")
    private DrProduto drProduto;
    private int etp_ordem;

    public int getEtp_codigo() {
        return etp_codigo;
    }

    public void setEtp_codigo(int etp_codigo) {
        this.etp_codigo = etp_codigo;
    }

    public DrSetor getDrSetor() {
        return drSetor;
    }

    public void setDrSetor(DrSetor drSetor) {
        this.drSetor = drSetor;
    }

    public DrProduto getDrProduto() {
        return drProduto;
    }

    public void setDrProduto(DrProduto drProduto) {
        this.drProduto = drProduto;
    }

    public int getEtp_ordem() {
        return etp_ordem;
    }

    public void setEtp_ordem(int etp_ordem) {
        this.etp_ordem = etp_ordem;
    }

}
