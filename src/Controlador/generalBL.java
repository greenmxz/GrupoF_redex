/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.generalDA;
import Modelo.*;
import java.util.*;

/**
 *
 * @author Moises
 */
public class generalBL {
    private generalDA generalDA;
    public generalBL(){
        generalDA = new generalDA();
    }
    
    public ArrayList<rol> obtenerRoles(){
        return generalDA.obtenerRoles();
    }
    public ArrayList<ciudad> obtenerCiudades(){
        return generalDA.obtenerCiudades();
    }
    public ArrayList<tipoDocumento> obtenerTipoDocumentos(){
        return generalDA.obtenerTipoDocumentos();
    }
    
}
