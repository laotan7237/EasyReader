package com.laotan.easyreader.rx;

import rx.Observable;
import rx.functions.Func1;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by quantan.liu on 2017/3/10.
 */
public class RxBus {
    /**
     * 参考网址:  http://www.loongwind.com/archives/264.html 看这个学习rxbus怎么用
     *http://gank.io/post/560e15be2dca930e00da1083  看这个学习rxjava
     */
    private static volatile RxBus mDefaultInstance;

    private RxBus() {
    }

    public static RxBus getDefault() {
        if (mDefaultInstance == null) {
            synchronized (RxBus.class) {
                if (mDefaultInstance == null) {
                    mDefaultInstance = new RxBus();
                }
            }
        }
        return mDefaultInstance;
    }

    private final Subject<Object, Object> _bus = new SerializedSubject<>(PublishSubject.create());

    public void send(Object o) {
        _bus.onNext(o);
    }

    public Observable<Object> toObservable() {
        return _bus;
    }
    /**
     * 根据传递的 eventType 类型返回特定类型(eventType)的 被观察者
     * @param eventType 事件类型
     * @param <T>
     * @return
     */
    public <T> Observable<T> toObservable(Class<T> eventType) {
        return _bus.ofType(eventType);
    }

    /**
     * 提供了一个新的事件,根据code进行分发
     * @param code 事件code
     * @param o
     */
    public void post(int code, Object o){
        _bus.onNext(new RxBusBaseMessage(code,o));
    }

    /**
     * 提供了一个新的事件,单一类型
     * @param o 事件数据
     */
    public void post (Object o) {
        _bus.onNext(o);
    }

    /**
     * 根据传递的code和 eventType 类型返回特定类型(eventType)的 被观察者
     * 对于注册了code为0，class为voidMessage的观察者，那么就接收不到code为0之外的voidMessage。
     * @param code 事件code
     * @param eventType 事件类型
     * @param <T>
     * @return
     */
    public <T> Observable<T> toObservable(final int code, final Class<T> eventType) {
        return _bus.ofType(RxBusBaseMessage.class)
                .filter(new Func1<RxBusBaseMessage,Boolean>() {
                    @Override
                    public Boolean call(RxBusBaseMessage o) {
                        //过滤code和eventType都相同的事件
                        return o.getCode() == code && eventType.isInstance(o.getObject());
                    }
                }).map(new Func1<RxBusBaseMessage,Object>() {
                    @Override
                    public Object call(RxBusBaseMessage o) {
                        return o.getObject();
                    }
                }).cast(eventType);
    }
    /**
     * 判断是否有订阅者
     */
    public boolean hasObservers() {
        return _bus.hasObservers();
    }


}