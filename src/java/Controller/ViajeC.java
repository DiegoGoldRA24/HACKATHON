package Controller;

import Dao.ViajeD;
import Model.ViajeM;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


@Named(value = "viajeC")
@SessionScoped
public class ViajeC implements Serializable {

        ViajeM vm = new ViajeM();
        private List<ViajeM> lstViaje;
        
        
        
        public void agregar() throws Exception{
        ViajeD dao;
        try {
            dao = new ViajeD();
            dao.agregarVia(vm);            
            listar();
            limpiarViaje();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "MODIFICADO", "Correctamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "No se pudo modificar"));
            throw e;
        }
    }
    
    public void delete() throws Exception{
        ViajeD dao;
        try {
            dao = new ViajeD();
            dao.deleteVia(vm);
            listar();
            limpiarViaje();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "MODIFICADO", "Correctamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "No se pudo modificar"));
            throw e;
        }
    }
    
    public void listar() throws Exception{
        ViajeD dao;
        try {
            dao = new ViajeD();
            lstViaje = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void update() throws Exception {
        ViajeD dao;
        try {
            dao = new ViajeD();
            dao.update(vm);
            listar();
            limpiarViaje();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "MODIFICADO", "Correctamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "No se pudo modificar"));
            throw e;
        }
    }
    
    public void limpiarViaje() {
        vm = new ViajeM() ;
    }

    public ViajeM getVm() {
        return vm;
    }

    public void setVm(ViajeM vm) {
        this.vm = vm;
    }

    public List<ViajeM> getLstViaje() {
        return lstViaje;
    }

    public void setLstViaje(List<ViajeM> lstViaje) {
        this.lstViaje = lstViaje;
    }   
    
    
}
