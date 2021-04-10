/*
 * Copyright 2021 Omri Himelbrand. All Rights Reserved.
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
 */
package com.github.benmanes.caffeine.cache.simulator.parser.snia.systor;

import com.github.benmanes.caffeine.cache.simulator.parser.TextTraceReader;
import com.github.benmanes.caffeine.cache.simulator.policy.AccessEvent;
import com.github.benmanes.caffeine.cache.simulator.policy.Policy.Characteristic;
import com.google.common.collect.Sets;

import java.math.BigInteger;
import java.util.Set;
import java.util.stream.Stream;

import static com.github.benmanes.caffeine.cache.simulator.policy.Policy.Characteristic.WEIGHTED;

/**
 * A reader for the SNIA SYSTOR '17 trace files provided by
 * <a href="http://iotta.snia.org/traces/4964">SNIA</a>.
 * This reader is for weighted entries.
 *
 * @author himelbrand@gmail.com (Omri Himelbrand)
 */
public final class SystorTraceSizeReader extends TextTraceReader {

  public SystorTraceSizeReader(String filePath) {
    super(filePath);
  }

  @Override
  public Set<Characteristic> characteristics() {
    return Sets.immutableEnumSet(WEIGHTED);
  }

  @Override
  public Stream<AccessEvent> events() {
    return lines()
            .map(line -> line.split(","))
            .filter(array -> array[2].equals("R"))
            .map(array -> {
              long key = new BigInteger(array[4]).longValue();
              int weight = Integer.parseInt(array[5]);
              return AccessEvent.forKeyAndWeight(key, weight);
            });
  }
}