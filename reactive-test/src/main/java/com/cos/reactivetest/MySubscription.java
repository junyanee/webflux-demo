package com.cos.reactivetest;

import java.util.Iterator;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

// ���� ���� (������, � �����͸� ��������)
public class MySubscription implements Subscription{

	private Subscriber s;
	private Iterator<Integer> it;

	public MySubscription(Subscriber s, Iterable<Integer> its) {
		this.s = s;
		this.it = its.iterator();
	}

	public void request(long n) { // 1
		while(n > 0) {
			if(it.hasNext()) {
				s.onNext(it.next());
			} else {
				s.onComplete();
				break;
			}
			n--;
		}
	}

	public void cancel() {

	}


}
