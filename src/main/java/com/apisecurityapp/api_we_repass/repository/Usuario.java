package com.apisecurityapp.api_we_repass.repository;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")

@NamedStoredProcedureQueries(value ={
        @NamedStoredProcedureQuery(name = "f_inicio_sesion", procedureName = "f_inicio_sesion", parameters = {

                @StoredProcedureParameter(mode = ParameterMode.IN, name = "in_user", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "in_password", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "resultado", type = String.class) }),

})
public class Usuario {

    @Id
    @Column(name = "idusuario")
    private int idusuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "dni")
    private int dni;

    @Column(name = "contrasenia")
    private String contrasenia;

    @Column(name = "perfil")
    private String perfil;

    public Usuario(){
        super();
    }

    public Usuario(int idusuario, String nombre, String apellidos, int dni, String perfil, String contrasenia) {
        super();
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.contrasenia = contrasenia;
        this.perfil = perfil;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}
