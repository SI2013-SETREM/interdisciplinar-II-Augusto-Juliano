/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Augusto
 */
@javax.ws.rs.ApplicationPath("ws")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(br.com.sotos.controller.DrColecaoController.class);
        resources.add(br.com.sotos.controller.DrCorController.class);
        resources.add(br.com.sotos.controller.DrEtapaProducaoController.class);
        resources.add(br.com.sotos.controller.DrEtapasProdutoController.class);
        resources.add(br.com.sotos.controller.DrLogController.class);
        resources.add(br.com.sotos.controller.DrOrdemProducaoController.class);
        resources.add(br.com.sotos.controller.DrOrdemProdutosController.class);
        resources.add(br.com.sotos.controller.DrPessoasController.class);
        resources.add(br.com.sotos.controller.DrProdutoController.class);
        resources.add(br.com.sotos.controller.DrProdutoCoresController.class);
        resources.add(br.com.sotos.controller.DrProdutoFinalController.class);
        resources.add(br.com.sotos.controller.DrProdutoTamanhoController.class);
        resources.add(br.com.sotos.controller.DrSetorController.class);
        resources.add(br.com.sotos.controller.DrTamanhoController.class);
    }
    
}
