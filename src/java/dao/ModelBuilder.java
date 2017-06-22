/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Statement;

/**
 *
 * @author julio
 */
public class ModelBuilder {
    Statement statement;
    
    public ModelBuilder(Statement statement) {
        this.statement = statement;
    }
    
    public void portoBuilder() throws Exception {
        String query = "DO $$ BEGIN" +
            " IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'tipo_administracao') THEN" +
            " create type tipo_administracao as enum ('PUBLICO', 'PRIVADO');" +
            " END IF; END $$;"
            + "create table if not exists porto ("
            + "id serial,"
            + "nome varchar(255) NOT NULL,"
            + "administracao tipo_administracao NOT NULL,"
            + "ano_fundacao date NOT NULL,"
            + "primary key(id)"
            + ");";
        statement.execute(query);
    }
    
    public void viagemBuilder() throws Exception {
        String query = "create table if not exists viagem (" +
            "id serial," +
            "data_saida date NOT NULL," +
            "data_chegada date NOT NULL," +
            "porto_origem_id integer NOT NULL," +
            "porto_destino_id integer NOT NULL," +
            "embarcadao_id integer NOT NULL," +
            "primary key(id)" +
            ");";
        statement.execute(query);
    }
    
    public void embarcacaoBuilder() throws Exception {
        String query = "create table if not exists embarcacao (" +
            "id serial," +
            "nome varchar(255) NOT NULL," +
            "tamanho decimal(5,2) NOT NULL," +
            "primary key(id)" +
            ");";
        statement.execute(query);
    }
    
    public void especieBuilder() throws Exception {
        String query = "create table if not exists especie("
            + "id                  serial,"
            + "nome                varchar(255) NOT NULL,"
            + "profundidade_minima DECIMAL(5,2) NOT NULL,"
            + "profundidade_maxima DECIMAL(5,2) NOT NULL,"
            + "PRIMARY KEY(id)"
            + ");";
        statement.execute(query);
    }
    
    public void fotografiaBuilder() throws Exception {
        String query = "create table if not exists fotografia(" +
            "id         serial 		NOT NULL," +
            "especie_id int 		    NOT NULL," +
            "caminho    varchar(255) NOT NULL," +
            "PRIMARY KEY(id)" +
            ");";
        statement.execute(query);
    }
    
    public void lanceBuilder() throws Exception {
        String query = "create table if not exists lance(" +
            "id serial," +
            "viagem_id        int          NOT NULL," +
            "data_inicio      TIMESTAMP    NOT NULL," +
            "data_termino     TIMESTAMP    NOT NULL," +
            "comprimento_rede DECIMAL(3,2) NOT NULL," +
            "altura_rede      DECIMAL(3,2) NOT NULL," +
            "tamanho_malha    DECIMAL(3,2) NOT NULL," +
            "profundidade     DECIMAL(4,2) NOT NULL," +
            "latitude         REAL         NOT NULL," +
            "longitude        REAL         NOT NULL," +
            "PRIMARY KEY(id)" +
            ");";
        statement.execute(query);
    }
    
    public void capturaBuilder() throws Exception {
        String query = "create table if not exists captura(" +
            "lance_id    int," +
            "especie_id  int," +
            "kg          DECIMAL(3,2) NOT NULL," +
            "PRIMARY KEY(lance_id, especie_id)" +
            ");";
        statement.execute(query);
    }
    
    public void altersBuilder() throws Exception {
        String query = "alter table viagem     add foreign key (porto_origem_id)references porto (id);"
        + "alter table viagem     add foreign key (porto_destino_id) references porto (id);"
        + "alter table fotografia add FOREIGN key (especie_id) REFERENCES especie (id);"
        + "alter table lance      add FOREIGN key (viagem_id)  REFERENCES viagem  (id);"
        + "alter table captura    add FOREIGN key (lance_id)   REFERENCES lance   (id);"
        + "alter table captura    add FOREIGN key (especie_id) REFERENCES especie (id);";
        statement.execute(query);
    }
    
    public void closeStatement() throws Exception {
        statement.close();
    }
}
