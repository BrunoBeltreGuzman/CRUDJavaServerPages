/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuarios;
import ModeloDAO.UsuariosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diosl
 */
public class Controlador extends HttpServlet {

   private String listar = "Pages/PageListar.jsp";
    private String add = "Pages/PageAgregar.jsp";
    private String edit = "Pages/PageEditar.jsp";

    private String acceso = "";

    Usuarios usuarios = new Usuarios();

    UsuariosDAO usuariosDAO = new UsuariosDAO();

    private int id;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("accion");

        if (action.equalsIgnoreCase("listar")) {
            listar(request, response);
        }

        if (action.equalsIgnoreCase("accesoRegistrar")) {
            accesoRegistrar(request, response);
        }

        if (action.equalsIgnoreCase("registrar")) {
            registrar(request, response);
        }

        if (action.equalsIgnoreCase("accesoEditar")) {
            accesoEditar(request, response);
        }

        if (action.equalsIgnoreCase("editar")) {
            editar(request, response);
        }

        if (action.equalsIgnoreCase("eliminar")) {
            eliminar(request, response);
        }

        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void listar(HttpServletRequest request, HttpServletResponse response) {
        acceso = listar;
    }

    private void registrar(HttpServletRequest request, HttpServletResponse response) {

        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        String email = request.getParameter("txtEmail");
        String user = request.getParameter("txtUser");
        String passWord = request.getParameter("txtPassWord");

        usuarios.setNombre(nombre);
        usuarios.setApellido(apellido);
        usuarios.setEmail(email);
        usuarios.setUser(user);
        usuarios.setPassWord(passWord);
        usuariosDAO.registrar(usuarios);
        acceso = listar;
    }

    private void accesoRegistrar(HttpServletRequest request, HttpServletResponse response) {
        acceso = add;
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) {
        id = Integer.parseInt(request.getParameter("txtId"));
        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        String email = request.getParameter("txtEmail");
        String user = request.getParameter("txtUser");
        String passWord = request.getParameter("txtPassWord");

        usuarios.setNombre(nombre);
        usuarios.setApellido(apellido);
        usuarios.setEmail(email);
        usuarios.setUser(user);
        usuarios.setPassWord(passWord);
        usuarios.setId(id);
        
        usuariosDAO.editar(usuarios);
        acceso = listar;
    }

    private void accesoEditar(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("idUsuario", request.getParameter("txtId"));
        acceso = edit;
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) {
        id = Integer.parseInt(request.getParameter("txtId"));
        usuarios.setId(id);
        usuariosDAO.eliminar(id);
        acceso = listar;
    }
}
