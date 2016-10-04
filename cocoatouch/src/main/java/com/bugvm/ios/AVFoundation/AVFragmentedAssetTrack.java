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
import com.bugvm.objc.block.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
import com.bugvm.apple.foundation.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVFragmentedAssetTrack/*</name>*/ 
    extends /*<extends>*/AVAssetTrack/*</extends>*/
    /*<implements>*//*</implements>*/ {

    public static class Notifications {
        /**
         * @since Available in iOS 9.0 and later.
         */
        public static NSObject observeTimeRangeDidChange(AVFragmentedAssetTrack object, final VoidBlock1<AVFragmentedAssetTrack> block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(TimeRangeDidChangeNotification(), object, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke(NSNotification notification) {
                    block.invoke((AVFragmentedAssetTrack) notification.getObject());
                }
            });
        }
        /**
         * @since Available in iOS 9.0 and later.
         */
        public static NSObject observeSegmentsDidChange(AVFragmentedAssetTrack object, final VoidBlock1<AVFragmentedAssetTrack> block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(SegmentsDidChangeNotification(), object, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke(NSNotification notification) {
                    block.invoke((AVFragmentedAssetTrack) notification.getObject());
                }
            });
        }
    }
    
    /*<ptr>*/public static class AVFragmentedAssetTrackPtr extends Ptr<AVFragmentedAssetTrack, AVFragmentedAssetTrackPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVFragmentedAssetTrack.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVFragmentedAssetTrack() {}
    protected AVFragmentedAssetTrack(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 9.0 and later.
     */
    @GlobalValue(symbol="AVAssetTrackTimeRangeDidChangeNotification", optional=true)
    public static native NSString TimeRangeDidChangeNotification();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @GlobalValue(symbol="AVAssetTrackSegmentsDidChangeNotification", optional=true)
    public static native NSString SegmentsDidChangeNotification();
    
    
    /*</methods>*/
}