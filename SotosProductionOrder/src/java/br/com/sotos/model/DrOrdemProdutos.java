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
@Table(name = "dr_ordemprodutos")
public class DrOrdemProdutos implements Serializable {

    @Id
    @SequenceGenerator(name = "opr_codigo", sequenceName = "opr_codigo")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "opr_codigo")
    private int opr_codigo;

    @ManyToOne
    @JoinColumn(name = "ord_codigo", referencedColumnName = "ord_codigo")
    private DrOrdemProducao drOrdemProducao;

    @ManyToOne
    @JoinColumn(name = "pro_codigoref", referencedColumnName = "pro_codigoref")
    private DrProdutoFinal drProdutoFinal;

    private int opr_quantidade;

    public int getOpr_codigo() {
        return opr_codigo;
    }

    public void setOpr_codigo(int opr_codigo) {
        this.opr_codigo = opr_codigo;
    }

    public DrOrdemProducao getDrOrdemProducao() {
        return drOrdemProducao;
    }

    public void setDrOrdemProducao(DrOrdemProducao drOrdemProducao) {
        this.drOrdemProducao = drOrdemProducao;
    }

    public DrProdutoFinal getDrProdutoFinal() {
        return drProdutoFinal;
    }

    public void setDrProdutoFinal(DrProdutoFinal drProdutoFinal) {
        this.drProdutoFinal = drProdutoFinal;
    }

    public int getOpr_quantidade() {
        return opr_quantidade;
    }

    public void setOpr_quantidade(int opr_quantidade) {
        this.opr_quantidade = opr_quantidade;
    }

}
