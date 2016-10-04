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
import java.util.*;

import com.bugvm.objc.*;
import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
import com.bugvm.apple.foundation.*;
import com.bugvm.apple.corefoundation.*;
import com.bugvm.apple.coreaudio.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("AudioToolbox")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AudioQueue/*</name>*/ 
    extends /*<extends>*/NativeObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    public interface PropertyListener {
        void onChange(AudioQueue queue, com.bugvm.ios.AudioToolbox.AudioQueueProperty id);
    }
    public interface InputCallback {
        void onInput(AudioQueue queue, long buffer, AudioTimeStamp startTime, AudioStreamPacketDescription[] packetDescs);
    }
    public interface OutputCallback {
        void onOutput(AudioQueue queue, long buffer);
    }
    
    /*<ptr>*/public static class AudioQueuePtr extends Ptr<AudioQueue, AudioQueuePtr> {}/*</ptr>*/
    
    private static java.util.concurrent.atomic.AtomicLong callbackId = new java.util.concurrent.atomic.AtomicLong();
    
    private static final LongMap<PropertyListener> propertyListeners = new LongMap<>();
    private static final java.lang.reflect.Method cbPropertyChanged;
    private static final LongMap<InputCallback> inputCallbacks = new LongMap<>();
    private static final java.lang.reflect.Method cbInput;
    private static final LongMap<OutputCallback> outputCallbacks = new LongMap<>();
    private static final java.lang.reflect.Method cbOutput;
    
    static {
        try {
            cbPropertyChanged = AudioQueue.class.getDeclaredMethod("cbPropertyChanged", Long.TYPE, AudioQueue.class, com.bugvm.ios.AudioToolbox.AudioQueueProperty.class);
            cbInput = AudioQueue.class.getDeclaredMethod("cbInput", Long.TYPE, AudioQueue.class, Long.TYPE, AudioTimeStamp.class, Integer.TYPE, AudioStreamPacketDescription.class);
            cbOutput = AudioQueue.class.getDeclaredMethod("cbOutput", Long.TYPE, AudioQueue.class, Long.TYPE);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }
    /*<bind>*/static { Bro.bind(AudioQueue.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected AudioQueue() {}
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    @Callback
    private static void cbPropertyChanged(@Pointer long userData, AudioQueue queue, com.bugvm.ios.AudioToolbox.AudioQueueProperty id) {
        synchronized (propertyListeners) {
            propertyListeners.get(userData).onChange(queue, id);
        }
    }
    @Callback
    private static void cbInput(@Pointer long userData, AudioQueue queue, @Pointer long buffer, AudioTimeStamp startTime, int numberPacketDescs, AudioStreamPacketDescription packetDescs) {
        synchronized (inputCallbacks) {
            inputCallbacks.get(userData).onInput(queue, buffer, startTime, packetDescs.toArray(numberPacketDescs));
        }
    }
    @Callback
    private static void cbOutput(@Pointer long userData, AudioQueue queue, @Pointer long buffer) {
        synchronized (outputCallbacks) {
            outputCallbacks.get(userData).onOutput(queue, buffer);
        }
    }
    
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public static AudioQueue createOutput(AudioStreamBasicDescription format, OutputCallback callback) throws OSStatusException {
        return createOutput(format, callback, null, (String)null);
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public static AudioQueue createOutput(AudioStreamBasicDescription format, OutputCallback callback, NSRunLoop callbackRunLoop, NSRunLoopMode callbackRunLoopMode) throws OSStatusException {
        return createOutput(format, callback, callbackRunLoop, callbackRunLoopMode.value().toString());
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public static AudioQueue createOutput(AudioStreamBasicDescription format, OutputCallback callback, NSRunLoop callbackRunLoop, String callbackRunLoopMode) throws OSStatusException {
        if (callback == null) {
            throw new NullPointerException("callback");
        }
        long cid = callbackId.getAndIncrement();
        
        AudioQueue.AudioQueuePtr ptr = new AudioQueue.AudioQueuePtr();
        OSStatus status = createOutput0(format, new FunctionPtr(cbOutput), cid, callbackRunLoop, callbackRunLoopMode, 0, ptr);
        if (OSStatusException.throwIfNecessary(status)) {
            synchronized (outputCallbacks) {
                outputCallbacks.put(cid, callback);
            }
            return ptr.get();
        }
        return null;
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public static AudioQueue createInput(AudioStreamBasicDescription format, InputCallback callback) throws OSStatusException {
        return createInput(format, callback, null, (String)null);
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public static AudioQueue createInput(AudioStreamBasicDescription format, InputCallback callback, NSRunLoop callbackRunLoop, NSRunLoopMode callbackRunLoopMode) throws OSStatusException {
        return createInput(format, callback, callbackRunLoop, callbackRunLoopMode.value().toString());
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public static AudioQueue createInput(AudioStreamBasicDescription format, InputCallback callback, NSRunLoop callbackRunLoop, String callbackRunLoopMode) throws OSStatusException {
        if (callback == null) {
            throw new NullPointerException("callback");
        }
        long cid = callbackId.getAndIncrement();
        
        AudioQueue.AudioQueuePtr ptr = new AudioQueue.AudioQueuePtr();
        OSStatus status = createInput0(format, new FunctionPtr(cbInput), cid, callbackRunLoop, callbackRunLoopMode, 0, ptr);
        if (OSStatusException.throwIfNecessary(status)) {
            synchronized (inputCallbacks) {
                inputCallbacks.put(cid, callback);
            }
            return ptr.get();
        }
        return null;
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public void dispose(boolean immediate) throws OSStatusException {
        OSStatus status = dispose0(immediate);
        OSStatusException.throwIfNecessary(status);
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public com.bugvm.ios.AudioToolbox.AudioQueueBuffer allocateBuffer(int bufferByteSize) throws OSStatusException {
        com.bugvm.ios.AudioToolbox.AudioQueueBuffer.AudioQueueBufferPtr ptr = new com.bugvm.ios.AudioToolbox.AudioQueueBuffer.AudioQueueBufferPtr();
        OSStatus status = allocateBuffer0(bufferByteSize, ptr);
        OSStatusException.throwIfNecessary(status);
        return ptr.get();
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public com.bugvm.ios.AudioToolbox.AudioQueueBuffer allocateBuffer(int bufferByteSize, int numberPacketDescriptions) throws OSStatusException {
        com.bugvm.ios.AudioToolbox.AudioQueueBuffer.AudioQueueBufferPtr ptr = new com.bugvm.ios.AudioToolbox.AudioQueueBuffer.AudioQueueBufferPtr();
        OSStatus status = allocateBuffer0(bufferByteSize, numberPacketDescriptions, ptr);
        OSStatusException.throwIfNecessary(status);
        return ptr.get();
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public void freeBuffer(com.bugvm.ios.AudioToolbox.AudioQueueBuffer buffer) throws OSStatusException {
        freeBuffer(buffer.getHandle());
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public void freeBuffer(long buffer) throws OSStatusException {
        OSStatus status = freeBuffer0(buffer);
        OSStatusException.throwIfNecessary(status);
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public void enqueueBuffer(com.bugvm.ios.AudioToolbox.AudioQueueBuffer buffer, AudioStreamPacketDescription[] packetDescs) throws OSStatusException {
        enqueueBuffer(buffer.getHandle(), packetDescs);
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public void enqueueBuffer(long buffer, AudioStreamPacketDescription[] packetDescs) throws OSStatusException {
        AudioStreamPacketDescription.AudioStreamPacketDescriptionPtr ptr = null;
        if (packetDescs != null) {
            ptr = new AudioStreamPacketDescription.AudioStreamPacketDescriptionPtr();
            ptr.set(packetDescs);
        }
        OSStatus status = enqueueBuffer0(buffer, packetDescs != null ? packetDescs.length : 0, ptr);
        OSStatusException.throwIfNecessary(status);
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public AudioTimeStamp enqueueBuffer(com.bugvm.ios.AudioToolbox.AudioQueueBuffer buffer, AudioStreamPacketDescription[] packetDescs, int trimFramesAtStart, int trimFramesAtEnd, com.bugvm.ios.AudioToolbox.AudioQueueParameterEvent[] paramValues, AudioTimeStamp startTime) throws OSStatusException {
        return enqueueBuffer(buffer.getHandle(), packetDescs, trimFramesAtStart, trimFramesAtEnd, paramValues, startTime);
    }   
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public AudioTimeStamp enqueueBuffer(long buffer, AudioStreamPacketDescription[] packetDescs, int trimFramesAtStart, int trimFramesAtEnd, com.bugvm.ios.AudioToolbox.AudioQueueParameterEvent[] paramValues, AudioTimeStamp startTime) throws OSStatusException {
        AudioTimeStamp.AudioTimeStampPtr ptr = new AudioTimeStamp.AudioTimeStampPtr();
        
        AudioStreamPacketDescription.AudioStreamPacketDescriptionPtr packetDescsPtr = new AudioStreamPacketDescription.AudioStreamPacketDescriptionPtr();
        packetDescsPtr.set(packetDescs);
        com.bugvm.ios.AudioToolbox.AudioQueueParameterEvent.AudioQueueParameterEventPtr paramValuesPtr = new com.bugvm.ios.AudioToolbox.AudioQueueParameterEvent.AudioQueueParameterEventPtr();
        paramValuesPtr.set(paramValues);
        
        OSStatus status = enqueueBuffer0(buffer, packetDescs.length, packetDescsPtr, trimFramesAtStart, trimFramesAtEnd, paramValues.length, paramValuesPtr, startTime, ptr);
        OSStatusException.throwIfNecessary(status);
        return ptr.get();
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public void start() throws OSStatusException {
        start(null);
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public void start(AudioTimeStamp startTime) throws OSStatusException {
        OSStatus status = start0(startTime);
        OSStatusException.throwIfNecessary(status);
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public int prime(int numberOfFramesToPrepare) throws OSStatusException {
        IntPtr ptr = new IntPtr();
        OSStatus status = prime0(numberOfFramesToPrepare, ptr);
        OSStatusException.throwIfNecessary(status);
        return ptr.get();
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public void stop(boolean immediate) throws OSStatusException {
        OSStatus status = stop0(immediate);
        OSStatusException.throwIfNecessary(status);
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public void pause() throws OSStatusException {
        OSStatus status = pause0();
        OSStatusException.throwIfNecessary(status);
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public void flush() throws OSStatusException {
        OSStatus status = flush0();
        OSStatusException.throwIfNecessary(status);
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public void reset() throws OSStatusException {
        OSStatus status = reset0();
        OSStatusException.throwIfNecessary(status);
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public float getParameter(com.bugvm.ios.AudioToolbox.AudioQueueParam param) throws OSStatusException {
        FloatPtr ptr = new FloatPtr();
        OSStatus status = getParameter0(param, ptr);
        OSStatusException.throwIfNecessary(status);
        return ptr.get();
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public void setParameter(com.bugvm.ios.AudioToolbox.AudioQueueParam param, float value) throws OSStatusException {
        OSStatus status = setParameter0(param, value);
        OSStatusException.throwIfNecessary(status);
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public int getPropertySize(com.bugvm.ios.AudioToolbox.AudioQueueProperty id) throws OSStatusException {
        IntPtr ptr = new IntPtr();
        OSStatus status = getPropertySize0(id, ptr);
        OSStatusException.throwIfNecessary(status);
        return ptr.get();
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public <T extends Struct<T>> T getProperty(com.bugvm.ios.AudioToolbox.AudioQueueProperty id, Class<T> type) throws OSStatusException {
        T data = Struct.allocate(type);
        IntPtr dataSize = new IntPtr(Struct.sizeOf(data));
        OSStatus status = getProperty0(id, data.as(VoidPtr.class), dataSize);
        OSStatusException.throwIfNecessary(status);
        return data;
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public <T extends Struct<T>> void setProperty(com.bugvm.ios.AudioToolbox.AudioQueueProperty id, T data) throws OSStatusException {
        OSStatus status = setProperty0(id, data == null ? null : data.as(VoidPtr.class), data == null ? 0 : Struct.sizeOf(data));
        OSStatusException.throwIfNecessary(status);
    }
    public int getPropertyAsInt(com.bugvm.ios.AudioToolbox.AudioQueueProperty id) throws OSStatusException {
        IntPtr ptr = getProperty(id, IntPtr.class);
        return ptr.get();
    }
    public long getPropertyAsLong(com.bugvm.ios.AudioToolbox.AudioQueueProperty id) throws OSStatusException {
        LongPtr ptr = getProperty(id, LongPtr.class);
        return ptr.get();
    }
    public float getPropertyAsFloat(com.bugvm.ios.AudioToolbox.AudioQueueProperty id) throws OSStatusException {
        FloatPtr ptr = getProperty(id, FloatPtr.class);
        return ptr.get();
    }
    public double getPropertyAsDouble(com.bugvm.ios.AudioToolbox.AudioQueueProperty id) throws OSStatusException {
        DoublePtr ptr = getProperty(id, DoublePtr.class);
        return ptr.get();
    }
    public void setProperty(com.bugvm.ios.AudioToolbox.AudioQueueProperty id, int value) throws OSStatusException {
        setProperty(id, new IntPtr(value));
    }
    public void setProperty(com.bugvm.ios.AudioToolbox.AudioQueueProperty id, long value) throws OSStatusException {
        setProperty(id, new LongPtr(value));
    }
    public void setProperty(com.bugvm.ios.AudioToolbox.AudioQueueProperty id, float value) throws OSStatusException {
        setProperty(id, new FloatPtr(value));
    }
    public void setProperty(com.bugvm.ios.AudioToolbox.AudioQueueProperty id, double value) throws OSStatusException {
        setProperty(id, new DoublePtr(value));
    }
    
    /* Convenience methods for getting/setting properties */
    public boolean isRunning() throws OSStatusException {
        int result = getPropertyAsInt(com.bugvm.ios.AudioToolbox.AudioQueueProperty.IsRunning);
        return result != 0;
    }
    
    /* End: Convenience methods for getting/setting properties */
    
    /**
     * @since Available in iOS 2.0 and later.
     */
    public void addPropertyListener(com.bugvm.ios.AudioToolbox.AudioQueueProperty id, PropertyListener listener) throws OSStatusException {
        long cid = callbackId.getAndIncrement();
        
        OSStatus status = addPropertyListener0(id, new FunctionPtr(cbPropertyChanged), cid);
        if (OSStatusException.throwIfNecessary(status)) {
            synchronized (propertyListeners) {
                propertyListeners.put(cid, listener);
            }
        }
    }
    /**
     * @since Available in iOS 2.0 and later.
     */
    public void removePropertyListener(com.bugvm.ios.AudioToolbox.AudioQueueProperty id, PropertyListener listener) throws OSStatusException {
        synchronized (propertyListeners) {
            for (Iterator<LongMap.Entry<PropertyListener>> it = propertyListeners.entries().iterator(); it.hasNext();) {
                LongMap.Entry<PropertyListener> entry = it.next();
                if (entry.value == listener) {
                    OSStatus status = removePropertyListener0(id, new FunctionPtr(cbPropertyChanged), entry.key);
                    OSStatusException.throwIfNecessary(status);
                }
            }
        }
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public com.bugvm.ios.AudioToolbox.AudioQueueTimeline createTimeline() throws OSStatusException {
        com.bugvm.ios.AudioToolbox.AudioQueueTimeline.AudioQueueTimelinePtr ptr = new com.bugvm.ios.AudioToolbox.AudioQueueTimeline.AudioQueueTimelinePtr();
        OSStatus status = createTimeline0(ptr);
        OSStatusException.throwIfNecessary(status);
        return ptr.get();
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public void disposeTimeline(com.bugvm.ios.AudioToolbox.AudioQueueTimeline timeline) throws OSStatusException {
        OSStatus status = disposeTimeline0(timeline);
        OSStatusException.throwIfNecessary(status);
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public AudioTimeStamp getCurrentTime(com.bugvm.ios.AudioToolbox.AudioQueueTimeline timeline) throws OSStatusException {
        AudioTimeStamp.AudioTimeStampPtr ptr = new AudioTimeStamp.AudioTimeStampPtr();
        OSStatus status = getCurrentTime0(timeline, ptr, null);
        OSStatusException.throwIfNecessary(status);
        return ptr.get();
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public AudioTimeStamp getCurrentDeviceTime() throws OSStatusException {
        AudioTimeStamp.AudioTimeStampPtr ptr = new AudioTimeStamp.AudioTimeStampPtr();
        OSStatus status = getCurrentDeviceTime0(ptr);
        OSStatusException.throwIfNecessary(status);
        return ptr.get();
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public AudioTimeStamp translateDeviceTime(AudioTimeStamp time) throws OSStatusException {
        AudioTimeStamp.AudioTimeStampPtr ptr = new AudioTimeStamp.AudioTimeStampPtr();
        OSStatus status = translateDeviceTime0(time, ptr);
        OSStatusException.throwIfNecessary(status);
        return ptr.get();
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public AudioTimeStamp getNearestDeviceStartTime(AudioTimeStamp requestedStartTime) throws OSStatusException {
        OSStatus status = getNearestDeviceStartTime0(requestedStartTime, 0);
        OSStatusException.throwIfNecessary(status);
        return requestedStartTime;
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public void setOfflineRenderFormat(AudioStreamBasicDescription format, AudioChannelLayout layout) throws OSStatusException {
        OSStatus status = setOfflineRenderFormat0(format, layout);
        OSStatusException.throwIfNecessary(status);
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 2.0 and later.
     */
    public com.bugvm.ios.AudioToolbox.AudioQueueBuffer offlineRender(AudioTimeStamp timestamp, com.bugvm.ios.AudioToolbox.AudioQueueBuffer buffer, int numberFrames) throws OSStatusException {
        OSStatus status = offlineRender0(timestamp, buffer, numberFrames);
        OSStatusException.throwIfNecessary(status);
        return buffer;
    }

    
    /**
     * @throws OSStatusException 
     * @since Available in iOS 6.0 and later.
     */
    public com.bugvm.ios.AudioToolbox.AudioQueueProcessingTap createProcessingTap(com.bugvm.ios.AudioToolbox.AudioQueueProcessingTap.ProcessingTapCallback callback, AudioQueueProcessingTapFlags flags) throws OSStatusException {
        return com.bugvm.ios.AudioToolbox.AudioQueueProcessingTap.create(this, callback, flags);
    }
    /*<methods>*/
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="AudioQueueNewOutput", optional=true)
    protected static native OSStatus createOutput0(AudioStreamBasicDescription inFormat, FunctionPtr inCallbackProc, @Pointer long inUserData, NSRunLoop inCallbackRunLoop, String inCallbackRunLoopMode, int inFlags, AudioQueue.AudioQueuePtr outAQ);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="AudioQueueNewInput", optional=true)
    protected static native OSStatus createInput0(AudioStreamBasicDescription inFormat, FunctionPtr inCallbackProc, @Pointer long inUserData, NSRunLoop inCallbackRunLoop, String inCallbackRunLoopMode, int inFlags, AudioQueue.AudioQueuePtr outAQ);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="AudioQueueDispose", optional=true)
    protected native OSStatus dispose0(boolean inImmediate);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="AudioQueueAllocateBuffer", optional=true)
    protected native OSStatus allocateBuffer0(int inBufferByteSize, com.bugvm.ios.AudioToolbox.AudioQueueBuffer.AudioQueueBufferPtr outBuffer);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="AudioQueueAllocateBufferWithPacketDescriptions", optional=true)
    protected native OSStatus allocateBuffer0(int inBufferByteSize, int inNumberPacketDescriptions, com.bugvm.ios.AudioToolbox.AudioQueueBuffer.AudioQueueBufferPtr outBuffer);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="AudioQueueFreeBuffer", optional=true)
    protected native OSStatus freeBuffer0(@Pointer long inBuffer);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="AudioQueueEnqueueBuffer", optional=true)
    protected native OSStatus enqueueBuffer0(@Pointer long inBuffer, int inNumPacketDescs, AudioStreamPacketDescription.AudioStreamPacketDescriptionPtr inPacketDescs);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="AudioQueueEnqueueBufferWithParameters", optional=true)
    protected native OSStatus enqueueBuffer0(@Pointer long inBuffer, int inNumPacketDescs, AudioStreamPacketDescription.AudioStreamPacketDescriptionPtr inPacketDescs, int inTrimFramesAtStart, int inTrimFramesAtEnd, int inNumParamValues, com.bugvm.ios.AudioToolbox.AudioQueueParameterEvent.AudioQueueParameterEventPtr inParamValues, AudioTimeStamp inStartTime, AudioTimeStamp.AudioTimeStampPtr outActualStartTime);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="AudioQueueStart", optional=true)
    protected native OSStatus start0(AudioTimeStamp inStartTime);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="AudioQueuePrime", optional=true)
    protected native OSStatus prime0(int inNumberOfFramesToPrepare, IntPtr outNumberOfFramesPrepared);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="AudioQueueStop", optional=true)
    protected native OSStatus stop0(boolean inImmediate);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="AudioQueuePause", optional=true)
    protected native OSStatus pause0();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="AudioQueueFlush", optional=true)
    protected native OSStatus flush0();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="AudioQueueReset", optional=true)
    protected native OSStatus reset0();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="AudioQueueGetParameter", optional=true)
    protected native OSStatus getParameter0(com.bugvm.ios.AudioToolbox.AudioQueueParam inParamID, FloatPtr outValue);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="AudioQueueSetParameter", optional=true)
    protected native OSStatus setParameter0(com.bugvm.ios.AudioToolbox.AudioQueueParam inParamID, float inValue);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="AudioQueueGetProperty", optional=true)
    protected native OSStatus getProperty0(com.bugvm.ios.AudioToolbox.AudioQueueProperty inID, VoidPtr outData, IntPtr ioDataSize);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="AudioQueueSetProperty", optional=true)
    protected native OSStatus setProperty0(com.bugvm.ios.AudioToolbox.AudioQueueProperty inID, VoidPtr inData, int inDataSize);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="AudioQueueGetPropertySize", optional=true)
    protected native OSStatus getPropertySize0(com.bugvm.ios.AudioToolbox.AudioQueueProperty inID, IntPtr outDataSize);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="AudioQueueAddPropertyListener", optional=true)
    protected native OSStatus addPropertyListener0(com.bugvm.ios.AudioToolbox.AudioQueueProperty inID, FunctionPtr inProc, @Pointer long inUserData);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="AudioQueueRemovePropertyListener", optional=true)
    protected native OSStatus removePropertyListener0(com.bugvm.ios.AudioToolbox.AudioQueueProperty inID, FunctionPtr inProc, @Pointer long inUserData);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="AudioQueueCreateTimeline", optional=true)
    protected native OSStatus createTimeline0(com.bugvm.ios.AudioToolbox.AudioQueueTimeline.AudioQueueTimelinePtr outTimeline);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="AudioQueueDisposeTimeline", optional=true)
    protected native OSStatus disposeTimeline0(com.bugvm.ios.AudioToolbox.AudioQueueTimeline inTimeline);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="AudioQueueGetCurrentTime", optional=true)
    protected native OSStatus getCurrentTime0(com.bugvm.ios.AudioToolbox.AudioQueueTimeline inTimeline, AudioTimeStamp.AudioTimeStampPtr outTimeStamp, BooleanPtr outTimelineDiscontinuity);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="AudioQueueDeviceGetCurrentTime", optional=true)
    protected native OSStatus getCurrentDeviceTime0(AudioTimeStamp.AudioTimeStampPtr outTimeStamp);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="AudioQueueDeviceTranslateTime", optional=true)
    protected native OSStatus translateDeviceTime0(AudioTimeStamp inTime, AudioTimeStamp.AudioTimeStampPtr outTime);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="AudioQueueDeviceGetNearestStartTime", optional=true)
    protected native OSStatus getNearestDeviceStartTime0(AudioTimeStamp ioRequestedStartTime, int inFlags);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="AudioQueueSetOfflineRenderFormat", optional=true)
    protected native OSStatus setOfflineRenderFormat0(AudioStreamBasicDescription inFormat, AudioChannelLayout inLayout);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="AudioQueueOfflineRender", optional=true)
    protected native OSStatus offlineRender0(AudioTimeStamp inTimestamp, com.bugvm.ios.AudioToolbox.AudioQueueBuffer ioBuffer, int inNumberFrames);
    /*</methods>*/
}