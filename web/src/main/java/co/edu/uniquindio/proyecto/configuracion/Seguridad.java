package co.edu.uniquindio.proyecto.configuracion;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Seguridad {
    private static final Map<String, Set<String>> permisos;
    static {
        permisos = new HashMap<>();
        permisos.put("Usuario",getPermisosUsuario());
        permisos.put("Administrador",getPermisosAdministrador());
    }

    private static Set<String> getPermisosAdministrador() {
        Set<String> p = new LinkedHashSet<>();
        p.add("/administradores/.*");
        p.add("/ciudades/.*");
        p.add("/categorias/.*");
        return p;
    }

    private static Set<String> getPermisosUsuario() {
        Set<String> p = new LinkedHashSet<>();
        p.add("/productos/.*");
        return p;
    }

    public static boolean tienePermiso(String rol,String recurso){
        return permisos.get(rol) != null && permisos.get(rol).stream().filter( recurso::matches ).count() > 0
                || permisos.entrySet().stream().filter( e->!e.getKey().equals(rol) )
                .map(Map.Entry::getValue)
                .filter( set-> set.stream().filter( recurso::matches ).count() > 0)
                .count() == 0;
    }

}
