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
@Table(name = "dr_colecao")
public class DrColecao implements Serializable {

    @Id
    @SequenceGenerator(name = "col_codigo", sequenceName = "col_codigo")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "col_codigo")
    private int col_codigo;
    private String col_descricao;
    private boolean col_status;

    public int getCol_codigo() {
        return col_codigo;
    }

    public void setCol_codigo(int col_codigo) {
        this.col_codigo = col_codigo;
    }

    public String getCol_descricao() {
        return col_descricao;
    }

    public void setCol_descricao(String col_descricao) {
        this.col_descricao = col_descricao;
    }

    public boolean isCol_status() {
        return col_status;
    }

    public void setCol_status(boolean col_status) {
        this.col_status = col_status;
    }

}
