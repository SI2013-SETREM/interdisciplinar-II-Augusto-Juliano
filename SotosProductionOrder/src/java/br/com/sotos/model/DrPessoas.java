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
@Table(name = "dr_pessoas")
public class DrPessoas implements Serializable {

    @Id
    @SequenceGenerator(name = "pes_codigo", sequenceName = "pes_codigo")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "pes_codigo")
    private int pes_codigo;

    @ManyToOne
    @JoinColumn(name = "set_codigo", referencedColumnName = "set_codigo")
    private DrSetor drSetor;

    private String pes_nome;
    private String pes_cpf;
    private String pes_rg;
    private String pes_email;
    private String pes_login;
    private String pes_password;
    private boolean pes_status;
    private short pes_nivelacesso;

    public int getPes_codigo() {
        return pes_codigo;
    }

    public void setPes_codigo(int pes_codigo) {
        this.pes_codigo = pes_codigo;
    }

    public DrSetor getDrSetor() {
        return drSetor;
    }

    public void setDrSetor(DrSetor drSetor) {
        this.drSetor = drSetor;
    }

    public String getPes_nome() {
        return pes_nome;
    }

    public void setPes_nome(String pes_nome) {
        this.pes_nome = pes_nome;
    }

    public String getPes_cpf() {
        return pes_cpf;
    }

    public void setPes_cpf(String pes_cpfcnpj) {
        this.pes_cpf = pes_cpfcnpj;
    }

    public String getPes_rg() {
        return pes_rg;
    }

    public void setPes_rg(String pes_rg) {
        this.pes_rg = pes_rg;
    }

    public String getPes_email() {
        return pes_email;
    }

    public void setPes_email(String pes_email) {
        this.pes_email = pes_email;
    }

    public String getPes_login() {
        return pes_login;
    }

    public void setPes_login(String pes_login) {
        this.pes_login = pes_login;
    }

    public String getPes_password() {
        return pes_password;
    }

    public void setPes_password(String pes_password) {
        this.pes_password = pes_password;
    }

    public boolean isPes_status() {
        return pes_status;
    }

    public void setPes_status(boolean pes_status) {
        this.pes_status = pes_status;
    }

    public String getPes_nivelacesso() {
        if (pes_nivelacesso == 1) {
            return "Gerente de Produção";
        } else if (pes_nivelacesso == 2) {
            return "Gerente de Setor";
        } else if (pes_nivelacesso == 3) {
            return "Chefe de Produção";
        } else {
            return "Falha na Leitura";
        }
    }

    public void setPes_nivelacesso(short pes_nivelacesso) {
        this.pes_nivelacesso = pes_nivelacesso;
    }

}
