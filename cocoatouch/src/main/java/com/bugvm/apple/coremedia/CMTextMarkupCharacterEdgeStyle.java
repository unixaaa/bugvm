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
package com.bugvm.apple.coremedia;

/*<imports>*/
import java.util.*;

import com.bugvm.apple.corefoundation.CFArray;
import com.bugvm.apple.corefoundation.CFMutableArray;
import com.bugvm.apple.corefoundation.CFString;
import com.bugvm.apple.corefoundation.CFType;
import com.bugvm.apple.foundation.GlobalValueEnumeration;
import com.bugvm.objc.*;
import com.bugvm.rt.*;
import com.bugvm.rt.annotation.*;
import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("CoreMedia") @StronglyLinked/*</annotations>*/
@Marshaler(/*<name>*/CMTextMarkupCharacterEdgeStyle/*</name>*/.Marshaler.class)
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CMTextMarkupCharacterEdgeStyle/*</name>*/ 
    extends /*<extends>*/GlobalValueEnumeration<CFString>/*</extends>*/
    /*<implements>*//*</implements>*/ {

    /*<marshalers>*/
    public static class Marshaler {
        @MarshalsPointer
        public static CMTextMarkupCharacterEdgeStyle toObject(Class<CMTextMarkupCharacterEdgeStyle> cls, long handle, long flags) {
            CFString o = (CFString) CFType.Marshaler.toObject(CFString.class, handle, flags);
            if (o == null) {
                return null;
            }
            return CMTextMarkupCharacterEdgeStyle.valueOf(o);
        }
        @MarshalsPointer
        public static long toNative(CMTextMarkupCharacterEdgeStyle o, long flags) {
            if (o == null) {
                return 0L;
            }
            return CFType.Marshaler.toNative(o.value(), flags);
        }
    }
    public static class AsListMarshaler {
        @MarshalsPointer
        public static List<CMTextMarkupCharacterEdgeStyle> toObject(Class<? extends CFType> cls, long handle, long flags) {
            CFArray o = (CFArray) CFType.Marshaler.toObject(CFArray.class, handle, flags);
            if (o == null) {
                return null;
            }
            List<CMTextMarkupCharacterEdgeStyle> list = new ArrayList<>();
            for (int i = 0; i < o.size(); i++) {
                list.add(CMTextMarkupCharacterEdgeStyle.valueOf(o.get(i, CFString.class)));
            }
            return list;
        }
        @MarshalsPointer
        public static long toNative(List<CMTextMarkupCharacterEdgeStyle> l, long flags) {
            if (l == null) {
                return 0L;
            }
            CFArray array = CFMutableArray.create();
            for (CMTextMarkupCharacterEdgeStyle o : l) {
                array.add(o.value());
            }
            return CFType.Marshaler.toNative(array, flags);
        }
    }
    /*</marshalers>*/

    /*<constants>*/
    /**
     * @since Available in iOS 7.0 and later.
     */
    public static final CMTextMarkupCharacterEdgeStyle None = new CMTextMarkupCharacterEdgeStyle("None");
    /**
     * @since Available in iOS 7.0 and later.
     */
    public static final CMTextMarkupCharacterEdgeStyle Raised = new CMTextMarkupCharacterEdgeStyle("Raised");
    /**
     * @since Available in iOS 7.0 and later.
     */
    public static final CMTextMarkupCharacterEdgeStyle Depressed = new CMTextMarkupCharacterEdgeStyle("Depressed");
    /**
     * @since Available in iOS 7.0 and later.
     */
    public static final CMTextMarkupCharacterEdgeStyle Uniform = new CMTextMarkupCharacterEdgeStyle("Uniform");
    /**
     * @since Available in iOS 7.0 and later.
     */
    public static final CMTextMarkupCharacterEdgeStyle DropShadow = new CMTextMarkupCharacterEdgeStyle("DropShadow");
    /*</constants>*/
    
    private static /*<name>*/CMTextMarkupCharacterEdgeStyle/*</name>*/[] values = new /*<name>*/CMTextMarkupCharacterEdgeStyle/*</name>*/[] {/*<value_list>*/None, Raised, Depressed, Uniform, DropShadow/*</value_list>*/};
    
    /*<name>*/CMTextMarkupCharacterEdgeStyle/*</name>*/ (String getterName) {
        super(Values.class, getterName);
    }
    
    public static /*<name>*/CMTextMarkupCharacterEdgeStyle/*</name>*/ valueOf(/*<type>*/CFString/*</type>*/ value) {
        for (/*<name>*/CMTextMarkupCharacterEdgeStyle/*</name>*/ v : values) {
            if (v.value().equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + value + " found in " 
            + /*<name>*/CMTextMarkupCharacterEdgeStyle/*</name>*/.class.getName());
    }
    
    /*<methods>*//*</methods>*/
    
    /*<annotations>*/@Library("CoreMedia") @StronglyLinked/*</annotations>*/
    public static class Values {
    	static { Bro.bind(Values.class); }

        /*<values>*/
        /**
         * @since Available in iOS 7.0 and later.
         */
        @GlobalValue(symbol="kCMTextMarkupCharacterEdgeStyle_None", optional=true)
        public static native CFString None();
        /**
         * @since Available in iOS 7.0 and later.
         */
        @GlobalValue(symbol="kCMTextMarkupCharacterEdgeStyle_Raised", optional=true)
        public static native CFString Raised();
        /**
         * @since Available in iOS 7.0 and later.
         */
        @GlobalValue(symbol="kCMTextMarkupCharacterEdgeStyle_Depressed", optional=true)
        public static native CFString Depressed();
        /**
         * @since Available in iOS 7.0 and later.
         */
        @GlobalValue(symbol="kCMTextMarkupCharacterEdgeStyle_Uniform", optional=true)
        public static native CFString Uniform();
        /**
         * @since Available in iOS 7.0 and later.
         */
        @GlobalValue(symbol="kCMTextMarkupCharacterEdgeStyle_DropShadow", optional=true)
        public static native CFString DropShadow();
        /*</values>*/
    }
}