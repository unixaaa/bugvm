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
package com.bugvm.ios.AVFoundation;

/*<imports>*/

import com.bugvm.objc.*;
import com.bugvm.objc.annotation.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
import com.bugvm.apple.foundation.*;
import com.bugvm.apple.coremedia.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 4.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVMutableMetadataItem/*</name>*/ 
    extends /*<extends>*/AVMetadataItem/*</extends>*/
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AVMutableMetadataItemPtr extends Ptr<AVMutableMetadataItem, AVMutableMetadataItemPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVMutableMetadataItem.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVMutableMetadataItem() {}
    protected AVMutableMetadataItem(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "identifier")
    public native com.bugvm.ios.AVFoundation.AVMetadataIdentifier getIdentifier();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setIdentifier:")
    public native void setIdentifier(com.bugvm.ios.AVFoundation.AVMetadataIdentifier v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "extendedLanguageTag")
    public native String getExtendedLanguageTag();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setExtendedLanguageTag:")
    public native void setExtendedLanguageTag(String v);
    @Property(selector = "locale")
    public native NSLocale getLocale();
    @Property(selector = "setLocale:")
    public native void setLocale(NSLocale v);
    @Property(selector = "time")
    public native @ByVal CMTime getTime();
    @Property(selector = "setTime:")
    public native void setTime(@ByVal CMTime v);
    /**
     * @since Available in iOS 4.2 and later.
     */
    @Property(selector = "duration")
    public native @ByVal CMTime getDuration();
    /**
     * @since Available in iOS 4.2 and later.
     */
    @Property(selector = "setDuration:")
    public native void setDuration(@ByVal CMTime v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "dataType")
    public native CMMetadataDataType getDataType();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setDataType:")
    public native void setDataType(CMMetadataDataType v);
    @Property(selector = "value")
    public native NSObject getValue();
    @Property(selector = "setValue:")
    public native void setValue(NSObject v);
    @Property(selector = "extraAttributes")
    public native com.bugvm.ios.AVFoundation.AVMetadataExtraAttributes getExtraAttributes();
    @Property(selector = "setExtraAttributes:")
    public native void setExtraAttributes(com.bugvm.ios.AVFoundation.AVMetadataExtraAttributes v);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "startDate")
    public native NSDate getStartDate();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "setStartDate:")
    public native void setStartDate(NSDate v);
    @Property(selector = "keySpace")
    public native com.bugvm.ios.AVFoundation.AVMetadataKeySpace getKeySpace();
    @Property(selector = "setKeySpace:")
    public native void setKeySpace(com.bugvm.ios.AVFoundation.AVMetadataKeySpace v);
    @Property(selector = "key")
    public native com.bugvm.ios.AVFoundation.AVMetadataKey getKey();
    @Property(selector = "setKey:")
    public native void setKey(com.bugvm.ios.AVFoundation.AVMetadataKey v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    
    /*</methods>*/
}