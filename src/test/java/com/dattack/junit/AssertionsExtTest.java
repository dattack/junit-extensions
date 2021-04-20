/*
 * Copyright (c) 2021, The Dattack team (http://www.dattack.com)
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
package com.dattack.junit;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author cvarela
 * @since 0.1
 */
public class AssertionsExtTest {

    @Test
    public void testValidContains() {
        AssertionsExt.assertContains("hello world", "hello");
        AssertionsExt.assertContains("hello world", "world");
        AssertionsExt.assertContainsIgnoreCase("hello world", "World");
        AssertionsExt.assertContains("hello world", "");
        AssertionsExt.assertContains("", "");
        AssertionsExt.assertContainsIgnoreCase("hello world", "");
    }

    @Test
    public void testValidNotContains() {
        AssertionsExt.assertNotContains("hello world", "HELLO");
        AssertionsExt.assertNotContains("hello world", "WORLD");
        AssertionsExt.assertNotContainsIgnoreCase("hello world", "Wrld");
        AssertionsExt.assertNotContains("hello world", "  ");
        AssertionsExt.assertNotContains("", " ");
        AssertionsExt.assertNotContainsIgnoreCase("hello world", "hello  ");
    }

    @Test
    public void testContainsTextIsNull() {

        final Error error = assertThrows(AssertionFailedError.class, () -> {
            AssertionsExt.assertContains(null, "");
        });

        AssertionsExt.assertContains(error.getMessage(), "The text to be searched can't be null");
    }

    @Test
    public void testContainsSubstringIsNull() {

        final Error error = assertThrows(AssertionFailedError.class, () -> {
            AssertionsExt.assertContains("", null);
        });

        AssertionsExt.assertContains(error.getMessage(), "The substring to searching for can't be null");
    }
}
