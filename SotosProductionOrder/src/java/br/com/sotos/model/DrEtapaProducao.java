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
@Table(name = "dr_etapaproducao")
public class DrEtapaProducao implements Serializable {

    @Id
    @SequenceGenerator(name = "epp_codigo", sequenceName = "epp_codigo")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "epp_codigo")
    private int epp_codigo;

    @ManyToOne
    @JoinColumn(name = "ord_codigo", referencedColumnName = "ord_codigo")
    private DrOrdemProducao drOrdemProducao;

    @ManyToOne
    @JoinColumn(name = "set_codigo", referencedColumnName = "set_codigo")
    private DrSetor drSetor;

    private boolean epp_status;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date epp_datainicio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date epp_datafim;
    private int epp_ordem;

    public int getEpp_codigo() {
        return epp_codigo;
    }

    public void setEpp_codigo(int epp_codigo) {
        this.epp_codigo = epp_codigo;
    }

    public DrOrdemProducao getDrOrdemProducao() {
        return drOrdemProducao;
    }

    public void setDrOrdemProducao(DrOrdemProducao drOrdemProducao) {
        this.drOrdemProducao = drOrdemProducao;
    }

    public DrSetor getDrSetor() {
        return drSetor;
    }

    public void setDrSetor(DrSetor drSetor) {
        this.drSetor = drSetor;
    }

    public boolean isEpp_status() {
        return epp_status;
    }

    public void setEpp_status(boolean epp_status) {
        this.epp_status = epp_status;
    }

    public Date getEpp_datainicio() {
        return epp_datainicio;
    }

    public void setEpp_datainicio(Date epp_datainicio) {
        this.epp_datainicio = epp_datainicio;
    }

    public Date getEpp_datafim() {
        return epp_datafim;
    }

    public void setEpp_datafim(Date epp_datafim) {
        this.epp_datafim = epp_datafim;
    }

    public int getEpp_ordem() {
        return epp_ordem;
    }

    public void setEpp_ordem(int epp_ordem) {
        this.epp_ordem = epp_ordem;
    }

}
