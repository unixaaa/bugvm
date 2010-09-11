#ifndef NULLVM_STRING_H
#define NULLVM_STRING_H

extern jboolean nvmInitStrings(Env* env);
extern Object* nvmNewString(Env* env, jchar* chars, jint length);
extern Object* nvmNewStringUTF(Env* env, char* s, jint length);
extern Object* nvmNewStringAscii(Env* env, char* s, jint length);
extern jint nvmGetStringLength(Env* env, Object* str);
extern jchar* nvmGetStringChars(Env* env, Object* str);
extern jint nvmGetStringUTFLength(Env* env, Object* str);
extern char* nvmGetStringUTFChars(Env* env, Object* str);
extern void nvmGetStringRegion(Env* env, Object* str, jint start, jint len, jchar* buf);
extern void nvmGetStringUTFRegion(Env* env, Object* str, jint start, jint len, char* buf);

#endif

