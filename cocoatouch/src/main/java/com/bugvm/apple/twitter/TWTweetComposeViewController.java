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
package com.bugvm.apple.twitter;

/*<imports>*/

import com.bugvm.apple.foundation.NSObject;
import com.bugvm.apple.foundation.NSURL;
import com.bugvm.apple.uikit.UIImage;
import com.bugvm.apple.uikit.UIViewController;
import com.bugvm.objc.ObjCRuntime;
import com.bugvm.objc.annotation.Block;
import com.bugvm.objc.annotation.Method;
import com.bugvm.objc.annotation.NativeClass;
import com.bugvm.objc.annotation.Property;
import com.bugvm.objc.block.VoidBlock1;
import com.bugvm.objc.*;
import com.bugvm.rt.*;
import com.bugvm.rt.annotation.*;
import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 5.0 and later.
 * @deprecated Deprecated in iOS 6.0.
 */
@Deprecated
/*</javadoc>*/
/*<annotations>*/@Library("Twitter") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/TWTweetComposeViewController/*</name>*/ 
    extends /*<extends>*/UIViewController/*</extends>*/
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class TWTweetComposeViewControllerPtr extends Ptr<TWTweetComposeViewController, TWTweetComposeViewControllerPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(TWTweetComposeViewController.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public TWTweetComposeViewController() {}
    protected TWTweetComposeViewController(NSObject.SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "completionHandler")
    public native @Block
    VoidBlock1<TWTweetComposeViewControllerResult> getCompletionHandler();
    @Property(selector = "setCompletionHandler:")
    public native void setCompletionHandler(@Block VoidBlock1<TWTweetComposeViewControllerResult> v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "setInitialText:")
    public native boolean setInitialText(String text);
    @Method(selector = "addImage:")
    public native boolean addImage(UIImage image);
    @Method(selector = "removeAllImages")
    public native boolean removeAllImages();
    @Method(selector = "addURL:")
    public native boolean addURL(NSURL url);
    @Method(selector = "removeAllURLs")
    public native boolean removeAllURLs();
    @Method(selector = "canSendTweet")
    public static native boolean canSendTweet();
    /*</methods>*/
}