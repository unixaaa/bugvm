/*
 * Copyright (C) 2013-2015 RoboVM AB
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bugvm.apple.coretext;

/*<imports>*/
import java.io.*;
import java.nio.*;
import java.util.*;
import com.bugvm.objc.*;
import com.bugvm.objc.annotation.*;
import com.bugvm.objc.block.*;
import com.bugvm.rt.*;
import com.bugvm.rt.annotation.*;
import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
import com.bugvm.apple.foundation.*;
import com.bugvm.apple.corefoundation.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coremedia.*;
import com.bugvm.apple.uikit.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Marshaler(Bits.AsMachineSizedIntMarshaler.class)/*</annotations>*/
public final class /*<name>*/CTUnderlinePattern/*</name>*/ extends Bits</*<name>*/CTUnderlinePattern/*</name>*/> {
    /*<values>*/
    public static final CTUnderlinePattern None = new CTUnderlinePattern(0L);
    public static final CTUnderlinePattern Solid = new CTUnderlinePattern(0L);
    public static final CTUnderlinePattern Dot = new CTUnderlinePattern(256L);
    public static final CTUnderlinePattern Dash = new CTUnderlinePattern(512L);
    public static final CTUnderlinePattern DashDot = new CTUnderlinePattern(768L);
    public static final CTUnderlinePattern DashDotDot = new CTUnderlinePattern(1024L);
    /*</values>*/

    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<methods>*//*</methods>*/

    private static final /*<name>*/CTUnderlinePattern/*</name>*/[] values = _values(/*<name>*/CTUnderlinePattern/*</name>*/.class);

    public /*<name>*/CTUnderlinePattern/*</name>*/(long value) { super(value); }
    private /*<name>*/CTUnderlinePattern/*</name>*/(long value, long mask) { super(value, mask); }
    protected /*<name>*/CTUnderlinePattern/*</name>*/ wrap(long value, long mask) {
        return new /*<name>*/CTUnderlinePattern/*</name>*/(value, mask);
    }
    protected /*<name>*/CTUnderlinePattern/*</name>*/[] _values() {
        return values;
    }
    public static /*<name>*/CTUnderlinePattern/*</name>*/[] values() {
        return values.clone();
    }
}
