/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.internal.processors.query.h2.ddl.msg;

import org.apache.ignite.internal.managers.discovery.DiscoveryCustomMessage;
import org.apache.ignite.internal.processors.query.h2.ddl.DdlAbstractOperation;
import org.apache.ignite.internal.util.typedef.internal.S;
import org.jetbrains.annotations.Nullable;

import java.util.Set;
import java.util.UUID;

/**
 * {@code ACK} message - triggers actual execution of local portion of DDL operation.
 */
public class DdlAckDiscoveryMessage extends DdlAbstractDiscoveryMessage {
    /** */
    private static final long serialVersionUID = 0L;

    /** Ids of participating nodes. */
    private final Set<UUID> nodeIds;

    /**
     * Constructor.
     *
     * @param op Operation.
     * @param nodeIds Ids of participating nodes.
     */
    public DdlAckDiscoveryMessage(DdlAbstractOperation op, Set<UUID> nodeIds) {
        super(op);
        this.nodeIds = nodeIds;
    }

    /** {@inheritDoc} */
    @Nullable @Override public DiscoveryCustomMessage ackMessage() {
        return null;
    }

    /** {@inheritDoc} */
    @Override public boolean isMutable() {
        return false;
    }

    /**
     * @return Ids of participating nodes.
     */
    public Set<UUID> nodeIds() {
        return nodeIds;
    }

    /** {@inheritDoc} */
    @Override public String toString() {
        return S.toString(DdlAckDiscoveryMessage.class, this);
    }
}