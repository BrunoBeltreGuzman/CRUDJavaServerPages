
package Intefaces;

import Modelo.Usuarios;
import java.util.List;


public interface IUsuario {
    public List listarUsuarios();
    public Usuarios listUsuarios(int id);
    public boolean registrar(Usuarios usuarios);
    public boolean editar(Usuarios usuarios);
    public boolean eliminar(int id);
}
