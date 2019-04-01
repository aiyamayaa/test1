/*
 * Copyright © 2016 jiaxin,Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.test.impl;

import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.test.rev150105.ConfigtestInput;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.test.rev150105.ConfigtestOutput;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.test.rev150105.ConfigtestOutputBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.test.rev150105.TestService;
import org.opendaylight.yangtools.yang.common.RpcResult;
import org.opendaylight.yangtools.yang.common.RpcResultBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.Future;

public class rpcHandle implements TestService{
    private static final Logger LOG = LoggerFactory.getLogger(rpcHandle.class);
    @Override
    public Future<RpcResult<ConfigtestOutput>> configtest(ConfigtestInput input){
//
        LOG.info("rpcHandler---start--");
        ConfigtestOutputBuilder outputBuilder = new ConfigtestOutputBuilder();
        outputBuilder.setGreeting("get"+input.getConfig());

        OsmConnected connected = new OsmConnected();
        connected.sendOsmCmd(input.getConfig());

//        LOG.info("rpcHandler---SendPacketService--");
//        SendPacketService service = new SendPacket();
//        LOG.info("rpcHandler---SendPacketService-end-");
//         if(input.getConfig().equals("test")){
//            LOG.info("----------jiaxinTest------test--------");
//
//            DbConnected db = new DbConnected();
//            List<String> aau = db.getAauResoure();
//            List<String> dc = db.getDcResource();
//            List<String> eswitch = db.getEswitchResource();
//            List<String> roadm = db.getRoadmResource();
//            List<String> link = db.getLinkResource();
//            List<String> olt = db.getOltResource();
//            Showresource(aau);
//            Showresource(dc);
//            Showresource(eswitch);
//            Showresource(roadm);
//            Showresource(link);
//            Showresource(olt);
//
//        }
//        if(input.getConfig().equals("shownet")){
//            DbConnected db = new DbConnected();
//            LOG.info("----------jiaxinTestshownet------test1--------");
//            db.ShowNetNodeResource();
//            db.ShowPathResource();
//            LOG.info("----------jiaxinTestshownet------test2--------");
//            db.ShowNetLinkResource();
//            LOG.info("----------jiaxinTestshownet------test3--------");
//        }
//        if(input.getConfig().equals("sendroadm")){
//            //service.send26roadm();
//             LOG.info("----------sendtest------test1--------");
//
//        }
//        if(input.getConfig().equals("sendaau")){
//
//            service.send37aau();
//             LOG.info("----------sendtest------test2--------");
//        }
//
//        if(input.getConfig().equals("send")){
//
//            Map<Short,Integer> vlink = new HashMap<>();
//            LOG.info("----------jiaxinTest------send--------");
//            vlink.put((short)21,23);
//            vlink.put((short)22,15);
//            vlink.put((short)23,10);
//           LOG.info("----------jiaxinTest------send----vlink----{}"+vlink);
//            service.sendCuConfig((short)1,(short)1,(short)2,(short)51,20,5110,vlink);
//            LOG.info("----------jiaxinTest------send--end------");
//            service.sendDuConfig((short)1,(short)1,(short)34,(short)51,21,5109,vlink);
//            LOG.info("----------jiaxinTest------send--end------");
//            service.sendvLinkConfig((short)1,(short)1,1556,vlink);
//            LOG.info("----------jiaxinTest------send--end------");
//        }
//        LOG.info("----------jiaxinTest-------ok-------");
//        if(input.getConfig().equals("showNetResource ")){
//             LOG.info("------------showNetResource------------");
//            service.showNetResource();
//             LOG.info("----------jiaxinTest-------ok-------");
//        }

        return RpcResultBuilder.success(outputBuilder.build()).buildFuture();

    }
    public void Showresource(List<String> resource){
        for(String res:resource){
            LOG.info("----------jiaxinTest--------------"+res);
        }
    }

}
