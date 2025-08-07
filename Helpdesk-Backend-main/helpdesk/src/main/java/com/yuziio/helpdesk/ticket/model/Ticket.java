package com.yuziio.helpdesk.ticket.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tabela") /*  @document diz que essa classe sera armazenada como um documento do MongoDB e ao lado o nome da coleção */
public class Ticket {

    @Id  /* Define a variavel que sera usada como ID no banco de dados*/
    private String id; /* ID do ticket */


    /* Campos principais que serão enviados pelo front end */

    private String nome;
    private String setor;
    private String problema;


    /* Getters e Setters responsaveis por acessar os atributos principais ou altera-los */

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
