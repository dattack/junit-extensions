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

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Utility methods that extend the functionality of the Assertions class.
 *
 * @author cvarela
 * @since 0.1
 */
public class AssertionsExt extends org.junit.jupiter.api.Assertions {

    protected AssertionsExt() {
        super();
    }

    public static void assertContains(final String text, final String substring) {
        assertContains(text, substring, false);
    }

    private static void assertContains(final String text, final String substring, final boolean ignoreCase) {
        assertTrue(checkContains(text, substring, ignoreCase),
                String.format("'%s' doesn't contains the substring '%s'", text, substring));
    }

    private static boolean checkContains(final String text, final String substring, final boolean ignoreCase) {
        assertTrue(Objects.nonNull(text), "The text to be searched can't be null");
        assertTrue(Objects.nonNull(substring), "The substring to searching for can't be null");
        return ignoreCase ? Pattern.compile(Pattern.quote(substring), Pattern.CASE_INSENSITIVE).matcher(text).find()
                : text.contains(substring);
    }

    public static void assertContainsIgnoreCase(final String text, final String substring) {
        assertContains(text, substring, true);
    }

    public static void assertNotContains(final String text, final String substring) {
        assertNotContains(text, substring, false);
    }

    private static void assertNotContains(final String text, final String substring, final boolean ignoreCase) {
        assertFalse(checkContains(text, substring, ignoreCase),
                String.format("'%s' contains the substring '%s'", text, substring));
    }

    public static void assertNotContainsIgnoreCase(final String text, final String substring) {
        assertNotContains(text, substring, true);
    }
}
