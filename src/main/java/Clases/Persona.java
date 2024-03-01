package Clases;

import oracle.sql.DATE;

public class Persona {
    private Integer codigo;
    private String nombre;
    private Direccion direc;
    private DATE fechaNac;

    public Persona() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDirec() {
        return direc;
    }

    public void setDirec(Direccion direc) {
        this.direc = direc;
    }

    public DATE getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(DATE fechaNac) {
        this.fechaNac = fechaNac;
    }
}
