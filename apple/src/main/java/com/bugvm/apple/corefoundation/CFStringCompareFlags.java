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
package com.bugvm.apple.corefoundation;

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
import com.bugvm.apple.dispatch.*;
import com.bugvm.apple.coreservices.*;
import com.bugvm.apple.coremedia.*;
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.coretext.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Marshaler(Bits.AsMachineSizedIntMarshaler.class)/*</annotations>*/
public final class /*<name>*/CFStringCompareFlags/*</name>*/ extends Bits</*<name>*/CFStringCompareFlags/*</name>*/> {
    /*<values>*/
    public static final CFStringCompareFlags None = new CFStringCompareFlags(0L);
    public static final CFStringCompareFlags CaseInsensitive = new CFStringCompareFlags(1L);
    public static final CFStringCompareFlags Backwards = new CFStringCompareFlags(4L);
    public static final CFStringCompareFlags Anchored = new CFStringCompareFlags(8L);
    public static final CFStringCompareFlags Nonliteral = new CFStringCompareFlags(16L);
    public static final CFStringCompareFlags Localized = new CFStringCompareFlags(32L);
    public static final CFStringCompareFlags Numerically = new CFStringCompareFlags(64L);
    /**
     * @since Available in iOS 2.0 and later.
     */
    public static final CFStringCompareFlags DiacriticInsensitive = new CFStringCompareFlags(128L);
    /**
     * @since Available in iOS 2.0 and later.
     */
    public static final CFStringCompareFlags WidthInsensitive = new CFStringCompareFlags(256L);
    /**
     * @since Available in iOS 2.0 and later.
     */
    public static final CFStringCompareFlags ForcedOrdering = new CFStringCompareFlags(512L);
    /*</values>*/

    private static final /*<name>*/CFStringCompareFlags/*</name>*/[] values = _values(/*<name>*/CFStringCompareFlags/*</name>*/.class);

    public /*<name>*/CFStringCompareFlags/*</name>*/(long value) { super(value); }
    private /*<name>*/CFStringCompareFlags/*</name>*/(long value, long mask) { super(value, mask); }
    protected /*<name>*/CFStringCompareFlags/*</name>*/ wrap(long value, long mask) {
        return new /*<name>*/CFStringCompareFlags/*</name>*/(value, mask);
    }
    protected /*<name>*/CFStringCompareFlags/*</name>*/[] _values() {
        return values;
    }
    public static /*<name>*/CFStringCompareFlags/*</name>*/[] values() {
        return values.clone();
    }
}
