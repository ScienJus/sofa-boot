/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alipay.sofa.infra.config.spring;

import com.sun.org.apache.xml.internal.utils.DefaultErrorHandler;
import org.junit.Test;
import org.springframework.beans.factory.xml.DefaultDocumentLoader;
import org.springframework.beans.factory.xml.DelegatingEntityResolver;
import org.springframework.beans.factory.xml.DocumentLoader;
import org.springframework.util.xml.XmlValidationModeDetector;
import org.xml.sax.InputSource;

/**
 * XML validation with rpc.xsd
 *
 * @author <a href="mailto:scienjus@gmail.com">ScienJus</a>
 */
public class XsdValidationTest {

    @Test
    public void testSofaParameter() throws Exception {
        loadXml("config/spring/test_sofa_parameter.xml");
    }

    private void loadXml(String xml) throws Exception {
        DocumentLoader documentLoader = new DefaultDocumentLoader();
        documentLoader.loadDocument(new InputSource(this.getClass().getClassLoader()
            .getResourceAsStream(xml)), new DelegatingEntityResolver(this.getClass()
            .getClassLoader()), new DefaultErrorHandler(),
            XmlValidationModeDetector.VALIDATION_XSD, true);
    }
}
