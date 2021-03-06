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
package com.bugvm.apple.corevideo;

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
import com.bugvm.apple.opengles.*;
import com.bugvm.apple.metal.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("CoreVideo")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CVOpenGLESTextureCache/*</name>*/ 
    extends /*<extends>*/CFType/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CVOpenGLESTextureCachePtr extends Ptr<CVOpenGLESTextureCache, CVOpenGLESTextureCachePtr> {}/*</ptr>*/
    /*<bind>*/static { Bro.bind(CVOpenGLESTextureCache.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*//*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    /**
     * @since Available in iOS 5.0 and later.
     */
    @WeaklyLinked
    public static CVOpenGLESTextureCache create(CVOpenGLESTextureCacheAttributes cacheAttributes, EAGLContext eaglContext, NSDictionary<NSString, ?> textureAttributes) {
        return create(null, cacheAttributes, eaglContext, textureAttributes);
    }
    /**
     * @since Available in iOS 5.0 and later.
     */
    @WeaklyLinked
    public static CVOpenGLESTextureCache create(CFAllocator allocator, CVOpenGLESTextureCacheAttributes cacheAttributes, EAGLContext eaglContext, NSDictionary<NSString, ?> textureAttributes) {
        CVOpenGLESTextureCachePtr ptr = new CVOpenGLESTextureCachePtr();
        create(allocator, cacheAttributes, eaglContext, textureAttributes, ptr);
        return ptr.get();
    }
    /**
     * @since Available in iOS 5.0 and later.
     */
    public CVOpenGLESTexture createTexture(CVImageBuffer sourceImage, NSDictionary<NSString, ?> textureAttributes, int target, int internalFormat, int width, int height, int format, int type, @MachineSizedUInt long planeIndex) {
        return createTexture(null, sourceImage, textureAttributes, target, internalFormat, width, height, format, type, planeIndex);
    }
    /**
     * @since Available in iOS 5.0 and later.
     */
    public CVOpenGLESTexture createTexture(CFAllocator allocator, CVImageBuffer sourceImage, NSDictionary<NSString, ?> textureAttributes, int target, int internalFormat, int width, int height, int format, int type, @MachineSizedUInt long planeIndex) {
        CVOpenGLESTexture.CVOpenGLESTexturePtr ptr = new CVOpenGLESTexture.CVOpenGLESTexturePtr();
        createTexture(allocator, this, sourceImage, textureAttributes, target, internalFormat, width, height, format, type, planeIndex, ptr);
        return ptr.get();
    }
    /*<methods>*/
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="CVOpenGLESTextureCacheGetTypeID", optional=true)
    public static native @MachineSizedUInt long getClassTypeID();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @WeaklyLinked
    @Bridge(symbol="CVOpenGLESTextureCacheCreate", optional=true)
    private static native CVReturn create(CFAllocator allocator, CVOpenGLESTextureCacheAttributes cacheAttributes, EAGLContext eaglContext, NSDictionary textureAttributes, CVOpenGLESTextureCache.CVOpenGLESTextureCachePtr cacheOut);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="CVOpenGLESTextureCacheCreateTextureFromImage", optional=true)
    private static native CVReturn createTexture(CFAllocator allocator, CVOpenGLESTextureCache textureCache, CVImageBuffer sourceImage, NSDictionary textureAttributes, int target, int internalFormat, int width, int height, int format, int type, @MachineSizedUInt long planeIndex, CVOpenGLESTexture.CVOpenGLESTexturePtr textureOut);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="CVOpenGLESTextureCacheFlush", optional=true)
    public native void flush(long options);
    /*</methods>*/
}
