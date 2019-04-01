/*
 * Copyright © 2016 jiaxin,Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.test.impl;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class OsmConnected {

    private static final String osm_url = "http://10.112.197.221:8181/restconf/operations/osmcontroller:osmcontroller";
    private static Logger LOG = LoggerFactory.getLogger(OsmConnected.class);
    public String sendOsmCmd(String osmcmd){
        String payload = getPayload(osmcmd);
        System.out.println("payload"+payload);
        String res = PostAuthorition(osm_url,payload);
        JSONObject object = new JSONObject(res);
        Object greeting  =  object.get("output");
        JSONObject greetingj = new JSONObject(greeting.toString());

        System.out.println(greetingj.get("greeting"));

        return res;
    }




    public String getPayload(String osmcmd){
        String payload = "{\"input\":{\"config\":\""+osmcmd+"\"}}";
        return payload;
    }

    public static String PostAuthorition(String endpoint,String payload){
        try{
            URL url = new URL(endpoint);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestProperty("Accept","application/json");
            connection.setRequestProperty("Content-Type","application/json");
            connection.setRequestProperty("Authorization","Basic YWRtaW46YWRtaW4=");
            connection.connect();

            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            out.write(payload.getBytes("UTF-8"));
            out.flush();
            out.close();


            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer buffer = new StringBuffer();
            String lines = "";
            while((lines=reader.readLine())!=null){
                lines = new String(lines.getBytes("UTF-8"));
                buffer.append(lines);
            }
            connection.disconnect();
            return buffer.toString();
        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

}
