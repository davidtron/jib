/*
 * Copyright 2021 Google LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.cloud.tools.jib.cli;

import static com.google.common.truth.Truth.assertThat;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;

public class JibCliTest {

  @Test
  public void testConfigureHttpLogging() {
    Logger logger = JibCli.configureHttpLogging(Level.ALL);
    assertThat(logger.getName()).isEqualTo("com.google.api.client.http.HttpTransport");
    assertThat(logger.getLevel()).isEqualTo(Level.ALL);

    assertThat(logger.getHandlers()).hasLength(1);
    Handler handler = logger.getHandlers()[0];
    assertThat(handler).isInstanceOf(ConsoleHandler.class);
    assertThat(handler.getLevel()).isEqualTo(Level.ALL);
  }
}
