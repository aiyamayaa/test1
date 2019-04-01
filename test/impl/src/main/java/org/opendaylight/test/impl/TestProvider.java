/*
 * Copyright © 2016 jiaxin,Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.test.impl;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker;
import org.opendaylight.controller.sal.binding.api.RpcProviderRegistry;


import org.opendaylight.feng.ssac.impl.LinkPropertyService;
import org.opendaylight.feng.ssac.impl.SendPacketService;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.test.rev150105.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestProvider {

    private static final Logger LOG = LoggerFactory.getLogger(TestProvider.class);

    private final DataBroker dataBroker;
    private final LinkPropertyService linkPropertyService;
    private final RpcProviderRegistry rpcRegistry;
    private BindingAwareBroker.RpcRegistration<TestService> testService = null;

    private final SendPacketService sendPacket;

    public TestProvider(final DataBroker dataBroker,final LinkPropertyService linkPropertyService,
                        final RpcProviderRegistry rpcRegistry,final SendPacketService sendService) {
        this.dataBroker = dataBroker;
        this.linkPropertyService = linkPropertyService;
        this.rpcRegistry = rpcRegistry;
        this.sendPacket = sendService;
    }


    /**
     * Method called when the blueprint container is created.
     */
    public void init() {
        LOG.info("TestProvider Session Initiated");
        LOG.info("linkproperty"+linkPropertyService);
        LOG.info("jiaxin-setSendPacket.nnConfigSevice");
        new DbConnected(linkPropertyService);
        testService = rpcRegistry.addRpcImplementation(TestService.class,new rpcHandle());

    }

    /**
     * Method called when the blueprint container is destroyed.
     */
    public void close() {
        LOG.info("TestProvider Closed");
        if(testService!=null){
            testService.close();
        }
    }
}