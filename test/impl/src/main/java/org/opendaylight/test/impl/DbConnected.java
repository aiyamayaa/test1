/*
 * Copyright © 2016 jiaxin,Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.test.impl;

import org.opendaylight.feng.ssac.impl.LinkPropertyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DbConnected {
     private static final Logger LOG = LoggerFactory.getLogger(DbConnected.class);
    public static LinkPropertyService linkPropertyService;
    public DbConnected(){}
    public DbConnected(LinkPropertyService linkPropertyService){
        LOG.info("---DbConnected-----init---------{}"+linkPropertyService);
        this.linkPropertyService = linkPropertyService;
        LOG.info("---DbConnected-----init---end------");
    }

    public String getNetNodeResource(){
        return linkPropertyService.getNetNode();
    }
    public String getNetLinkResource(){
        return linkPropertyService.getNetLinkresource();
    }
    public String getNetPathResource(){return linkPropertyService.getPath();}
     public void ShowPathResource(){
        LOG.info("---------------XXX-----------------");
        String res = getNetPathResource();
        String[] resource = res.split("&");
        for(String info:resource){
            LOG.info(info);
        }
    }
    public void ShowNetNodeResource(){
        LOG.info("---------------XXX-----------------");
        String res = getNetNodeResource();
        String[] resource = res.split("&");
        for(String info:resource){
            LOG.info(info);
        }
    }
    public void ShowNetLinkResource(){
         LOG.info("---------------XXX-----------------");
         String res = getNetLinkResource();
         String[] resource = res.split("&");
         for(String info:resource){
            LOG.info(info);
        }
    }
    public List<String> getAauResoure(){
        LOG.info("--DbConnected-------getAauresoure---------------{}"+linkPropertyService.getAauResource());
        for (String resource:linkPropertyService.getAauResource()
             ) {
            LOG.info("--DbConnected---getAauresouressss---------{}"+resource);
        }
        return linkPropertyService.getAauResource();
    }

    public List<String> getDcResource(){
        LOG.info("--DbConnected-----getDcResource-----------------{}"+linkPropertyService.getDcResource());
        for (String resource:linkPropertyService.getDcResource()
             ) {
            LOG.info("--DbConnected---getDcResource---------{}"+resource);
        }
        return linkPropertyService.getDcResource();
    }

    public List<String> getEswitchResource(){
         LOG.info("--DbConnected-------getEswitchResource---------------{}"+linkPropertyService.getEswitchResource());
        for (String resource:linkPropertyService.getEswitchResource()
             ) {
            LOG.info("--DbConnected----getEswitchResource--------{}"+resource);
        }
        return linkPropertyService.getEswitchResource();
    }
    public List<String> getRoadmResource(){
        LOG.info("--DbConnected---------getRoadmResource-------------{}"+linkPropertyService.getRoadmResource());
        for (String resource:linkPropertyService.getRoadmResource()
             ) {
            LOG.info("--DbConnected-----getRoadmResource-------{}"+resource);
        }
        return linkPropertyService.getRoadmResource();
    }
    public List<String> getOltResource(){
        LOG.info("--DbConnected----------getOltResource------------{}"+linkPropertyService.getOltResource());
        for (String resource:linkPropertyService.getOltResource()
             ) {
            LOG.info("--DbConnected------getOltResource------{}"+resource);
        }
        return  linkPropertyService.getOltResource();
    }

    public List<String> getLinkResource(){
        LOG.info("--DbConnected--------getLinkResource--------------{}"+linkPropertyService.getLinkResource());
        for (String resource:linkPropertyService.getLinkResource()
             ) {
            LOG.info("--DbConnected-----getLinkResource-------{}"+resource);
        }
        return  linkPropertyService.getLinkResource();
    }
}
