/*
 The MIT License

 Copyright (c) 2004-2021 Paul R. Holser, Jr.

 Permission is hereby granted, free of charge, to any person obtaining
 a copy of this software and associated documentation files (the
 "Software"), to deal in the Software without restriction, including
 without limitation the rights to use, copy, modify, merge, publish,
 distribute, sublicense, and/or sell copies of the Software, and to
 permit persons to whom the Software is furnished to do so, subject to
 the following conditions:

 The above copyright notice and this permission notice shall be
 included in all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package tests.joptsimple;

import joptsimple.OptionParser;
import joptsimple.OptionSet;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;
import static org.junit.rules.ExpectedException.*;

/**
 * @author <a href="mailto:pholser@alumni.rice.edu">Paul Holser</a>
 */
public abstract class AbstractOptionParserFixture {
    @Rule public final ExpectedException thrown = none();

    protected OptionParser parser;

    @Before
    public final void createNewParser() {
        parser = new OptionParser();
    }

    static void assertOptionDetected( OptionSet detectedOptions, String option ) {
        assertTrue( "option '" + option + "' not detected?", detectedOptions.has( option ) );
    }

    static void assertOptionNotDetected( OptionSet detectedOptions, String option ) {
        assertOptionNotDetected( "option '" + option + "' detected?", detectedOptions, option );
    }

    static void assertOptionNotDetected( String message, OptionSet detectedOptions, String option ) {
        assertFalse( message, detectedOptions.has( option ) );
    }
}