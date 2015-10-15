package br.com.sotos.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Augusto
 */
@Entity
@Table(name = "dr_cor")
public class DrCor implements Serializable {

    @Id
    @SequenceGenerator(name = "cor_codigo", sequenceName = "cor_codigo")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "cor_codigo")
    private int cor_codigo;

    public DrCor() {
    }
    
    private String cor_descricao;
    private String cor_codigocor;

    public int getCor_codigo() {
        return cor_codigo;
    }

    public void setCor_codigo(int cor_codigo) {
        this.cor_codigo = cor_codigo;
    }

    public String getCor_descricao() {
        return cor_descricao;
    }

    public void setCor_descricao(String cor_descricao) {
        this.cor_descricao = cor_descricao;
    }

    public String getCor_codigocor() {
        return cor_codigocor;
    }

    public void setCor_codigocor(String cor_codigocor) {
        this.cor_codigocor = cor_codigocor;
    }

}
