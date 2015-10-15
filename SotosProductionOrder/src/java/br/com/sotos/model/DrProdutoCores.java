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
@Table(name = "dr_produtocores")
public class DrProdutoCores implements Serializable {

    @Id
    @SequenceGenerator(name = "prc_codigo", sequenceName = "prc_codigo")
    @GeneratedValue(generator = "prc_codigo", strategy = GenerationType.AUTO)
    private int prc_codigo;

    @ManyToOne
    @JoinColumn(name = "cor_codigo", referencedColumnName = "cor_codigo")
    private DrCor drCor;

    private short prc_ordem;

    public int getPrc_codigo() {
        return prc_codigo;
    }

    public void setPrc_codigo(int prc_codigo) {
        this.prc_codigo = prc_codigo;
    }

    public DrCor getDrCor() {
        return drCor;
    }

    public void setDrCor(DrCor drCor) {
        this.drCor = drCor;
    }

    public short getPrc_ordem() {
        return prc_ordem;
    }

    public void setPrc_ordem(short prc_ordem) {
        this.prc_ordem = prc_ordem;
    }

}
