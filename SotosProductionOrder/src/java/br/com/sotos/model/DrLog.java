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
@Table(name = "dr_log")
public class DrLog implements Serializable {

    @Id
    @SequenceGenerator(name = "log_codigo", sequenceName = "log_codigo")
    @GeneratedValue(generator = "log_codigo", strategy = GenerationType.AUTO)
    private int log_codigo;

    @ManyToOne
    @JoinColumn(name = "pes_codigo", referencedColumnName = "pes_codigo")
    private DrPessoas drPessoas;

    private String log_acao;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date log_datetime;
    private String log_valorantigo;
    private String log_valornovo;

    public int getLog_codigo() {
        return log_codigo;
    }

    public void setLog_codigo(int log_codigo) {
        this.log_codigo = log_codigo;
    }

    public DrPessoas getDrPessoas() {
        return drPessoas;
    }

    public void setDrPessoas(DrPessoas drPessoas) {
        this.drPessoas = drPessoas;
    }

    public String getLog_acao() {
        return log_acao;
    }

    public void setLog_acao(String log_acao) {
        this.log_acao = log_acao;
    }

    public Date getLog_datetime() {
        return log_datetime;
    }

    public void setLog_datetime(Date log_datetime) {
        this.log_datetime = log_datetime;
    }

    public String getLog_valorantigo() {
        return log_valorantigo;
    }

    public void setLog_valorantigo(String log_valorantigo) {
        this.log_valorantigo = log_valorantigo;
    }

    public String getLog_valornovo() {
        return log_valornovo;
    }

    public void setLog_valornovo(String log_valornovo) {
        this.log_valornovo = log_valornovo;
    }

    public String getLog_tabela() {
        return log_tabela;
    }

    public void setLog_tabela(String log_tabela) {
        this.log_tabela = log_tabela;
    }
    private String log_tabela;

}
