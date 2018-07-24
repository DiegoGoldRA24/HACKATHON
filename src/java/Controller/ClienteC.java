package Controller;

import Dao.ClienteD;
import Model.ClienteM;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "clienteC")
@SessionScoped
public class ClienteC implements Serializable {

    ClienteM cm = new ClienteM();
    private List<ClienteM> lstCliente;
    
    @PostConstruct
    public void iniciar(){
        try {
            listar();
        } catch (Exception ex) {
            Logger.getLogger(ClienteC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void agregar() throws Exception{
        ClienteD dao;
        try {
            dao = new ClienteD();
            dao.agregarCli(cm);            
            listar();
            limpiarCliente();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "MODIFICADO", "Correctamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "No se pudo modificar"));
            throw e;
        }
    }
    
    public void delete() throws Exception{
        ClienteD dao;
        try {
            dao = new ClienteD();
            dao.deleteCli(cm);
            listar();
            limpiarCliente();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "MODIFICADO", "Correctamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "No se pudo modificar"));
            throw e;
        }
    }
    
    public void listar() throws Exception{
        ClienteD dao;
        try {
            dao = new ClienteD();
            lstCliente = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void update() throws Exception {
        ClienteD dao;
        try {
            dao = new ClienteD();
            dao.update(cm);
            listar();
            limpiarCliente();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "MODIFICADO", "Correctamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "No se pudo modificar"));
            throw e;
        }
    }
    
    public void limpiarCliente() {
        cm = new ClienteM();
    }
    

    public ClienteM getCm() {
        return cm;
    }

    public void setCm(ClienteM cm) {
        this.cm = cm;
    }

    public List<ClienteM> getLstCliente() {
        return lstCliente;
    }

    public void setLstCliente(List<ClienteM> lstCliente) {
        this.lstCliente = lstCliente;
    }
    
    
    
}
