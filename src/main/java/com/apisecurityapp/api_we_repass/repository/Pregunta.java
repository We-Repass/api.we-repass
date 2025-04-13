package com.apisecurityapp.api_we_repass.repository;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "preguntas")
@NamedStoredProcedureQueries(value ={
        @NamedStoredProcedureQuery(name = "f_crear_examen", procedureName = "f_crear_examen", parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "in_idsemana", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "in_idtema", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "in_dificultad", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "in_pregunta", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "in_opciones", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "in_respuesta", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "resultado", type = String.class) }),

        @NamedStoredProcedureQuery(name = "f_ver_examen", procedureName = "f_ver_examen", parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "in_idsemana", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "resultado", type = String.class) }),

})
public class Pregunta {
    @Id
    @Column(name = "idpregunta")
    private int idpregunta;

    @Column(name = "idsemana")
    private int idsemana;

    @Column(name = "tema")
    private String tema;

    @Column(name = "dificultad")
    private String dificultad;

    @Column(name = "preguntas")
    private String preguntas;

    @ElementCollection
    @Column(name = "opciones")
    private List<String> opciones;

    @Column(name = "respuesta")
    private String respuesta;

    @Column(name = "nota")
    private int nota;

    public Pregunta(){
        super();
    }

    public Pregunta(int idpregunta,int idsemana, String tema, String dificultad, String preguntas, List<String> opciones, String respuesta, int nota ) {
        super();
        this.idpregunta = idpregunta;
        this.idsemana = idsemana;
        this.tema = tema;
        this.dificultad = dificultad;
        this.preguntas = preguntas;
        this.opciones = opciones;
        this.respuesta = respuesta;
        this.nota = nota;
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

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public String getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(String preguntas) {
        this.preguntas = preguntas;
    }

    public List<String> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<String> opciones) {
        this.opciones = opciones;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}
