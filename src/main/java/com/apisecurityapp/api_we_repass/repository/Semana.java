package com.apisecurityapp.api_we_repass.repository;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "semana")
@NamedStoredProcedureQueries(value ={
        @NamedStoredProcedureQuery(name = "f_ver_semana", procedureName = "f_ver_semana", parameters = {
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "resultado", type = String.class) }),



})
public class Semana {

    @Id
    @Column(name = "idsemana")
    private int idsemana;

    @Column(name = "nrosemana")
    private int nrosemana;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "hora_inicio")
    private Time hora_inicio;

    @Column(name = "hora_fin")
    private Time hora_fin;

    public Semana(){
        super();
    }

    public Semana(int idsemana, int nrosemana, Date fecha, Time hora_inicio, Time hora_fin) {
        super();
        this.idsemana = idsemana;
        this.nrosemana = nrosemana;
        this.fecha = fecha;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
    }

    public int getIdsemana() {
        return idsemana;
    }

    public void setIdsemana(int idsemana) {
        this.idsemana = idsemana;
    }

    public int getNrosemana() {
        return nrosemana;
    }

    public void setNrosemana(int nrosemana) {
        this.nrosemana = nrosemana;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(Time hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public Time getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(Time hora_fin) {
        this.hora_fin = hora_fin;
    }
}
