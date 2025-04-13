package com.apisecurityapp.api_we_repass.repository;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "respuestas")
@NamedStoredProcedureQueries(value ={
        @NamedStoredProcedureQuery(name = "f_guardar_respuesta", procedureName = "f_guardar_respuesta", parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "in_idpregunta", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "in_idsemana", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "in_idusuario", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "in_respuesta", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "resultado", type = String.class) }),

        @NamedStoredProcedureQuery(name = "f_ver_nota", procedureName = "f_ver_nota", parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "in_idusuario", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "resultado", type = String.class) }),
})
public class Respuesta {

    @Id
    @Column(name = "idrespuesta")
    private int idrespuesta;

    @Column(name = "idpregunta")
    private int idpregunta;

    @Column(name = "idsemana")
    private int idsemana;

    @Column(name = "idusuario")
    private int idusuario;

    @Column(name = "respuesta")
    private String respuesta;

    @Column(name = "hora_subida")
    private Time hora_subida;

    public Respuesta(){
        super();
    }

    public Respuesta(int idrespuesta, int idpregunta,int idsemana, int idusuario, String respuesta, Time hora_subida) {
        super();
        this.idrespuesta = idrespuesta;
        this.idpregunta = idpregunta;
        this.idsemana = idsemana;
        this.idusuario = idusuario;
        this.respuesta = respuesta;
        this.hora_subida = hora_subida;
    }

    public int getIdrespuesta() {
        return idrespuesta;
    }

    public void setIdrespuesta(int idrespuesta) {
        this.idrespuesta = idrespuesta;
    }

    public int getIdpregunta() {
        return idpregunta;
    }

    public void setIdpregunta(int idpregunta) {
        this.idpregunta = idpregunta;
    }

    public int getIdsemana() {
        return idsemana;
    }

    public void setIdsemana(int idsemana) {
        this.idsemana = idsemana;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Time getHora_subida() {
        return hora_subida;
    }

    public void setHora_subida(Time hora_subida) {
        this.hora_subida = hora_subida;
    }
}
