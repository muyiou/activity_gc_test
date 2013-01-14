activity_gc_test
================

模拟追踪activity的回收

所谓的activity内存泄漏指的是activity在destroy以后因为有gc root到activity的强引用导致了activity的实例不能被垃圾回收机制回收。

实现监控的关键点在：如何在activity被垃圾回收时获得通知。

强引用：Java中，一般使用对象的强引用，当GC Root到对象的强引用链存在时，该对象不会被当做垃圾回收。

软引用：自是在内存不足时，垃圾收集器回收只被软引用的对象。

弱引用：在垃圾收集发生时回收只被弱引用的对象。

ReferenceQueue可以和软引用、弱引用等引用配合使用，如果软引用、弱引用所引用的对象被垃圾回收时，java虚拟机就会把他们加入到关联的引用队列里。

这种机制给了我们一种监控activity的方法：
1:纪录所有的activity实例
2:为每个activity关联一个弱和referenceQueue
3:在独立的线程中检测ReferenceQueue中的activity对象
4:这样activity被Destory以后一段时间还没有进入到ReferenceQueue的，即可能泄漏，这个时间可以自行判断。
5:结合MAT工具分析出泄漏的原因
