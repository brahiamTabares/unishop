package co.edu.uniquindio.proyecto.filtros;

import co.edu.uniquindio.proyecto.bean.SeguridadBean;
import co.edu.uniquindio.proyecto.configuracion.Seguridad;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class SeguridadFilter implements Filter {
    public static final String PAGINA_INICIO = "/index.xhtml";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        try {
            final HttpServletRequest request = (HttpServletRequest) servletRequest;
            final HttpServletResponse response = (HttpServletResponse) servletResponse;
            final String requestURI = request.getRequestURI();
//Aplicar el filtro a esta carpeta

//Obtenemos el objeto seguridadBean de la sesión actual
            SeguridadBean userManager = (SeguridadBean)
                    request.getSession().getAttribute("scopedTarget.seguridadBean");
//Se determina el rol del usuario, en caso de no estar autenticado el rol es vacio ""
            String rol = userManager != null ? userManager.getRol() : "";
            if ( Seguridad.tienePermiso(rol, requestURI)) {
//El usuario está logueado entonces si puede ver la página solicitada
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
//El usuario no está logueado, o no tiene permisos para acceder al recurso entonces se redirecciona al inicio
                response.sendRedirect(request.getContextPath() + PAGINA_INICIO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}