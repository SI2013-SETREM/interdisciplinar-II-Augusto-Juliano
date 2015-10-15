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
@Table(name = "dr_tamanho")
public class DrTamanho implements Serializable {

    @Id
    @SequenceGenerator(name = "tam_codigo", sequenceName = "tam_codigo")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "tam_codigo")
    private int tam_codigo;
    private String tam_descricao;
    private String tam_sigla;
    private int tam_ordem;

    public int getTam_codigo() {
        return tam_codigo;
    }

    public void setTam_codigo(int tam_codigo) {
        this.tam_codigo = tam_codigo;
    }

    public String getTam_descricao() {
        return tam_descricao;
    }

    public void setTam_descricao(String tam_descricao) {
        this.tam_descricao = tam_descricao;
    }

    public String getTam_sigla() {
        return tam_sigla;
    }

    public void setTam_sigla(String tam_sigla) {
        this.tam_sigla = tam_sigla;
    }

    public int getTam_ordem() {
        return tam_ordem;
    }

    public void setTam_ordem(int tam_ordem) {
        this.tam_ordem = tam_ordem;
    }

}
