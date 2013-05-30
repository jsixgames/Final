package br.com.controller;

import br.com.interfaces.CadastroClienteRemote;
import br.com.modelos.CadastroCliente;
import br.com.modelos.MetodosGerais;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "AlterarClienteServlet", urlPatterns = {"/AlterarClienteServlet"})
public class AlterarClienteServlet extends HttpServlet {

    private boolean alterado = false;    
    @EJB    
    private CadastroClienteRemote cr;           

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();                    
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        try {
                String email,senha;
                email = (String) session.getAttribute("emailLogado");
                senha = (String) session.getAttribute("senhaLogado");           
                
                CadastroCliente cc = cr.login(email, senha);
            
            try {
                if (req.getParameter("opcao").equals("1")) {
                    session.setAttribute("cliente", cc);
                    req.getRequestDispatcher("alterarcadastro.jsp").forward(req, resp);
                }
            } catch (Exception e) {
                out.println("Erro ao colocar o objeto na sessao e redirecionar para a pagina de alteracao");
            }
                
            try {
            if(req.getParameter("btn-alterar").equals("alterar")){
                cc.setNome(req.getParameter("nome"));
                cc.setCpf(new MetodosGerais().tirardotecoma(req.getParameter("cpf")));
                cc.setDnasc(new MetodosGerais().formataData(req.getParameter("data")));
                cc.setSexo(req.getParameter("sexo"));
                cc.setTelefone(new MetodosGerais().tirardotecoma(req.getParameter("telefone")));
                cc.setCelular(new MetodosGerais().tirardotecoma(req.getParameter("celular")));
                cc.setEmail(email);
                cc.setSenha(req.getParameter("senha"));
            }
            } catch (Exception e) {
                out.println("Erro ao setar os novos dados do cliente");
            }
                
            try {
                cr.edit(cc);                
                cr.create(cc);
            } catch (Exception e) {
                out.println("Erro ao dar merge e persistir os novos dados do cliente");
            }               
                
            try {
                alterado = true;                
                session.setAttribute("alterado", alterado);
                session.setAttribute("username", cc.getNome());
                
                session.removeAttribute("cliente");
                req.getRequestDispatcher("painel.jsp").forward(req, resp);
            } catch (Exception e) {
                out.println("Erro ao remover o objeto da sessao e redirecionar a pagina");
            }
                
                                                
        }catch (Exception e) {
         out.println("Erro na Servlet -AlterarClienteServlet-");
          }        
        finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
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
}