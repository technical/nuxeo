/*
 * (C) Copyright 2010-2015 Nuxeo SA (http://nuxeo.com/) and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Benoit Delbosc
 *     Julien Carsique
 *
 */

package org.nuxeo.launcher.daemon;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A factory to create daemon thread, this prevents the JVM to hang on exit waiting for non-daemon threads to finish.
 *
 * @author ben
 * @since 5.4.2
 */
public class DaemonThreadFactory implements ThreadFactory {

    private static final AtomicInteger count = new AtomicInteger(0);

    private String basename;

    private boolean isDaemon;

    /**
     * @param basename String to use in thread name
     */
    public DaemonThreadFactory(String basename) {
        this(basename, true);
    }

    /**
     * @param basename String to use in thread name
     * @param isDaemon Will created threads be set as daemon ?
     */
    public DaemonThreadFactory(String basename, boolean isDaemon) {
        this.basename = basename;
        this.isDaemon = isDaemon;
    }

    /**
     * New daemon thread.
     */
    @Override
    public Thread newThread(final Runnable runnable) {
        final Thread thread = new Thread(runnable, basename + "-" + count.getAndIncrement());
        thread.setDaemon(isDaemon);
        return thread;
    }

}
