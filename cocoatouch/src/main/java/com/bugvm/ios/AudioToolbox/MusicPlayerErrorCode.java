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
import com.bugvm.rt.bro.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*//*</annotations>*/
public enum /*<name>*/MusicPlayerErrorCode/*</name>*/ implements ValuedEnum {
    /*<values>*/
    InvalidSequenceType(-10846L),
    TrackIndexError(-10859L),
    TrackNotFound(-10858L),
    EndOfTrack(-10857L),
    StartOfTrack(-10856L),
    IllegalTrackDestination(-10855L),
    NoSequence(-10854L),
    InvalidEventType(-10853L),
    InvalidPlayerState(-10852L),
    CannotDoInCurrentContext(-10863L);
    /*</values>*/

    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<methods>*//*</methods>*/

    private final long n;

    private /*<name>*/MusicPlayerErrorCode/*</name>*/(long n) { this.n = n; }
    public long value() { return n; }
    public static /*<name>*/MusicPlayerErrorCode/*</name>*/ valueOf(long n) {
        for (/*<name>*/MusicPlayerErrorCode/*</name>*/ v : values()) {
            if (v.n == n) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + n + " found in " 
            + /*<name>*/MusicPlayerErrorCode/*</name>*/.class.getName());
    }
}