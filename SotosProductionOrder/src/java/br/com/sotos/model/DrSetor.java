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
@Table(name = "dr_setor")
public class DrSetor implements Serializable {

    @Id
    @SequenceGenerator(name = "set_codigo", sequenceName = "set_codigo")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "set_codigo")
    private int set_codigo;
    private String set_descricao;

    public int getSet_codigo() {
        return set_codigo;
    }

    public void setSet_codigo(int set_codigo) {
        this.set_codigo = set_codigo;
    }

    public String getSet_descricao() {
        return set_descricao;
    }

    public void setSet_descricao(String set_descricao) {
        this.set_descricao = set_descricao;
    }
}
