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

package org.apache.ignite.internal.processors.query.ddl;

import org.apache.ignite.internal.ContextAware;
import org.apache.ignite.internal.GridKernalContext;
import org.apache.ignite.internal.managers.discovery.DiscoveryCustomMessage;
import org.apache.ignite.internal.util.tostring.GridToStringExclude;
import org.apache.ignite.internal.util.typedef.internal.S;
import org.jetbrains.annotations.Nullable;

/**
 * {@code INIT} part of a distributed index create/drop operation.
 */
public class IndexInitDiscoveryMessage extends IndexAbstractDiscoveryMessage implements ContextAware {
    /** */
    private static final long serialVersionUID = 0L;

    /** Kernal context. */
    @GridToStringExclude
    private transient GridKernalContext ctx;

    /**
     * Constructor.
     *
     * @param op Operation.
     */
    public IndexInitDiscoveryMessage(AbstractIndexOperation op) {
        super(op);
    }

    /** {@inheritDoc} */
    @Nullable @Override public DiscoveryCustomMessage ackMessage() {
        // TODO: Ask indexing for ack message

        return null;
    }

    /** {@inheritDoc} */
    @Override public boolean isMutable() {
        return true;
    }

    /** {@inheritDoc} */
    @Override public void context(GridKernalContext ctx) {
        this.ctx = ctx;
    }

    /** {@inheritDoc} */
    @Override public String toString() {
        return S.toString(IndexInitDiscoveryMessage.class, this);
    }
}
