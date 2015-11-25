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
    
    private String ord_observacao;
    private Boolean ord_impressa;
    private String ord_situacao;
    
//    @OneToMany(mappedBy = "drOrdemProducao", targetEntity = DrEtapaProducao.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private List<DrEtapaProducao> lstDrEtapaProducao;
//    
//    @OneToMany(mappedBy = "drOrdemProducao", targetEntity = DrOrdemProdutos.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private List<DrOrdemProdutos> lstDrOrdemProdutos;

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

    public String getOrd_observacao() {
        return ord_observacao;
    }

    public void setOrd_observacao(String ord_observacao) {
        this.ord_observacao = ord_observacao;
    }

    public Boolean isOrd_impressa() {
        return ord_impressa;
    }

    public void setOrd_impressa(Boolean ord_impressa) {
        this.ord_impressa = ord_impressa;
    }

    public String getOrd_situacao() {
        return ord_situacao;
    }

    public void setOrd_situacao(String ord_situacao) {
        this.ord_situacao = ord_situacao;
    }
}
