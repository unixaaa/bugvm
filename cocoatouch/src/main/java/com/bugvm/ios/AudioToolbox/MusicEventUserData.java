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
package com.bugvm.ios.AudioToolbox;

/*<imports>*/
import java.nio.*;

import com.bugvm.rt.*;
import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MusicEventUserData/*</name>*/ 
    extends /*<extends>*/Struct<MusicEventUserData>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MusicEventUserDataPtr extends Ptr<MusicEventUserData, MusicEventUserDataPtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MusicEventUserData() {}
    
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    public byte[] getData() {
        return getData0().toByteArray(getLength0());
    }
    public ByteBuffer getDataAsByteBuffer() {
        return getData0().asByteBuffer(getLength0());
    }
    public MusicEventUserData setData(byte[] data) {
        setData0(VM.getArrayValuesAddress(data));
        setLength0(data.length);
        return this;
    }
    /*<members>*/
    @StructMember(0) protected native int getLength0();
    @StructMember(0) protected native MusicEventUserData setLength0(int length0);
    /*</members>*/
    @StructMember(1) protected native BytePtr getData0();
    @StructMember(1) protected native MusicEventUserData setData0(@Pointer long data0);
    /*<methods>*//*</methods>*/
}