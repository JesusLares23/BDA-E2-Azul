/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.equipo2.voluntariadorefugio;

import dao.EspecialidadDAO;
import dao.VoluntarioDAO;
import java.util.List;
import models.Especialidad;
import models.Voluntario;
import views.FrmPrincipal;

/**
 *
 * @author demib
 */
public class VoluntariadoRefugio {

    public static void main(String[] args) {
        
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });

        
        
        
        // ----listar especialidades----
//        EspecialidadDAO espDao = new EspecialidadDAO();
//        
//        List<Especialidad> lista = espDao.listarTodas();
//        
//        for(Especialidad esp: lista){
//            System.out.println(esp);
//        }
          
//        ----Registrar Especialiad----

//        Especialidad esp = new Especialidad(1,"Medico");

//        ---Registrar Voluntario----

//        VoluntarioDAO volDao = new VoluntarioDAO();
//        
//        Voluntario v = new Voluntario(0, "Cesar", 21, "6442565192", "cesarqmt115@gmail.com", esp);
//        
//        volDao.insertar(v);
        
        
    }
}
