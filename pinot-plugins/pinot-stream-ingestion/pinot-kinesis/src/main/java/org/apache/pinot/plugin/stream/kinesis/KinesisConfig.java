/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.pinot.plugin.stream.kinesis;

import java.util.Map;
import org.apache.pinot.spi.stream.StreamConfig;


public class KinesisConfig {
  private final Map<String, String> _props;

  public static final String STREAM = "stream";
  private static final String AWS_REGION = "aws-region";
  private static final String MAX_RECORDS_TO_FETCH = "max-records-to-fetch";

  private static final String DEFAULT_AWS_REGION = "us-central-1";
  private static final String DEFAULT_MAX_RECORDS = "20";

  public KinesisConfig(StreamConfig streamConfig) {
    _props = streamConfig.getStreamConfigsMap();
  }

  public KinesisConfig(Map<String, String> props) {
    _props = props;
  }

  public String getStream(){
    return _props.get(STREAM);
  }

  public String getAwsRegion(){
    return _props.getOrDefault(AWS_REGION, DEFAULT_AWS_REGION);
  }

  public Integer maxRecordsToFetch(){
    return Integer.parseInt(_props.getOrDefault(MAX_RECORDS_TO_FETCH, DEFAULT_MAX_RECORDS));
  }
}
