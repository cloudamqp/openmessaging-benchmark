/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.openmessaging.benchmark.driver.lavinmqmq;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

class LavinMqConfigTest {

    @Test
    public void deserialize() throws JsonProcessingException {
        String config =
                "{\"amqpUris\":[\"amqp://local\"],\"messagePersistence\":true}";
        LavinMqConfig value = new ObjectMapper().readValue(config, LavinMqConfig.class);
        assertThat(value)
                .satisfies(
                        v -> {
                            assertThat(v.amqpUris).containsOnly("amqp://local");
                            assertThat(v.messagePersistence).isTrue();
                        });
    }

    @Test
    public void deserializeWithDefaults() throws JsonProcessingException {
        String config = "{\"amqpUris\":[\"amqp://local\"]}";
        LavinMqConfig value = new ObjectMapper().readValue(config, LavinMqConfig.class);
        assertThat(value)
                .satisfies(
                        v -> {
                            assertThat(v.amqpUris).containsOnly("amqp://local");
                            assertThat(v.messagePersistence).isFalse();
                            assertThat(v.queueType).isEqualTo(LavinMqConfig.QueueType.CLASSIC);
                        });
    }
}
